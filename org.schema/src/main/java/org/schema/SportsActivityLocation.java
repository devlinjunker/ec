package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SportsActivityLocation
 * A sports location, such as a playing field.
 * @author schema.org
 * @module schema.org
 * @class SportsActivityLocation
 * @extends LocalBusiness
 */
public class SportsActivityLocation extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportsActivityLocation()
	{
		context="http://schema.org/";
		type="SportsActivityLocation";
	}

}