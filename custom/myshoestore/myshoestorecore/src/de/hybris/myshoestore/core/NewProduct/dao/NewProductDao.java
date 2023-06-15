package de.hybris.myshoestore.core.NewProduct.dao;
import java.util.List;
import de.hybris.myshoestore.core.model.NewProductModel;

public interface NewProductDao {
    
    public List<NewProductModel> getNewProductDetails();
    public List<NewProductModel> getSpecificNewProductDetails(final String code);
    public void createNewProduct(NewProductModel newProductModel);
    public void removeNewProduct(List<NewProductModel> NewProduct);
    public void updateNewProduct(final String code, final String color);

}
