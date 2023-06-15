package de.hybris.myshoestore.core.LenskartProduct.impl;

import de.hybris.myshoestore.core.LenskartProduct.LenskartProductService;
import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.core.model.LenskartProductModel;
import org.apache.log4j.Logger;
import de.hybris.myshoestore.core.LenskartProduct.dao.LenskartProductDao;
import java.util.List;

public class LenskartProductServiceImpl implements LenskartProductService
{
    private LenskartProductDao lenskartProductDao;
    private static final Logger LOG =
            Logger.getLogger(LenskartProductServiceImpl.class);
    public LenskartProductDao getLenskartProductDao()
    {
        return lenskartProductDao;
    }

    public void setLenskartProductDao(LenskartProductDao lenskartProductDao)
    {

        this.lenskartProductDao = lenskartProductDao;
    }


    @Override
    public List<LenskartProductModel> getLenskartProductDetails()
    {
        LOG.info("###### LenskartProductServiceImpl ######");
        return lenskartProductDao.getLenskartProductDetails();
    }

    @Override
    public List<LenskartProductModel> getSpecificLenskartProductDetails(String name)
    {
        LOG.info("###### LenskartProductServiceImpl ######");
        return lenskartProductDao.getSpecificLenskartProductDetails(name);
    }
    @Override
    public void removeLenskartProduct(String name)
    {
        LOG.info("###### LenskartProductServiceImpl ######");
        List<LenskartProductModel> lenskartProduct = getSpecificLenskartProductDetails(name);
        getLenskartProductDao().removeLenskartProduct(lenskartProduct);
    }


    @Override
    public void createLenskartProduct(LenskartProductModel lenskartProductModel)
    {
        LOG.info("###### LenskartProductServiceImpl ######");
        getLenskartProductDao().createLenskartProduct(lenskartProductModel);

    }

    @Override
    public void updateLenskartProduct(final String name,final Integer size)
    {
        LOG.info("###### LenskartProductServiceImpl ######");
        getLenskartProductDao().updateLenskartProduct(name, size);

    }

    @Override
    public List<LenskartBrandModel> getLenskartProductBrandDetails() {
        LOG.info("########################### LenskartProductServiceImpl #######################");
        return lenskartProductDao.getLenskartProductBrandDetails();
    }
}
