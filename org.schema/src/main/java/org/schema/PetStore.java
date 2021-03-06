package org.schema;

/**
 * Schema.org/PetStore
 * A pet store.
 *
 * @author schema.org
 * @class PetStore
 * @module org.schema
 * @extends Store
 */
public class PetStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PetStore() {
		context = "http://schema.org/";
		type = "PetStore";
	}

}