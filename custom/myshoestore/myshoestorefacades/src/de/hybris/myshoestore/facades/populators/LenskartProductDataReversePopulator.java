package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.LenskartProductModel;
import de.hybris.myshoestore.facades.LenskartBrandData;
import de.hybris.myshoestore.facades.LenskartProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class LenskartProductDataReversePopulator implements Populator<LenskartProductData, LenskartProductModel> {

    private static final Logger LOG = Logger.getLogger(LenskartProductDataReversePopulator.class);

    private LenskartBrandData lenskartBrandData;

    @Override
    public void populate(final LenskartProductData source, final LenskartProductModel target) throws ConversionException {
        LOG.info("########## LenskartProductDetailsDataPopulator ###########");
        Assert.notNull(source, "Parameter source can not be null");
        Assert.notNull(target, "Parameter target can not be null");
        target.setName(source.getName());
        target.setSize(source.getSize());
        target.setColour(source.getColour());
        target.setCost(source.getCost());
        target.setLenskartBrand(source.getBrand());

    }
}
