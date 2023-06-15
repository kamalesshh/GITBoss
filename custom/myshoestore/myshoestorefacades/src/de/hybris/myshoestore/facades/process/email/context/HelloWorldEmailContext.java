package de.hybris.myshoestore.facades.process.email.context;

import de.hybris.myshoestore.core.model.process.HelloWorldEmailProcessModel;
import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;

public class HelloWorldEmailContext extends CustomerEmailContext
{
    private String firstName;

    @Override
    public void init(final StoreFrontCustomerProcessModel processModel, final EmailPageModel emailPageModel)
    {
        super.init(processModel, emailPageModel);
        if (processModel instanceof HelloWorldEmailProcessModel)
        {
            setFirstName(((HelloWorldEmailProcessModel) processModel).getFirstName());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}