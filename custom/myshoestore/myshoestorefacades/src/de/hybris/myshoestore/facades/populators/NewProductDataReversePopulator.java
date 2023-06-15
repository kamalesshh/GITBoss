package de.hybris.myshoestore.facades.populators;
import de.hybris.myshoestore.core.model.NewProductModel;
import de.hybris.myshoestore.facades.NewProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
public class NewProductDataReversePopulator implements Populator<NewProductData, NewProductModel> {

    private static final Logger LOG = Logger.getLogger(NewProductDataReversePopulator.class);

    @Override
    public void populate(final NewProductData source, final NewProductModel target) throws ConversionException {
        LOG.info("########## NewProductDetailsDataPopulator ###########");

        Assert.notNull(source, "NewProduct source can not be null");
        Assert.notNull(target, "NewProduct target can not be null");
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setSize(source.getSize());
        target.setColor(source.getColor());
        target.setPrice(source.getPrice());


    }
}

