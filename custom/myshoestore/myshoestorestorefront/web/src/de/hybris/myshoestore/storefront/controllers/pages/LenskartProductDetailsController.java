package de.hybris.myshoestore.storefront.controllers.pages;

import de.hybris.myshoestore.core.LenskartProduct.LenskartProductForm;
import de.hybris.myshoestore.core.enums.Color;
import de.hybris.myshoestore.facades.LenskartBrandData;
import de.hybris.myshoestore.facades.LenskartProduct.LenskartProductFacade;
import de.hybris.myshoestore.facades.LenskartProductData;
import de.hybris.myshoestore.storefront.controllers.ControllerConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/lenskart")
public class LenskartProductDetailsController extends AbstractPageController
{
    @Autowired
    private LenskartProductFacade lenskartProductFacade;

    private static final String LENSKARTPRODUCT_CMS_PAGE = "lenskartProductDetails";

    private static final String REDIRECT_TO_CREATE_LENSKARTPRODUCT = REDIRECT_PREFIX + "/lenskart/lenskartProducts";

    private static final String FORM_GLOBAL_ERROR = "form.global.error";

    private static final Logger LOG = Logger.getLogger(LenskartProductDetailsController.class);

//        private static final String UPDATE_OLD_PASSWORD_CMS_PAGE = "lenskartProducts";

    @RequestMapping(value = "/lenskartProducts", method = RequestMethod.GET)
    public String getLenskartProductDetails(final Model model) throws CMSItemNotFoundException
    {

        final List<LenskartProductData> lenskartProductData = lenskartProductFacade.getLenskartProductDetails();

        model.addAttribute("lenskartProductData", lenskartProductData );

        storeCmsPageInModel(model, getContentPageForLabelOrId("lenskartProducts"));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId("lenskartProducts"));

        return ControllerConstants.Views.Pages.Product.LenskartProductDetails;
    }

    @RequestMapping(value = "/create-lenskartproduct", method = RequestMethod.GET)
    public String createLenskartProduct(final Model model) throws CMSItemNotFoundException
    {
        LOG.info("######## LenskartProductDetailsController ########");
        final LenskartProductForm lenskartProductForm = getPreparedLenskartProductForm();
        model.addAttribute("lenskartProductForm", new LenskartProductForm());
        final ContentPageModel createLenskartProductPage = getContentPageForLabelOrId("create-lenskartproduct");
        storeCmsPageInModel(model, createLenskartProductPage);
        setUpMetaDataForContentPage(model, createLenskartProductPage);
        return ControllerConstants.Views.Pages.Product.CreateLenskartProduct;
    }

    @RequestMapping(value = "/create-lenskartproduct", method = RequestMethod.POST)
    public String createLenskartProduct(final LenskartProductForm lenskartProductForm, final BindingResult bindingResult, final Model model,
                                   final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
    {
        LOG.info("######## LenskartProductDetailsController ########");
        if (bindingResult.hasErrors())
        {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            final ContentPageModel createLenskartProduct = getContentPageForLabelOrId("create-lenskartproduct");
            storeCmsPageInModel(model, createLenskartProduct);
            setUpMetaDataForContentPage(model, createLenskartProduct);
            return getViewForPage(model);
        }
        String returnAction = REDIRECT_TO_CREATE_LENSKARTPRODUCT;
        final LenskartProductData lenskartProduct = new LenskartProductData();
        lenskartProduct.setName(lenskartProductForm.getName());
        lenskartProduct.setSize(lenskartProductForm.getSize());
        lenskartProduct.setColour(Color.valueOf(lenskartProductForm.getColour()));
        lenskartProduct.setBrand(lenskartProductForm.getLenskartBrand());


        model.addAttribute("lenskartProductForm", new LenskartProductForm());

        final ContentPageModel createLenskartProductPage = getContentPageForLabelOrId("create-lenskartproduct");
        storeCmsPageInModel(model, createLenskartProductPage);
        setUpMetaDataForContentPage(model, createLenskartProductPage);

        getLenskartProductFacade().createLenskartProduct(lenskartProduct);
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "LenskartProduct Created!", null);

        return returnAction;
    }

    @RequestMapping(value = "/update-lenskartproduct-size", method = RequestMethod.GET)
    public String updateLenskartProduct(final Model model) throws CMSItemNotFoundException
    {
        LOG.info("######## LenskartProductController ########");
        model.addAttribute("lenskartProductForm", new LenskartProductForm());
        final ContentPageModel updateLenskartProductSize = getContentPageForLabelOrId("update-lenskartproduct-size");
        storeCmsPageInModel(model, updateLenskartProductSize);
        setUpMetaDataForContentPage(model, updateLenskartProductSize);
        return ControllerConstants.Views.Pages.Product.UpdateLenskartProductSize;
    }

    @RequestMapping(value = "/update-lenskartproduct-size", method = RequestMethod.POST)
    public String updateLenskartProductSize(final LenskartProductForm lenskartProductForm, final BindingResult bindingResult, final Model model,
                                        final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
    {
        LOG.info("######## LenskartProductController ########");
        if(lenskartProductForm.getName() == null)
        {
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "Please Enter LenskartProduct Name", null);
            return REDIRECT_PREFIX + "update-lenskartproduct-size";
        }
        if(getLenskartProductFacade().getSpecificLenskartProductDetails(lenskartProductForm.getName()).isEmpty())
        {
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "LenskartProduct Not Found", null);
            return REDIRECT_PREFIX + "update-lenskartproduct-size";
        }
        if (bindingResult.hasErrors())
        {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            final ContentPageModel updateLenskartProductSize = getContentPageForLabelOrId("update-lenskartproduct-size");
            storeCmsPageInModel(model, updateLenskartProductSize);
            setUpMetaDataForContentPage(model, updateLenskartProductSize);
            return getViewForPage(model);
        }
        String returnAction = REDIRECT_TO_CREATE_LENSKARTPRODUCT;

        final List <LenskartProductData> lenskartProductData = lenskartProductFacade.getSpecificLenskartProductDetails(lenskartProductForm.getName());

        model.addAttribute("lenskartProductForm", new LenskartProductForm());

        final ContentPageModel updateLenskartProductSize = getContentPageForLabelOrId("update-lenskartproduct-size");
        storeCmsPageInModel(model, updateLenskartProductSize);
        setUpMetaDataForContentPage(model, updateLenskartProductSize);

        getLenskartProductFacade().updateLenskartProduct(lenskartProductForm.getName(), lenskartProductForm.getSize());
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "LenskartProduct Size Updated!", null);

        return returnAction;
    }

    @RequestMapping(value = "/remove-lenskartproduct/{name}", method = RequestMethod.POST)
    public String removeLenskartProduct(@PathVariable final String name,
                                   final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
    {
        LOG.info("######## LenskartProductController ########");

        String returnAction = REDIRECT_TO_CREATE_LENSKARTPRODUCT;

        getLenskartProductFacade().removeLenskartProduct(name);
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "LenskartProduct Removed with Name - " + name + "!" , null);

        return returnAction;
    }

    @RequestMapping(value = "/lenskartProductBrand", method = RequestMethod.GET)
    public String getLenskartProductBrand(final Model model) throws CMSItemNotFoundException
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("####### LenskartProductDetailsController getLenskartProductBrand() method ");
        }
        final List<LenskartBrandData> LenskartProductBrandData =
                lenskartProductFacade.getLenskartProductBrandDetails();
        model.addAttribute("lenskartProductBrandData", LenskartProductBrandData);
        storeCmsPageInModel(model, getContentPageForLabelOrId("lenskartProductBrand"));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId("lenskartProductBrand"));
        return ControllerConstants.Views.Pages.Product.LenskartProductBrandDetails;
    }
    protected LenskartProductForm getPreparedLenskartProductForm()
    {
        final LenskartProductForm lenskartProductForm = new LenskartProductForm();
        lenskartProductForm.setName("");
        lenskartProductForm.setSize(0);
        lenskartProductForm.setColour("");

        return lenskartProductForm;
    }

    public LenskartProductFacade getLenskartProductFacade()
    {
        return lenskartProductFacade;
    }
    public void setLenskartProductFacade(final LenskartProductFacade lenskartProductFacade)
    {
        this.lenskartProductFacade = lenskartProductFacade;
    }
    public static String getLenskartProductCmsPage()
    {
        return LENSKARTPRODUCT_CMS_PAGE;
    }
}
