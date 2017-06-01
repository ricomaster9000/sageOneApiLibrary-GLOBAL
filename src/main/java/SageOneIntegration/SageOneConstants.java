/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;

import java.util.HashMap;
import java.util.Map;

public final class SageOneConstants {

	/* Request Limits,

       All Sage One companies have a request limit of 5000 API requests per day. A maximum of 100 results will be
       returned for list methods, regardless of the parameter sent through. THIS IS PER COMPANY/USER,
       CAN HAVE MORE THAN ONE, LIMIT IS NOT ENFORCED BUT REALLY RECOMMENDED.
    */
	static String CLIENT_USERNAME = ""; // TODO testing account, change to actual
	static String CLIENT_PASSWORD = "";  // TODO testing password, change to actual
	static String API_URL = "https://accounting.sageone.co.za/";
	static String API_VERSION = "1.1.2";
	static String API_KEY = "";
	static final Map<String, Integer> COMPANY_LIST = new HashMap<String, Integer>();
	static int SageOneRequestLimit = 100;
	static int requestTimeout = 30 * 1000; // Seconds multiplied with milliseconds

	public static Map<String, Integer> getSageOneApiCompanyList() {
		return COMPANY_LIST;
	}
}
