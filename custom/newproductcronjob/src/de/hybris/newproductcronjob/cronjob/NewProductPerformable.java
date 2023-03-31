package de.hybris.newproductcronjob.cronjob;
import de.hybris.myshoestore.core.NewProduct.dao.NewProductDao;
import de.hybris.myshoestore.core.model.NewProductModel;
import de.hybris.newproductcronjob.model.NewProductCronJobModel;
import org.apache.log4j.Logger;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.util.List;

public class NewProductPerformable extends AbstractJobPerformable<NewProductCronJobModel>
{
    private static final Logger LOG = Logger.getLogger(NewProductPerformable.class.getName());
    private final NewProductDao newProductDao;

    public NewProductPerformable(NewProductDao newProductDao) {
        this.newProductDao = newProductDao;
    }

    @Override
    public PerformResult perform(final NewProductCronJobModel cronJobModel)
    {

        List<NewProductModel> newproducts = newProductDao.getNewProductDetails();

        for (final NewProductModel newProductModel : newproducts) {

            LOG.info(newProductModel.getCode() + " " + newProductModel.getName() + " " + newProductModel.getSize() + " " + newProductModel.getColor() + " " + newProductModel.getDescription() + " " + newProductModel.getPrice());
        }

        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}