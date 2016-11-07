package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OceanBodyOfWater
 * An ocean (for example, the Pacific).
 * @author schema.org
 * @module schema.org
 * @class OceanBodyOfWater
 * @extends BodyOfWater
 */
public class OceanBodyOfWater extends BodyOfWater
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OceanBodyOfWater()
	{
		context="http://schema.org/";
		type="OceanBodyOfWater";
	}

}