/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;

import java.util.HashMap;
import java.util.Map;

final class SageOneConstants {

	/* Request Limits,

       All Sage One companies have a request limit of 5000 API requests per day. A maximum of 100 results will be
       returned for list methods, regardless of the parameter sent through. THIS IS PER COMPANY/USER,
       CAN HAVE MORE THAN ONE, LIMIT IS NOT ENFORCED BUT REALLY RECOMMENDED.
    */
	static final String CLIENT_USERNAME = "ricorpwd@yahoo.co.za"; // TODO testing account, change to actual
	static final String CLIENT_PASSWORD = "StartingSmall500*";  // TODO testing password, change to actual
	static final String API_URL = "https://accounting.sageone.co.za/";
	static final String API_VERSION = "1.1.2";
	static final String API_KEY = "{71A42541-A543-4164-8CBA-5E0F0602B141}";
	static final Map<String, Integer> COMPANY_LIST = new HashMap<String, Integer>();
	static final int SageOneRequestLimit = 100;
	static final int requestTimeout = 30 * 1000; // Seconds multiplied with milliseconds

	public static Map<String, Integer> getSageOneApiCompanyList() {
		return COMPANY_LIST;
	}
}