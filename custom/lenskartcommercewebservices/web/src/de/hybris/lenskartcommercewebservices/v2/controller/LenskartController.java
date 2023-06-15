package de.hybris.lenskartcommercewebservices.v2.controller;
import de.hybris.lenskartcommercewebservices.queues.data.LenskartProductDataList;
import de.hybris.myshoestore.facades.LenskartProduct.LenskartProductFacade;
import de.hybris.myshoestore.facades.LenskartProductData;
import de.hybris.platform.commercewebservicescommons.dto.lenskartproduct.LenskartProductDataListWSDTO;
import de.hybris.platform.commercewebservicescommons.dto.lenskartproduct.LenskartProductDataWSDTO;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import de.hybris.platform.webservicescommons.swagger.ApiFieldsParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



import javax.annotation.Resource;
import javax.xml.bind.annotation.XmlTransient;

@Controller
@RequestMapping(value = "/myShoeStore/en")
@Api(tags = "LenskartProduct")
public class LenskartController extends BaseCommerceController
{

    private static final String LENSKARTPRODUCT_MAPPING = "name, size, colour";
    public static final String LENSKARTPRODUCT_DOES_NOT_EXIST = "LenskartProduct with given code: '%s' doesn't exist";
    private static final String OBJECT_NAME_LENSKARTPRODUCT_NAME = "name";

    private static final Logger LOGGER = Logger.getLogger(LenskartController.class);

    @Resource(name = "lenskartProductFacade")
    private LenskartProductFacade lenskartProductFacade;

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{name}", method=RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(nickname = "getSpecificLenskartProductDetails", value = "Get a Specific Product Details",
            notes = "Return a specific Product based on name",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public LenskartProductDataListWSDTO getSpecificLenskartProductDetails(
            @ApiParam(value = "name", required = true)
            @PathVariable final String name,
            @ApiParam(value = "Response configuration. This is the list of fields that should be returned in the response body",
            allowableValues = "BASIC,DEFAULT,FULL")
            @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields)
    {
        LOGGER.info("Product name is " +name);
        final LenskartProductDataList lenskartProductDataList = new LenskartProductDataList();
        lenskartProductDataList.setLenskartProduct(lenskartProductFacade.getSpecificLenskartProductDetails(name));
        return getDataMapper().map(lenskartProductDataList, LenskartProductDataListWSDTO.class);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = {"/{name}"}, method = {RequestMethod.DELETE})
    @ApiOperation(nickname = "removeLenskartProduct", value = "Delete Product",
            notes = "Removes Product",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    @ResponseStatus(HttpStatus.OK)
    public void removeLenskartProduct(@ApiParam(value = "Product identifier.", required = true) @PathVariable final String name)
    {
        LOGGER.info("removeLenskartProduct: name = " + name);
        this.getLenskartProductFacade().removeLenskartProduct(name);
    }

    @Secured("ROLE_TRUSTED_CLIENT")

    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(nickname = "getAllLenskartProductDetails", value = "Get data of All Product Details",
            notes = "Return data of All Products",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @XmlTransient

    public LenskartProductDataListWSDTO getLenskartProductDetails()
    {
        LOGGER.info("LenskartProducts Data");
        final LenskartProductDataList lenskartProductDataList = new LenskartProductDataList();
        lenskartProductDataList.setLenskartProduct(lenskartProductFacade.getLenskartProductDetails());
        return getDataMapper().map(lenskartProductDataList, LenskartProductDataListWSDTO.class);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(nickname = "createLenskartProduct", value = "Create a Product",
            notes = "Create a Product",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    @XmlTransient
    public LenskartProductDataWSDTO createLenskartProduct(
            @ApiParam(value = "LenskartProduct object", required = true) @RequestBody final LenskartProductDataWSDTO lenskartProduct,
            @ApiFieldsParam @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields)
    {
        final LenskartProductData lenskartProductData = getDataMapper().map(lenskartProduct, LenskartProductData.class, LENSKARTPRODUCT_MAPPING);
        getLenskartProductFacade().createLenskartProduct(lenskartProductData);
        return getDataMapper().map(lenskartProductData, LenskartProductDataWSDTO.class, fields);
    }
//
//    @Secured("ROLE_TRUSTED_CLIENT")
//    @RequestMapping(value = "/{code}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(nickname = "replaceLenskartProduct", value = "Updates Product details", notes = "Updates Product details.",
//            authorizations = {@Authorization(value = "oauth2_client_credentials")})
//    @ApiBaseSiteIdParam
//    public void replaceLenskartProduct(@ApiParam(value = "Product Code.", required = true) @PathVariable final String code,
//                                @ApiParam(value = "Product Object.", required = true) @RequestBody final LenskartProductDataWSDTO lenskartProduct)
//    {
//        if (getLenskartProductFacade().getSpecificLenskartProductDetails(code).isEmpty())
//        {
//            LOGGER.error("Product Not Found");
//        }
//        else
//        {
//            final LenskartProductData lenskartProductData = getDataMapper().map(lenskartProduct, LenskartProductData.class, NEWPRODUCT_MAPPING);
//            getLenskartProductFacade().replaceLenskartProduct(lenskartProductData, code);
//        }
//    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{name}/{size}", method = RequestMethod.PATCH)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(nickname = "UpdateLenskartProductName", value = "Updates Product Name", notes = "Updates Product name.",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public void updateLenskartProduct(@ApiParam(value = "Product name.", required = true) @PathVariable final String name,
                                 @ApiParam(value = "Product New size.", required = true) @PathVariable final Integer size)
    {
        if (getLenskartProductFacade().getSpecificLenskartProductDetails(name).isEmpty())
        {
            LOGGER.error("Product Not Found");
        }
        else
        {
            getLenskartProductFacade().updateLenskartProduct(name, size);
        }
    }

    public LenskartProductFacade getLenskartProductFacade() {
        return lenskartProductFacade;
    }

    public void setLenskartProductFacade(LenskartProductFacade lenskartProductFacade) {
        this.lenskartProductFacade = lenskartProductFacade;
    }
}