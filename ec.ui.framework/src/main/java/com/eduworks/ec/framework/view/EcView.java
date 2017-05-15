package com.eduworks.ec.framework.view;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;

/**
 * Class that represents a "view" that can be displayed in an container element on the page. The View should define 
 * a display function that loads HTML into the container element on the page and then finally calls the callback once
 * the view has been completely initialized
 * 
 * @module com.eduworks.ec.ui
 * @class EcView
 * @author devlin.junker@eduworks.com
 *
 */
public abstract class EcView
{

	/**
	 * Function to be defined in subclasses that returns the location of the main html file associated with this view
	 * 
	 * @memberOf EcView
	 * @method getHtmlLocation
	 * @abstract
	 * @return {String}
	 * 			The string path to an html file
	 */
	public abstract String getHtmlLocation();

	/**
	 * Display function to override (usually in JavaScript) that will set up any event handlers
	 * 
	 * @memberOf EcView
	 * @method display
	 * @param {String} containerId
	 */
	public void display(String containerId)
	{
		Global.console.error("Not Implemented");
	}

	/***
	 * Function that will convert a view to a certain other view class as long as it the converted type inherits the
	 * current type of the view
	 * 
	 * @memberOf EcView
	 * @method as
	 * @param {Class} _interface
	 * 			Class type that the instance should be converted to
	 * @return {Object}
	 * 			The converted instance of the type passed in
	 */
	public <T> T as(Class<T> _interface)
	{
		Object prototype = JSObjectAdapter.$get(this, "__proto__");
		Object constructor = JSObjectAdapter.$get(prototype, "constructor");
		Array inherits = (Array) JSObjectAdapter.$get(constructor, "$inherit");

		if (inherits != null)
			for (int i = 0; i < inherits.$length(); i++)
			{
				if (inherits.$get(i) == _interface)
				{
					return (T) this;
				}
			}

		return null;
	}

	/***
	 * Event that is called when the view is deleted, removed, or found to have no applicable selector.
	 * Called upon screen change or when replacing a view with the same selector.
	 *
	 * @memberOf EcView
	 * @method onClose
	 * @return {Boolean} True if the view finished cleaning up after itself. False otherwise.
	 */
	public Boolean onClose(){return true;};

	/***
	 * Display this alert on the view.
	 *
	 * @memberOf EcView
	 * @method displayAlert
	 * @param {String} Error to display.
	 * @param {String} Type of error.
	 */
	public void displayAlert(String err, String type) {
	}

	/***
	 * Clear the alert.
	 *
	 * @memberOf EcView
	 * @method clearAlert
	 * @param {String} Type of error.
	 */
	public void clearAlert(String type) {
	}

}
