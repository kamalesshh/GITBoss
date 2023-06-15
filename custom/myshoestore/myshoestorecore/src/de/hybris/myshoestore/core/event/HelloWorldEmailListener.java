package de.hybris.myshoestore.core.event;

import de.hybris.myshoestore.core.model.process.HelloWorldEmailProcessModel;
import de.hybris.platform.acceleratorservices.site.AbstractAcceleratorSiteEventListener;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.enums.SiteChannel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.util.ServicesUtil;

public class HelloWorldEmailListener extends AbstractAcceleratorSiteEventListener<HelloWorldEmailEvent> {
    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    private ModelService modelService;

    public BusinessProcessService getBusinessProcessService() {
        return businessProcessService;
    }

    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    private BusinessProcessService businessProcessService;

    public SessionService getSessionService() {
        return sessionService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    private SessionService sessionService;

    @Override
    protected void onSiteEvent(final HelloWorldEmailEvent helloWorldEmailEvent) {
        final HelloWorldEmailProcessModel helloWorldProcessModel = (HelloWorldEmailProcessModel) getBusinessProcessService()
                .createProcess("helloWorld-" + System.currentTimeMillis(), "helloWorldEmailProcess");

// Fill the process with the appropriate data
        helloWorldProcessModel.setSite(helloWorldEmailEvent.getSite());
        helloWorldProcessModel.setCustomer(helloWorldEmailEvent.getCustomer());
        helloWorldProcessModel.setLanguage(helloWorldEmailEvent.getLanguage());
        helloWorldProcessModel.setCurrency(helloWorldEmailEvent.getCurrency());
        helloWorldProcessModel.setStore(helloWorldEmailEvent.getBaseStore());

        helloWorldProcessModel.setFirstName("Kamalesh");

        // Save the process
        getModelService().save(helloWorldProcessModel);

        // Then start the process = send the Email
        getBusinessProcessService().startProcess(helloWorldProcessModel);
    }

    @Override
    protected SiteChannel getSiteChannelForEvent(final HelloWorldEmailEvent event) {
        final BaseSiteModel site = event.getSite();
        ServicesUtil.validateParameterNotNullStandardMessage("event.site", site);
        return site.getChannel();    }
}