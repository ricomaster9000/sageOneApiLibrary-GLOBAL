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

import SageOneIntegration.SageOneApiEntities.SageOneCustomerReturn;
import SageOneIntegration.SageOneApiEntities.SageOneSupplierReturn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by ricardo on 2017/05/31.
 */
public final class SageOneCoreHelperMethods {

    SageOneCoreHelperMethods() {

    }

    static String encodeCurlyBrackets(String endpointToEncode) throws UnsupportedEncodingException {
        String stringToReturn = "";
        int indexOfCurlyBeginning = 0;
        int indexOfCurlyEnding = 0;

        if(endpointToEncode.contains("{") && endpointToEncode.contains("}")) {

            indexOfCurlyBeginning = endpointToEncode.indexOf("{");
            indexOfCurlyEnding = endpointToEncode.indexOf("}") + 1;

            String stringToEncode = endpointToEncode.substring(indexOfCurlyBeginning, indexOfCurlyEnding);
            stringToEncode = URLEncoder.encode(stringToEncode, "UTF-8");

            endpointToEncode = endpointToEncode.replace(endpointToEncode.substring(indexOfCurlyBeginning,
            indexOfCurlyEnding), stringToEncode);

            if(endpointToEncode.contains("{") && endpointToEncode.contains("}")) {
                stringToReturn = encodeCurlyBrackets(endpointToEncode);
            } else {
                stringToReturn = endpointToEncode;
            }
        } else {
            stringToReturn = endpointToEncode;
        }
        return stringToReturn;
    }

    public static Object alterResponseJsonObjectAfterSageOneApiCall(final ResponseObject responseObjectFromApi,
                                                                                final String forSpecificField) {
        ResponseJsonObject.initializeClass();
        ResponseJsonObject responseJsonObject = new ResponseJsonObject(false,
                "Failed to grab data from Sage One Api", "");

        if(responseObjectFromApi.getSuccess()) {
            Object responseObjectToWorkWith = responseObjectFromApi.getResponseObject();
            if(responseObjectToWorkWith instanceof SageOneCustomerReturn) {

                if(forSpecificField.equals("invoiceNumber")) {
                    SageOneCustomerReturn purchaseInvoice = (SageOneCustomerReturn) responseObjectToWorkWith;

                    responseJsonObject = new ResponseJsonObject(responseObjectFromApi.getSuccess(),
                            "Successfully grabbed invoiceNumber", purchaseInvoice.getDocumentNumber());
                } else {
                    Gson g = new Gson();
                    String jsonString = g.toJson(responseObjectFromApi);

                    responseJsonObject = new ResponseJsonObject(responseObjectFromApi.getSuccess(),
                    "Successfully grabbed invoiceNumber", jsonString);
                }

            } else if(responseObjectToWorkWith instanceof SageOneSupplierReturn) {


                if(forSpecificField.equals("invoiceNumber")) {
                    SageOneSupplierReturn saleInvoice = (SageOneSupplierReturn) responseObjectToWorkWith;

                    responseJsonObject = new ResponseJsonObject(responseObjectFromApi.getSuccess(),
                            "Successfully grabbed invoiceNumber", saleInvoice.getDocumentNumber());
                } else {
                        boolean responseFromTry = false;
                        String jsonString = "";

                        try {
                            Gson g = new Gson();
                            jsonString = g.toJson(responseObjectFromApi);
                            responseFromTry = true;
                        } catch(Exception e) {
                            e.printStackTrace();
                            responseFromTry = false;
                        }

                        responseJsonObject = new ResponseJsonObject((responseObjectFromApi.getSuccess() && responseFromTry),
                                (responseFromTry) ? "Successfully grabbed data from SageOne Api" : "Failed to grab " +
                                        "data from SageOne Api, Api call was successful but the data returned caused " +
                                        "an error", jsonString);
                }

            }

            ResponseJsonObject.deInitializeClass();
        } else {
            responseJsonObject.setResponseMessage(responseObjectFromApi.getResponseMessage());
        }
        return responseJsonObject;
    }

    static String convertObjectToJsonString(final Object object) {

        String stringToReturn = "";
        try {
            stringToReturn = SageOneApiConnector.objectMapper.writeValueAsString(object);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        return stringToReturn;
    }

    public static <T> T[] convertToArray(List<?> list, Class<T> c) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(c, list.size());
        result = list.toArray(result);
        return (T[]) result;
    }
}
