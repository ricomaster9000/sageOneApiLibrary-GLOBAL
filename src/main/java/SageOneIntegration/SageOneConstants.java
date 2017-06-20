/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;

import java.util.Calendar;
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
	public static String API_URL = "https://accounting.sageone.co.za";
	public static String API_VERSION = "1.1.2";
	static String API_KEY = "";
	static final Map<String, Integer> COMPANY_LIST = new HashMap<String, Integer>();
	public static int SAGE_ONE_REQUEST_RESULT_LIMIT = 100;
	public static int SAGE_ONE_REQUEST_LIMIT_HOUR = 250;
	public static int SAGE_ONE_REQUEST_LIMIT_DAY = 6000;
	public static int SAGE_ONE_REQUEST_TIMEOUT_SOCKET = 30000;
	public static int REQUEST_TIMEOUT = 30000;
	static Map<Integer, Integer> SAGE_ONE_REQUEST_COUNTER_DAY = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> SAGE_ONE_REQUEST_COUNTER_HOUR = new HashMap<Integer, Integer>();
	static int CURRENT_DAY = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	static int CURRENT_HOUR = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

	final static int MAX_STRING_LENGTH = 255; // For mysql, for VARCHAR() and not LONGTEXT/LONGBLOB/BLOBTEXT
	final static int MAX_DIGIT_LENGTH = 18; // 18/19 for longs
	final static String GENERAL_DIGIT_REGEX = "[.0-9.]{1," + MAX_DIGIT_LENGTH + "}";
	final static String GENERAL_PRICE_REGEX = "[.0-9.]+[.]+[.0-9.]{1," + MAX_DIGIT_LENGTH + "}";
	final static String GENERAL_STRING_REGEX = "[.*\\S .]{1," + MAX_STRING_LENGTH + "}";
	final static String REPLACEMENT_STRING = "####";
	final static String BooleanTrueString = "TRUE";
	final static String BooleanFalseString = "FALSE";
	final static String SKIP_QUERY_PARAM = "&$skip=";
	final static String API_KEY_QUERY_PARAM = "apikey=";
	final static String COMPANY_ID_QUERY_PARAM = "&companyid=";

	public final static Map<String, Integer> getSageOneApiCompanyList() {
		return SageOneConstants.COMPANY_LIST;
	}

	@Override
	public final Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
