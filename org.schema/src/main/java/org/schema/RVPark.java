package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RVPark
 * A place offering space for "Recreational Vehicles", Caravans, mobile homes and the like.
 * @author schema.org
 * @module schema.org
 * @class RVPark
 * @extends CivicStructure
 */
public class RVPark extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RVPark()
	{
		context="http://schema.org/";
		type="RVPark";
	}

}