package org.zend.webapi.internal.core.connection;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.engine.connector.HttpClientHelper;
import org.zend.webapi.core.connection.request.IRequest;

public class WebApiHttpClientHelper extends HttpClientHelper {

	private static final String CONNECTOR_LATCH = "org.restlet.engine.http.connector.latch";

	public WebApiHttpClientHelper(Client client) {
		super(client);
	}

	@Override
	public void handle(Request request, Response response) {
		try {
			if (request.getOnResponse() == null) {
				// Synchronous mode
				CountDownLatch latch = new CountDownLatch(1);
				request.getAttributes().put(CONNECTOR_LATCH, latch);

				// Add the message to the outbound queue for processing
				getOutboundMessages().add(response);
				
				long timeout = (Long) request.getAttributes().get(
						IRequest.TIMEOUT);

				// Await on the latch
				if (!latch.await(timeout, TimeUnit.MILLISECONDS)) {
					// Timeout detected
					response.setStatus(Status.CONNECTOR_ERROR_INTERNAL,
							"The calling thread timed out while waiting for a response to unblock it.");
				}
			} else {
				// Add the message to the outbound queue for processing
				getOutboundMessages().add(response);
			}
		} catch (Exception e) {
			getLogger().log(
					Level.INFO,
					"Error while handling a " + request.getProtocol().getName()
							+ " client request", e);
			response.setStatus(Status.CONNECTOR_ERROR_INTERNAL, e);
		}
	}

}
