package de.hybris.lenskartcommercewebservices.v2.controller;

import de.hybris.lenskartcommercewebservices.queues.data.RecipeDataList;
import de.hybris.myshoestore.facades.Recipe.RecipeFacade;
import de.hybris.platform.commercewebservicescommons.dto.recipe.RecipeDataListWSDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.bind.annotation.XmlTransient;
@Controller
@RequestMapping(value = "/myShoeStore/en")
@Api(tags = "Recipe")
public class RecipeController extends BaseCommerceController {


    private static final Logger LOGGER = Logger.getLogger(RecipeController.class);

    @Resource(name = "recipeFacade")
    private RecipeFacade recipeFacade;

    @Secured("ROLE_TRUSTED_CLIENT")

    @RequestMapping(value = "/all-recipes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(nickname = "getAllRecipeDetails", value = "Get data of All Product Details",
            notes = "Return data of All Products",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @XmlTransient

    public RecipeDataListWSDTO getRecipeDetails() {
        LOGGER.info("Recipes Data");
        final RecipeDataList recipeDataList = new RecipeDataList();
        recipeDataList.setRecipe(recipeFacade.getAllRecipes());
        return getDataMapper().map(recipeDataList, RecipeDataListWSDTO.class);
    }
}