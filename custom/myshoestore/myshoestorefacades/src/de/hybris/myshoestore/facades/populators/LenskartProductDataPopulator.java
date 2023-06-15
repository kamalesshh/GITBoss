package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.LenskartBrandModel;
import de.hybris.myshoestore.facades.LenskartBrandData;
import de.hybris.myshoestore.facades.LenskartProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import de.hybris.myshoestore.core.model.LenskartProductModel;



public class LenskartProductDataPopulator implements Populator<LenskartProductModel, LenskartProductData> {
        private static final Logger LOG = Logger.getLogger(NewProductDataPopulator.class);

        @Override
        public void populate(final LenskartProductModel source, final LenskartProductData target) throws ConversionException {
                LOG.info("############### LenskartProductDataPopulator ###########");

                Assert.notNull(source, "Parameter source can not be null");
                Assert.notNull(target, "Parameter target can not be null");
                target.setName(source.getName());
                target.setSize(source.getSize());
                target.setColour(source.getColour());
                target.setCost(source.getCost());
                target.setBrand(source.getLenskartBrand());

        }

}
