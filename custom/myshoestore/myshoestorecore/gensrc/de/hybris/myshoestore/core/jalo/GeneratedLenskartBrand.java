/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 12, 2023, 12:36:34 PM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myshoestore.core.jalo;

import de.hybris.myshoestore.core.constants.MyshoestoreCoreConstants;
import de.hybris.myshoestore.core.jalo.LenskartProduct;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem LenskartBrand}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedLenskartBrand extends GenericItem
{
	/** Qualifier of the <code>LenskartBrand.brand</code> attribute **/
	public static final String BRAND = "brand";
	/** Qualifier of the <code>LenskartBrand.lenskartProduct</code> attribute **/
	public static final String LENSKARTPRODUCT = "lenskartProduct";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n LENSKARTPRODUCT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedLenskartBrand> LENSKARTPRODUCTHANDLER = new BidirectionalOneToManyHandler<GeneratedLenskartBrand>(
	MyshoestoreCoreConstants.TC.LENSKARTBRAND,
	false,
	"lenskartProduct",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(BRAND, AttributeMode.INITIAL);
		tmp.put(LENSKARTPRODUCT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartBrand.brand</code> attribute.
	 * @return the brand
	 */
	public String getBrand(final SessionContext ctx)
	{
		return (String)getProperty( ctx, BRAND);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartBrand.brand</code> attribute.
	 * @return the brand
	 */
	public String getBrand()
	{
		return getBrand( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartBrand.brand</code> attribute. 
	 * @param value the brand
	 */
	public void setBrand(final SessionContext ctx, final String value)
	{
		setProperty(ctx, BRAND,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartBrand.brand</code> attribute. 
	 * @param value the brand
	 */
	public void setBrand(final String value)
	{
		setBrand( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		LENSKARTPRODUCTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartBrand.lenskartProduct</code> attribute.
	 * @return the lenskartProduct
	 */
	public LenskartProduct getLenskartProduct(final SessionContext ctx)
	{
		return (LenskartProduct)getProperty( ctx, LENSKARTPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartBrand.lenskartProduct</code> attribute.
	 * @return the lenskartProduct
	 */
	public LenskartProduct getLenskartProduct()
	{
		return getLenskartProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartBrand.lenskartProduct</code> attribute. 
	 * @param value the lenskartProduct
	 */
	public void setLenskartProduct(final SessionContext ctx, final LenskartProduct value)
	{
		LENSKARTPRODUCTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartBrand.lenskartProduct</code> attribute. 
	 * @param value the lenskartProduct
	 */
	public void setLenskartProduct(final LenskartProduct value)
	{
		setLenskartProduct( getSession().getSessionContext(), value );
	}
	
}
