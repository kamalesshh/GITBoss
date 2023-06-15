package de.hybris.myshoestore.core.LenskartProduct.dao.impl;

import de.hybris.myshoestore.core.LenskartProduct.dao.LenskartProductDao;
import de.hybris.myshoestore.core.NewProduct.dao.NewProductDao;
import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.core.model.LenskartProductModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.*;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

public class LenskartProductDaoImpl implements LenskartProductDao
{

    public LenskartProductModel getLenskartProductModel() {
        return lenskartProductModel;
    }

    public void setLenskartProductModel(LenskartProductModel lenskartProductModel) {
        this.lenskartProductModel = lenskartProductModel;
    }

    private LenskartProductModel lenskartProductModel;
    private ModelService modelService;
    private static final Logger LOG = LoggerFactory.getLogger(LenskartProductDaoImpl.class);


    public ModelService getModelService()
    {
        return modelService;
    }

    public void setModelService(ModelService modelService)
    {

        this.modelService = modelService;
    }

    private static final String query = "SELECT {PK} FROM {LenskartProduct}";

    private FlexibleSearchService flexibleSearchService;

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
    {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<LenskartProductModel> getLenskartProductDetails()
    {
        LOG.info("##### LenskartProductDaoImpl ######");
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        final SearchResult<LenskartProductModel> searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult();
    }

    public List<LenskartProductModel> getSpecificLenskartProductDetails(final String name)
    {
        final Map<String, Object> params = new HashMap<String, Object>();
        final String query = "SELECT {PK} FROM {LenskartProduct} WHERE {name}=?name";
        params.put("name", name);
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        searchQuery.addQueryParameters(params);
        final SearchResult searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult() == null ? Collections.emptyList() : searchResult.getResult();
    }

    @Override
    public void createLenskartProduct(LenskartProductModel lenskartProductModel)
    {
        LOG.info("##### LenskartProductDaoImpl ######");
        getModelService().save(lenskartProductModel);
    }

    @Override
    public void removeLenskartProduct(List<LenskartProductModel> LenskartProduct)
    {
        LOG.info("##### LenskartProductDaoImpl ######");
        validateParameterNotNull(LenskartProduct, "Lenskart Product cannot be null");
        getModelService().removeAll(LenskartProduct);
    }

    @Override
    public void updateLenskartProduct(final String name, final Integer size)
    {
        LOG.info("##### LenskartProductDaoImpl ######");
        validateParameterNotNull(name, "Name cannot be null");
        for (LenskartProductModel lenskartProduct : getSpecificLenskartProductDetails(name))
        {
            if (lenskartProduct.getName().equals(name))
            {
//                LenskartProductModel ne = lenskartProduct;
//                ne.setColor(color);
                getModelService().setAttributeValue(lenskartProduct, "size", size);
                getModelService().save(lenskartProduct);
                getModelService().refresh(lenskartProduct);
            }
        }
    }

    @Override
    public List<LenskartBrandModel> getLenskartProductBrandDetails() {
        final LenskartProductModel productModel = (LenskartProductModel) modelService.get(lenskartProductModel);
        final String name = productModel.getName();

        final String query = "SELECT {" + LenskartBrandModel.PK + "} FROM {" + LenskartBrandModel._TYPECODE + "} where {" + LenskartProductModel.NAME
                + "}='" + name + "'";

        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        final SearchResult searchResult = flexibleSearchService.search(searchQuery);
        final List<LenskartProductModel> model = searchResult.getResult();
        final Set<LenskartBrandModel> productList = model.get(0).getLenskartBrand();
        final List<LenskartBrandModel> messageList = new ArrayList<LenskartBrandModel>(productList);
        return messageList;
    }


}
