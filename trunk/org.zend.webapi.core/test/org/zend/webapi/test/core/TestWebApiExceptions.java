package org.zend.webapi.test.core;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.restlet.data.MediaType;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.zend.webapi.core.WebApiException;
import org.zend.webapi.core.connection.data.values.ErrorCode;
import org.zend.webapi.core.connection.response.ResponseCode;
import org.zend.webapi.internal.core.connection.exception.InternalWebApiException;
import org.zend.webapi.internal.core.connection.exception.NoSuchServiceMethod;
import org.zend.webapi.internal.core.connection.exception.UnexpectedResponseCode;
import org.zend.webapi.internal.core.connection.exception.WebApiCommunicationError;
import org.zend.webapi.test.server.response.ServiceResponse;
import org.zend.webapi.test.server.utils.ResponseFactory;

public class TestWebApiExceptions {

	@Test
	public void testUnexpectedResponseCode() throws WebApiException,
			IOException {

		ServiceResponse response = ResponseFactory.createErrorResponse(
				"testException", ErrorCode.notImplementedByEdition);
		Representation representation = new DomRepresentation(
				MediaType.APPLICATION_XML,
				((ServiceResponse) response).getData());
		UnexpectedResponseCode exception = new UnexpectedResponseCode(response
				.getStatus().getCode(), representation);
		Assert.assertEquals(ResponseCode.METHOD_NOT_ALLOWED,
				exception.getResponseCode());
		Assert.assertTrue(ResponseCode.METHOD_NOT_ALLOWED.getDescription()
				.equals(exception.getMessage()));
	}

	@Test
	public void testEmptyUnexpectedResponseCode() throws WebApiException,
			IOException {
		// Get response without errorMessage node
		ServiceResponse response = ResponseFactory.createResponse(
				"getSystemInfo", ResponseCode.METHOD_NOT_ALLOWED);
		Representation representation = new DomRepresentation(
				MediaType.APPLICATION_XML,
				((ServiceResponse) response).getData());
		UnexpectedResponseCode exception = new UnexpectedResponseCode(response
				.getStatus().getCode(), representation);
		Assert.assertEquals(ResponseCode.METHOD_NOT_ALLOWED,
				exception.getResponseCode());
		Assert.assertTrue(ResponseCode.METHOD_NOT_ALLOWED.getDescription()
				.equals(exception.getMessage()));
	}

	@Test
	public void testInternalWebApiException() {
		InternalWebApiException exception = new InternalWebApiException(
				new Exception("test"));
		Assert.assertNull(exception.getResponseCode());
		Assert.assertTrue("test".equals(exception.getMessage()));
	}

	@Test
	public void testWebApiCommunicationError() {
		WebApiCommunicationError error = new WebApiCommunicationError();
		Assert.assertNull(error.getResponseCode());
		Assert.assertNotNull(error.getMessage());
	}

	@Test
	public void testNoSuchServiceMethodExcepiton() {
		NoSuchServiceMethod exception = new NoSuchServiceMethod("testMethod");
		Assert.assertNull(exception.getResponseCode());
		Assert.assertNotNull(exception.getMessage());
		Assert.assertEquals("No such method testMethod", exception.getMessage());
	}
}
