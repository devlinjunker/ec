package com.eduworks.ec.crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore(
		{"/forge/forge.bundle.js", "ec.base.js", "base64toArrayBuffer.js"})
public class EcAesAsyncTest {
	@Test
	public void aesTest() {
		final String randomString = "foo is bar";
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		EcAesCtrAsync.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				console.log("Encrypted String (Proper): " + EcAesCtr.encrypt(randomString, secret, iv));
				EcAesCtrAsync.decrypt(encrypted, secret, iv, new Callback1<String>() {
					@Override
					public void $invoke(String decrypted) {
						console.log("Decrypted String: " + decrypted);

						assertTrue(randomString.equals(decrypted));
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						assertTrue(false);
					}
				});
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				assertTrue(false);
			}
		});

	}

	@Test
	public void aesCrossTest1() {
		final String randomString = EcAes.newIv(1024);
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(32);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(32);
		console.log("Random iv:" + iv);
		EcAesCtrAsync.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				String decrypted = EcAesCtr.decrypt(encrypted, secret, iv);
				console.log("Decrypted String: " + decrypted);

				assertTrue(randomString.equals(decrypted));
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				assertTrue(false);
			}
		});

	}
}
