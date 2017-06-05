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
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static SageOneIntegration.SageOneConstants.*;
import static SageOneIntegration.SageOneCoreHelperMethods.encodeCurlyBrackets;


public final class SageOneApiConnector {
	private static final long serialVersionUID = 1L;
	static final ObjectMapper objectMapper = new ObjectMapper();
	private static String endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
	private static String endpointSuffix = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";
	private static String notEncodedCredentials = CLIENT_USERNAME + ":" + CLIENT_PASSWORD;
	private static HttpClient client = HttpClientBuilder.create().build();
	private static List<Object> objectsBeforeConversion;
	private static int globalSkipIterator = 0;
	private static boolean runningInner = false;
	private static boolean globalResponse = true;

	SageOneApiConnector() {
	}

	public static final void setupSageOneApiConnector(final Properties properties) {
		SageOneConstants.CLIENT_USERNAME = properties.getProperty("sageOneApi.SA.clientUsername");
		SageOneConstants.CLIENT_PASSWORD = properties.getProperty("sageOneApi.SA.clientPassword");
		SageOneConstants.API_URL = properties.getProperty("sageOneApi.SA.apiUrl");
		SageOneConstants.API_VERSION = properties.getProperty("sageOneApi.SA.apiVersion");
		SageOneConstants.API_KEY = "{" + properties.get("sageOneApi.SA.apiKey") + "}";
		SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT = Integer.valueOf(properties.getProperty("sageOneApi.SA.requestResultLimit"));
		SageOneConstants.REQUEST_TIMEOUT = Integer.valueOf(properties.getProperty("sageOneApi.SA.requestTimeout"));
		SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY = Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitDay"));
		SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR = Integer.valueOf(properties.getProperty("sageOneApi.SA.requestLimitHour"));


		SageOneApiConnector.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
		SageOneApiConnector.endpointSuffix = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";
		SageOneApiConnector.notEncodedCredentials = CLIENT_USERNAME + ":" + CLIENT_PASSWORD;


		SageOneApiConnector.objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(REQUEST_TIMEOUT).build();
		SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

		try {
			if (!setupCompanyList()) {
				throw new Exception("Could net setup SageOne Integration Library, check console for details");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final void setupSageOneApiSA(final Map<String, String> properties) {
		SageOneConstants.CLIENT_USERNAME = properties.get("sageOneApi.SA.clientUsername");
		SageOneConstants.CLIENT_PASSWORD = properties.get("sageOneApi.SA.clientPassword");
		SageOneConstants.API_URL = properties.get("sageOneApi.SA.apiUrl");
		SageOneConstants.API_VERSION = properties.get("sageOneApi.SA.apiVersion");
		SageOneConstants.API_KEY = "{" + properties.get("sageOneApi.SA.apiKey") + "}";
		SageOneConstants.SAGE_ONE_REQUEST_RESULT_LIMIT = Integer.valueOf(properties.get("sageOneApi.SA.requestResultLimit"));
		SageOneConstants.REQUEST_TIMEOUT = Integer.valueOf(properties.get("sageOneApi.SA.requestTimeout"));
		SageOneConstants.SAGE_ONE_REQUEST_LIMIT_DAY = Integer.valueOf(properties.get("sageOneApi.SA.requestLimitDay"));
		SageOneConstants.SAGE_ONE_REQUEST_LIMIT_HOUR = Integer.valueOf(properties.get("sageOneApi.SA.requestLimitHour"));

		SageOneApiConnector.endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
		SageOneApiConnector.endpointSuffix = "$top=" + SAGE_ONE_REQUEST_RESULT_LIMIT + "&apikey=";
		SageOneApiConnector.notEncodedCredentials = CLIENT_USERNAME + ":" + CLIENT_PASSWORD;

		SageOneApiConnector.objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(REQUEST_TIMEOUT).build();
		SageOneApiConnector.client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

		try {
			if (!setupCompanyList()) {
				throw new Exception("Could net setup SageOne Integration Library, check console for details");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
				String endpointToGetCompanies = endpointPrefix + "Company/Get?" + endpointSuffix +
				encodeCurlyBrackets(API_KEY);

				if (!runningInner) {
					globalSkipIterator = 0;
					objectsBeforeConversion = new ArrayList<Object>();
					globalResponse = true;
				}

				SageOneResponseJsonObject sageOneResponseJsonObject = ConnectionCoreCodeReturnResponseJson(-255,
				endpointToGetCompanies + "&$skip=" + globalSkipIterator, "GET");

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
							SAGE_ONE_ID_HOLDER.put(sageOneCompanyToGetIdFrom.getId(), new HashMap<String, Integer>());
						}
						runningInner = false;
					}

					System.out.println("Companies with their id's successfully grabbed and listed from Sage One Accounting" +
					" account");
				} else {
					System.out.println("Companies with their id's successfully grabbed and listed from Sage One Accounting" +
					" account");
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
																				  String endpoint,
																				  final String requestMethod) {
		boolean response = true;
		String resultToReturn = "";
		HttpRequestBase request = null;

		try {
			endpoint = encodeCurlyBrackets(endpoint);
			if(requestMethod.toUpperCase().equals("GET")) {
				request = new HttpGet(endpoint);
			} else if(requestMethod.toUpperCase().equals("POST")) {
				request = new HttpPost(endpoint);
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

					request.addHeader("Accept", "*/*");
					request.addHeader("Content-Type", "application/json");
					request.addHeader("Authorization", encodedCredidentials);
					HttpResponse responseFromRquest = client.execute(request);

					BufferedReader rd = new BufferedReader(new InputStreamReader(responseFromRquest.getEntity().getContent()));

					StringBuilder constructedResultString = new StringBuilder();
					String line = "";

					while ((line = rd.readLine()) != null) {
						constructedResultString.append(line);
					}

					resultToReturn = constructedResultString.toString();
				} else {
					String string = "MAX REQUEST LIMIT REACHED FOR HOUR/DAY, REQUEST COUNTERS:\n" +
							"DAY -> " + SageOneConstants.SAGE_ONE_REQUEST_COUNTER_DAY + "\n" +
							"HOUR -> " + SageOneConstants.SAGE_ONE_REQUEST_COUNTER_HOUR;

					System.out.println(string);
					resultToReturn = string;
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
		SageOneResponseObject.initializeClass();
		SageOneResponseObject sageOneResponseObject = null;
		String endpoint = "";

		try {
			if(!runningInner) {
				globalSkipIterator = 0;
				objectsBeforeConversion = new ArrayList<Object>();
				
				endpoint = endpointPrefix + encodeCurlyBrackets(endpointPlusQuery) +
					((endpointPlusQuery.contains("?") && endpointPlusQuery.contains("=")) ? 
					"&" + endpointSuffix : "?" + endpointSuffix) + encodeCurlyBrackets(API_KEY) +
					"&companyid=" + companyId;
			}
			SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, (runningInner) ?
			endpoint + "&$skip=" + globalSkipIterator : endpoint, "GET");

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

		SageOneResponseObject.deInitializeClass();
		return sageOneResponseObject;
	}

	public final static SageOneResponseObject sageOneSaveData(final String endpointPlusQuery, final int companyId) {
		SageOneResponseObject.initializeClass();
		SageOneResponseObject sageOneResponseObject = null;
		String endpoint = "";

		try {
			endpoint = endpointPrefix + encodeCurlyBrackets(endpointPlusQuery) +
					((endpointPlusQuery.contains("?") && endpointPlusQuery.contains("=")) ?
					"&" + endpointSuffix : "?" + endpointSuffix) + encodeCurlyBrackets(API_KEY) + "&companyid=" +
					companyId;

			SageOneResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(companyId, endpoint, "POST");

			sageOneResponseObject = (jsonResponse.getSuccess())
					? new SageOneResponseObject(true, jsonResponse.getResponseMessage()) :
					new SageOneResponseObject(false, "Failed to save data on SageOne account, the request failed");

		} catch (Exception e) {
			e.printStackTrace();
			
			sageOneResponseObject = new SageOneResponseObject(false, "An error occurred while " +
			"trying to save data on the SageOne account, look on terminal or log files for details");
		}

		SageOneResponseObject.deInitializeClass();
		return sageOneResponseObject;
	}
}
