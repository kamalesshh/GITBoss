package de.hybris.newproductwebservices.v2.controller;
import de.hybris.platform.commercewebservicescommons.dto.newproduct.NewProductDataListWSDTO;
import de.hybris.platform.commercewebservicescommons.dto.newproduct.NewProductDataWSDTO;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import de.hybris.platform.webservicescommons.swagger.ApiFieldsParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import de.hybris.myshoestore.facades.NewProduct.NewProductFacade;
import de.hybris.myshoestore.facades.NewProductData;
import de.hybris.newproductwebservices.queues.data.NewProductDataList;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/myShoeStore/en")
@Api(tags = "NewProduct")
public class NewProductController extends BaseCommerceController
{

    private static final String NEWPRODUCT_MAPPING = "code, name, description, size, color";
    public static final String NEWPRODUCT_DOES_NOT_EXIST = "NewProduct with given code: '%s' doesn't exist";
    private static final String OBJECT_NAME_NEWPRODUCT_CODE = "code";

    private static final Logger LOGGER = Logger.getLogger(NewProductController.class);

    @Resource(name = "newProductFacade")
    private NewProductFacade newProductFacade;

    public NewProductFacade getNewProductFacade()
    {
        return newProductFacade;
    }

    public void setNewProductFacade(NewProductFacade newProductFacade)
    {
        this.newProductFacade = newProductFacade;
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(nickname = "getSpecificNewProductDetails", value = "Get a Specific Product Details",
            notes = "Return a specific Product based on code",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    public NewProductDataListWSDTO getSpecificNewProductDetails(
            @ApiParam(value = "code", required = true)
            @PathVariable final String code,@ApiParam(value = "Response configuration. This is the list of fields that should be returned in the response body",
            allowableValues = "BASIC,DEFAULT,FULL")
            @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields)
    {
        LOGGER.info("Product code is " + code);
        final NewProductDataList newProductDataList = new NewProductDataList();
        newProductDataList.setNewProduct(newProductFacade.getSpecificNewProductDetails(code));
        return getDataMapper().map(newProductDataList, NewProductDataListWSDTO.class, fields);
    }

    @Secured({"ROLE_TRUSTED_CLIENT"})
    @RequestMapping(value = {"/{code}"}, method = {RequestMethod.DELETE})
    @ApiOperation(nickname = "removeNewProduct", value = "Delete Product",
            notes = "Removes Product",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    @ResponseStatus(HttpStatus.OK)
    public void removeNewProduct(@ApiParam(value = "Product identifier.", required = true) @PathVariable final String code)
    {
        LOGGER.info("removeNewProduct: code = " + code);
        this.getNewProductFacade().removeNewProduct(code);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(nickname = "getAllNewProductDetails", value = "Get data of All Product Details",
            notes = "Return data of All Products",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    public NewProductDataListWSDTO getAllNewProductDetails()
    {
        LOGGER.info("NewProducts Data");
        final NewProductDataList newProductDataList = new NewProductDataList();
        newProductDataList.setNewProduct(newProductFacade.getNewProductDetails());
        return getDataMapper().map(newProductDataList, NewProductDataListWSDTO.class);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = {"/{id}"},
            method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(nickname = "createNewProduct", value = "Create a Product",
            notes = "Create an Product",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public NewProductDataWSDTO createNewProductDetails(
            @ApiParam(value = "NewProduct object", required = true) @RequestBody final NewProductDataWSDTO newProduct,
            @ApiFieldsParam @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields)
    {
        final NewProductData newProductData = getDataMapper().map(newProduct, NewProductData.class, NEWPRODUCT_MAPPING);
        this.getNewProductFacade().createNewProduct(newProductData);
        return getDataMapper().map(newProductData, NewProductDataWSDTO.class, fields);
    }
//
//    @Secured("ROLE_TRUSTED_CLIENT")
//    @RequestMapping(value = "/{code}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(nickname = "replaceNewProduct", value = "Updates Product details", notes = "Updates Product details.",
//            authorizations = {@Authorization(value = "oauth2_client_credentials")})
//    @ApiBaseSiteIdParam
//    public void replaceNewProduct(@ApiParam(value = "Product Code.", required = true) @PathVariable final String code,
//                                @ApiParam(value = "Product Object.", required = true) @RequestBody final NewProductDataWSDTO newProduct)
//    {
//        if (getNewProductFacade().getSpecificNewProductDetails(code).isEmpty())
//        {
//            LOGGER.error("Product Not Found");
//        }
//        else
//        {
//            final NewProductData newProductData = getDataMapper().map(newProduct, NewProductData.class, NEWPRODUCT_MAPPING);
//            getNewProductFacade().replaceNewProduct(newProductData, code);
//        }
//    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{code}/{color}", method = RequestMethod.PATCH)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(nickname = "UpdateNewProductColor", value = "Updates Product Color", notes = "Updates Product Color.",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public void updateNewProduct(@ApiParam(value = "Product code.", required = true) @PathVariable final String code,
                                @ApiParam(value = "Product New color.", required = true) @PathVariable final String color)
    {
        if (getNewProductFacade().getSpecificNewProductDetails(code).isEmpty())
        {
            LOGGER.error("Product Not Found");
        }
        else
        {
            getNewProductFacade().updateNewProduct(code, color);
        }
    }

}