package de.hybris.myshoestore.core.Recipe.DAO;

import de.hybris.myshoestore.core.jalo.Recipe;
import de.hybris.myshoestore.core.model.RecipeModel;

import java.util.List;

public interface RecipeDAO {
    public List<RecipeModel> getAllRecipes();
    public List<RecipeModel> getSpecificRecipeDetails(final String name);
    public void createRecipe(RecipeModel recipeModel);
    public void removeRecipe(List<RecipeModel> Recipe);
    public void updateRecipe(final String name, final String title);
}
