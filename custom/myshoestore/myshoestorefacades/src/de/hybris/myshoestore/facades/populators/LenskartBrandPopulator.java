package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.core.model.LenskartProductModel;
import de.hybris.myshoestore.facades.LenskartBrandData;
import de.hybris.myshoestore.facades.LenskartProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class LenskartBrandPopulator implements Populator<LenskartBrandModel, LenskartBrandData> {
    private static final Logger LOG = Logger.getLogger(NewProductDataPopulator.class);

    @Override
    public void populate(final LenskartBrandModel source, final LenskartBrandData target) throws ConversionException {
        LOG.info("############### LenskartBrandPopulator ###########");

        target.setBrand(source.getBrand());
    }
}