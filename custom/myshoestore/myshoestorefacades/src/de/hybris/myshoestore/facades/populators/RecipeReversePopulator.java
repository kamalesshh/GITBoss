package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.myshoestore.facades.RecipeData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class RecipeReversePopulator implements Populator<RecipeData, RecipeModel> {

    private static final Logger LOG = Logger.getLogger(RecipeReversePopulator.class);

    @Override
    public void populate(final RecipeData source, final RecipeModel target) throws ConversionException {
        LOG.info("########## RecipeReversePopulator ###########");

        Assert.notNull(source, "Recipe source can not be null");
        Assert.notNull(target, "Recipe target can not be null");
        target.setCode(source.getCode());
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setIsComplicated(source.getIsComplicated());
    }
}