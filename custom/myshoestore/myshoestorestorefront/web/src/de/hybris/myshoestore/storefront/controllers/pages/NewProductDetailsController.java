package de.hybris.myshoestore.storefront.controllers.pages;

import de.hybris.myshoestore.core.NewProduct.NewProductForm;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.myshoestore.facades.NewProductData;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;


import java.util.List;

import de.hybris.platform.cms2.model.pages.ContentPageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.hybris.myshoestore.facades.NewProduct.NewProductFacade;
import de.hybris.myshoestore.storefront.controllers.ControllerConstants;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static de.hybris.myshoestore.storefront.controllers.pages.AccountPageController.FORM_GLOBAL_ERROR;

@Controller
    @RequestMapping(value = "/new")
    public class NewProductDetailsController extends AbstractPageController
    {
        @Autowired
        private NewProductFacade newProductFacade;

        private static final String NEWPRODUCT_CMS_PAGE = "newProductDetails";

        private static final String REDIRECT_TO_CREATE_NEWPRODUCT = REDIRECT_PREFIX + "/new/newProducts";

        private static final String FORM_GLOBAL_ERROR = "form.global.error";

        private static final Logger LOG = Logger.getLogger(NewProductDetailsController.class);

//        private static final String UPDATE_OLD_PASSWORD_CMS_PAGE = "newProducts";

        @RequestMapping(value = "/newProducts", method = RequestMethod.GET)
        public String getNewProductDetails(final Model model) throws CMSItemNotFoundException
        {

            final List<NewProductData>  newProductData = newProductFacade.getNewProductDetails();

            model.addAttribute("newProductData", newProductData );

            storeCmsPageInModel(model, getContentPageForLabelOrId("newProducts"));
            setUpMetaDataForContentPage(model, getContentPageForLabelOrId("newProducts"));

            return ControllerConstants.Views.Pages.Product.NewProductDetails;
        }

        @RequestMapping(value = "/create-newproduct", method = RequestMethod.GET)
        public String createNewProduct(final Model model) throws CMSItemNotFoundException
        {
            LOG.info("######## NewProductDetailsController ########");
            final NewProductForm newProductForm = getPreparedNewProductForm();
            model.addAttribute("newProductForm", new NewProductForm());
            final ContentPageModel createNewProductPage = getContentPageForLabelOrId("create-newproduct");
            storeCmsPageInModel(model, createNewProductPage);
            setUpMetaDataForContentPage(model, createNewProductPage);
            return ControllerConstants.Views.Pages.Product.CreateNewProduct;
        }

        @RequestMapping(value = "/create-newproduct", method = RequestMethod.POST)
        public String createNewProduct(final NewProductForm newProductForm, final BindingResult bindingResult, final Model model,
                                       final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
        {
            LOG.info("######## NewProductDetailsController ########");
            if (bindingResult.hasErrors())
            {
                GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
                final ContentPageModel createNewProduct = getContentPageForLabelOrId("create-newproduct");
                storeCmsPageInModel(model, createNewProduct);
                setUpMetaDataForContentPage(model, createNewProduct);
                return getViewForPage(model);
            }
            String returnAction = REDIRECT_TO_CREATE_NEWPRODUCT;
            final NewProductData newProduct = new NewProductData();
            newProduct.setCode(newProductForm.getCode());
            newProduct.setName(newProductForm.getName());
            newProduct.setDescription(newProductForm.getDescription());
            newProduct.setSize(newProductForm.getSize());
            newProduct.setColor(newProductForm.getColor());

            model.addAttribute("newProductForm", new NewProductForm());

            final ContentPageModel createNewProductPage = getContentPageForLabelOrId("create-newproduct");
            storeCmsPageInModel(model, createNewProductPage);
            setUpMetaDataForContentPage(model, createNewProductPage);

            getNewProductFacade().createNewProduct(newProduct);
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                    "NewProduct Created!", null);

            return returnAction;
        }

        @RequestMapping(value = "/update-newproduct-color", method = RequestMethod.GET)
        public String updateNewProduct(final Model model) throws CMSItemNotFoundException
        {
            LOG.info("######## NewProductController ########");
            model.addAttribute("newProductForm", new NewProductForm());
            final ContentPageModel updateNewProductColor = getContentPageForLabelOrId("update-newproduct-color");
            storeCmsPageInModel(model, updateNewProductColor);
            setUpMetaDataForContentPage(model, updateNewProductColor);
            return ControllerConstants.Views.Pages.Product.UpdateNewProductColor;
        }

        @RequestMapping(value = "/update-newproduct-color", method = RequestMethod.POST)
        public String updateNewProductColor(final NewProductForm newProductForm, final BindingResult bindingResult, final Model model,
                                           final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
        {
            LOG.info("######## NewProductController ########");
            if(newProductForm.getCode() == null)
            {
                GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "Please Enter NewProduct Code", null);
                return REDIRECT_PREFIX + "update-newproduct-color";
            }
            if(getNewProductFacade().getSpecificNewProductDetails(newProductForm.getCode()).isEmpty())
            {
                GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "NewProduct Not Found", null);
                return REDIRECT_PREFIX + "update-newproduct-color";
            }
            if (bindingResult.hasErrors())
            {
                GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
                final ContentPageModel updateNewProductColor = getContentPageForLabelOrId("update-newproduct-color");
                storeCmsPageInModel(model, updateNewProductColor);
                setUpMetaDataForContentPage(model, updateNewProductColor);
                return getViewForPage(model);
            }
            String returnAction = REDIRECT_TO_CREATE_NEWPRODUCT;

            final List <NewProductData> newProductData = newProductFacade.getSpecificNewProductDetails(newProductForm.getCode());

            model.addAttribute("newProductForm", new NewProductForm());

            final ContentPageModel updateNewProductColor = getContentPageForLabelOrId("update-newproduct-color");
            storeCmsPageInModel(model, updateNewProductColor);
            setUpMetaDataForContentPage(model, updateNewProductColor);

            getNewProductFacade().updateNewProduct(newProductForm.getCode(), newProductForm.getColor());
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                    "NewProduct Color Updated!", null);

            return returnAction;
        }

        @RequestMapping(value = "/remove-newproduct/{code}", method = RequestMethod.POST)
        public String removeNewProduct(@PathVariable final String code,
                                     final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
        {
            LOG.info("######## NewProductController ########");

            String returnAction = REDIRECT_TO_CREATE_NEWPRODUCT;

            getNewProductFacade().removeNewProduct(code);
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                    "NewProduct Removed with Code - " + code + "!" , null);

            return returnAction;
        }
        protected NewProductForm getPreparedNewProductForm()
        {
            final NewProductForm newProductForm = new NewProductForm();
            newProductForm.setCode("");
            newProductForm.setName("");
            newProductForm.setDescription("");
            newProductForm.setSize(0);
            newProductForm.setColor("");

            return newProductForm;
        }

        public NewProductFacade getNewProductFacade()
        {
            return newProductFacade;
        }
        public void setNewProductFacade(final NewProductFacade newProductFacade)
        {
            this.newProductFacade = newProductFacade;
        }
        public static String getNewProductCmsPage()
        {
            return NEWPRODUCT_CMS_PAGE;
        }
    }
