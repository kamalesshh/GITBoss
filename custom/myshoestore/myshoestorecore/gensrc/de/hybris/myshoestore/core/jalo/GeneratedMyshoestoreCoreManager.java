/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 12, 2023, 12:36:34 PM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myshoestore.core.jalo;

import com.stackextend.training.jalo.components.YoutubeVideoComponent;
import de.hybris.myshoestore.core.constants.MyshoestoreCoreConstants;
import de.hybris.myshoestore.core.jalo.ApparelProduct;
import de.hybris.myshoestore.core.jalo.ApparelSizeVariantProduct;
import de.hybris.myshoestore.core.jalo.ApparelStyleVariantProduct;
import de.hybris.myshoestore.core.jalo.CustomOffersComponent;
import de.hybris.myshoestore.core.jalo.ElectronicsColorVariantProduct;
import de.hybris.myshoestore.core.jalo.Ingredients;
import de.hybris.myshoestore.core.jalo.LenskartBrand;
import de.hybris.myshoestore.core.jalo.LenskartProduct;
import de.hybris.myshoestore.core.jalo.NewProduct;
import de.hybris.myshoestore.core.jalo.Recipe;
import de.hybris.myshoestore.core.jalo.process.HelloWorldEmailProcess;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>MyshoestoreCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedMyshoestoreCoreManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("myCustomAttribute", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("LoyaltyPoints", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public CustomOffersComponent createCustomOffersComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.CUSTOMOFFERSCOMPONENT );
			return (CustomOffersComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CustomOffersComponent : "+e.getMessage(), 0 );
		}
	}
	
	public CustomOffersComponent createCustomOffersComponent(final Map attributeValues)
	{
		return createCustomOffersComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public HelloWorldEmailProcess createHelloWorldEmailProcess(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.HELLOWORLDEMAILPROCESS );
			return (HelloWorldEmailProcess)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating HelloWorldEmailProcess : "+e.getMessage(), 0 );
		}
	}
	
	public HelloWorldEmailProcess createHelloWorldEmailProcess(final Map attributeValues)
	{
		return createHelloWorldEmailProcess( getSession().getSessionContext(), attributeValues );
	}
	
	public Ingredients createIngredients(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.INGREDIENTS );
			return (Ingredients)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Ingredients : "+e.getMessage(), 0 );
		}
	}
	
	public Ingredients createIngredients(final Map attributeValues)
	{
		return createIngredients( getSession().getSessionContext(), attributeValues );
	}
	
	public LenskartBrand createLenskartBrand(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.LENSKARTBRAND );
			return (LenskartBrand)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating LenskartBrand : "+e.getMessage(), 0 );
		}
	}
	
	public LenskartBrand createLenskartBrand(final Map attributeValues)
	{
		return createLenskartBrand( getSession().getSessionContext(), attributeValues );
	}
	
	public LenskartProduct createLenskartProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.LENSKARTPRODUCT );
			return (LenskartProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating LenskartProduct : "+e.getMessage(), 0 );
		}
	}
	
	public LenskartProduct createLenskartProduct(final Map attributeValues)
	{
		return createLenskartProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public NewProduct createNewProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.NEWPRODUCT );
			return (NewProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating NewProduct : "+e.getMessage(), 0 );
		}
	}
	
	public NewProduct createNewProduct(final Map attributeValues)
	{
		return createNewProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Recipe createRecipe(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.RECIPE );
			return (Recipe)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Recipe : "+e.getMessage(), 0 );
		}
	}
	
	public Recipe createRecipe(final Map attributeValues)
	{
		return createRecipe( getSession().getSessionContext(), attributeValues );
	}
	
	public YoutubeVideoComponent createYoutubeVideoComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MyshoestoreCoreConstants.TC.YOUTUBEVIDEOCOMPONENT );
			return (YoutubeVideoComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating YoutubeVideoComponent : "+e.getMessage(), 0 );
		}
	}
	
	public YoutubeVideoComponent createYoutubeVideoComponent(final Map attributeValues)
	{
		return createYoutubeVideoComponent( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return MyshoestoreCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.LoyaltyPoints</code> attribute.
	 * @return the LoyaltyPoints - Loyalty Points of User
	 */
	public Integer getLoyaltyPoints(final SessionContext ctx, final Customer item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomer.getLoyaltyPoints requires a session language", 0 );
		}
		return (Integer)item.getLocalizedProperty( ctx, MyshoestoreCoreConstants.Attributes.Customer.LOYALTYPOINTS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.LoyaltyPoints</code> attribute.
	 * @return the LoyaltyPoints - Loyalty Points of User
	 */
	public Integer getLoyaltyPoints(final Customer item)
	{
		return getLoyaltyPoints( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @return the LoyaltyPoints - Loyalty Points of User
	 */
	public int getLoyaltyPointsAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Integer value = getLoyaltyPoints( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @return the LoyaltyPoints - Loyalty Points of User
	 */
	public int getLoyaltyPointsAsPrimitive(final Customer item)
	{
		return getLoyaltyPointsAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @return the localized LoyaltyPoints - Loyalty Points of User
	 */
	public Map<Language,Integer> getAllLoyaltyPoints(final SessionContext ctx, final Customer item)
	{
		return (Map<Language,Integer>)item.getAllLocalizedProperties(ctx,MyshoestoreCoreConstants.Attributes.Customer.LOYALTYPOINTS,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @return the localized LoyaltyPoints - Loyalty Points of User
	 */
	public Map<Language,Integer> getAllLoyaltyPoints(final Customer item)
	{
		return getAllLoyaltyPoints( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @param value the LoyaltyPoints - Loyalty Points of User
	 */
	public void setLoyaltyPoints(final SessionContext ctx, final Customer item, final Integer value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomer.setLoyaltyPoints requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, MyshoestoreCoreConstants.Attributes.Customer.LOYALTYPOINTS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @param value the LoyaltyPoints - Loyalty Points of User
	 */
	public void setLoyaltyPoints(final Customer item, final Integer value)
	{
		setLoyaltyPoints( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @param value the LoyaltyPoints - Loyalty Points of User
	 */
	public void setLoyaltyPoints(final SessionContext ctx, final Customer item, final int value)
	{
		setLoyaltyPoints( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @param value the LoyaltyPoints - Loyalty Points of User
	 */
	public void setLoyaltyPoints(final Customer item, final int value)
	{
		setLoyaltyPoints( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @param value the LoyaltyPoints - Loyalty Points of User
	 */
	public void setAllLoyaltyPoints(final SessionContext ctx, final Customer item, final Map<Language,Integer> value)
	{
		item.setAllLocalizedProperties(ctx,MyshoestoreCoreConstants.Attributes.Customer.LOYALTYPOINTS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.LoyaltyPoints</code> attribute. 
	 * @param value the LoyaltyPoints - Loyalty Points of User
	 */
	public void setAllLoyaltyPoints(final Customer item, final Map<Language,Integer> value)
	{
		setAllLoyaltyPoints( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.myCustomAttribute</code> attribute.
	 * @return the myCustomAttribute
	 */
	public String getMyCustomAttribute(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, MyshoestoreCoreConstants.Attributes.Product.MYCUSTOMATTRIBUTE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.myCustomAttribute</code> attribute.
	 * @return the myCustomAttribute
	 */
	public String getMyCustomAttribute(final Product item)
	{
		return getMyCustomAttribute( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.myCustomAttribute</code> attribute. 
	 * @param value the myCustomAttribute
	 */
	public void setMyCustomAttribute(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, MyshoestoreCoreConstants.Attributes.Product.MYCUSTOMATTRIBUTE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.myCustomAttribute</code> attribute. 
	 * @param value the myCustomAttribute
	 */
	public void setMyCustomAttribute(final Product item, final String value)
	{
		setMyCustomAttribute( getSession().getSessionContext(), item, value );
	}
	
}
