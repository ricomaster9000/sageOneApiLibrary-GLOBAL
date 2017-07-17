/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA;


import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ricardo on 2017-07-05.
 */
public class SageOneConstants {
    /*
    Request Limits,

    All Sage One companies have a request limit of 5000 API requests per day. A maximum of 100 results will be
    returned for list methods, regardless of the parameter sent through. THIS IS PER COMPANY/USER,
    CAN HAVE MORE THAN ONE, LIMIT IS NOT ENFORCED BUT REALLY RECOMMENDED.
   */
    protected static char[] CLIENT_USERNAME = new char[]{}; // Change to actual and then toCharArray
    protected static char[] CLIENT_PASSWORD = new char[]{};  // Change to actual and then toCharArray
    protected static char[] API_KEY = new char[]{}; // Change to actual and then toCharArray


    protected static String API_URL = "https://accounting.sageone.co.za";
    public static String API_VERSION = "1.1.2";
    protected static int SAGE_ONE_REQUEST_RESULT_LIMIT = 100;
    protected static int SAGE_ONE_REQUEST_LIMIT_HOUR = 250;
    protected static int SAGE_ONE_REQUEST_LIMIT_DAY = 6000;
    protected static int SAGE_ONE_REQUEST_TIMEOUT_SOCKET = 30000;
    protected static int REQUEST_TIMEOUT = 30000;
    protected final static String API_KEY_QUERY_PARAM = "apikey=";
    protected final static String COMPANY_ID_QUERY_PARAM = "&companyid=";
    protected static Map<Integer, Integer> SAGE_ONE_REQUEST_COUNTER_DAY = new HashMap<Integer, Integer>();
    protected static Map<Integer, Integer> SAGE_ONE_REQUEST_COUNTER_HOUR = new HashMap<Integer, Integer>();
    protected static int CURRENT_DAY = new DateTime().getDayOfMonth();
    protected static int CURRENT_HOUR = new DateTime().getHourOfDay();
    protected static final Map<String, Integer> COMPANY_LIST = new HashMap<String, Integer>();


    public final static Map<String, Integer> getSageOneApiCompanyList() {
        return SageOneConstants.COMPANY_LIST;
    }
}
