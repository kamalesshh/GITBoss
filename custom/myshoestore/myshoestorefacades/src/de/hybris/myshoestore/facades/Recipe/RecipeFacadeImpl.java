package de.hybris.myshoestore.facades.Recipe;

import de.hybris.myshoestore.core.Recipe.Service.RecipeService;
import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.myshoestore.facades.RecipeData;
import de.hybris.myshoestore.facades.RecipeData;
import de.hybris.myshoestore.facades.populators.NewProductDataReversePopulator;
import de.hybris.myshoestore.facades.populators.RecipePopulator;
import de.hybris.myshoestore.facades.populators.RecipeReversePopulator;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class RecipeFacadeImpl implements RecipeFacade{
    private static final Logger LOG = Logger.getLogger(RecipeFacadeImpl.class);


    private RecipeService recipeService;
    private ModelService modelService;

    public RecipeReversePopulator getRecipeReversePopulator() {
        return recipeReversePopulator;
    }

    public void setRecipeReversePopulator(RecipeReversePopulator recipeReversePopulator) {
        this.recipeReversePopulator = recipeReversePopulator;
    }

    private RecipePopulator recipePopulator;

    private RecipeReversePopulator recipeReversePopulator;


    public RecipePopulator getRecipePopulator() {
        return recipePopulator;
    }

    public void setRecipePopulator(RecipePopulator recipePopulator) {
        this.recipePopulator = recipePopulator;
    }

    public RecipeService getRecipeService() {
        return recipeService;
    }

    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Resource(name = "recipeConverter")
    private Converter<RecipeModel, RecipeData> recipeConverter;

    public Converter<RecipeModel, RecipeData> getRecipeConverter() {
        return recipeConverter;
    }

    public void setRecipeConverter(Converter<RecipeModel, RecipeData> recipeConverter) {
        this.recipeConverter = recipeConverter;
    }

    @Override
    public List<RecipeData> getAllRecipes() {
        LOG.info("######### RecipeFacadeImpl #############");
        final List<RecipeData> recipes = new ArrayList<RecipeData>();
        final List<RecipeModel> model = getRecipeService().getAllRecipes();
        final List<RecipeData> recipeData = recipeConverter.convertAll(model);
        recipes.addAll(recipeData);
        int a = recipes.size();
        LOG.info("NO. of Recipes = " +a);
        return recipes;

    }

    @Override
    public List<RecipeData> getSpecificRecipeDetails(String code) {
        LOG.info("######### RecipeFacadeImpl #############");
        final List<RecipeData> recipe = new ArrayList<RecipeData>();
        final List<RecipeModel> model = getRecipeService().getSpecificRecipeDetails(code);
        final List<RecipeData> recipeData = recipeConverter.convertAll(model);
        recipe.addAll(recipeData);
        return recipe;
    }

    @Override
    public void createRecipe(RecipeData recipeData) {
        LOG.info("######### RecipeFacadeImpl #############");
        final RecipeModel recipeModel = getModelService().create(RecipeModel.class);
        getRecipeReversePopulator().populate(recipeData, recipeModel);
        getRecipeService().createRecipe(recipeModel);

    }

    @Override
    public void removeRecipe(String code) {
        LOG.info("######### RecipeFacadeImpl #############");
        getRecipeService().removeRecipe(code);

    }

    @Override
    public void updateRecipe(String code, String title) {
        LOG.info("######### RecipeFacadeImpl #############");
        getRecipeService().updateRecipe(code, title);


    }
}
