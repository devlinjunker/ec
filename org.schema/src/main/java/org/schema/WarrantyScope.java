package org.schema;

/**
 * Schema.org/WarrantyScope
 * A range of of services that will be provided to a customer free of charge in case of a defect or malfunction of a product.\n\nCommonly used values:\n\n* http://purl.org/goodrelations/v1#Labor-BringIn\n* http://purl.org/goodrelations/v1#PartsAndLabor-BringIn\n* http://purl.org/goodrelations/v1#PartsAndLabor-PickUp
 *
 * @author schema.org
 * @class WarrantyScope
 * @module org.schema
 * @extends Enumeration
 */
public class WarrantyScope extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WarrantyScope() {
		context = "http://schema.org/";
		type = "WarrantyScope";
	}

}