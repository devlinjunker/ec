package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HVACBusiness
 * A business that provide Heating, Ventilation and Air Conditioning services.
 * @author schema.org
 * @module schema.org
 * @class HVACBusiness
 * @extends HomeAndConstructionBusiness
 */
public class HVACBusiness extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HVACBusiness()
	{
		context="http://schema.org/";
		type="HVACBusiness";
	}

}