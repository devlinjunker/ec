package org.schema;

/**
 * Schema.org/MusicEvent
 * Event type: Music event.
 *
 * @author schema.org
 * @class MusicEvent
 * @module org.schema
 * @extends Event
 */
public class MusicEvent extends Event {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MusicEvent() {
		context = "http://schema.org/";
		type = "MusicEvent";
	}

}