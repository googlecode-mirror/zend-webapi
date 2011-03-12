/*******************************************************************************
 * Copyright (c) Feb 9, 2011 Zend Technologies Ltd. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
import java.net.MalformedURLException;

import org.zend.webapi.core.WebApiClient;
import org.zend.webapi.core.WebApiException;
import org.zend.webapi.core.connection.auth.BasicCredentials;
import org.zend.webapi.core.connection.auth.WebApiCredentials;
import org.zend.webapi.core.connection.data.SystemInfo;

/**
 * Example code for Web API Get system info service method.
 * 
 * @see WebApiClient#getSystemInfo()
 * @author Roy, 2011
 * 
 */
public class GetInfo {

	// required parameters
	private static final String KEY_NAME = "my-key";
	private static final String HOST = "http://www.exemple.com:10081";
	private static final String SECRET_KEY = "a6493c9c850357e3fa237b808101e15a7116ad7c1b1560f987f909c7e53ad065";

	public static void main(String[] args) throws WebApiException,
			MalformedURLException {

		/**
		 * Create the credential object
		 */
		WebApiCredentials credentials = new BasicCredentials(KEY_NAME,
				SECRET_KEY);

		/**
		 * Creates the Web API client object
		 */
		final WebApiClient webApiClient = new WebApiClient(credentials, HOST);

		/**
		 * Retrieve system info
		 */
		SystemInfo systemInfo = webApiClient.getSystemInfo();

		/**
		 * Print license info from retrieved system info
		 */
		System.out.println("License order number:"
				+ systemInfo.getLicenseInfo().getOrderNumber());
	}
}
