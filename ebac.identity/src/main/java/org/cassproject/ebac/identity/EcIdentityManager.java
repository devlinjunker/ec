package org.cassproject.ebac.identity;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.JSStringAdapterBase;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.stjs.STJS;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacSignature;

/**
 * Manages identities and contacts, provides hooks to respond to identity and
 * contact events, and builds signatures and signature sheets for authorizing
 * movement of data. Also provides helper functions for identity management.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EcIdentityManager
{
	public static void main(String[] args)
	{
		readContacts();
	}

	// Identities (also called Aliases)
	public static Array<EcIdentity> ids = new Array<EcIdentity>();
	// Contacts (Identities that we do not own)
	public static Array<EcContact> contacts = new Array<EcContact>();

	// Identity change hook.
	public static Callback1<EcIdentity> onIdentityAdded = null;
	// Contacts change hook.
	public static Callback1<EcContact> onContactAdded = null;

	public static void identityAdded(EcIdentity identity)
	{
		if (onIdentityAdded != null)
			onIdentityAdded.$invoke(identity);
	}

	public static void contactAdded(EcContact contact)
	{
		if (onContactAdded != null)
			onContactAdded.$invoke(contact);
		saveContacts();
	}

	/**
	 * Reads contact data from localstorage.
	 */
	private static void readContacts()
	{
		Object localStore = Global.localStorage.$get("contacts");
		if (localStore == null)
			return;
		Array<Object> c = (Array<Object>) JSGlobal.JSON.parse((String) localStore);
		for (int i = 0; i < c.$length(); i++)
		{
			EcContact contact = new EcContact();
			Object o = new Object();
			Map<String, Object> props = JSObjectAdapter.$properties(o);
			contact.displayName = (String) props.$get("displayName");
			contact.pk = EcPk.fromPem((String) props.$get("ok"));
			contact.source = (String) props.$get("source");
			contacts.push(contact);
		}
	}

	/**
	 * Writes contact data to localstorage.
	 */
	private static void saveContacts()
	{
		Array<Object> c = new Array<Object>();
		for (int i = 0; i < contacts.$length(); i++)
		{
			Object o = new Object();
			Map<String, Object> props = JSObjectAdapter.$properties(o);
			EcContact contact = contacts.$get(i);
			props.$put("displayName", contact.displayName);
			props.$put("pk", contact.pk.toPem());
			props.$put("source", contact.source);
			c.push(o);
		}
		Global.localStorage.$put("contacts", c);
	}

	/**
	 * Adds an identity to the identity manager. Checks for duplicates. Triggers
	 * events.
	 * 
	 * @param identity
	 *            Identity to add.
	 */
	public static void addIdentity(EcIdentity identity)
	{
		for (int i = 0; i < ids.$length(); i++)
			if (ids.$get(i).equals(identity))
				return;
		ids.push(identity);
		identityAdded(identity);
	}

	/**
	 * Adds a contact to the identity manager. Checks for duplicates. Triggers
	 * events.
	 * 
	 * @param contact
	 *            Contact to add.
	 */
	public static void addContact(EcContact contact)
	{
		for (int i = 0; i < ids.$length(); i++)
			if (contacts.$get(i).equals(contact))
				return;
		contacts.push(contact);
		contactAdded(contact);
	}

	/**
	 * Create a signature sheet, authorizing movement of data outside of our
	 * control.
	 * 
	 * @param identityPksinPem
	 *            Which identities to create signatures for.
	 * @param duration
	 *            Length of time in milliseconds to authorize control.
	 * @param server
	 *            Server that we are authorizing.
	 * @return JSON Array containing signatures.
	 */
	public static String signatureSheetFor(Array<String> identityPksinPem, long duration, String server)
	{
		Array<Object> signatures = new Array<Object>();
		EcRsaOaep crypto = new EcRsaOaep();
		for (int j = 0; j < ids.$length(); j++)
		{
			EcPpk ppk = ids.$get(j).ppk;
			Array<String> pemArr = JSStringAdapterBase.split(ppk.toPk().toPem(), "\n");
			
			String ourPem = "";
			for(int i = 0; i < pemArr.$length(); i++){
				ourPem += pemArr.$get(i).trim() + "\n";
			}
			ourPem = ourPem.trim();
			if (identityPksinPem != null)
				for (int i = 0; i < identityPksinPem.$length(); i++)
				{
					String ownerPem = identityPksinPem.$get(i).trim();
					if (new String(ownerPem).equals(new String(ourPem)))
					{
						signatures.push(createSignature(duration, server, crypto, ppk).atIfy());
					}
				}
		}
		return JSGlobal.JSON.stringify(signatures);
	}

	/**
	 * Create a signature sheet for all identities, authorizing movement of data
	 * outside of our control.
	 * 
	 * @param duration
	 *            Length of time in milliseconds to authorize control.
	 * @param server
	 *            Server that we are authorizing.
	 * @return JSON Array containing signatures.
	 */
	public static String signatureSheet(long duration, String server)
	{
		Array<Object> signatures = new Array<Object>();
		EcRsaOaep crypto = new EcRsaOaep();
		for (int j = 0; j < ids.$length(); j++)
		{
			EcPpk ppk = ids.$get(j).ppk;
			signatures.push(createSignature(duration, server, crypto, ppk).atIfy());
		}
		return JSGlobal.JSON.stringify(signatures);
	}

	private static EbacSignature createSignature(long duration, String server, EcRsaOaep crypto, EcPpk ppk)
	{
		EbacSignature s = new EbacSignature();
		s.owner = ppk.toPk().toPem();
		s.expiry = new Date().getTime() + duration;
		s.server = server;
		s.signature = EcRsaOaep.sign(ppk, s.toJson());
		return s;
	}

	/**
	 * Get PPK from PK (if we have it)
	 * 
	 * @param fromPem
	 *            PK to use to look up PPK
	 * @return PPK or null.
	 */
	public static EcPpk getPpk(EcPk fromPem)
	{
		String pem = fromPem.toPem();
		for (int i = 0; i < ids.$length(); i++)
		{
			if (pem.equals(ids.$get(i).ppk.toPk().toPem()))
				return ids.$get(i).ppk;
		}
		return null;
	}

	/**
	 * Sign a piece of data with all available keys that own that data.
	 * 
	 * @param d
	 *            Data to sign.
	 */
	public static void sign(EcRemoteLinkedData d)
	{
		//TODO: Validate object here using all signatures and remove any that don't work.
		if(d.owner != null)
		{
			for (int i = 0; i < d.owner.$length(); i++)
			{
				EcPpk attempt = getPpk(EcPk.fromPem(d.owner.$get(i)));
				if (attempt != null)
					d.signWith(attempt);
			}
		}
	}
}