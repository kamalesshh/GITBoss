package de.hybris.myshoestore.facades.attributehandler;
import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

public class DynamicComplexHandler implements DynamicAttributeHandler<Boolean, RecipeModel> {

    public static boolean complicated = false;

    @Override
    public Boolean get(final RecipeModel model)
    {
        if (model.getIngredients() != null && model.getIngredients().size() < 6)
        {
            complicated = false;
        } else
        {
            complicated = true;
        }
        return complicated;
    }

    @Override
    public void set(final RecipeModel model, final Boolean aBoolean) {
        if (aBoolean != null)
        {
            throw new UnsupportedOperationException();
        }
    }

}