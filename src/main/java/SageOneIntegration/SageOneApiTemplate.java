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
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static SageOneIntegration.SageOneApiConnector.objectMapper;
import static SageOneIntegration.SageOneConstants.SAGE_ONE_ID_HOLDER;

public final class SageOneApiTemplate {

    SageOneApiTemplate() {

    }

    public static List<SageOneCustomer> getCustomersByNameAndSurnameOrName(final String companyName,
                                                                           String... customerNames) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneCustomer> sageOneCustomersGrabbed = new ArrayList<SageOneCustomer>();
        String endpointQuery = "Customer/Get?$filter=";

        try {
            final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);
         
            if(companyId == null) {
                response = false;
            }
            
            if(response) {
                for (String customerName : customerNames) {
                    sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                    URLEncoder.encode("Name eq " + "'" + customerName + "'", "UTF-8"), SageOneCustomer.class,
                    true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        if (sageOneResponseObject.getTotalResponseObjects() <= 0) {

                            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                            "startswith(Name,'" + customerName + "')", SageOneCustomer.class, true,
                            companyId);
                        }

                        sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                            (List<SageOneCustomer>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                        break;
                    }
                }
            } else {
                sageOneCustomersGrabbed = null;
                
                System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                "SageOneApiTemplate.class");
            }    
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(sageOneCustomersGrabbed.size());
        return sageOneCustomersGrabbed;

    }

    public static <T> T getSageOneEntity(final String companyName, final SageOneEntityType entityName, final int entityId) {
        String endpointQuery = entityName.GetObject.getStringProperty() + "/" + entityId;
        SageOneResponseObject sageOneResponseObject = null;

        final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

        if(companyId == null) {
            sageOneResponseObject = null;
            
            System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
            "SageOneApiTemplate.class");
        } else {
            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery, entityName.GetObject.getClassProperty(),
                    false, companyId);
        }

        return (sageOneResponseObject != null && sageOneResponseObject.getSuccess() ) ? (T) sageOneResponseObject.getResponseObject() : null;
    }

    public static SageOneSaveEntityResponse saveSageOneEntity(final String companyName, final Object entityToSave) {
        boolean response = false;
        SageOneResponseObject sageOneResponseObject = null;
        SageOneEntityType entityTypeToUse = null;
        Integer companyId = null;

        for(SageOneEntityType sageOneEntityType : SageOneEntityType.values()) {
            if(entityToSave.getClass().getName().equals(sageOneEntityType.GetObject.getClassProperty().getName())) {
                entityTypeToUse = sageOneEntityType;
                response = true;
            }
        }

        if(response) {
            companyId = SageOneConstants.COMPANY_LIST.get(companyName);
            if (companyId == null) {
                sageOneResponseObject = null;
                System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                        "SageOneApiTemplate.class");
            } else {
                if(SAGE_ONE_ID_HOLDER.get(companyId).get(entityTypeToUse.name()) == null) {
                    SageOneResponseObject getHighestIdEntity = null;
                    try {
                        getHighestIdEntity = SageOneApiConnector.sageOneGrabData(entityTypeToUse.GetObject
                                .getStringProperty() + "?$orderby=" + URLEncoder.encode("ID desc", "UTF-8"),
                                entityTypeToUse.GetObject.getClassProperty(), true, companyId);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        response = false;
                    }

                    if(response) {
                        try {
                            if (getHighestIdEntity.getSuccess()) {
                                List<Object> objectList = (List<Object>) getHighestIdEntity.getResponseObject();

                                if (objectList.size() > 0) {
                                    Field field = objectList.get(0).getClass().getDeclaredField("ID");
                                    field.setAccessible(true);
                                    Integer highestIdFromEntityList = (Integer) field.get(objectList.get(0));

                                    if (highestIdFromEntityList != null && highestIdFromEntityList > 0) {
                                        SAGE_ONE_ID_HOLDER.get(companyId).put(entityTypeToUse.name(), highestIdFromEntityList);
                                    } else {
                                        throw new Exception("Could not set Id holder for SageOne entity saving:\n" +
                                                "companyId -> " + companyId + "\n" +
                                                "entityName -> " + entityTypeToUse.name());
                                    }
                                } else {
                                    SAGE_ONE_ID_HOLDER.get(companyId).put(entityTypeToUse.name(), 0);
                                }
                            } else {
                                throw new Exception("Could not set Id holder for SageOne entity saving:\n" +
                                        "companyId -> " + companyId + "\n" +
                                        "entityName -> " + entityTypeToUse.name());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            response = false;
                        }
                    }
                }

                try {
                    Field field = entityToSave.getClass().getDeclaredField("ID");
                    field.setAccessible(true);
                    field.setInt(entityToSave, SAGE_ONE_ID_HOLDER.get(companyId).get(entityTypeToUse.name()) + 1);
                } catch(NoSuchFieldException e) {
                    e.printStackTrace();
                    response = false;
                } catch(IllegalAccessException e) {
                    e.printStackTrace();
                    response = false;
                }

                sageOneResponseObject = SageOneApiConnector.sageOneSaveData(
                SageOneCoreHelperMethods.convertObjectToJsonString(entityToSave), companyId);

                if(sageOneResponseObject.getSuccess()) {
                    SAGE_ONE_ID_HOLDER.get(companyId).put(entityTypeToUse.name(), SAGE_ONE_ID_HOLDER.get(companyId).get(entityTypeToUse.name()) + 1);
                }
            }
        }

        return (response && sageOneResponseObject != null && sageOneResponseObject.getSuccess()) ? new SageOneSaveEntityResponse(sageOneResponseObject.getSuccess(), SAGE_ONE_ID_HOLDER.get(companyId).get(entityTypeToUse.name())) : new SageOneSaveEntityResponse(false, -1);
    }
}
