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


import SageOneIntegration.SageOneApiEntities.Company;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static SageOneIntegration.SageOneConstants.*;
import static SageOneIntegration.SageOneCoreHelperMethods.encodeCurlyBrackets;


final class SageOneApiConnector {
	private static final long serialVersionUID = 1L;
	static final ObjectMapper objectMapper = new ObjectMapper();
	private static final String endpointPrefix = API_URL + "/api/" + API_VERSION + "/";
	private static final String endpointSuffix = "$top=" + SageOneRequestLimit + "&apikey=";
	private static final String notEncodedCredentials = CLIENT_USERNAME + ":" + CLIENT_PASSWORD;
	private static HttpClient client = HttpClientBuilder.create().build();
	private static List<Object> objectsBeforeConversion;
	private static int globalSkipIterator = 0;
	private static boolean runningInner = false;
	private static boolean globalResponse = true;

	SageOneApiConnector() {
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(requestTimeout).build();
		client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

		setupCompanyList();
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

				ResponseJsonObject responseJsonObject = ConnectionCoreCodeReturnResponseJson(
				endpointToGetCompanies + "&$skip=" + globalSkipIterator,
				"GET");

				if (responseJsonObject.getSuccess()) {

					SageOneGrabbedResultsClass resultObject = objectMapper.readValue(responseJsonObject.getResponseJson(),
					SageOneGrabbedResultsClass.class);

					objectsBeforeConversion.addAll(Arrays.asList(resultObject.getResults()));

					if (resultObject.getResults().length >= SageOneRequestLimit) {
						runningInner = true;
						globalSkipIterator += SageOneRequestLimit;
						globalResponse = setupCompanyList();
					} else {
						for (Object object : objectsBeforeConversion) {
							Company companyToGetIdFrom = objectMapper.convertValue(object, Company.class);
							COMPANY_LIST.put(companyToGetIdFrom.getName(), companyToGetIdFrom.getId());
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

	private static ResponseJsonObject ConnectionCoreCodeReturnResponseJson(String endpoint, final String requestMethod) {
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
			}
		} catch(IOException e) {
			resultToReturn = "A Java Exception Occurred in the Sage One Integration SageOneApiConnector.class " +
					"ConnectionCoreCode method code, please check to see what may have caused it, not that it gets" +
					"used in all the other component methods, so you need to pinpoint which one it is";
			e.printStackTrace();
		}

		ResponseJsonObject.initializeClass();

		ResponseJsonObject jsonObjectToReturn = (response)
		? new ResponseJsonObject(true, null, resultToReturn) :
		new ResponseJsonObject(false, "ERROR", resultToReturn);

		ResponseJsonObject.deInitializeClass();

		return jsonObjectToReturn;
	}

	static ResponseObject sageOneGrabData(final String endpointPlusQuery, final Class<?> ObjectClassToMapTo,
												 final boolean mustReturnResultObject, final int companyId) {
		ResponseObject.initializeClass();
		ResponseObject responseObject = null;
		String endpoint = "";

		try {
			if(!runningInner) {
				globalSkipIterator = 0;
				objectsBeforeConversion = new ArrayList<Object>();
				endpoint = endpointPrefix + encodeCurlyBrackets(endpointPlusQuery) +
						((endpointPlusQuery.contains("?") && endpointPlusQuery.contains("="))
						? "&" + endpointSuffix : "?" + endpointSuffix) + encodeCurlyBrackets(API_KEY) +
						"&companyid=" + companyId;
			}
			ResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson((runningInner) ?
			endpoint + "&$skip=" + globalSkipIterator : endpoint, "GET");

			if(mustReturnResultObject && jsonResponse.getSuccess()) {

				SageOneGrabbedResultsClass responseResultObject =
				objectMapper.readValue(jsonResponse.getResponseJson(), SageOneGrabbedResultsClass.class);

				for(Object object : responseResultObject.getResults()) {
					objectsBeforeConversion.add(objectMapper.convertValue(object, ObjectClassToMapTo));
				}

				if(responseResultObject.getResults().length >= SageOneRequestLimit) {
					runningInner = true;
					globalSkipIterator += SageOneRequestLimit;

					sageOneGrabData(endpoint, ObjectClassToMapTo, mustReturnResultObject, companyId);
				} else {
					runningInner = false;
				}
					responseObject = (jsonResponse.getSuccess()) ? new ResponseObject(true,
							objectsBeforeConversion, objectsBeforeConversion.size()) :
							new ResponseObject(false,
							"Failed to grab data from SageOne account, the request failed");
			} else {
				responseObject = (jsonResponse.getSuccess())
						? new ResponseObject(true, objectMapper.readValue(jsonResponse.getResponseJson(),
						ObjectClassToMapTo)) : new ResponseObject(false,
						"Failed to grab data from SageOne account, the request failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObject = new ResponseObject(false, "An error occurred while " +
			"trying to grab data from the SageOne account, look on terminal or log files for details");
		}

		ResponseObject.deInitializeClass();
		return responseObject;
	}

	static ResponseObject sageOneSaveData(final String endpointPlusQuery, final int companyId) {
		ResponseObject.initializeClass();
		ResponseObject responseObject = null;
		String endpoint = "";

		try {
			endpoint = endpointPrefix + encodeCurlyBrackets(endpointPlusQuery) +
				((endpointPlusQuery.contains("?") && endpointPlusQuery.contains("="))
				? "&" + endpointSuffix : "?" + endpointSuffix) + encodeCurlyBrackets(API_KEY) +
				"&companyid=" + companyId;

			ResponseJsonObject jsonResponse = ConnectionCoreCodeReturnResponseJson(endpoint, "POST");

			responseObject = (jsonResponse.getSuccess())
				? new ResponseObject(true, jsonResponse.getResponseMessage()) :
				new ResponseObject(false,
				"Failed to save data on SageOne account, the request failed");

		} catch (Exception e) {
			e.printStackTrace();
			responseObject = new ResponseObject(false, "An error occurred while " +
				"trying to save data on the SageOne account, look on terminal or log files for details");
		}

		ResponseObject.deInitializeClass();
		return responseObject;
	}
}
