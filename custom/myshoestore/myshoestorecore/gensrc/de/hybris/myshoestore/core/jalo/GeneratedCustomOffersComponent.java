/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 30, 2023, 12:32:47 PM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myshoestore.core.jalo;

import de.hybris.myshoestore.core.constants.MyshoestoreCoreConstants;
import de.hybris.platform.cms2.jalo.contents.components.CMSLinkComponent;
import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.myshoestore.core.jalo.CustomOffersComponent CustomOffersComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedCustomOffersComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>CustomOffersComponent.headerText</code> attribute **/
	public static final String HEADERTEXT = "headerText";
	/** Qualifier of the <code>CustomOffersComponent.footerText</code> attribute **/
	public static final String FOOTERTEXT = "footerText";
	/** Qualifier of the <code>CustomOffersComponent.offerImage</code> attribute **/
	public static final String OFFERIMAGE = "offerImage";
	/** Qualifier of the <code>CustomOffersComponent.offerImageLink</code> attribute **/
	public static final String OFFERIMAGELINK = "offerImageLink";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(HEADERTEXT, AttributeMode.INITIAL);
		tmp.put(FOOTERTEXT, AttributeMode.INITIAL);
		tmp.put(OFFERIMAGE, AttributeMode.INITIAL);
		tmp.put(OFFERIMAGELINK, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.footerText</code> attribute.
	 * @return the footerText
	 */
	public String getFooterText(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomOffersComponent.getFooterText requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, FOOTERTEXT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.footerText</code> attribute.
	 * @return the footerText
	 */
	public String getFooterText()
	{
		return getFooterText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.footerText</code> attribute. 
	 * @return the localized footerText
	 */
	public Map<Language,String> getAllFooterText(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,FOOTERTEXT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.footerText</code> attribute. 
	 * @return the localized footerText
	 */
	public Map<Language,String> getAllFooterText()
	{
		return getAllFooterText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.footerText</code> attribute. 
	 * @param value the footerText
	 */
	public void setFooterText(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomOffersComponent.setFooterText requires a session language", 0 );
		}
		setLocalizedProperty(ctx, FOOTERTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.footerText</code> attribute. 
	 * @param value the footerText
	 */
	public void setFooterText(final String value)
	{
		setFooterText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.footerText</code> attribute. 
	 * @param value the footerText
	 */
	public void setAllFooterText(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,FOOTERTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.footerText</code> attribute. 
	 * @param value the footerText
	 */
	public void setAllFooterText(final Map<Language,String> value)
	{
		setAllFooterText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.headerText</code> attribute.
	 * @return the headerText
	 */
	public String getHeaderText(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomOffersComponent.getHeaderText requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, HEADERTEXT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.headerText</code> attribute.
	 * @return the headerText
	 */
	public String getHeaderText()
	{
		return getHeaderText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.headerText</code> attribute. 
	 * @return the localized headerText
	 */
	public Map<Language,String> getAllHeaderText(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,HEADERTEXT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.headerText</code> attribute. 
	 * @return the localized headerText
	 */
	public Map<Language,String> getAllHeaderText()
	{
		return getAllHeaderText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.headerText</code> attribute. 
	 * @param value the headerText
	 */
	public void setHeaderText(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomOffersComponent.setHeaderText requires a session language", 0 );
		}
		setLocalizedProperty(ctx, HEADERTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.headerText</code> attribute. 
	 * @param value the headerText
	 */
	public void setHeaderText(final String value)
	{
		setHeaderText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.headerText</code> attribute. 
	 * @param value the headerText
	 */
	public void setAllHeaderText(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,HEADERTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.headerText</code> attribute. 
	 * @param value the headerText
	 */
	public void setAllHeaderText(final Map<Language,String> value)
	{
		setAllHeaderText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.offerImage</code> attribute.
	 * @return the offerImage
	 */
	public Media getOfferImage(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, OFFERIMAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.offerImage</code> attribute.
	 * @return the offerImage
	 */
	public Media getOfferImage()
	{
		return getOfferImage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.offerImage</code> attribute. 
	 * @param value the offerImage
	 */
	public void setOfferImage(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, OFFERIMAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.offerImage</code> attribute. 
	 * @param value the offerImage
	 */
	public void setOfferImage(final Media value)
	{
		setOfferImage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.offerImageLink</code> attribute.
	 * @return the offerImageLink - List of CMS Link Component
	 */
	public List<CMSLinkComponent> getOfferImageLink(final SessionContext ctx)
	{
		List<CMSLinkComponent> coll = (List<CMSLinkComponent>)getProperty( ctx, OFFERIMAGELINK);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomOffersComponent.offerImageLink</code> attribute.
	 * @return the offerImageLink - List of CMS Link Component
	 */
	public List<CMSLinkComponent> getOfferImageLink()
	{
		return getOfferImageLink( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.offerImageLink</code> attribute. 
	 * @param value the offerImageLink - List of CMS Link Component
	 */
	public void setOfferImageLink(final SessionContext ctx, final List<CMSLinkComponent> value)
	{
		setProperty(ctx, OFFERIMAGELINK,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomOffersComponent.offerImageLink</code> attribute. 
	 * @param value the offerImageLink - List of CMS Link Component
	 */
	public void setOfferImageLink(final List<CMSLinkComponent> value)
	{
		setOfferImageLink( getSession().getSessionContext(), value );
	}
	
}
