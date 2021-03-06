package org.schema;

/**
 * Schema.org/TrackAction
 * An agent tracks an object for updates.\n\nRelated actions:\n\n* [[FollowAction]]: Unlike FollowAction, TrackAction refers to the interest on the location of innanimates objects.\n* [[SubscribeAction]]: Unlike SubscribeAction, TrackAction refers to  the interest on the location of innanimate objects.
 *
 * @author schema.org
 * @class TrackAction
 * @module org.schema
 * @extends FindAction
 */
public class TrackAction extends FindAction {
	/**
	 * Schema.org/deliveryMethod
	 * A sub property of instrument. The method of delivery.
	 *
	 * @property deliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod deliveryMethod;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TrackAction() {
		context = "http://schema.org/";
		type = "TrackAction";
	}

}