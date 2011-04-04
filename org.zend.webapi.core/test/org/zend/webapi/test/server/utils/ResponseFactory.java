package org.zend.webapi.test.server.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.restlet.ext.xml.DomRepresentation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.zend.webapi.core.connection.data.values.ErrorCode;
import org.zend.webapi.core.connection.response.ResponseCode;
import org.zend.webapi.test.Configuration;
import org.zend.webapi.test.server.response.ConfigurationResponse;
import org.zend.webapi.test.server.response.ServerResponse;
import org.zend.webapi.test.server.response.ServiceResponse;

public class ResponseFactory {

	private static final String EXPORT_CONFIG = "myConfig.cfg";

	public static ServerResponse createConfigResponse(String requestName,
			ResponseCode code) throws IOException {
		File file = new File(ServerUtils.createFileName(EXPORT_CONFIG));
		FileInputStream inputStream = new FileInputStream(file);
		int size = (int) file.length();
		byte content[] = new byte[size];
		inputStream.read(content);
		return new ConfigurationResponse(code.getCode(), EXPORT_CONFIG, size,
				content);
	}

	public static ServiceResponse createResponse(String requestName,
			ResponseCode code) throws IOException {
		String file = ServerUtils.createXMLFileName("responseBody");
		DomRepresentation dom = ServerUtils.readDomRepresentation(file);
		setRequestData(requestName, dom);
		Node responseData = dom.getNode("/zendServerAPIResponse/responseData");
		responseData.appendChild(getResponseData(dom, requestName));
		ServiceResponse result = null;
		result = new ServiceResponse(code.getCode(), dom.getDocument());
		return result;
	}

	public static ServiceResponse createErrorResponse(String requestName,
			ErrorCode code) throws IOException {
		String file = ServerUtils.createXMLFileName("errorBody");
		DomRepresentation dom = ServerUtils.readDomRepresentation(file);
		setRequestData(requestName, dom);
		Node root = dom.getNode("/zendServerAPIResponse");
		root.appendChild(getResponseData(dom, String.valueOf(code.getCode())));
		ServiceResponse result = null;
		result = new ServiceResponse(code.getCode(), dom.getDocument());
		return result;
	}

	private static void setRequestData(String requestName, DomRepresentation dom) {
		Node key = dom.getNode("/zendServerAPIResponse/requestData/apiKeyName");
		key.setTextContent(Configuration.getKeyName());
		Node method = dom.getNode("/zendServerAPIResponse/requestData/method");
		method.setTextContent(requestName);
	}

	private static Node getResponseData(DomRepresentation dom,
			String requestName) throws IOException {
		String file = ServerUtils.createXMLFileName(requestName);
		Document data = ServerUtils.readXMLFile(file);
		Document domDoc = dom.getDocument();
		return domDoc.importNode(data.getFirstChild(), true);
	}

}