package de.hybris.myshoestore.facades.NewProduct;
import java.util.List;
import de.hybris.myshoestore.facades.NewProductData;


public interface NewProductFacade {
    public List<NewProductData> getNewProductDetails();
    public List<NewProductData> getSpecificNewProductDetails(final String code);
    public void createNewProduct(final NewProductData newProductData);
    public void removeNewProduct(final String code);
    public void updateNewProduct(final String code, final String color);
}
