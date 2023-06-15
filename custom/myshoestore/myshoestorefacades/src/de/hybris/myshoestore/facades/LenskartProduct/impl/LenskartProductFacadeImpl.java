package de.hybris.myshoestore.facades.LenskartProduct.impl;

import de.hybris.myshoestore.core.LenskartProduct.LenskartProductService;
import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.core.model.LenskartProductModel;
import de.hybris.myshoestore.facades.LenskartBrandData;
import de.hybris.myshoestore.facades.LenskartProduct.LenskartProductFacade;
import de.hybris.myshoestore.facades.LenskartProductData;
import de.hybris.myshoestore.facades.populators.LenskartProductDataReversePopulator;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class LenskartProductFacadeImpl implements LenskartProductFacade
{
    private static final Logger LOG = Logger.getLogger(LenskartProductFacadeImpl.class);

    private LenskartProductService lenskartProductService;
    private ModelService modelService;
    private LenskartProductDataReversePopulator lenskartProductDataReversePopulator;
    public LenskartProductDataReversePopulator getLenskartProductDataReversePopulator()
    {
        return lenskartProductDataReversePopulator;
    }
    public void setLenskartProductDataReversePopulator(LenskartProductDataReversePopulator lenskartProductDataReversePopulator)
    {
        this.lenskartProductDataReversePopulator = lenskartProductDataReversePopulator;
    }

    public LenskartProductService getLenskartProductService()
    {
        return lenskartProductService;
    }

    @Required
    public void setLenskartProductService(LenskartProductService lenskartProductService)
    {
        this.lenskartProductService = lenskartProductService;
    }
    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService)
    {
        this.modelService = modelService;
    }

    public Converter<LenskartBrandModel, LenskartBrandData> getLenskartBrandConverter() {
        return lenskartBrandConverter;
    }

    public void setLenskartBrandConverter(Converter<LenskartBrandModel, LenskartBrandData> lenskartBrandConverter) {
        this.lenskartBrandConverter = lenskartBrandConverter;
    }

    @Resource(name = "lenskartBrandConverter")
    private Converter<LenskartBrandModel, LenskartBrandData> lenskartBrandConverter;


    @Resource(name = "lenskartProductDataConverter")
    private Converter<LenskartProductModel, LenskartProductData> lenskartProductDataConverter;
    public Converter<LenskartProductModel, LenskartProductData> getLenskartProductDataConverter()
    {
        return lenskartProductDataConverter;
    }
    public void setLenskartProductDataConverter(Converter<LenskartProductModel, LenskartProductData> lenskartProductDataConverter)
    {
        this.lenskartProductDataConverter = lenskartProductDataConverter;
    }
    @Override
    public List<LenskartProductData> getLenskartProductDetails()
    {
        LOG.info("######### LenskartProductFacadeImpl #############");
        final List<LenskartProductData> lenskartProducts = new ArrayList<LenskartProductData>();
        final List<LenskartProductModel> model = getLenskartProductService().getLenskartProductDetails();
        final List<LenskartProductData> lenskartProductData = lenskartProductDataConverter.convertAll(model);
        lenskartProducts.addAll(lenskartProductData);
        return lenskartProducts;
    }

    @Override
    public List<LenskartProductData> getSpecificLenskartProductDetails(String name)
    {
        LOG.info("######### LenskartProductFacadeImpl #############");
        final List<LenskartProductData> lenskartProduct = new ArrayList<LenskartProductData>();
        final List<LenskartProductModel> model = getLenskartProductService().getSpecificLenskartProductDetails(name);
        final List<LenskartProductData> lenskartProductData = lenskartProductDataConverter.convertAll(model);
        lenskartProduct.addAll(lenskartProductData);
        return lenskartProduct;
    }

    @Override
    public void createLenskartProduct(LenskartProductData lenskartProductData)
    {
        LOG.info("######### LenskartProductFacadeImpl #############");
        final LenskartProductModel lenskartProductModel = getModelService().create(LenskartProductModel.class);
        getLenskartProductDataReversePopulator().populate(lenskartProductData, lenskartProductModel);
        getLenskartProductService().createLenskartProduct(lenskartProductModel);

    }

    @Override
    public void removeLenskartProduct(String name)
    {
        LOG.info("######### LenskartProductFacadeImpl #############");
        getLenskartProductService().removeLenskartProduct(name);
    }

    @Override
    public void updateLenskartProduct(String name, Integer size)
    {
        LOG.info("######### LenskartProductFacadeImpl #############");
        getLenskartProductService().updateLenskartProduct(name, size);

    }

    @Override
    public List<LenskartBrandData> getLenskartProductBrandDetails() {
        LOG.info("####################### LenskartProductFacadeImpl ###################");
        final List<LenskartBrandModel> productModel = getLenskartProductService().getLenskartProductBrandDetails();

        final List<LenskartBrandData> productData = lenskartBrandConverter.convertAll(productModel);
        return productData;
    }

}
