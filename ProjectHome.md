The Zend Server Web API allows automation of the management and deployment of Zend Server and Zend Server Cluster Manager, and allows integration with other Zend or 3rd party software. For more details read the [Zend Web API reference guide](http://files.zend.com/help/Zend-Server/web_api_table_of_contents.htm)

Zend Web API SDK for Java provides a Java API for Zend Server infrastructure services, making it even easier for developers to build applications that tap into the scalable, and reliable Zend Server product.

## Zend WebAPI for Java ##
The Zend Web API SDK for Java provides a Java API for Zend Server infrastructure services, making it even easier for developers to build applications that tap into the cost-effective, scalable, and reliable Zend Server. Using the SDK, developers can build solutions on top of Zend Server configuration and management services. With the SDK for Java, developers get started in minutes with a single, downloadable package that includes the Java library, code samples, and documentation.

  * [Getting Starterd Guide](GettingStartedGuide.md)
  * [Browse JavaDoc Pages](http://zend-webapi.googlecode.com/svn/trunk/docs/api/index.html)
  * [Download Zend Web API SDK](http://code.google.com/p/zend-webapi/downloads/list)
  * [Discussion Forum](https://groups.google.com/group/zend-webapi)

## Code Sample ##

```
/**
 * Create the credential object
 */
WebApiCredentials credentials = new BasicCredentials(KEY_NAME, SECRET_KEY);

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
System.out.println("License order number:" + systemInfo.getLicenseInfo().getOrderNumber());
```

## So what can I do with it? ##
1. This library can easily be integrated with [Hudson/Jenkins](http://jenkins-ci.org/), [Apache Ant](http://ant.apache.org) or [CruiseControl](http://cruisecontrol.sourceforge.net) in order to:

  * Get System Info
  * Get Server Status
  * Add Server
  * Remove Server
  * Disable Server
  * Enable Server
  * Restart PHP
  * Configuration Export
  * Configuration Import

2. Developers tools with Zend-Web API.

3. Mobile Application