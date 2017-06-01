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


import SageOneIntegration.SageOneApiEntities.SageOneCustomer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricomaster9000 on 2017/05/31.
 */
public final class SageOneApiTemplate {

    SageOneApiTemplate() {

    }

    public static List<SageOneCustomer> getCustomersByNameAndSurnameOrName(final int companyId,
                                                                           String... customerNames) {
        boolean response = false;
        ResponseObject responseObject;
        List<SageOneCustomer> sageOneCustomersGrabbed = new ArrayList<SageOneCustomer>();
        String endpointQuery = "Customer/Get?$filter=";

        try {
            for (String customerName : customerNames) {
                responseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                URLEncoder.encode("Name eq " + "'" + customerName + "'", "UTF-8"), SageOneCustomer.class,
                true, companyId);

                if (responseObject.getSuccess()) {

                    if (responseObject.getTotalResponseObjects() <= 0) {

                        responseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                        "startswith(Name,'" + customerName + "')", SageOneCustomer.class, true,
                        companyId);
                    }

                    sageOneCustomersGrabbed.addAll((responseObject.getResponseObject() != null) ?
                            (List<SageOneCustomer>) responseObject.getResponseObject() : sageOneCustomersGrabbed);
                } else {
                    System.out.println(responseObject.getResponseMessage());
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(sageOneCustomersGrabbed.size());
        return sageOneCustomersGrabbed;

    }

    public static <T> T getSageOneEntity(final String companyName, final SageOneEntityType entityName, final int entityId) {
        String endpointQuery = entityName.GetObject.getStringProperty() + "/" + entityId;
        ResponseObject responseObject = null;

        final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

        if(companyId == null) {
            responseObject = null;
            System.out.println("Company does not exist for the specified Sage One accounting User -> " +
                    "SageOneApiTemplate.class");
        } else {
            responseObject = SageOneApiConnector.sageOneGrabData(endpointQuery, entityName.GetObject.getClassProperty(),
                    false, companyId);
        }

        return (responseObject != null && responseObject.getSuccess() ) ? (T) responseObject.getResponseObject() : null;
    }

    public static boolean saveSageOneEntity(final String companyName, final Object entityToSave) {
        boolean response = false;
        ResponseObject responseObject = null;
        Class classToUse;

        for(SageOneEntityType sageOneEntityType : SageOneEntityType.values()) {
            if(entityToSave.getClass().getName().equals(sageOneEntityType.GetObject.getClassProperty().getName())) {
                classToUse = sageOneEntityType.GetObject.getClassProperty();
                response = true;
            }
        }

        if(response) {

            final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);
            if (companyId == null) {
                responseObject = null;
                System.out.println("Company does not exist for the specified Sage One accounting User -> " +
                        "SageOneApiTemplate.class");
            } else {
                responseObject = SageOneApiConnector.sageOneSaveData(
                SageOneCoreHelperMethods.convertObjectToJsonString(entityToSave), companyId);
            }

        }

        return (response && responseObject != null && responseObject.getSuccess());
    }
}
