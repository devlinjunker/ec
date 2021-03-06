package org.schema;

/**
 * Schema.org/GovernmentBuilding
 * A government building.
 *
 * @author schema.org
 * @class GovernmentBuilding
 * @module org.schema
 * @extends CivicStructure
 */
public class GovernmentBuilding extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GovernmentBuilding() {
		context = "http://schema.org/";
		type = "GovernmentBuilding";
	}

}