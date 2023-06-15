/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 12, 2023, 12:36:34 PM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.newproductcronjob.jalo;

import de.hybris.platform.cronjob.jalo.CronJob;
import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.media.Media;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type NewProductCronJob.
 */
@SLDSafe
@SuppressWarnings({"unused","cast"})
public class NewProductCronJob extends CronJob
{
	/** Qualifier of the <code>NewProductCronJob.exportMedia</code> attribute **/
	public static final String EXPORTMEDIA = "exportMedia";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CronJob.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(EXPORTMEDIA, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProductCronJob.exportMedia</code> attribute.
	 * @return the exportMedia
	 */
	public Collection<Media> getExportMedia(final SessionContext ctx)
	{
		Collection<Media> coll = (Collection<Media>)getProperty( ctx, "exportMedia".intern());
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProductCronJob.exportMedia</code> attribute.
	 * @return the exportMedia
	 */
	public Collection<Media> getExportMedia()
	{
		return getExportMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProductCronJob.exportMedia</code> attribute. 
	 * @param value the exportMedia
	 */
	public void setExportMedia(final SessionContext ctx, final Collection<Media> value)
	{
		setProperty(ctx, "exportMedia".intern(),value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProductCronJob.exportMedia</code> attribute. 
	 * @param value the exportMedia
	 */
	public void setExportMedia(final Collection<Media> value)
	{
		setExportMedia( getSession().getSessionContext(), value );
	}
	
}
