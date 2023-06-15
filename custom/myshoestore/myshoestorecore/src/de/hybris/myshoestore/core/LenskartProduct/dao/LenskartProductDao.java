package de.hybris.myshoestore.core.LenskartProduct.dao;

import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.core.model.LenskartProductModel;

import java.util.List;

public interface LenskartProductDao
{

    public List<LenskartProductModel> getLenskartProductDetails();
    public List<LenskartProductModel> getSpecificLenskartProductDetails(final String name);
    public void createLenskartProduct(LenskartProductModel lenskartProductModel);
    public void removeLenskartProduct(List<LenskartProductModel> LenskartProduct);
    public void updateLenskartProduct(final String name, final Integer size);

    public List<LenskartBrandModel> getLenskartProductBrandDetails();

}
