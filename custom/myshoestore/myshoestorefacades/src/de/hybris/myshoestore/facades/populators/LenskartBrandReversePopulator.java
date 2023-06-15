package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.facades.LenskartBrandData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;

public class LenskartBrandReversePopulator implements Populator<LenskartBrandData, LenskartBrandModel> {
private static final Logger LOG = Logger.getLogger(NewProductDataPopulator.class);

@Override
public void populate(final LenskartBrandData  source, final LenskartBrandModel target) throws ConversionException {
        LOG.info("############### LenskartBrandPopulator ###########");

        target.setBrand(source.getBrand());
        }
        }