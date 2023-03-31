package de.hybris.myshoestore.facades.attributehandler;
import de.hybris.myshoestore.core.model.NewProductModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;


public class DynamicPriceHandler implements DynamicAttributeHandler<Integer, NewProductModel>

{

    public static int price = 0;

    @Override
    public Integer get(final NewProductModel model)

    {

            final int size = model.getSize();

            price = size * 100;

        return price;

    }

    @Override
    public void set(final NewProductModel model, final Integer val)

    {
        if (val != null)
        {
            throw new UnsupportedOperationException();
        }
    }

}