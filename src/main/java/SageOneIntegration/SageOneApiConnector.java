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
package SageOneIntegration;


import SageOneIntegration.SageOneApiEntities.SageOneCompany;
import SageOneIntegration.SageOneApiEntities.SageOneGrabbedResultsClass;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.core.env.Environment;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.*;

import static SageOneIntegration.SageOneConstants.*;
import static SageOneIntegration.SageOneCoreHelperMethods.encodeCurlyBrackets;


public final class SageOneApiConnector {
	private static final long serialVersionUID = 1L;
	static final ObjectMapper objectMapper = new ObjectMapper();
	private static String endpointPrefix;
	private static String endpointSuffixGet;
	private static String notEncodedCredentials;
	private static RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).setExpectContinueEnabled(true).setStaleConnectionCheckEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
	private static CloseableHttpClient client = HttpClients.createDefault();
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
	private static List<Object> objectsBeforeConversion;
	private static int globalSkipIterator = 0;
	private static boolean runningInner = false;
	private static boolean globalResponse = true;

	SageOneApiConnector() {
	}

	public static final void setupSageOneApiSA(final Properties properties) {
		boolean response = true;
		try {
			if (properties.getProperty("sageOneApi.SA.apiKey") == null ||
				properties.getProperty("sageOneApi.SA.clientUsername") == null ||
				properties.getProperty("sageOneApi.SA.clientPassword") == null) {

				throw new Exception("Api key not set for SageOne SA Api Library");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			response = false;
		}

		if(response) {
			SageOneConstants.CLIENT_USERNAME = properties.getProperty("sageOneApi.SA.clientUsername");
			SageOneConstants.CLIENT_PASSWORD = properties.getProperty("sageOneApi.SA.clientPassword");
			SageOneConstants.API_KEY = "{" + properties.getProperty("sageOneApi.SA.apiKey") + "}";

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

			SageOneApiConnector.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
			SageOneApiConnector.endpointSuffixGet = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";
			SageOneApiConnector.notEncodedCredentials = CLIENT_USERNAME + ":" + CLIENT_PASSWORD;
			SageOneApiConnector.objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

			SageOneApiConnector.requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
			SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneApiConnector.requestConfig).build();
			setupCompanyList();
		}
	}

	public static final void setupSageOneApiSA(final Map<String, String> properties) {
		boolean response = true;
		try {
			if (properties.get("sageOneApi.SA.apiKey") == null || properties.get("sageOneApi.SA.clientUsername") == null ||
					properties.get("sageOneApi.SA.clientPassword") == null) {

				throw new Exception("Api key not set for SageOne SA Api Library");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			response = false;
		}

		if(response) {
			SageOneConstants.CLIENT_USERNAME = properties.get("sageOneApi.SA.clientUsername");
			SageOneConstants.CLIENT_PASSWORD = properties.get("sageOneApi.SA.clientPassword");
			SageOneConstants.API_KEY = "{" + properties.get("sageOneApi.SA.apiKey") + "}";

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

			SageOneApiConnector.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
			SageOneApiConnector.endpointSuffixGet = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";
			SageOneApiConnector.notEncodedCredentials = CLIENT_USERNAME + ":" + CLIENT_PASSWORD;
			SageOneApiConnector.objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

			SageOneApiConnector.requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
			SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneApiConnector.requestConfig).build();
			setupCompanyList();
		}
	}

	public static final void setupSageOneApiSA(final Environment properties) {
		boolean response = true;
		try {
			if (properties.getProperty("sageOneApi.SA.apiKey") == null || properties.getProperty("sageOneApi.SA.clientUsername") == null ||
					properties.getProperty("sageOneApi.SA.clientPassword") == null) {

				throw new Exception("Api key not set for SageOne SA Api Library");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			response = false;
		}

		if(response) {
			SageOneConstants.CLIENT_USERNAME = properties.getProperty("sageOneApi.SA.clientUsername");
			SageOneConstants.CLIENT_PASSWORD = properties.getProperty("sageOneApi.SA.clientPassword");
			SageOneConstants.API_KEY = "{" + properties.getProperty("sageOneApi.SA.apiKey") + "}";

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

			SageOneApiConnector.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
			SageOneApiConnector.endpointSuffixGet = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";
			SageOneApiConnector.notEncodedCredentials = CLIENT_USERNAME + ":" + CLIENT_PASSWORD;
			SageOneApiConnector.objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

			SageOneApiConnector.requestConfig = RequestConfig.custom().setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
			SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(SageOneApiConnector.requestConfig).build();
			setupCompanyList();
		}
	}

	private static boolean incrementSageOneRequestCounter(final int companyId) {
		boolean response = true;
		SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.put(companyId, SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.get(companyId) + 1);
		SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.put(companyId, SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.get(companyId) + 1);
		Calendar calendar = Calendar.getInstance();

		if((SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.get(companyId) >= SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY &&
		   SageOneConstants.CURRENT_DAY == calendar.get(Calendar.DAY_OF_WEEK))
		   || (SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.get(companyId) >= SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR &&
		   SageOneConstants.CURRENT_HOUR == calendar.get(Calendar.HOUR_OF_DAY))) {
			response = false;
		}

		if(SageOneConstants.CURRENT_DAY != calendar.get(Calendar.DAY_OF_WEEK)) {
		    SageOneConstants.CURRENT_DAY = calendar.get(Calendar.DAY_OF_WEEK);
			SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY.put(companyId, 0);
		}

		if(SageOneConstants.CURRENT_HOUR != calendar.get(Calendar.HOUR_OF_DAY)) {
			SageOneConstants.CURRENT_HOUR = calendar.get(Calendar.HOUR_OF_DAY);
			SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR.put(companyId, 0);
		}
		return response;
	}

	private static boolean setupCompanyList() {
		boolean response = true;

		if(globalResponse) {
			try {
				String endpointToGetCompanies = endpointPrefix + "Company/Get?" + endpointSuffixGet +
				encodeCurlyBrackets(API_KEY);

				if (!runningInner) {
					globalSkipIterator = 0;
					objectsBeforeConversion = new ArrayList<Object>();
					globalResponse = true;
				}

				SageOneResponseJsonObject sageOneResponseJsonObject = ConnectionCoreCodeReturnResponseJson(-255,
				endpointToGetCompanies + "&$skip=" + globalSkipIterator, "GET", null);

				if (sageOneResponseJsonObject.getSuccess()) {

					SageOneGrabbedResultsClass resultObject = objectMapper.readValue(sageOneResponseJsonObject.getResponseJson(),
					SageOneGrabbedResultsClass.class);

					objectsBeforeConversion.addAll(Arrays.asList(resultObject.getResults()));

					if (resultObject.getResults().length >= SAGE_ONE_REQUEST_RESULT_LIMIT) {
						runningInner = true;
						globalSkipIterator += SAGE_ONE_REQUEST_RESULT_LIMIT;
						globalResponse = setupCompanyList();
					} else {
						for (Object object : objectsBeforeConversion) {
							SageOneCompany sageOneCompanyToGetIdFrom = objectMapper.convertValue(object, SageOneCompany.class);
							COMPANY_LIST.put(sageOneCompanyToGetIdFrom.getName(), sageOneCompanyToGetIdFrom.getId());
							SAGE_ONE_REQUEST_COUNTER_DAY.put(sageOneCompanyToGetIdFrom.getId(), 0);
							SAGE_ONE_REQUEST_COUNTER_HOUR.put(sageOneCompanyToGetIdFrom.getId(), 0);
						}
						runningInner = false;
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

	private static SageOneResponseJsonObject ConnectionCoreCodeReturnResponseJson(final Integer companyId,
										      String endpoint, final String requestMethod,														  final String jsonEntityToPost) {
		boolean response = true;
		String resultToReturn = "";
		HttpRequestBase request = null;
		System.out.println(endpoint);

		try {
			if(requestMethod.toUpperCase().equals("GET")) {
				request = new HttpGet(endpoint);
			} else if(requestMethod.toUpperCase().equals("POST")) {
				request = new HttpPost(endpoint);
				RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setSocketTimeout(SAGE_ONE_REQUEST_TIMEOUT_SOCKET).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();
				request.setConfig(requestConfig);
				StringEntity stringEntity = new StringEntity(jsonEntityToPost);
				stringEntity.setContentType("application/json");
				((HttpPost) request).setEntity(stringEntity);
				request.setHeader("Accept", "application/json");
			} else if(requestMethod.toUpperCase().equals("PUT")) {
				request = new HttpPut(endpoint);
			} else if(requestMethod.toUpperCase().equals("DELETE")) {
				request = new HttpDelete(endpoint);
			} else {
				response = false;
				resultToReturn = "ERROR, UNKNOWN REQUEST METHOD";
			}

			if(response) {
				response = (companyId != -255) ? incrementSageOneRequestCounter(companyId) : (companyId == -255);

				if(response) {
					String authStringEnc = new BASE64Encoder().encode(notEncodedCredentials.getBytes());
					String encodedCredidentials = "Basic " + authStringEnc;

					request.addHeader("Content-Type", "application/json");
					request.addHeader("Authorization", encodedCredidentials);
					HttpResponse responseFromRequest = client.execute(request);
					StatusLine responseCode = responseFromRequest.getStatusLine();
					System.out.println(responseCode);

					response = responseCode.getStatusCode() >= 200 && responseCode.getStatusCode() < 300;

					if(response) {
						BufferedReader rd = new BufferedReader(new InputStreamReader(responseFromRequest.getEntity().getContent()));

						StringBuilder constructedResultString = new StringBuilder();
						String line = "";

						while ((line = rd.readLine()) != null) {
							constructedResultString.append(line);
						}
						resultToReturn = constructedResultString.toString();
					}
					request.releaseConnection();
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
		}

		SageOneResponseJsonObject.initializeClass();

		SageOneResponseJsonObject jsonObjectToReturn = (response)
				? new SageOneResponseJsonObject(true, null, resultToReturn) :
				new SageOneResponseJsonObject(false, "ERROR", resultToReturn);

		SageOneResponseJsonObject.deInitializeClass();

		return jsonObjectToReturn;
	}

	public final static SageOneResponseObject sageOneGrabData(final String endpointPlusQuery, final Class<?> ObjectClassToMapTo,
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
					"&" + endpointSuffixGet : "?" + endpointSuffixGet) + encodeCurlyBrackets(API_KEY) +
					"&companyid=" + companyId;
			} else {
				endpoint = endpointPlusQuery;
			}
			SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, (runningInner) ?
			endpoint + "&$skip=" + globalSkipIterator : endpoint, "GET", null);
			if(mustReturnResultObject && jsonResponse.getSuccess()) {
				SageOneGrabbedResultsClass responseResultObject =
				objectMapper.readValue(jsonResponse.getResponseJson(), SageOneGrabbedResultsClass.class);

				for(Object object : responseResultObject.getResults()) {
					objectsBeforeConversion.add(objectMapper.convertValue(object, ObjectClassToMapTo));
				}

				if(responseResultObject.getResults().length >= SAGE_ONE_REQUEST_RESULT_LIMIT) {
					runningInner = true;
					globalSkipIterator += SAGE_ONE_REQUEST_RESULT_LIMIT;
					sageOneGrabData(endpoint, ObjectClassToMapTo, mustReturnResultObject, companyId);
				} else {
					runningInner = false;
				}
				sageOneResponseObject = (jsonResponse.getSuccess()) ? new SageOneResponseObject(true,
						objectsBeforeConversion, objectsBeforeConversion.size()) :
						new SageOneResponseObject(false, "Failed to grab data from SageOne account, the request failed");
			} else {
				sageOneResponseObject = (jsonResponse.getSuccess())
						? new SageOneResponseObject(true, objectMapper.readValue(jsonResponse.getResponseJson(),
						ObjectClassToMapTo)) : new SageOneResponseObject(false,
						"Failed to grab data from SageOne account, the request failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
			"trying to grab data from the SageOne account, look on terminal or log files for details");
		}

		return sageOneResponseObject;
	}

	public final static SageOneResponseObject sageOneSaveData(final Class<?> classToMapTo,
													   final String endpointPlusQuery, final String jsonObject,
													   final int companyId) {
		SageOneResponseObject.initializeClass();
		SageOneResponseObject sageOneResponseObject = null;
		String endpoint = "";
		try {
			endpoint = endpointPrefix + endpointPlusQuery +
					"apikey=" + encodeCurlyBrackets(API_KEY) + "&companyid=" + companyId;

			SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, endpoint, "POST", jsonObject);

			sageOneResponseObject = (jsonResponse.getSuccess())
					? new SageOneResponseObject(true, jsonResponse.getResponseMessage(), objectMapper.readValue(jsonResponse.getResponseJson(), classToMapTo)) :
					new SageOneResponseObject(false, "Failed to save data on SageOne account, the request failed");

		} catch (Exception e) {
			e.printStackTrace();
			
			sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
			"trying to save data on the SageOne account, look on terminal or log files for details");
		}

		SageOneResponseObject.deInitializeClass();
		return sageOneResponseObject;
	}

	public final static SageOneResponseObject deleteSageOneEntity(final String endpointPlusQuery,
														   final int companyId) {
		SageOneResponseObject.initializeClass();
		SageOneResponseObject sageOneResponseObject = null;
		String endpoint = "";
		try {
			endpoint = endpointPrefix + endpointPlusQuery +
					"?apikey=" + encodeCurlyBrackets(API_KEY) + "&companyid=" + companyId;

			SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, endpoint, "DELETE", null);

			sageOneResponseObject = (jsonResponse.getSuccess())
					? new SageOneResponseObject(true, jsonResponse.getResponseMessage()) :
					new SageOneResponseObject(false, "Failed to delete data on SageOne account, the request failed");

		} catch (Exception e) {
			e.printStackTrace();

			sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
					"trying to delete data on the SageOne account, look on terminal or log files for details");
		}

		SageOneResponseObject.deInitializeClass();
		return sageOneResponseObject;
	}
}
