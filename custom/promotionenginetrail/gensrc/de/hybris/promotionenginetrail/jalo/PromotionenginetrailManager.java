/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 12, 2023, 12:36:34 PM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.promotionenginetrail.jalo;

import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.promotionenginetrail.constants.PromotionenginetrailConstants;
import de.hybris.promotionenginetrail.jalo.RuleBasedAddUserToUserGroupAction;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>PromotionenginetrailManager</code>.
 */
@SuppressWarnings({"unused","cast"})
@SLDSafe
public class PromotionenginetrailManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
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
	
	public RuleBasedAddUserToUserGroupAction createRuleBasedAddUserToUserGroupAction(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("RuleBasedAddUserToUserGroupAction");
			return (RuleBasedAddUserToUserGroupAction)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating RuleBasedAddUserToUserGroupAction : "+e.getMessage(), 0 );
		}
	}
	
	public RuleBasedAddUserToUserGroupAction createRuleBasedAddUserToUserGroupAction(final Map attributeValues)
	{
		return createRuleBasedAddUserToUserGroupAction( getSession().getSessionContext(), attributeValues );
	}
	
	public static final PromotionenginetrailManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (PromotionenginetrailManager) em.getExtension(PromotionenginetrailConstants.EXTENSIONNAME);
	}
	
	@Override
	public String getName()
	{
		return PromotionenginetrailConstants.EXTENSIONNAME;
	}
	
}
