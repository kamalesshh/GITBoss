package de.hybris.newproductcronjob.cronjob;
import de.hybris.myshoestore.core.NewProduct.dao.NewProductDao;
import de.hybris.myshoestore.core.NewProduct.dao.impl.NewProductDaoImpl;
import de.hybris.myshoestore.core.model.NewProductModel;
import de.hybris.newproductcronjob.model.NewProductCronJobModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.media.MediaService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.slf4j.LoggerFactory;

import javax.print.attribute.standard.Media;
import java.io.*;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static de.hybris.platform.commerceservices.organization.services.impl.DefaultOrgUnitHierarchyService.DELIMITER;

public class NewProductPerformable extends AbstractJobPerformable<NewProductCronJobModel> {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(NewProductPerformable.class);

    private final NewProductDao newProductDao;

    public MediaService getMediaService() {
        return mediaService;
    }

    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    private MediaService mediaService;

    public NewProductPerformable(NewProductDao newProductDao) {
        this.newProductDao = newProductDao;
    }

    @Override
    public PerformResult perform(final NewProductCronJobModel cronJobModel) {
        List<NewProductModel> newproducts = newProductDao.getNewProductDetails();

        // 3. process create data into csv file
        String csvFileName = "NewProductDetails";
        File file = null;
        try {
            file = generateCSV(csvFileName, newproducts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 4. process save data into media collection field
        saveData(file, csvFileName, cronJobModel);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);

    }

    private void saveData(File file, String csvFileName, NewProductCronJobModel cronJobModel) {
        MediaModel mediaModel = mediaService.getMedia(csvFileName);
        if (null == mediaModel) {
            mediaModel = modelService.create(MediaModel.class);
            mediaModel.setCode(csvFileName);
            mediaModel.setRealFileName(csvFileName);
            mediaModel.setMime("text/csv");
            modelService.save(mediaModel);
        }
        try (InputStream fileInputStream = new FileInputStream(file)) {
            mediaService.setStreamForMedia(mediaModel, fileInputStream);
        } catch (IOException e) {
            LOGGER.error("file not found:{}", e);
        }
        modelService.save(mediaModel);

        Collection<MediaModel> existingMedias = cronJobModel.getExportMedia();
        List<MediaModel> newMedias = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(existingMedias)) {
            newMedias.addAll(existingMedias);
        }
        newMedias.add(mediaModel);
        cronJobModel.setExportMedia(newMedias);
        modelService.save(cronJobModel);
    }


    private File generateCSV(String csvFileName, List<NewProductModel> newproducts) throws IOException {
        final String outputDir = System.getProperty("java.io.tmpdir");
        final String filePath = outputDir + "/" + csvFileName;
        final File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        final File csvfile = new File(filePath);
        LOGGER.info("csv file is created at" + csvfile.getAbsolutePath());
        if (CollectionUtils.isNotEmpty(newproducts)) {
            try (final FileWriter writer = new FileWriter(csvfile, StandardCharsets.UTF_8)) {
                writerHeader(csvfile, writer);
                for (NewProductModel newProductModel : newproducts) {
                    writer.write(newProductModel.getCode());
                    writer.write(DELIMITER);
                    writer.write(newProductModel.getName());
                    writer.write(DELIMITER);
                    writer.write(newProductModel.getDescription());
                    writer.write(DELIMITER);
                    writer.write(newProductModel.getSize());
                    writer.write(DELIMITER);
                    writer.write(newProductModel.getColor());
                    writer.write(DELIMITER);
                    writer.write(newProductModel.getPrice());
                    writer.write(DELIMITER);
                }
            } catch (IOException ex) {
                LOGGER.error("file not found:{}", ex);
            }
        }
        return csvfile;
    }

    private void writerHeader(File csvfile, FileWriter writer) throws IOException {
        writer.write("CODE");
        writer.write(DELIMITER);
        writer.write("NAME");
        writer.write(DELIMITER);
        writer.write("DESCRIPTION");
        writer.write(DELIMITER);
        writer.write("SIZE");
        writer.write(DELIMITER);
        writer.write("COLOR");
        writer.write(DELIMITER);
        writer.write("PRICE");
        writer.write(DELIMITER);
    }
}
//    public PerformResult perform(final NewProductCronJobModel cronJobModel)
//    {
//
//        List<NewProductModel> newproducts = newProductDao.getNewProductDetails();
//
//        for (final NewProductModel newProductModel : newproducts) {
//
//            LOG.info(newProductModel.getCode() + " " + newProductModel.getName() + " " + newProductModel.getSize() + " " + newProductModel.getColor() + " " + newProductModel.getDescription() + " " + newProductModel.getPrice());
//        }
//
//        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
//    }
