# A Getting Started Guide #
This guide introduces the Zend Server Web API SDK for Java and provides a walk-through for getting started using the SDK.
The Zend Web API SDK for Java provides a Java API for Zend Server infrastructure services. Using the SDK, you can automate and configure your PHP Web Applications servers to build applications on top of Zend Server. The Zend Web API SDK for Java includes:

  1. Zend Web API Java Library—Build Java applications on top of APIs to take the complexity out of coding directly against a web service interface. The library provides APIs that hide much of the lower-level plumbing, including authentication, request retries, and error handling.
  1. Code Samples—Practical examples for how to use the library to build applications.

## 1. Signing up for Zend Web API Services ##

Before you can begin, you must install a Zend Server Cluster Manager or Zend Server you want to use.

To install Zend Server (Cluster Manager) http://www.zend.com/en/products/server-cluster-manager/

## 2. Getting your Zend Web API Security Credentials ##

In order to use the Zend Web API SDK for Java, you will need a Zend Server API Key (security credentials) that you created through the Administration | API Keys window. Security credentials are used to authenticate requests to a service and identify yourself as the sender of a request. The security credentials used with the Zend Web API SDK for Java are a pair of public/private keys:

![http://farm6.static.flickr.com/5297/5519428275_3037424ac9_b.jpg](http://farm6.static.flickr.com/5297/5519428275_3037424ac9_b.jpg)

Access Key ID (for example: admin)
Secret Access Key (for example: 748a34361ad65b4ed15c76d13859a94f621c60bcf2a3fe1cb237666cac8e378d)

IMPORTANT: Your Secret Access Key is a secret, which only you and your Zend Server should know. It is important to keep it confidential to protect your account. Store it securely in a safe place. Never include it in your requests, and never e-mail it to anyone. Do not share it outside your organization, even if an inquiry appears to come from anyone at Zend. No one who legitimately represents Zend will ever ask you for your Secret Access Key.

## 3. View Your Zend Web API Security Credentials ##
To view your security credentials, hit the "Show full key" button

![http://farm6.static.flickr.com/5134/5520057806_b04f02c449_b.jpg](http://farm6.static.flickr.com/5134/5520057806_b04f02c449_b.jpg)

## 4. Using the Zend Web API SDK for Java ##
Download the Zend Web API SDK for Java from the SDK web page at [zend-webapi project](http://code.google.com/p/zend-webapi/). After downloading the SDK, extract the contents into a folder.

The SDK /samples folder includes a number of code samples:

GetInfo sample — Demonstrates how to make a request to get information service.

ServersListing sample — Demonstrates how to use the basic features for listing servers and their status.

## 5. To run a sample ##

  1. To add the SDK to an existing Eclipse project
Right-click the project in the Project Explorer, then select Build Path -> Add Libraries....
Select all jars located under the "lib" directory of the Java SDK, then click Next and follow the remaining on-screen instructions.

  1. Create a new class and a method and include the following code:

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