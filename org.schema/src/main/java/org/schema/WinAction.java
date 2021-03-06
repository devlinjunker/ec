package org.schema;

/**
 * Schema.org/WinAction
 * The act of achieving victory in a competitive activity.
 *
 * @author schema.org
 * @class WinAction
 * @module org.schema
 * @extends AchieveAction
 */
public class WinAction extends AchieveAction {
	/**
	 * Schema.org/loser
	 * A sub property of participant. The loser of the action.
	 *
	 * @property loser
	 * @type Person
	 */
	public Person loser;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WinAction() {
		context = "http://schema.org/";
		type = "WinAction";
	}

}