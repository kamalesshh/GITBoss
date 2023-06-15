package de.hybris.myshoestore.core.Recipe.DAO;
import de.hybris.myshoestore.core.jalo.Recipe;
import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

public class RecipeDAOImpl implements RecipeDAO {

    private ModelService modelService;
    private static final Logger LOG = LoggerFactory.getLogger(RecipeDAOImpl.class);


    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {

        this.modelService = modelService;
    }

    private static final String query = "SELECT {PK} FROM {Recipe}";

    private FlexibleSearchService flexibleSearchService;

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public List<RecipeModel> getAllRecipes() {
        LOG.info("##### RecipeDaoImpl ######");
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        final SearchResult<RecipeModel> searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult();
    }

    @Override
    public List<RecipeModel> getSpecificRecipeDetails(String code) {
        final Map<String, Object> params = new HashMap<String, Object>();
        final String query = "SELECT {PK} FROM {Recipe} WHERE {code}=?code";
        params.put("code", code);
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        searchQuery.addQueryParameters(params);
        final SearchResult searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult() == null ? Collections.emptyList() : searchResult.getResult();
    }

    @Override
    public void createRecipe(RecipeModel recipeModel) {
        LOG.info("##### RecipeDaoImpl ######");
        getModelService().save(recipeModel);

    }

    @Override
    public void removeRecipe(List<RecipeModel> Recipe) {
        LOG.info("##### RecipeDaoImpl ######");
        validateParameterNotNull(Recipe, "Recipe cannot be null");
        getModelService().removeAll(Recipe);

    }

    @Override
    public void updateRecipe(String code, String title) {
        LOG.info("##### RecipeDaoImpl ######");
        validateParameterNotNull(code, "Name cannot be null");
        for (RecipeModel recipeModel : getSpecificRecipeDetails(code)) {
            if (recipeModel.getCode().equals(code)) {
//                RecipeModel ne = recipeModel;
//                ne.setTitle(title);
                getModelService().setAttributeValue(recipeModel, "title", title);
                getModelService().save(recipeModel);
                getModelService().refresh(recipeModel);
            }
        }
    }
}