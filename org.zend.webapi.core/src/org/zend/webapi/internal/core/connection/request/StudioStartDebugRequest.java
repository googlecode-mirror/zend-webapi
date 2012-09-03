/*******************************************************************************
 * Copyright (c) Feb 13, 2012 Zend Technologies Ltd. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html  
 *******************************************************************************/
package org.zend.webapi.internal.core.connection.request;

import java.util.Date;

import org.restlet.Request;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.representation.Representation;
import org.zend.webapi.core.connection.data.IResponseData.ResponseType;
import org.zend.webapi.core.connection.data.values.WebApiVersion;
import org.zend.webapi.core.connection.response.ResponseCode;

/**
 * Start a debug session for a specific issue.
 * 
 * Request Parameters:
 * <table border="1">
 * <tr>
 * <th>Parameter</th>
 * <th>Type</th>
 * <th>Required</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td>eventsGroupId</td>
 * <td>String</td>
 * <td>Yes</td>
 * <td>The issue event group identifier</td>
 * </tr>
 * <tr>
 * <td>noRemote</td>
 * <td>boolean</td>
 * <td>No</td>
 * <td>Use server's own local files for debug display. Default: true. Setting to
 * false will use local files from studio if available.</td>
 * </tr>
 * <tr>
 * <td>overrideHost</td>
 * <td>String</td>
 * <td>No</td>
 * <td>Override the host address sent to Zend Server for initiating a Debug
 * session. This is used to point Zend Server at the right address where Studio
 * is executed.</td>
 * </tr>
 * </table>
 * 
 * @author Wojciech Galanciak, 2012
 * 
 */
public class StudioStartDebugRequest extends AbstractRequest {

	public static final MediaType FORM = MediaType.register(
			"application/x-www-form-urlencoded", "Form");

	private static final ResponseCode[] RESPONSE_CODES = new ResponseCode[] { ResponseCode.OK };

	public StudioStartDebugRequest(WebApiVersion version, Date date,
			String keyName, String userAgent, String host, String secretKey) {
		super(version, date, keyName, userAgent, host, secretKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.zend.webapi.core.connection.request.IRequest#getMethod()
	 */
	public Method getMethod() {
		return Method.POST;
	}

	/**
	 * The issue event group identifier.
	 * 
	 * @param - events group id
	 */
	public void setEventsGroupId(String eventsGroupId) {
		addParameter("eventGroupId", eventsGroupId);
	}

	/**
	 * Use server's own local files for debug display. Default: true. Setting to
	 * false will use local files from studio if available.
	 * 
	 * @param - boolean value
	 */
	public void setNoRemote(boolean noRemote) {
		addParameter("noRemote", noRemote);
	}

	/**
	 * Override the host address sent to Zend Server for initiating a Debug
	 * session. This is used to point Zend Server at the right address where
	 * Studio is executed.
	 * 
	 * @param - host address
	 */
	public void setOverrideHost(String overrideHost) {
		addParameter("overrideHost", overrideHost);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.zend.webapi.internal.core.connection.request.AbstractRequest#
	 * getResponseCodeList()
	 */
	@Override
	protected ResponseCode[] getValidResponseCode() {
		return RESPONSE_CODES;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.zend.webapi.core.connection.request.IRequest#getExpectedResponseDataType
	 * ()
	 */
	public ResponseType getExpectedResponseDataType() {
		return ResponseType.DEBUG_REQUEST;
	}

	@Override
	public void applyParameters(Request request) {
		Representation rep = new MultipartRepresentation(getParameters(), FORM);
		request.setEntity(rep);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.zend.webapi.internal.core.connection.request.AbstractRequest#
	 * getMethodName()
	 */
	protected String getRequestName() {
		return "studioStartDebug";
	}

}
