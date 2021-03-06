package org.schema;

/**
 * Schema.org/SportsOrganization
 * Represents the collection of all sports organizations, including sports teams, governing bodies, and sports associations.
 *
 * @author schema.org
 * @class SportsOrganization
 * @module org.schema
 * @extends Organization
 */
public class SportsOrganization extends Organization {
	/**
	 * Schema.org/sport
	 * A type of sport (e.g. Baseball).
	 *
	 * @property sport
	 * @type schema, URL | schema,Text
	 */
	public Object sport;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SportsOrganization() {
		context = "http://schema.org/";
		type = "SportsOrganization";
	}

}