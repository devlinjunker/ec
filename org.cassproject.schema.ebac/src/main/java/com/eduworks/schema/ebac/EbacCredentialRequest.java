package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Message used to retrieve credentials from a remote system.
 * 
 * TODO: Vulnerable to replay attacks.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredentialRequest extends EcLinkedData
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/ebac/0.1/credentialRequest";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/ebac/0.2/credentialRequest";
	public EbacCredentialRequest()
	{
		super(Ebac.context, TYPE_0_2);
	}

	/**
	 * Hashed username.
	 */
	public String username;
	/**
	 * Hashed password to authorize request.
	 */
	public String password;
	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (type.equals(TYPE_0_1))
		{
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Ebac.context_0_2,TYPE_0_2);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
