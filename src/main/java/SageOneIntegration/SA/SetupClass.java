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

import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCompany;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneGrabbedResultsClass;
import SageOneIntegration.SageOneApiConnector;
import SageOneIntegration.SageOneResponseJsonDataObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import static SageOneIntegration.SA.SageOneConstants.*;
import static SageOneIntegration.SA.SageOneCoreConnection.*;
import static SageOneIntegration.SA.SageOneCoreConnection.objectsBeforeConversion;
import static SageOneIntegration.SA.SageOneCoreConnection.runningInner;
import static SageOneIntegration.SageOneConstants.SKIP_QUERY_PARAM;
import static SageOneIntegration.SageOneCoreHelperMethods.encodeCurlyBrackets;

/**
 * Created by Ricardo on 2017-07-05.
 */
class SetupClass {

    final boolean setupCompanyList() {
        boolean response = true;

        if(globalResponse) {
            try {
                String endpointToGetCompanies = endpointPrefix + "Company/Get?" + endpointSuffixGet +
                        encodeCurlyBrackets(new String(SageOneConstants.API_KEY));

                if (!runningInner) {
                    globalSkipIterator = 0;
                    objectsBeforeConversion = new ArrayList<Object>();
                    globalResponse = true;
                }

                SageOneResponseJsonDataObject sageOneResponseJsonDataObject = ConnectionCoreCodeReturnResponseJson(-255,
                        endpointToGetCompanies + SKIP_QUERY_PARAM + globalSkipIterator, RequestMethod.GET, null);

                if (sageOneResponseJsonDataObject.getSuccess()) {

                    SageOneGrabbedResultsClass resultObject = SageOneApiConnector.objectMapper.readValue(sageOneResponseJsonDataObject.getResponseJson(),
                            SageOneGrabbedResultsClass.class);

                    objectsBeforeConversion.addAll(Arrays.asList(resultObject.getResults()));

                    if (resultObject.getResults().length >= SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT) {
                        runningInner = true;
                        globalSkipIterator += SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT;
                        globalResponse = setupCompanyList();
                    } else {
                        for (Object object : objectsBeforeConversion) {
                            SageOneCompany sageOneCompanyToGetIdFrom = SageOneApiConnector.objectMapper.convertValue(object, SageOneCompany.class);
                            SageOneConstants.COMPANY_LIST.put(sageOneCompanyToGetIdFrom.getName(), sageOneCompanyToGetIdFrom.getId());
                            SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.put(sageOneCompanyToGetIdFrom.getId(), 0);
                            SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.put(sageOneCompanyToGetIdFrom.getId(), 0);
                        }
                        runningInner = false;
                        SageOneApiTemplateMainImpl.CompanyList =  SageOneConstants.COMPANY_LIST;
                    }

                    System.out.println("Companies with their id's successfully grabbed and listed from Sage One Accounting" +
                            " account");
                } else {
                    System.out.println("Sage One Integration code, could not setup CompanyId list, request failed or processing of data failed" +
                            ", check log for details.");
                }
            } catch (UnsupportedEncodingException e) {
                response = false;

                System.out.println("Sage One Integration code, could not setup CompanyId list, an error occurred while " +
                        "encoding the api-key");

                e.printStackTrace();

            } catch (Exception e) {
                response = false;

                System.out.println("Sage One Integration code, could not setup CompanyId list, a general Java IOException" +
                        " occurred");

                e.printStackTrace();
            }
        } else {
            response = false;
        }
        return response;
    }

    void setupSageOneApiSA(final Properties properties) {
        boolean response = true;
        try {
            if (properties.getProperty("sageOneApi.SA.apiKey") == null ||
                    properties.getProperty("sageOneApi.SA.clientUsername") == null ||
                    properties.getProperty("sageOneApi.SA.clientPassword") == null) {

                throw new Exception("Api key not set for SageOneSA SA Api Library");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response = false;
        }

        if (response) {
            SageOneConstants.CLIENT_USERNAME = properties.getProperty("sageOneApi.SA.clientUsername").toCharArray();
            SageOneConstants.CLIENT_PASSWORD = properties.getProperty("sageOneApi.SA.clientPassword").toCharArray();
            SageOneConstants.API_KEY = ("{" + properties.getProperty("sageOneApi.SA.apiKey") + "}").toCharArray();

            SageOneConstants.API_URL = (properties.getProperty("sageOneApi.SA.apiUrl") != null) ?
                    properties.getProperty("sageOneApi.SA.apiUrl") : SageOneConstants.API_URL;

            SageOneConstants.API_VERSION = (properties.getProperty("sageOneApi.SA.apiVersion") != null) ?
                    properties.getProperty("sageOneApi.SA.apiVersion") : SageOneConstants.API_VERSION;

            SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT = (properties.getProperty("sageOneApi.SA.requestResultLimit") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestResultLimit")) : SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT;

            SageOneConstants.REQUEST_TIMEOUT = (properties.getProperty("sageOneApi.SA.requestTimeout") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestTimeout")) : SageOneConstants.REQUEST_TIMEOUT;

            SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY = (properties.getProperty("sageOneApi.SA.requestLimitDay") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitDay")) : SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY;

            SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR = (properties.getProperty("sageOneApi.SA.requestLimitHour") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitHour")) : SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR;

            SageOneConstants.SAGE_ONE_REQUEST_TIMEOUT_SOCKET = (properties.getProperty("sageOneApi.SA.requestSocketTimeout") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitHour")) : SageOneConstants.SAGE_ONE_REQUEST_TIMEOUT_SOCKET;

            SageOneCoreConnection.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
            SageOneCoreConnection.endpointSuffixGet = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";

            SageOneCoreConnection.requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
            SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneCoreConnection.requestConfig).build();
            this.setupCompanyList();
        }
    }

    void setupSageOneApiSA(final Map<String, String> properties) {
        boolean response = true;
        try {
            if (properties.get("sageOneApi.SA.apiKey") == null || properties.get("sageOneApi.SA.clientUsername") == null ||
                    properties.get("sageOneApi.SA.clientPassword") == null) {

                throw new Exception("Api key not set for SageOneSA SA Api Library");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response = false;
        }

        if (response) {
            SageOneConstants.CLIENT_USERNAME = properties.get("sageOneApi.SA.clientUsername").toCharArray();
            SageOneConstants.CLIENT_PASSWORD = properties.get("sageOneApi.SA.clientPassword").toCharArray();
            SageOneConstants.API_KEY = ("{" + properties.get("sageOneApi.SA.apiKey") + "}").toCharArray();

            SageOneConstants.API_URL = (properties.get("sageOneApi.SA.apiUrl") != null) ?
                    properties.get("sageOneApi.SA.apiUrl") : SageOneConstants.API_URL;

            SageOneConstants.API_VERSION = (properties.get("sageOneApi.SA.apiVersion") != null) ?
                    properties.get("sageOneApi.SA.apiVersion") : SageOneConstants.API_VERSION;

            SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT = (properties.get("sageOneApi.SA.requestResultLimit") != null) ?
                    Integer.valueOf(properties.get("sageOneApi.SA.requestResultLimit")) : SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT;

            SageOneConstants.REQUEST_TIMEOUT = (properties.get("sageOneApi.SA.requestTimeout") != null) ?
                    Integer.valueOf(properties.get("sageOneApi.SA.requestTimeout")) : SageOneConstants.REQUEST_TIMEOUT;

            SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY = (properties.get("sageOneApi.SA.requestLimitDay") != null) ?
                    Integer.valueOf(properties.get("sageOneApi.SA.requestLimitDay")) : SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY;

            SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR = (properties.get("sageOneApi.SA.requestLimitHour") != null) ?
                    Integer.valueOf(properties.get("sageOneApi.SA.requestLimitHour")) : SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR;

            SageOneConstants.SAGE_ONE_REQUEST_TIMEOUT_SOCKET = (properties.get("sageOneApi.SA.requestSocketTimeout") != null) ?
                    Integer.valueOf(properties.get("sageOneApi.SA.requestLimitHour")) : SageOneConstants.SAGE_ONE_REQUEST_TIMEOUT_SOCKET;

            SageOneCoreConnection.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
            SageOneCoreConnection.endpointSuffixGet = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";

            SageOneCoreConnection.requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
            SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneCoreConnection.requestConfig).build();
            this.setupCompanyList();
        }
    }

    void setupSageOneApiSA(final Environment properties) {
        boolean response = true;
        try {
            if (properties.getProperty("sageOneApi.SA.apiKey") == null || properties.getProperty("sageOneApi.SA.clientUsername") == null ||
                    properties.getProperty("sageOneApi.SA.clientPassword") == null) {

                throw new Exception("Api key not set for SageOneSA SA Api Library");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response = false;
        }

        if (response) {
            SageOneConstants.CLIENT_USERNAME = properties.getProperty("sageOneApi.SA.clientUsername").toCharArray();
            SageOneConstants.CLIENT_PASSWORD = properties.getProperty("sageOneApi.SA.clientPassword").toCharArray();
            SageOneConstants.API_KEY = ("{" + properties.getProperty("sageOneApi.SA.apiKey") + "}").toCharArray();

            SageOneConstants.API_URL = (properties.getProperty("sageOneApi.SA.apiUrl") != null) ?
                    properties.getProperty("sageOneApi.SA.apiUrl") : SageOneConstants.API_URL;

            SageOneConstants.API_VERSION = (properties.getProperty("sageOneApi.SA.apiVersion") != null) ?
                    properties.getProperty("sageOneApi.SA.apiVersion") : SageOneConstants.API_VERSION;

            SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT = (properties.getProperty("sageOneApi.SA.requestResultLimit") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestResultLimit")) : SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT;

            SageOneConstants.REQUEST_TIMEOUT = (properties.getProperty("sageOneApi.SA.requestTimeout") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestTimeout")) : SageOneConstants.REQUEST_TIMEOUT;

            SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY = (properties.getProperty("sageOneApi.SA.requestLimitDay") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitDay")) : SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY;

            SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR = (properties.getProperty("sageOneApi.SA.requestLimitHour") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitHour")) : SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR;

            SageOneConstants.SAGE_ONE_REQUEST_TIMEOUT_SOCKET = (properties.getProperty("sageOneApi.SA.requestSocketTimeout") != null) ?
                    Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitHour")) : SageOneConstants.SAGE_ONE_REQUEST_TIMEOUT_SOCKET;

            SageOneCoreConnection.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
            SageOneCoreConnection.endpointSuffixGet = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";

            SageOneCoreConnection.requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
            SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneCoreConnection.requestConfig).build();
            this.setupCompanyList();
        }
    }
}
