package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.IngredientsModel;
import de.hybris.myshoestore.facades.IngredientsData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class IngredientsPopulator implements Populator<IngredientsModel, IngredientsData> {
    private static final Logger LOG = Logger.getLogger(IngredientsPopulator.class);

    @Override
    public void populate(final IngredientsModel source, final IngredientsData target) throws ConversionException {
        LOG.info("############### IngredientsPopulator ###########");
        Assert.notNull(source, "Parameter source can not be null");
        Assert.notNull(target, "Parameter target can not be null");
        target.setName(source.getName());
        target.setQuantity(source.getQuantity());
        target.setUnit(source.getUnit());
    }
}
