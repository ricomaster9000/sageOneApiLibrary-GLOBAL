package SageOneIntegration.SA;

import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCompany;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneGrabbedResultsClass;
import SageOneIntegration.SageOneApiConnector;
import SageOneIntegration.SageOneResponseJsonObject;
import SageOneIntegration.SageOneResponseObject;
import org.apache.http.StatusLine;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static SageOneIntegration.SA.SageOneConstants.REQUEST_TIMEOUT;
import static SageOneIntegration.SA.SageOneConstants.SAGE_ONE_REQUEST_TIMEOUT_SOCKET;
import static SageOneIntegration.SageOneConstants.SKIP_QUERY_PARAM;
import static SageOneIntegration.SageOneCoreHelperMethods.encodeCurlyBrackets;

/**
 * Created by Ricardo on 2017-07-05.
 */
final class SageOneCoreConnection {
    protected static String notEncodedCredentials;
    protected static RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).setExpectContinueEnabled(true).setStaleConnectionCheckEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
    protected static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
    protected static int globalSkipIterator = 0;
    protected static boolean runningInner = false;
    protected static boolean globalResponse = true;
    protected static String endpointPrefix;
    protected static String endpointSuffixGet;
    protected static List<Object> objectsBeforeConversion;
    protected static boolean resultLimitReached = false;

    static boolean incrementSageOneRequestCounter(final int companyId) {
        boolean response = true;
        SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.put(companyId, SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.get(companyId) + 1);
        SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.put(companyId, SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.get(companyId) + 1);
        DateTime now = new DateTime();

        if((SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.get(companyId) >= SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY &&
                SageOneConstants.CURRENT_DAY == now.getDayOfMonth())
                || (SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.get(companyId) >= SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR &&
                SageOneConstants.CURRENT_HOUR == now.getHourOfDay())) {
            response = false;
            resultLimitReached = true;
        }

        if(SageOneConstants.CURRENT_DAY != now.getDayOfMonth()) {
            SageOneConstants.CURRENT_DAY = now.getDayOfMonth();
            SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.put(companyId, 0);
        }

        if(SageOneConstants.CURRENT_HOUR != now.getHourOfDay()) {
            SageOneConstants.CURRENT_HOUR = now.getHourOfDay();
            SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.put(companyId, 0);
        }
        return response;
    }

    static SageOneResponseJsonObject ConnectionCoreCodeReturnResponseJson(final int companyId,
                                                                                  final String endpoint,
                                                                                  final RequestMethod requestMethod,
                                                                                  final String jsonEntityToPost) {
        boolean response = true;
        String resultToReturn = "";
        HttpRequestBase request = null;
        resultLimitReached = false;

        try {
            if(requestMethod.equals(RequestMethod.GET)) {
                request = new HttpGet(endpoint);
                System.out.println(endpoint);
            } else if(requestMethod.equals(RequestMethod.POST)) {
                request = new HttpPost(endpoint);
                RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
                request.setConfig(requestConfig);
                StringEntity stringEntity = new StringEntity(jsonEntityToPost);
                stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
                ((HttpPost) request).setEntity(stringEntity);
                request.setHeader("Accept", ContentType.APPLICATION_JSON.toString());
            } else if(requestMethod.equals(RequestMethod.PUT)) {
                request = new HttpPut(endpoint);
            } else if(requestMethod.equals(RequestMethod.DELETE)) {
                request = new HttpDelete(endpoint);
            } else {
                response = false;
                resultToReturn = "ERROR, UNKNOWN REQUEST METHOD";
            }

            if(response) {
                response = (companyId != -255) ? incrementSageOneRequestCounter(companyId) : (companyId == -255);

                if(response) {
                    String authStringEnc = new BASE64Encoder().encode(notEncodedCredentials.getBytes());
                    String encodedCredentials = "Basic " + authStringEnc;

                    SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneCoreConnection.requestConfig).build();
                    request.addHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
                    request.addHeader("Authorization", encodedCredentials);
                    CloseableHttpResponse responseFromRequest = SageOneApiConnector.client.execute(request);
                    StatusLine responseCode = responseFromRequest.getStatusLine();

                    System.out.println(responseCode);

                    response = responseCode.getStatusCode() >= 200 && responseCode.getStatusCode() < 300;

                    if(response) {
                        if(responseCode.getStatusCode() == 204 || responseFromRequest.getEntity() == null) {
                            resultToReturn = "";
                        } else {
                            BufferedReader rd = new BufferedReader(new InputStreamReader(responseFromRequest.getEntity().getContent()));

                            StringBuilder constructedResultString = new StringBuilder();
                            String line = "";

                            while ((line = rd.readLine()) != null) {
                                constructedResultString.append(line);
                            }
                            resultToReturn = constructedResultString.toString();
                        }
                    }
                    request.releaseConnection();
                    responseFromRequest.close();
                    SageOneApiConnector.client.close();
                } else {
                    String string = "MAX REQUEST LIMIT REACHED FOR HOUR/DAY, REQUEST COUNTERS:\n" +
                            "DAY -> " + SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY + "\n" +
                            "HOUR -> " + SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR;
                    resultToReturn = string;
                    response = false;
                }
            }
        } catch(IOException e) {
            resultToReturn = "A Java Exception Occurred in the Sage One Integration SageOneApiConnector.class " +
                    "ConnectionCoreCode method code, please check to see what may have caused it, note that it gets" +
                    "used in all the other component methods, so you need to pinpoint which one it is";

            e.printStackTrace();
            request.releaseConnection();
        }

        SageOneResponseJsonObject.initializeClass();

        SageOneResponseJsonObject jsonObjectToReturn = (response)
                ? new SageOneResponseJsonObject(true, null, resultToReturn) :
                new SageOneResponseJsonObject(false, "ERROR", resultToReturn);

        SageOneResponseJsonObject.deInitializeClass();

        return jsonObjectToReturn;
    }

    final static SageOneResponseObject sageOneGrabData(final String endpointPlusQuery, final Class<?> ObjectClassToMapTo,
                                                                final boolean mustReturnResultObject, final int companyId) {
        SageOneResponseObject sageOneResponseObject = null;
        String endpoint = "";

        try {
            if(!runningInner) {
                SageOneResponseObject.initializeClass();
                globalSkipIterator = 0;
                objectsBeforeConversion = new ArrayList<Object>();

                endpoint = endpointPrefix + encodeCurlyBrackets(endpointPlusQuery) +
                        ((endpointPlusQuery.contains("?") && endpointPlusQuery.contains("=")) ?
                                "&" + endpointSuffixGet : "?" + endpointSuffixGet) + encodeCurlyBrackets(SageOneConstants.API_KEY) +
                        SageOneConstants.COMPANY_ID_QUERY_PARAM + companyId;
            } else {
                endpoint = endpointPlusQuery;
            }
            SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, (runningInner) ?
                    endpoint + SKIP_QUERY_PARAM + globalSkipIterator : endpoint, RequestMethod.GET, null);
            if(mustReturnResultObject) {
                SageOneGrabbedResultsClass responseResultObject;
                if(jsonResponse.getSuccess()) {
                    responseResultObject = SageOneApiConnector.objectMapper.readValue(jsonResponse.getResponseJson(), SageOneGrabbedResultsClass.class);
                    for (Object object : responseResultObject.getResults()) {
                        objectsBeforeConversion.add(SageOneApiConnector.objectMapper.convertValue(object, ObjectClassToMapTo));
                    }
                } else {
                    responseResultObject = new SageOneGrabbedResultsClass();
                }

                if (responseResultObject.getResults().length >= SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT) {
                    runningInner = true;
                    globalSkipIterator += SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT;
                    sageOneGrabData(endpoint, ObjectClassToMapTo, mustReturnResultObject, companyId);
                } else {
                    runningInner = false;
                }
                sageOneResponseObject = (jsonResponse.getSuccess()) ? new SageOneResponseObject(jsonResponse.getSuccess(),
                        objectsBeforeConversion, objectsBeforeConversion.size()) :
                        (resultLimitReached) ? new SageOneResponseObject(true,
                                objectsBeforeConversion, objectsBeforeConversion.size()) :
                                new SageOneResponseObject(jsonResponse.getSuccess(), "Failed to grab data from SageOneSA account, the request failed");
            } else {
                sageOneResponseObject = (jsonResponse.getSuccess()) ?
                        new SageOneResponseObject(true, SageOneApiConnector.objectMapper.readValue(jsonResponse.getResponseJson(),
                                ObjectClassToMapTo)) : new SageOneResponseObject(false,
                        "Failed to grab data from SageOneSA account, the request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();

            sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
                    "trying to grab data from the SageOneSA account, look on terminal or log files for details");
        }

        return sageOneResponseObject;
    }

    final static SageOneResponseObject sageOneSaveData(final Class<?> classToMapTo,
                                                              final String endpointPlusQuery, final String jsonObject,
                                                              final int companyId) {
        SageOneResponseObject.initializeClass();
        SageOneResponseObject sageOneResponseObject = null;
        String endpoint = "";
        try {
            endpoint = endpointPrefix + endpointPlusQuery +
                    SageOneConstants.API_KEY_QUERY_PARAM + encodeCurlyBrackets(SageOneConstants.API_KEY) + SageOneConstants.COMPANY_ID_QUERY_PARAM + companyId;

            SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, endpoint, RequestMethod.POST, jsonObject);

            sageOneResponseObject = (jsonResponse.getSuccess())
                    ? new SageOneResponseObject(true, jsonResponse.getResponseMessage(), SageOneApiConnector.objectMapper.readValue(jsonResponse.getResponseJson(), classToMapTo)) :
                    new SageOneResponseObject(false, "Failed to save data on SageOneSA account, the request failed");

        } catch (Exception e) {
            e.printStackTrace();

            sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
                    "trying to save data on the SageOneSA account, look on terminal or log files for details");
        }

        SageOneResponseObject.deInitializeClass();
        return sageOneResponseObject;
    }

    final static SageOneResponseObject deleteSageOneEntity(final String endpointPlusQuery,
                                                                  final int companyId) {
        SageOneResponseObject.initializeClass();
        SageOneResponseObject sageOneResponseObject = null;
        String endpoint = "";
        try {
            endpoint = endpointPrefix + endpointPlusQuery + SageOneConstants.API_KEY_QUERY_PARAM +
                    encodeCurlyBrackets(SageOneConstants.API_KEY) +
                    SageOneConstants.COMPANY_ID_QUERY_PARAM + companyId;

            SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, endpoint,
                    RequestMethod.DELETE, null);

            sageOneResponseObject = (jsonResponse.getSuccess())
                    ? new SageOneResponseObject(true, jsonResponse.getResponseMessage()) :
                    new SageOneResponseObject(false, "Failed to delete data on SageOneSA account, the request failed");

        } catch (Exception e) {
            e.printStackTrace();

            sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
                    "trying to delete data on the SageOneSA account, look on terminal or log files for details");
        }

        SageOneResponseObject.deInitializeClass();
        return sageOneResponseObject;
    }
}
