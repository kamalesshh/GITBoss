package de.hybris.myshoestore.facades.populators;
import de.hybris.myshoestore.facades.NewProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import de.hybris.myshoestore.core.model.NewProductModel;
public class NewProductDataPopulator implements Populator<NewProductModel, NewProductData> {
    private static final Logger LOG = Logger.getLogger(NewProductDataPopulator.class);

    @Override
    public void populate(final NewProductModel source, final NewProductData target) throws ConversionException {
        LOG.info("############### NewProductDataPopulator ###########");
        Assert.notNull(source, "Parameter source can not be null");
        Assert.notNull(target, "Parameter target can not be null");
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setSize(source.getSize());
        target.setColor(source.getColor());
        target.setPrice(source.getPrice());

    }
}
