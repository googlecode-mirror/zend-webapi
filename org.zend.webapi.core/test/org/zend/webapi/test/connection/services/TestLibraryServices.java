/*******************************************************************************
 * Copyright (c) 2013 Zend Technologies Ltd. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html  
 *******************************************************************************/
package org.zend.webapi.test.connection.services;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import org.junit.Test;
import org.zend.webapi.core.WebApiClient;
import org.zend.webapi.core.WebApiException;
import org.zend.webapi.core.connection.data.LibraryList;
import org.zend.webapi.core.connection.data.values.ServerType;
import org.zend.webapi.core.connection.request.NamedInputStream;
import org.zend.webapi.core.connection.response.ResponseCode;
import org.zend.webapi.test.AbstractTestServer;
import org.zend.webapi.test.Configuration;
import org.zend.webapi.test.DataUtils;
import org.zend.webapi.test.server.utils.ServerUtils;

public class TestLibraryServices extends AbstractTestServer {

	public static final String DEPLOY_FOLDER = "deploy/";

	@Test
	public void testLibraryGetStatus() throws WebApiException,
			MalformedURLException {
		initMock(handler.libraryGetStatus(), "libraryGetStatus",
				ResponseCode.OK);
		WebApiClient client = Configuration.getClient();
		client.setServerType(ServerType.ZEND_SERVER);
		LibraryList libraryList = client.libraryGetStatus();
		DataUtils.checkValidLibraryList(libraryList);
	}

	@Test
	public void testLibraryVersionGetStatus() throws WebApiException,
			MalformedURLException {
		initMock(handler.libraryVersionGetStatus(), "libraryVersionGetStatus",
				ResponseCode.OK);
		WebApiClient client = Configuration.getClient();
		client.setServerType(ServerType.ZEND_SERVER);
		LibraryList libraryList = client.libraryVersionGetStatus(1);
		DataUtils.checkValidLibraryList(libraryList);
	}

	@Test
	public void testLibraryVersionDeploy() throws MalformedURLException,
			WebApiException, FileNotFoundException {
		initMock(handler.libraryVersionDeploy(), "libraryVersionDeploy",
				ResponseCode.ACCEPTED);
		File app = new File(ServerUtils.createFileName(DEPLOY_FOLDER
				+ "library-1.0.0.zpk"));
		if (app.exists()) {
			WebApiClient client = Configuration.getClient();
			client.setServerType(ServerType.ZEND_SERVER);
			LibraryList libraryList  = client
					.libraryVersionDeploy(new NamedInputStream(app));
			DataUtils.checkValidLibraryList(libraryList);
		} else {
			fail("Cannot find file: " + app.getAbsolutePath());
		}
	}

}