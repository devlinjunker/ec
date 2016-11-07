package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BefriendAction
 * The act of forming a personal connection with someone (object) mutually/bidirectionally/symmetrically.\n\nRelated actions:\n\n* [[FollowAction]]: Unlike FollowAction, BefriendAction implies that the connection is reciprocal.
 * @author schema.org
 * @module schema.org
 * @class BefriendAction
 * @extends InteractAction
 */
public class BefriendAction extends InteractAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BefriendAction()
	{
		context="http://schema.org/";
		type="BefriendAction";
	}

}