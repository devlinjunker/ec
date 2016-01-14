package com.eduworks.ec.remote;

import static org.stjs.javascript.JSGlobal.JSON;
import static org.stjs.javascript.jquery.GlobalJQuery.$;

import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback3;
import org.stjs.javascript.jquery.AjaxParams;
import org.stjs.javascript.jquery.JQueryXHR;

import com.eduworks.ec.callback.EcCallback;

public class EcRemote
{
	public static void httpPost(String service, Object c, final EcCallback success, final EcCallback failure)
	{
		String url = EcRemoteConfig.serviceUrl;
		if (!url.endsWith("/"))
			url += "/";
		url += service;

		AjaxParams p = new AjaxParams();
		p.url = url;

		Callback3<Object, String, JQueryXHR> successListener = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				success.callback(JSON.parse(arg2.responseText));
			}
		};

		p.success = successListener;

		Callback3<JQueryXHR, String, String> failureListener = new Callback3<JQueryXHR, String, String>()
		{

			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				failure.callback(paramP1.status);
			}
		};

		p.error = failureListener;

		$.ajax(p);

	}

	public static void postExpectingObject(String server, String service, FormData fd, final Callback1<Object> success, final Callback1<String> failure)
	{
		Callback3<Object, String, JQueryXHR> successCallback = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (success != null)
					success.$invoke(JSON.parse(arg2.responseText));
			}
		};

		Callback3<JQueryXHR, String, String> failureCallback = new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				if (failure != null)
					failure.$invoke(paramP2);
			}
		};

		postInner(server, service, successCallback, failureCallback);
	}

	public static void postExpectingString(String server, String service, FormData fd, final Callback1<String> success, final Callback1<String> failure)
	{
		Callback3<Object, String, JQueryXHR> successCallback = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (success != null)
					success.$invoke(arg2.responseText);
			}
		};

		Callback3<JQueryXHR, String, String> failureCallback = new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				if (failure != null)
					failure.$invoke(paramP2);
			}
		};

		postInner(server, service, successCallback, failureCallback);
	}

	private static void postInner(String server, String service, Callback3<Object, String, JQueryXHR> successCallback,
			Callback3<JQueryXHR, String, String> failureCallback)
	{
		String url = server;
		if (!url.endsWith("/") && service != null && service.isEmpty() == false)
			url += "/";
		if (service != null)
			url += service;

		AjaxParams p = new AjaxParams();
		p.method = "POST";
		p.url = url;
		p.mimeType = "multipart/form-data";
		JSObjectAdapter.$properties(p).$put("contentType", false);

		p.cache = false;
		p.processData = false;

		p.success = successCallback;
		p.error = failureCallback;

		$.ajax(p);
	}

	public static void getExpectingObject(String server, String service, final Callback1<Object> success, final Callback1<String> failure)
	{
		Callback3<Object, String, JQueryXHR> successCallback = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (success != null)
					success.$invoke(JSON.parse(arg2.responseText));
			}
		};

		Callback3<JQueryXHR, String, String> failureCallback = new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				if (failure != null)
					failure.$invoke(paramP2);
			}
		};

		String url = server;
		if (!url.endsWith("/") && service != null && service.isEmpty() == false)
			url += "/";
		if (service != null)
			url += service;

		AjaxParams p = new AjaxParams();
		p.method = "GET";
		p.url = url;
		p.cache = false;
		p.processData = false;

		p.success = successCallback;
		p.error = failureCallback;

		$.ajax(p);
	}

}
