package org.schema;

/**
 * Schema.org/UserPlays
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 *
 * @author schema.org
 * @class UserPlays
 * @module org.schema
 * @extends UserInteraction
 */
public class UserPlays extends UserInteraction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UserPlays() {
		context = "http://schema.org/";
		type = "UserPlays";
	}

}