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
import de.hybris.myshoestore.core.jalo.LenskartBrand;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem LenskartProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedLenskartProduct extends GenericItem
{
	/** Qualifier of the <code>LenskartProduct.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>LenskartProduct.size</code> attribute **/
	public static final String SIZE = "size";
	/** Qualifier of the <code>LenskartProduct.colour</code> attribute **/
	public static final String COLOUR = "colour";
	/** Qualifier of the <code>LenskartProduct.lenskartBrand</code> attribute **/
	public static final String LENSKARTBRAND = "lenskartBrand";
	/**
	* {@link OneToManyHandler} for handling 1:n LENSKARTBRAND's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<LenskartBrand> LENSKARTBRANDHANDLER = new OneToManyHandler<LenskartBrand>(
	MyshoestoreCoreConstants.TC.LENSKARTBRAND,
	true,
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
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(SIZE, AttributeMode.INITIAL);
		tmp.put(COLOUR, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.colour</code> attribute.
	 * @return the colour - Product Color
	 */
	public EnumerationValue getColour(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, COLOUR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.colour</code> attribute.
	 * @return the colour - Product Color
	 */
	public EnumerationValue getColour()
	{
		return getColour( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.colour</code> attribute. 
	 * @param value the colour - Product Color
	 */
	public void setColour(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, COLOUR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.colour</code> attribute. 
	 * @param value the colour - Product Color
	 */
	public void setColour(final EnumerationValue value)
	{
		setColour( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.lenskartBrand</code> attribute.
	 * @return the lenskartBrand
	 */
	public Set<LenskartBrand> getLenskartBrand(final SessionContext ctx)
	{
		return (Set<LenskartBrand>)LENSKARTBRANDHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.lenskartBrand</code> attribute.
	 * @return the lenskartBrand
	 */
	public Set<LenskartBrand> getLenskartBrand()
	{
		return getLenskartBrand( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.lenskartBrand</code> attribute. 
	 * @param value the lenskartBrand
	 */
	public void setLenskartBrand(final SessionContext ctx, final Set<LenskartBrand> value)
	{
		LENSKARTBRANDHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.lenskartBrand</code> attribute. 
	 * @param value the lenskartBrand
	 */
	public void setLenskartBrand(final Set<LenskartBrand> value)
	{
		setLenskartBrand( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to lenskartBrand. 
	 * @param value the item to add to lenskartBrand
	 */
	public void addToLenskartBrand(final SessionContext ctx, final LenskartBrand value)
	{
		LENSKARTBRANDHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to lenskartBrand. 
	 * @param value the item to add to lenskartBrand
	 */
	public void addToLenskartBrand(final LenskartBrand value)
	{
		addToLenskartBrand( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from lenskartBrand. 
	 * @param value the item to remove from lenskartBrand
	 */
	public void removeFromLenskartBrand(final SessionContext ctx, final LenskartBrand value)
	{
		LENSKARTBRANDHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from lenskartBrand. 
	 * @param value the item to remove from lenskartBrand
	 */
	public void removeFromLenskartBrand(final LenskartBrand value)
	{
		removeFromLenskartBrand( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.name</code> attribute.
	 * @return the name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.name</code> attribute.
	 * @return the name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.size</code> attribute.
	 * @return the size
	 */
	public Integer getSize(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, SIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.size</code> attribute.
	 * @return the size
	 */
	public Integer getSize()
	{
		return getSize( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.size</code> attribute. 
	 * @return the size
	 */
	public int getSizeAsPrimitive(final SessionContext ctx)
	{
		Integer value = getSize( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LenskartProduct.size</code> attribute. 
	 * @return the size
	 */
	public int getSizeAsPrimitive()
	{
		return getSizeAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, SIZE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final Integer value)
	{
		setSize( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final SessionContext ctx, final int value)
	{
		setSize( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LenskartProduct.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final int value)
	{
		setSize( getSession().getSessionContext(), value );
	}
	
}
