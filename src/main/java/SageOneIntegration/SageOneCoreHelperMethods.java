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

import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomerReturn;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplierReturn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.List;


public final class SageOneCoreHelperMethods {

    SageOneCoreHelperMethods() {

    }

    public static String encodeCurlyBrackets(String endpointToEncode) {
        String stringToReturn = "";
        try {
            int indexOfCurlyBeginning = 0;
            int indexOfCurlyEnding = 0;

            if (endpointToEncode.contains("{") && endpointToEncode.contains("}")) {

                indexOfCurlyBeginning = endpointToEncode.indexOf("{");
                indexOfCurlyEnding = endpointToEncode.indexOf("}") + 1;

                String stringToEncode = endpointToEncode.substring(indexOfCurlyBeginning, indexOfCurlyEnding);
                stringToEncode = URLEncoder.encode(stringToEncode, "UTF-8");

                endpointToEncode = endpointToEncode.replace(endpointToEncode.substring(indexOfCurlyBeginning,
                        indexOfCurlyEnding), stringToEncode);

                if (endpointToEncode.contains("{") && endpointToEncode.contains("}")) {
                    stringToReturn = encodeCurlyBrackets(endpointToEncode);
                } else {
                    stringToReturn = endpointToEncode;
                }
            } else {
                stringToReturn = endpointToEncode;
            }
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return stringToReturn;
    }

    public static SageOneResponseJsonObject alterResponseJsonObjectAfterSageOneApiCall(final SageOneResponseObject
                                                                                               sageOneResponseObjectFromApi,
                                                                                       final String forSpecificField) {
        SageOneResponseJsonObject.initializeClass();
        SageOneResponseJsonObject sageOneResponseJsonObject = new SageOneResponseJsonObject(false,
                "Failed to grab data from Sage One Api", "");

        if(sageOneResponseObjectFromApi.getSuccess()) {
            Object responseObjectToWorkWith = sageOneResponseObjectFromApi.getResponseObject();
            if(responseObjectToWorkWith instanceof SageOneCustomerReturn) {

                if(forSpecificField.equals("invoiceNumber")) {
                    SageOneCustomerReturn purchaseInvoice = (SageOneCustomerReturn) responseObjectToWorkWith;

                    sageOneResponseJsonObject = new SageOneResponseJsonObject(sageOneResponseObjectFromApi.getSuccess(),
                            "Successfully grabbed invoiceNumber", purchaseInvoice.getDocumentNumber());
                } else {
                    Gson g = new Gson();
                    String jsonString = g.toJson(sageOneResponseObjectFromApi);

                    sageOneResponseJsonObject = new SageOneResponseJsonObject(sageOneResponseObjectFromApi.getSuccess(),
                    "Successfully grabbed invoiceNumber", jsonString);
                }

            } else if(responseObjectToWorkWith instanceof SageOneSupplierReturn) {


                if(forSpecificField.equals("invoiceNumber")) {
                    SageOneSupplierReturn saleInvoice = (SageOneSupplierReturn) responseObjectToWorkWith;

                    sageOneResponseJsonObject = new SageOneResponseJsonObject(sageOneResponseObjectFromApi.getSuccess(),
                            "Successfully grabbed invoiceNumber", saleInvoice.getDocumentNumber());
                } else {
                        boolean responseFromTry = false;
                        String jsonString = "";

                        try {
                            Gson g = new Gson();
                            jsonString = g.toJson(sageOneResponseObjectFromApi);
                            responseFromTry = true;
                        } catch(Exception e) {
                            e.printStackTrace();
                            responseFromTry = false;
                        }
                        sageOneResponseJsonObject = new SageOneResponseJsonObject((sageOneResponseObjectFromApi.getSuccess() && responseFromTry),
                                (responseFromTry) ? "Successfully grabbed data from SageOneSA Api" : "Failed to grab " +
                                "data from SageOneSA Api, Api call was successful but the data returned caused " +
                                "an error", jsonString);
                }
            }
            SageOneResponseJsonObject.deInitializeClass();
        } else {
            sageOneResponseJsonObject.setResponseMessage(sageOneResponseObjectFromApi.getResponseMessage());
        }
        return sageOneResponseJsonObject;
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

    static <T> T[] convertToArray(List<?> list, Class<T> c) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(c, list.size());
        result = list.toArray(result);
        return (T[]) result;
    }

    static final String custReplace(final String stringToReplace, final int stringSkipLength, final int stringLength,
                                    final String... parameterStrings) {
        char[] charString = stringToReplace.toCharArray();
        int mainParameterIterator = 0;
        int iterator = stringSkipLength;
        int parameterStringsLength = parameterStrings.length;
        int howMuchToPlus = (stringLength % 2 == 1) ? 3 : 4;

        while(parameterStringsLength > mainParameterIterator) {
            for(;iterator < stringLength; iterator += howMuchToPlus) {
                if(charString[iterator] == '#') {
                    charString[iterator - 3] = Character.MIN_VALUE;
                    charString[iterator - 2] = Character.MIN_VALUE;
                    charString[iterator - 1] = Character.MIN_VALUE;
                    charString[iterator] = Character.MIN_VALUE;

                    System.arraycopy(parameterStrings[mainParameterIterator].toCharArray(), 0, charString,
                    charString[iterator], parameterStrings[mainParameterIterator].length());
                    mainParameterIterator++;
                } else if(charString[iterator + 1] == '#') {
                    charString[iterator - 2] = Character.MIN_VALUE;
                    charString[iterator - 1] = Character.MIN_VALUE;
                    charString[iterator] = Character.MIN_VALUE;
                    charString[iterator + 1] = Character.MIN_VALUE;

                    System.arraycopy(parameterStrings[mainParameterIterator].toCharArray(), 0, charString,
                        charString[iterator], parameterStrings[mainParameterIterator].length());
                    mainParameterIterator++;
                } else if(charString[iterator + 2] == '#') {
                    charString[iterator - 1] = Character.MIN_VALUE;
                    charString[iterator] = Character.MIN_VALUE;
                    charString[iterator + 1] = Character.MIN_VALUE;
                    charString[iterator + 2] = Character.MIN_VALUE;

                    System.arraycopy(parameterStrings[mainParameterIterator].toCharArray(), 0, charString,
                            charString[iterator], parameterStrings[mainParameterIterator].length());
                    mainParameterIterator++;
                } else if(charString[iterator + 3] == '#') {
                    charString[iterator + 1] = Character.MIN_VALUE;
                    charString[iterator + 2] = Character.MIN_VALUE;
                    charString[iterator + 3] = Character.MIN_VALUE;
                    charString[iterator] = Character.MIN_VALUE;

                    System.arraycopy(parameterStrings[mainParameterIterator].toCharArray(), 0, charString,
                    charString[iterator], parameterStrings[mainParameterIterator].length());
                    mainParameterIterator++;
                }
            }
        }
        return new String(charString);
    }
}
