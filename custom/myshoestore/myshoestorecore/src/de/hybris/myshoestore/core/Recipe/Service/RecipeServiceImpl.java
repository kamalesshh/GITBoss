package de.hybris.myshoestore.core.Recipe.Service;

import de.hybris.myshoestore.core.Recipe.DAO.RecipeDAO;
import de.hybris.myshoestore.core.jalo.Recipe;
import de.hybris.myshoestore.core.model.LenskartProductModel;
import de.hybris.myshoestore.core.model.RecipeModel;
import org.apache.log4j.Logger;

import java.util.List;

public class RecipeServiceImpl implements RecipeService {

    public RecipeDAO getRecipeDAO() {
        return recipeDAO;
    }

    public void setRecipeDAO(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    private RecipeDAO recipeDAO;
        private static final Logger LOG =
                Logger.getLogger(de.hybris.myshoestore.core.Recipe.Service.RecipeServiceImpl.class);

        @Override
        public List<RecipeModel> getAllRecipes()
        {
            LOG.info("###### RecipeServiceImpl ######");
            return recipeDAO.getAllRecipes();
        }

    @Override
    public void removeRecipe(String code) {
        LOG.info("###### RecipeServiceImpl ######");
        List<RecipeModel> recipe = getSpecificRecipeDetails(code);
        getRecipeDAO().removeRecipe(recipe);


    }

    @Override
    public List<RecipeModel> getSpecificRecipeDetails(String code) {
        LOG.info("###### RecipeServiceImpl ######");
        return recipeDAO.getSpecificRecipeDetails(code);
    }

    @Override
    public void createRecipe(RecipeModel recipeModel) {
        LOG.info("###### RecipeServiceImpl ######");
        getRecipeDAO().createRecipe(recipeModel);


    }

    @Override
    public void updateRecipe(String code, String title) {
        LOG.info("###### RecipeServiceImpl ######");
        getRecipeDAO().updateRecipe(code, title);
    }

}
