package de.hybris.myshoestore.core.NewProduct;

import java.util.List;
import de.hybris.myshoestore.core.model.NewProductModel;

public interface NewProductService {
    public List<NewProductModel> getNewProductDetails();
    public void removeNewProduct(final String code);
    public List<NewProductModel> getSpecificNewProductDetails(final String code);
    public void createNewProduct(NewProductModel newProductModel);
    public void updateNewProduct(final String code, final String color);

}
