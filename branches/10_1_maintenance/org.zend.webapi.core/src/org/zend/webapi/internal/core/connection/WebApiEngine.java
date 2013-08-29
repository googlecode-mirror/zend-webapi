package org.zend.webapi.internal.core.connection;

import org.restlet.engine.Engine;
import org.restlet.ext.net.HttpClientHelper;

public class WebApiEngine extends Engine {

	public void registerDefaultConnectors() {
		getRegisteredClients().add(new HttpClientHelper(null));
		getRegisteredClients().add(new WebApiHttpClientHelper(null));
		getRegisteredClients().add(
				new org.restlet.engine.local.ClapClientHelper(null));
		getRegisteredClients().add(
				new org.restlet.engine.local.FileClientHelper(null));
		getRegisteredClients().add(
				new org.restlet.engine.local.ZipClientHelper(null));
		getRegisteredClients().add(
				new org.restlet.engine.riap.RiapClientHelper(null));
		getRegisteredServers().add(
				new org.restlet.engine.riap.RiapServerHelper(null));
		getRegisteredServers().add(
				new org.restlet.engine.http.connector.HttpServerHelper(null));
	}

}
