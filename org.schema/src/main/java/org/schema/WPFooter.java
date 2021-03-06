package org.schema;

/**
 * Schema.org/WPFooter
 * The footer section of the page.
 *
 * @author schema.org
 * @class WPFooter
 * @module org.schema
 * @extends WebPageElement
 */
public class WPFooter extends WebPageElement {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WPFooter() {
		context = "http://schema.org/";
		type = "WPFooter";
	}

}