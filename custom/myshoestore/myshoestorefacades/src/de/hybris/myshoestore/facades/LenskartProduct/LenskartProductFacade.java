package de.hybris.myshoestore.facades.LenskartProduct;

import de.hybris.myshoestore.facades.LenskartBrandData;
import de.hybris.myshoestore.facades.LenskartProductData;

import java.util.List;

public interface LenskartProductFacade 
{
    public List<LenskartProductData> getLenskartProductDetails();
    public List<LenskartProductData> getSpecificLenskartProductDetails(final String name);
    public void createLenskartProduct(final LenskartProductData lenskartProductData);
    public void removeLenskartProduct(final String name);
    public void updateLenskartProduct(final String name, final Integer size);
    public List<LenskartBrandData> getLenskartProductBrandDetails();


}