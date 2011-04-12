package org.zend.webapi.test.server;

import org.zend.webapi.test.server.response.ServerResponse;

public interface RequestHandler {

	ServerResponse getSystemInfo();

	ServerResponse clusterGetServerStatus();

	ServerResponse clusterAddServer();

	ServerResponse clusterRemoveServer();

	ServerResponse clusterDisableServer();

	ServerResponse clusterEnableServer();

	ServerResponse restartPhp();

	ServerResponse configurationExport();

	ServerResponse configurationImport();

	ServerResponse applicationGetStatus();

}