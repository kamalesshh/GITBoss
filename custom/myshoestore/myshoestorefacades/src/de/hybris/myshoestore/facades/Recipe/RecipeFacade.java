package de.hybris.myshoestore.facades.Recipe;

import de.hybris.myshoestore.facades.RecipeData;
import de.hybris.myshoestore.facades.RecipeData;

import java.util.List;

public interface RecipeFacade {
    public List<RecipeData> getAllRecipes();

    public List<RecipeData> getSpecificRecipeDetails(final String code);
    public void createRecipe(final RecipeData recipeData);
    public void removeRecipe(final String code);
    public void updateRecipe(final String code, final String title);

}
