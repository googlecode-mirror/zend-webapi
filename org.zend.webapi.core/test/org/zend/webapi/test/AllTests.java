package org.zend.webapi.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.zend.webapi.test.connection.TestCredentials;
import org.zend.webapi.test.connection.TestRequestParams;
import org.zend.webapi.test.connection.TestResponse;
import org.zend.webapi.test.connection.TestSignatrue;
import org.zend.webapi.test.connection.data.TestDataDigester;
import org.zend.webapi.test.connection.data.TestValues;
import org.zend.webapi.test.connection.services.TestClusterServices;
import org.zend.webapi.test.connection.services.TestZendServerServices;
import org.zend.webapi.test.core.TestClientConfiguration;
import org.zend.webapi.test.core.TestUtils;
import org.zend.webapi.test.core.TestWebApiExceptions;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestCredentials.class, TestRequestParams.class,
		TestResponse.class, TestSignatrue.class, TestDataDigester.class,
		TestValues.class, TestClusterServices.class,
		TestZendServerServices.class, TestClientConfiguration.class,
		TestWebApiExceptions.class, TestValues.class,
		TestClientConfiguration.class, TestUtils.class,
		TestWebApiExceptions.class })
public class AllTests {

}
