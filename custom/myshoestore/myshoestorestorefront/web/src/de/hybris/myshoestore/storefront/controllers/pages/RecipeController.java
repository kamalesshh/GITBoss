package de.hybris.myshoestore.storefront.controllers.pages;

import de.hybris.myshoestore.core.Recipe.RecipeForm;
import de.hybris.myshoestore.core.Recipe.Service.RecipeService;
import de.hybris.myshoestore.facades.Recipe.RecipeFacade;
import de.hybris.myshoestore.facades.RecipeData;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/recipe")
public class RecipeController extends AbstractPageController {
    private final RecipeService recipeService;

    public RecipeFacade getRecipeFacade() {
        return recipeFacade;
    }

    public void setRecipeFacade(RecipeFacade recipeFacade) {
        this.recipeFacade = recipeFacade;
    }

    @Autowired
    private RecipeFacade recipeFacade;

    private static final String RECIPE_CMS_PAGE = "recipeDetails";

    private static final String REDIRECT_TO_CREATE_RECIPE = REDIRECT_PREFIX + "/recipe/getrecipes";

    private static final String FORM_GLOBAL_ERROR = "form.global.error";

    private static final Logger LOG = Logger.getLogger(RecipeController.class);

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/getrecipes", method = RequestMethod.GET)
    public String getRecipes(final Model model) throws CMSItemNotFoundException {

        final List<RecipeData> recipeData = recipeFacade.getAllRecipes();

        model.addAttribute("recipeData", recipeData);

        storeCmsPageInModel(model, getContentPageForLabelOrId("getrecipes"));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId("getrecipes"));

        return ControllerConstants.Views.Pages.Product.RecipeDetails;
    }

    @RequestMapping(value = "/create-recipe", method = RequestMethod.GET)
    public String createRecipe(final Model model) throws CMSItemNotFoundException {
        LOG.info("######## RecipeController GET ########");
        final RecipeForm recipeForm = getPreparedRecipeForm();
        model.addAttribute("recipeForm", new RecipeForm());
        final ContentPageModel createRecipePage = getContentPageForLabelOrId("create-recipe");
        storeCmsPageInModel(model, createRecipePage);
        setUpMetaDataForContentPage(model, createRecipePage);
        return ControllerConstants.Views.Pages.Product.CreateRecipe;
    }

    @RequestMapping(value = "/create-recipe", method = RequestMethod.POST)
    public String createRecipe(@Valid RecipeForm recipeForm, final BindingResult bindingResult, final Model model,
                               final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException {
        LOG.info("######## RecipeController POST ########");
        if (bindingResult.hasErrors()) {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            final ContentPageModel createRecipe = getContentPageForLabelOrId("create-recipe");
            storeCmsPageInModel(model, createRecipe);
            setUpMetaDataForContentPage(model, createRecipe);
            return REDIRECT_PREFIX + "create-recipe";
        }
        String returnAction = REDIRECT_TO_CREATE_RECIPE;
        final RecipeData recipe = new RecipeData();
        recipe.setCode(recipeForm.getCode());
        recipe.setTitle(recipeForm.getTitle());
        recipe.setIsComplicated(recipeForm.getComplicated());
        recipe.setDescription(recipeForm.getDescription());

        model.addAttribute("recipeForm", new RecipeForm());

        final ContentPageModel createRecipePage = getContentPageForLabelOrId("create-recipe");
        storeCmsPageInModel(model, createRecipePage);
        setUpMetaDataForContentPage(model, createRecipePage);

        getRecipeFacade().createRecipe(recipe);
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "Recipe Created!", null);

        return returnAction;
    }

    @RequestMapping(value = "/update-recipe-title", method = RequestMethod.GET)
    public String updateRecipe(final Model model) throws CMSItemNotFoundException {
        LOG.info("######## RecipeController GET ########");
        model.addAttribute("recipeForm", new RecipeForm());
        final ContentPageModel updateRecipeTitle = getContentPageForLabelOrId("update-recipe-title");
        storeCmsPageInModel(model, updateRecipeTitle);
        setUpMetaDataForContentPage(model, updateRecipeTitle);
        return ControllerConstants.Views.Pages.Product.updateRecipe;
    }

    @RequestMapping(value = "/update-recipe-title", method = RequestMethod.POST)
    public String updateRecipeTitle(final RecipeForm recipeForm, final BindingResult bindingResult, final Model model,
                                    final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException {
        LOG.info("######## RecipeController POST ########");
        if (recipeForm.getCode() == null) {
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "Please Enter Recipe Name", null);
            return REDIRECT_PREFIX + "update-recipe-title";
        }
        if (getRecipeFacade().getSpecificRecipeDetails(recipeForm.getCode()).isEmpty()) {
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "Recipe Not Found", null);
            return REDIRECT_PREFIX + "update-recipe-title";
        }
        if (bindingResult.hasErrors()) {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            final ContentPageModel updateRecipeTitle = getContentPageForLabelOrId("update-recipe-title");
            storeCmsPageInModel(model, updateRecipeTitle);
            setUpMetaDataForContentPage(model, updateRecipeTitle);
            return getViewForPage(model);
        }
        String returnAction = REDIRECT_TO_CREATE_RECIPE;

        final List<RecipeData> recipeData = recipeFacade.getSpecificRecipeDetails(recipeForm.getCode());

        model.addAttribute("recipeForm", new RecipeForm());

        final ContentPageModel updateRecipeTitle = getContentPageForLabelOrId("update-recipe-title");
        storeCmsPageInModel(model, updateRecipeTitle);
        setUpMetaDataForContentPage(model, updateRecipeTitle);

        getRecipeFacade().updateRecipe(recipeForm.getCode(), recipeForm.getTitle());
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "Recipe Title Updated!", null);

        return returnAction;
    }

    @RequestMapping(value = "/remove-recipe/{code}", method = RequestMethod.POST)
    public String removeRecipe(@PathVariable final String code,
                               final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException {
        LOG.info("######## RecipeController POST ########");

        String returnAction = REDIRECT_TO_CREATE_RECIPE;

        getRecipeFacade().removeRecipe(code);
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "Recipe Removed with CODE - " + code + "!", null);

        return returnAction;
    }

    protected RecipeForm getPreparedRecipeForm() {
        final RecipeForm RecipeForm = new RecipeForm();
        RecipeForm.setCode("");
        RecipeForm.setTitle("");
        RecipeForm.setDescription("");
        RecipeForm.setComplicated(true);

        return RecipeForm;
    }
}