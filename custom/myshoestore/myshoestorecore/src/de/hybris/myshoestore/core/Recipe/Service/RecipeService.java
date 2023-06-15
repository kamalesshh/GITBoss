package de.hybris.myshoestore.core.Recipe.Service;

import de.hybris.myshoestore.core.jalo.Recipe;
import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.myshoestore.core.model.RecipeModel;

import java.util.List;

public interface RecipeService {
    public List<RecipeModel> getAllRecipes();
    public void removeRecipe(final String code);
    public List<RecipeModel> getSpecificRecipeDetails(final String code);
    public void createRecipe(RecipeModel recipeModel);
    public void updateRecipe(final String code, final String title);

}
