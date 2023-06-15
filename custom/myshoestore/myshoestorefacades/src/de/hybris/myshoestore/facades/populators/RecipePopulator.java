package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.myshoestore.facades.RecipeData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class RecipePopulator implements Populator<RecipeModel, RecipeData> {
    private static final Logger LOG = Logger.getLogger(RecipePopulator.class);

    @Override
    public void populate(final RecipeModel source, final RecipeData target) throws ConversionException {
        LOG.info("############### RecipePopulator ###########");
        Assert.notNull(source, "Parameter source can not be null");
        Assert.notNull(target, "Parameter target can not be null");
        target.setCode(source.getCode());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setIsComplicated(source.getIsComplicated());

    }
}
