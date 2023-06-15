package de.hybris.myshoestore.core.Ingredients.DAO;

import de.hybris.myshoestore.core.NewProduct.dao.NewProductDao;
import de.hybris.myshoestore.core.NewProduct.dao.impl.NewProductDaoImpl;
import de.hybris.myshoestore.core.model.NewProductModel;
import de.hybris.myshoestore.core.model.IngredientsModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class IngredientsDAOImpl implements IngredientsDAO {

    private ModelService modelService;
    private static final Logger LOG = LoggerFactory.getLogger(de.hybris.myshoestore.core.NewProduct.dao.impl.NewProductDaoImpl.class);


    public ModelService getModelService()
    {
        return modelService;
    }

    public void setModelService(ModelService modelService)
    {

        this.modelService = modelService;
    }

    private static final String query = "SELECT {PK} FROM {Ingredients}";

    private FlexibleSearchService flexibleSearchService;

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
    {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<IngredientsModel> getAllIngredients()
    {
        LOG.info("##### NewProductDaoImpl ######");
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        final SearchResult<IngredientsModel> searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult();
    }

}
