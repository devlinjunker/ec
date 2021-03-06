package org.schema;

/**
 * Schema.org/ItemAvailability
 * A list of possible product availability options.
 *
 * @author schema.org
 * @class ItemAvailability
 * @module org.schema
 * @extends Enumeration
 */
public class ItemAvailability extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ItemAvailability() {
		context = "http://schema.org/";
		type = "ItemAvailability";
	}

}