package de.hybris.myshoestore.core.NewProduct.impl;

import java.util.*;


import de.hybris.myshoestore.core.NewProduct.NewProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import de.hybris.myshoestore.core.NewProduct.dao.NewProductDao;
import de.hybris.myshoestore.core.model.NewProductModel;
    public class NewProductServiceImpl implements NewProductService
    {

        private NewProductDao newProductDao;
        private static final Logger LOG =
                Logger.getLogger(NewProductServiceImpl.class);
        public NewProductDao getNewProductDao()
        {
            return newProductDao;
        }

        public void setNewProductDao(NewProductDao newProductDao)
        {

            this.newProductDao = newProductDao;
        }
        

        @Override
        public List<NewProductModel> getNewProductDetails()
        {
            LOG.info("###### NewProductServiceImpl ######");
            return newProductDao.getNewProductDetails();
        }

        @Override
        public List<NewProductModel> getSpecificNewProductDetails(String code)
        {
            LOG.info("###### NewProductServiceImpl ######");
            return newProductDao.getSpecificNewProductDetails(code);
        }
        @Override
        public void removeNewProduct(String code)
        {
            LOG.info("###### NewProductServiceImpl ######");
            List<NewProductModel> newProduct = getSpecificNewProductDetails(code);
            getNewProductDao().removeNewProduct(newProduct);
        }


        @Override
        public void createNewProduct(NewProductModel newProductModel)
        {
            LOG.info("###### NewProductServiceImpl ######");
            getNewProductDao().createNewProduct(newProductModel);

        }

        @Override
        public void updateNewProduct(final String code,final String color)
        {
            LOG.info("###### NewProductServiceImpl ######");
            getNewProductDao().updateNewProduct(code, color);

        }
    }
