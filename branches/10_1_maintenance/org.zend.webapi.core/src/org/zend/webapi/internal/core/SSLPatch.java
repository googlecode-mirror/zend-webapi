package org.zend.webapi.internal.core.connection;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Copyright Keith D Swenson, Creative Commons Share-Alike Feel free to use this
 * code where you like, but keep this copyright statement in it, and understand
 * that there is no guarantee to be suitable for any purpose, so read it
 * carefully.
 */
public class SSLPatch {

	/**
	 * Java proides a standard "trust manager" interface. This trust manager
	 * essentially disables the rejection of certificates by trusting anyone and
	 * everyone.
	 */
	public static X509TrustManager getDummyTrustManager() {
		return new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs,
					String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) {
			}
		};
	}

	/**
	 * Returns a hostname verifiers that always returns true, always positively
	 * verifies a host.
	 */
	public static HostnameVerifier getAllHostVerifier() {
		return new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
	}

	/**
	 * a call to disableSSLCertValidation will disable certificate validation
	 * for SSL connection made after this call. This is installed as the default
	 * in the JVM for future calls. Returns the SSLContext in case you need it
	 * for something else.
	 */
	public static SSLContext disableSSLCertValidation() throws Exception {

		// Create a trust manager that does not validate certificate chains
		TrustManager[] tma = new TrustManager[] { getDummyTrustManager() };

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, tma, new java.security.SecureRandom());
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(getAllHostVerifier());
		return sc;
	}

}