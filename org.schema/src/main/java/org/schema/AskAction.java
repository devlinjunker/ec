package org.schema;

/**
 * Schema.org/AskAction
 * The act of posing a question / favor to someone.\n\nRelated actions:\n\n* [[ReplyAction]]: Appears generally as a response to AskAction.
 *
 * @author schema.org
 * @class AskAction
 * @module org.schema
 * @extends CommunicateAction
 */
public class AskAction extends CommunicateAction {
	/**
	 * Schema.org/question
	 * A sub property of object. A question.
	 *
	 * @property question
	 * @type Question
	 */
	public Question question;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AskAction() {
		context = "http://schema.org/";
		type = "AskAction";
	}

}