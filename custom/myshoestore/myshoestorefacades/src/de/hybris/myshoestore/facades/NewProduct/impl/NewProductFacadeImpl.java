package de.hybris.myshoestore.facades.NewProduct.impl;

import de.hybris.myshoestore.facades.NewProduct.NewProductFacade;
import de.hybris.myshoestore.facades.NewProductData;
import de.hybris.myshoestore.facades.populators.NewProductDataReversePopulator;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import de.hybris.myshoestore.core.NewProduct.NewProductService;
import de.hybris.myshoestore.core.model.NewProductModel;


    public class NewProductFacadeImpl implements NewProductFacade
    {
        private static final Logger LOG = Logger.getLogger(NewProductFacadeImpl.class);

        private NewProductService newProductService;
        private ModelService modelService;
        private NewProductDataReversePopulator newProductDataReversePopulator;
        public NewProductDataReversePopulator getNewProductDataReversePopulator()
        {
            return newProductDataReversePopulator;
        }
        public void setNewProductDataReversePopulator(NewProductDataReversePopulator newProductDataReversePopulator)
        {
            this.newProductDataReversePopulator = newProductDataReversePopulator;
        }

        public NewProductService getNewProductService()
        {
            return newProductService;
        }

        @Required
        public void setNewProductService(NewProductService newProductService)
        {
        this.newProductService = newProductService;
        }
        public ModelService getModelService() {
            return modelService;
        }

        public void setModelService(ModelService modelService)
        {
            this.modelService = modelService;
        }


        @Resource(name = "newProductDataConverter")
        private Converter<NewProductModel, NewProductData>  newProductDataConverter;
        public Converter<NewProductModel, NewProductData> getNewProductDataConverter()
        {
            return newProductDataConverter;
        }
        public void setNewProductDataConverter(Converter<NewProductModel, NewProductData> newProductDataConverter)
        {
            this.newProductDataConverter = newProductDataConverter;
        }
        @Override
        public List<NewProductData> getNewProductDetails()
        {
            LOG.info("######### NewProductFacadeImpl #############");
            final List<NewProductData> newProducts = new ArrayList<NewProductData>();
            final List<NewProductModel> model = getNewProductService().getNewProductDetails();
            final List<NewProductData> newProductData = newProductDataConverter.convertAll(model);
            newProducts.addAll(newProductData);
            return newProducts;
        }

        @Override
        public List<NewProductData> getSpecificNewProductDetails(String code)
        {
            LOG.info("######### NewProductFacadeImpl #############");
            final List<NewProductData> newProduct = new ArrayList<NewProductData>();
            final List<NewProductModel> model = getNewProductService().getSpecificNewProductDetails(code);
            final List<NewProductData> newProductData = newProductDataConverter.convertAll(model);
            newProduct.addAll(newProductData);
            return newProduct;
        }

        @Override
        public void createNewProduct(NewProductData newProductData)
        {
            LOG.info("######### NewProductFacadeImpl #############");
            final NewProductModel newProductModel = getModelService().create(NewProductModel.class);
            getNewProductDataReversePopulator().populate(newProductData, newProductModel);
            getNewProductService().createNewProduct(newProductModel);

        }

        @Override
        public void removeNewProduct(String code)
        {
            LOG.info("######### NewProductFacadeImpl #############");
            getNewProductService().removeNewProduct(code);
        }

        @Override
        public void updateNewProduct(String code, String color)
        {
            LOG.info("######### NewProductFacadeImpl #############");
            getNewProductService().updateNewProduct(code, color);

        }

    }
