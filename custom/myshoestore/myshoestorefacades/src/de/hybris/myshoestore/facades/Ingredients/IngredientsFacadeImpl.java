package de.hybris.myshoestore.facades.Ingredients;

import de.hybris.myshoestore.core.Ingredients.Service.IngredientsService;
import de.hybris.myshoestore.core.model.IngredientsModel;
import de.hybris.myshoestore.facades.IngredientsData;
import de.hybris.myshoestore.facades.populators.IngredientsPopulator;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class IngredientsFacadeImpl implements IngredientsFacade{
    private static final Logger LOG = Logger.getLogger(IngredientsFacadeImpl.class);


    private IngredientsService ingredientsService;
    private ModelService modelService;
    private IngredientsPopulator ingredientsPopulator;

    public IngredientsPopulator getIngredientsPopulator() {
        return ingredientsPopulator;
    }

    public void setIngredientsPopulator(IngredientsPopulator ingredientsPopulator) {
        this.ingredientsPopulator = ingredientsPopulator;
    }

    public IngredientsService getIngredientsService() {
        return ingredientsService;
    }

    public void setIngredientsService(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Resource(name = "ingredientsConverter")
    private Converter<IngredientsModel, IngredientsData> ingredientsConverter;

    public Converter<IngredientsModel, IngredientsData> getIngredientsConverter() {
        return ingredientsConverter;
    }

    public void setIngredientsConverter(Converter<IngredientsModel, IngredientsData> ingredientsConverter) {
        this.ingredientsConverter = ingredientsConverter;
    }

    @Override
    public List<IngredientsData> getAllIngredients() {
        LOG.info("######### IngredientsFacadeImpl #############");
        final List<IngredientsData> ingredients = new ArrayList<IngredientsData>();
        final List<IngredientsModel> model = getIngredientsService().getAllIngredients();
        final List<IngredientsData> ingredientsData = ingredientsConverter.convertAll(model);
        ingredients.addAll(ingredientsData);
        return ingredients;

    }
}
