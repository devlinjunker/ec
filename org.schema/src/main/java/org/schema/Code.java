package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Code
 * Computer programming source code. Example: Full (compile ready) solutions, code snippet samples, scripts, templates.
 * @author schema.org
 * @module schema.org
 * @class Code
 * @extends CreativeWork
 */
public class Code extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Code()
	{
		context="http://schema.org/";
		type="Code";
	}

}