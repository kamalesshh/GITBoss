package de.hybris.myshoestore.core.LenskartProduct;

import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.core.model.LenskartProductModel;

import java.util.List;

public interface LenskartProductService
{
    public List<LenskartProductModel> getLenskartProductDetails();
    public void removeLenskartProduct(final String name);
    public List<LenskartProductModel> getSpecificLenskartProductDetails(final String name);
    public void createLenskartProduct(LenskartProductModel lenskartProductModel);
    public void updateLenskartProduct(final String name, final Integer size);
    public List<LenskartBrandModel> getLenskartProductBrandDetails();

}
