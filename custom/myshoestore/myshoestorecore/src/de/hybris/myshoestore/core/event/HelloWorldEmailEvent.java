package de.hybris.myshoestore.core.event;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;

public class HelloWorldEmailEvent extends AbstractCommerceUserEvent<BaseSiteModel> {
    private String content;
    public HelloWorldEmailEvent() {
        super();
    }
    public HelloWorldEmailEvent(final String content)
    {
        super();
        this.content = content;
    }
}