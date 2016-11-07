package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OfferItemCondition
 * A list of possible conditions for the item.
 * @author schema.org
 * @module schema.org
 * @class OfferItemCondition
 * @extends Enumeration
 */
public class OfferItemCondition extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OfferItemCondition()
	{
		context="http://schema.org/";
		type="OfferItemCondition";
	}

}