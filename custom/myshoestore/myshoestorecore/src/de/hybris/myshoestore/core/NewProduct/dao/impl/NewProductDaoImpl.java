package de.hybris.myshoestore.core.NewProduct.dao.impl;
import de.hybris.myshoestore.core.NewProduct.dao.NewProductDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.model.ModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import de.hybris.platform.servicelayer.search.SearchResult;
import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;


import java.util.*;

import de.hybris.myshoestore.core.model.NewProductModel;
public class NewProductDaoImpl implements NewProductDao {
    private ModelService modelService;
    private static final Logger LOG = LoggerFactory.getLogger(NewProductDaoImpl.class);


    public ModelService getModelService()
    {
        return modelService;
    }

    public void setModelService(ModelService modelService)
    {

        this.modelService = modelService;
    }

    private static final String query = "SELECT {PK} FROM {NewProduct}";

    private FlexibleSearchService flexibleSearchService;

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
    {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<NewProductModel> getNewProductDetails()
    {
        LOG.info("##### NewProductDaoImpl ######");
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        final SearchResult<NewProductModel> searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult();
    }

    public List<NewProductModel> getSpecificNewProductDetails(final String code)
    {
        final Map<String, Object> params = new HashMap<String, Object>();
        final String query = "SELECT {PK} FROM {NewProduct} WHERE {code}=?code";
        params.put("code", code);
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        searchQuery.addQueryParameters(params);
        final SearchResult searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult() == null ? Collections.emptyList() : searchResult.getResult();
    }

    @Override
    public void createNewProduct(NewProductModel newProductModel)
    {
        LOG.info("##### NewProductDaoImpl ######");
        getModelService().save(newProductModel);
    }

    @Override
    public void removeNewProduct(List<NewProductModel> NewProduct)
    {
        LOG.info("##### NewProductDaoImpl ######");
        validateParameterNotNull(NewProduct, "New Product cannot be null");
        getModelService().removeAll(NewProduct);
    }

    @Override
    public void updateNewProduct(final String code, final String color)
    {
        LOG.info("##### NewProductDaoImpl ######");
        validateParameterNotNull(color, "Color cannot be null");
        for (NewProductModel newProduct : getSpecificNewProductDetails(code))
        {
            if (newProduct.getCode().equals(code))
            {
//                NewProductModel ne = newProduct;
//                ne.setColor(color);
                getModelService().setAttributeValue(newProduct, "color", color);
                getModelService().save(newProduct);
                getModelService().refresh(newProduct);
            }
        }
    }
}