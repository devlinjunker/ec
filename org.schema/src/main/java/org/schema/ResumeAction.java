package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ResumeAction
 * The act of resuming a device or application which was formerly paused (e.g. resume music playback or resume a timer).
 * @author schema.org
 * @module schema.org
 * @class ResumeAction
 * @extends ControlAction
 */
public class ResumeAction extends ControlAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ResumeAction()
	{
		context="http://schema.org/";
		type="ResumeAction";
	}

}