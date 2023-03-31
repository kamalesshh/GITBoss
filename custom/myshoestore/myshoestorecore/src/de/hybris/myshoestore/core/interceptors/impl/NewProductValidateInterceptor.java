package de.hybris.myshoestore.core.interceptors.impl;
import de.hybris.myshoestore.core.model.NewProductModel;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;


public class NewProductValidateInterceptor implements ValidateInterceptor
{
    private static final Logger LOG = Logger.getLogger(NewProductValidateInterceptor.class);

    @Override
    public void onValidate(final Object obj, final InterceptorContext ctx) throws InterceptorException
    {
        LOG.info("######## NewProductValidateInterceptor #############");

        if (obj instanceof NewProductModel)
        {
            final NewProductModel model = (NewProductModel) obj;
            if (NumberUtils.compare(model.getSize(),8)==1)
            {
                throw new InterceptorException("Size cannot be greater than 8");
            }
        }
    }
}