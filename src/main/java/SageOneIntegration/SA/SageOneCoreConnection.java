/**
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 **/
package SageOneIntegration.SA;

import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneGrabbedResultsClass;
import SageOneIntegration.SageOneApiConnector;
import SageOneIntegration.SageOneResponseJsonObject;
import SageOneIntegration.SageOneResponseObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tika.Tika;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

import static SageOneIntegration.SA.SageOneConstants.*;
import static SageOneIntegration.SA.SageOneConstants.CLIENT_PASSWORD;
import static SageOneIntegration.SA.SageOneConstants.CLIENT_USERNAME;
import static SageOneIntegration.SageOneApiConnector.client;
import static SageOneIntegration.SageOneConstants.SKIP_QUERY_PARAM;
import static SageOneIntegration.SageOneCoreHelperMethods.encodeCurlyBrackets;
import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 * Created by Ricardo on 2017-07-05.
 */
public final class SageOneCoreConnection {
    protected static char[] notEncodedCredentials;
    protected static RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).setExpectContinueEnabled(true).setStaleConnectionCheckEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
    protected static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
    protected static int globalSkipIterator = 0;
    protected static boolean runningInner = false;
    protected static boolean globalResponse = true;
    protected static String endpointPrefix;
    protected static String endpointSuffixGet;
    protected static List<Object> objectsBeforeConversion;
    protected static boolean resultLimitReached = false;
    private static Tika tika = new Tika();

    private static void setNotEncodedCreditentials() {
        SageOneCoreConnection.notEncodedCredentials = new char[CLIENT_USERNAME.length + CLIENT_PASSWORD.length + 1];

        System.arraycopy(CLIENT_USERNAME, 0, SageOneCoreConnection.notEncodedCredentials, 0,
        CLIENT_USERNAME.length);

        SageOneCoreConnection.notEncodedCredentials[CLIENT_USERNAME.length] = ':';

        System.arraycopy(CLIENT_PASSWORD, 0, SageOneCoreConnection.notEncodedCredentials, CLIENT_USERNAME.length + 1,
        CLIENT_PASSWORD.length);
    }

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

    private static SageOneResponseJsonObject UploadCoreCodeReturnResponseJson(final int companyId,
                                                                             final String endpoint,
                                                                             final String fileName,
                                                                             final String objectType,
                                                                             final Object objectTypeRelatedId,
                                                                             final byte[] fileData) {
        boolean response = true;
        String resultToReturn = null;
        try {

            response = incrementSageOneRequestCounter(companyId);

            if(response) {
                setNotEncodedCreditentials();
                String authStringEnc = new BASE64Encoder().encode(new String(notEncodedCredentials).getBytes());

                // START OF SECURITY SUBSECTION -> Ignore
                SageOneCoreConnection.notEncodedCredentials = null;
                // END OF SECURITY SUBSECTION

                String boundary = "---------------"+UUID.randomUUID().toString();



                HttpEntity entity = MultipartEntityBuilder
                        .create()
                        .setBoundary(boundary)
                        .addBinaryBody("file", fileData, ContentType.APPLICATION_OCTET_STREAM, fileName)
                        .addTextBody(objectType + "Id", objectTypeRelatedId.toString())
                        .build();

                HttpPost request = new HttpPost(endpoint);
                request.setEntity(entity);


                client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneCoreConnection.requestConfig).build();
                request.setHeader("Content-Type", ContentType.MULTIPART_FORM_DATA.getMimeType()+";boundary="+boundary);
                request.addHeader("Authorization", "Basic " + authStringEnc);
                request.setHeader("Connection", "keep-alive");

                System.out.println(entity);

                CloseableHttpResponse responseFromRequest = client.execute(request);

                StatusLine statusLine = responseFromRequest.getStatusLine();

                response = (statusLine.getStatusCode() >= 200 && statusLine.getStatusCode() < 300);

                BufferedReader reader = new BufferedReader(new InputStreamReader(responseFromRequest.getEntity().getContent()));
                StringBuilder constructedResultString = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    // ... System.out.println(line) ?
                    System.out.println(line);
                    constructedResultString.append(line);
                }

                reader.close();
                responseFromRequest.close();
                resultToReturn = constructedResultString.toString();
            } else {
                String string = "MAX REQUEST LIMIT REACHED FOR HOUR/DAY, REQUEST COUNTERS:\n" +
                        "DAY -> " + SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY + "\n" +
                        "HOUR -> " + SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR;
                resultToReturn = string;
                response = false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        SageOneResponseJsonObject.initializeClass();

        SageOneResponseJsonObject jsonObjectToReturn = (response)
                ? new SageOneResponseJsonObject(true, null, resultToReturn) :
                new SageOneResponseJsonObject(false, "ERROR", resultToReturn);

        SageOneResponseJsonObject.deInitializeClass();

        return jsonObjectToReturn;
    }

    public static SageOneResponseJsonObject ConnectionCoreCodeReturnResponseJson(final int companyId,
                                                                          final String endpoint,
                                                                          final RequestMethod requestMethod,
                                                                          final String jsonEntityToPost) {
        boolean response = true;
        String resultToReturn = "";
        HttpRequestBase request = null;
        resultLimitReached = false;

        try {
            System.out.println(endpoint);
                if(requestMethod.equals(RequestMethod.GET)) {
                    request = new HttpGet(endpoint);
                } else if(requestMethod.equals(RequestMethod.POST)) {
                    request = new HttpPost(endpoint);

                    System.out.println(jsonEntityToPost);

                    RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
                    .setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT)
                    .setConnectionRequestTimeout(REQUEST_TIMEOUT).build();

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
                        setNotEncodedCreditentials();
                        String authStringEnc = new BASE64Encoder().encode(new String(notEncodedCredentials).getBytes());

                        // START OF SECURITY SUBSECTION -> Ignore
                        SageOneCoreConnection.notEncodedCredentials = null;
                        // END OF SECURITY SUBSECTION

                        client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneCoreConnection.requestConfig).build();
                        request.addHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
                        request.addHeader("Authorization", "Basic " + authStringEnc);
                        CloseableHttpResponse responseFromRequest = client.execute(request);

                        // START OF SECURITY SUBSECTION -> Ignore
                        authStringEnc = null;
                        // END OF SECURITY SUBSECTION

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
                                System.out.println(resultToReturn);
                            }
                        }
                        request.releaseConnection();
                        responseFromRequest.close();
                        client.close();
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

    final static SageOneResponseObject sageOneGrabData(final int companyId,
                                                       final String endpointPlusQuery,
                                                       final Class<?> ObjectClassToMapTo,
                                                       final boolean mustReturnResultObject) {
        SageOneResponseObject sageOneResponseObject = null;
        String endpoint = "";

        try {
            if(!runningInner) {
                SageOneResponseObject.initializeClass();
                globalSkipIterator = 0;
                objectsBeforeConversion = new ArrayList<Object>();

                endpoint = endpointPrefix + encodeCurlyBrackets(endpointPlusQuery) +
                        ((endpointPlusQuery.contains("?") && endpointPlusQuery.contains("=")) ?
                                "&" + endpointSuffixGet : "?" + endpointSuffixGet) +
                                encodeCurlyBrackets(new String(SageOneConstants.API_KEY)) +
                        SageOneConstants.COMPANY_ID_QUERY_PARAM + companyId;
            } else {
                endpoint = endpointPlusQuery;
            }
            SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, (runningInner) ?
                    endpoint + SKIP_QUERY_PARAM + globalSkipIterator : endpoint, RequestMethod.GET, null);
            if(mustReturnResultObject) {
                SageOneGrabbedResultsClass responseResultObject;
                if(jsonResponse.getSuccess()) {
                    System.out.println(jsonResponse.getSuccess());
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
                    sageOneGrabData(companyId, endpoint, ObjectClassToMapTo, mustReturnResultObject);
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
        } catch (IOException e) {
            e.printStackTrace();

            sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
                    "trying to grab data from the SageOneSA account, look on terminal or log files for details");
        }

        return sageOneResponseObject;
    }

    final static SageOneResponseObject sageOneSaveData(final int companyId,
                                                       final Class<?> classToMapTo,
                                                       final String endpointPlusQuery,
                                                       final String jsonObject) {
        SageOneResponseObject.initializeClass();
        SageOneResponseObject sageOneResponseObject = null;
        String endpoint = "";
        try {
            endpoint = endpointPrefix + endpointPlusQuery +
            SageOneConstants.API_KEY_QUERY_PARAM + encodeCurlyBrackets(new String(SageOneConstants.API_KEY)) +
            SageOneConstants.COMPANY_ID_QUERY_PARAM + companyId;

            SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, endpoint,
                    RequestMethod.POST, jsonObject);

            sageOneResponseObject = (jsonResponse.getSuccess())
                    ? new SageOneResponseObject(true, jsonResponse.getResponseMessage(), SageOneApiConnector.objectMapper.readValue(jsonResponse.getResponseJson(), classToMapTo)) :
                    new SageOneResponseObject(false, "Failed to save data on SageOneSA account, the request failed");

        } catch (IOException e) {
            e.printStackTrace();

            sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
                    "trying to save data on the SageOneSA account, look on terminal or log files for details");
        }

        SageOneResponseObject.deInitializeClass();
        return sageOneResponseObject;
    }

    protected final static SageOneResponseObject deleteSageOneEntity(final int companyId,
                                                                     final String endpointPlusQuery) {
        SageOneResponseObject.initializeClass();
        SageOneResponseObject sageOneResponseObject = null;
        String endpoint = "";

        endpoint = endpointPrefix + endpointPlusQuery + SageOneConstants.API_KEY_QUERY_PARAM +
                    encodeCurlyBrackets(new String(SageOneConstants.API_KEY)) +
                    SageOneConstants.COMPANY_ID_QUERY_PARAM + companyId;

        SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, endpoint,
                RequestMethod.DELETE, null);

        sageOneResponseObject = (jsonResponse.getSuccess())
                ? new SageOneResponseObject(true, jsonResponse.getResponseMessage()) :
                new SageOneResponseObject(false,
                "Failed to delete data on SageOneSA account, the request failed");

        SageOneResponseObject.deInitializeClass();
        return sageOneResponseObject;
    }

    final static SageOneResponseObject sageOneUploadData(final int companyId,
                                                         final String endpointPlusQuery,
                                                         final Class<?> classToMapTo,
                                                         final String fileName,
                                                         final String objectType,
                                                         final Object objectTypeRelatedId,
                                                         final byte[] fileData) {
        SageOneResponseObject.initializeClass();
        SageOneResponseObject sageOneResponseObject = null;
        String endpoint = "";
        try {
            endpoint = endpointPrefix + endpointPlusQuery +
                    SageOneConstants.API_KEY_QUERY_PARAM + encodeCurlyBrackets(new String(SageOneConstants.API_KEY)) +
                    SageOneConstants.COMPANY_ID_QUERY_PARAM + companyId;

            SageOneResponseJsonObject jsonResponse = UploadCoreCodeReturnResponseJson(companyId, endpoint, fileName,
                    objectType, objectTypeRelatedId, fileData);

            sageOneResponseObject = (jsonResponse.getSuccess())
                    ? new SageOneResponseObject(true, jsonResponse.getResponseMessage(), SageOneApiConnector.objectMapper.readValue(jsonResponse.getResponseJson(), classToMapTo)) :
                    new SageOneResponseObject(false, "Failed to upload data on SageOneSA account, the request failed");

        } catch (IOException e) {
            e.printStackTrace();

            sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
                    "trying to upload data on the SageOneSA account, look on terminal or log files for details");
        }

        SageOneResponseObject.deInitializeClass();
        return sageOneResponseObject;
    }
}
