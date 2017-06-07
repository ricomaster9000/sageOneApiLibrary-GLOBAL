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
import SageOneIntegration.SageOneApiEntities.SageOneSupplier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public final class SageOneApiTemplate {
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    private static StringBuilder queryString = new StringBuilder();
    private static int globalIterator = 0;
    private static int globalIteratorInner = 0;

    private static final String ODataFilter1 = "Get?$filter=";
    private static final String ODataFilter2 = "Name eq '";
    private static final String ODataFilter3 = " eq '";
    private static final char ODataFilter4 = '\'';
    private static final String ODataFilter5 = "startswith(";
    private static final String ODataFilter6 = " eq '";

    SageOneApiTemplate() {

    }

    public static List<SageOneCustomer> getCustomersByNameAndSurnameOrName(final String companyName,
                                                                           String... customerNames) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneCustomer> sageOneCustomersGrabbed = new ArrayList<SageOneCustomer>();
        String endpointQuery = "Customer/" + ODataFilter1;

        try {
            final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);
         
            if(companyId == null) {
                response = false;
            }
            
            if(response) {
                for (String customerName : customerNames) {
                    sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                    URLEncoder.encode(ODataFilter2 + customerName + ODataFilter4, "UTF-8"), SageOneCustomer.class,
                    true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        if (sageOneResponseObject.getTotalResponseObjects() <= 0) {

                            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                    ODataFilter5 + "Name,'" + customerName + "')", SageOneCustomer.class, true,
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
        return sageOneCustomersGrabbed;

    }

    public static SageOneSupplier getSupplierByName(final String companyName, final String name) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneSupplier> sageOneCustomersGrabbed = new ArrayList<SageOneSupplier>();
        String endpointQuery = "Supplier/Get?$filter=";

        try {
            final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

            if(companyId == null) {
                response = false;
            }

            if(response) {
                    sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                    URLEncoder.encode("Name eq " + "'" + name + "'", "UTF-8"), SageOneSupplier.class,
                            true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        if (sageOneResponseObject.getTotalResponseObjects() <= 0) {

                            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                            "startswith(Name,'" + name + "')", SageOneSupplier.class, true,
                                    companyId);
                        }

                        sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<SageOneSupplier>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
            } else {
                sageOneCustomersGrabbed = null;

                System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                        "SageOneApiTemplate.class");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return (sageOneCustomersGrabbed.size() > 0) ? sageOneCustomersGrabbed.get(0) : null;

    }

    public static <T> T getEntityByPropertyValue(final String companyName, final SageOneEntityType sageOneEntityType,
                                                 final String propertyName, final String propertyValue) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<Object> sageOneCustomersGrabbed = new ArrayList<Object>();

        try {
            if (sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName) == null) {
                response = false;
            }
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
            response = false;
        }
        String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";

        if(response) {
            try {
                final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

                if (companyId == null) {
                    response = false;
                }

                if (response) {
                    sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                            URLEncoder.encode(propertyName + " eq " + "'" + propertyValue + "'", "UTF-8"),
                            sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<Object>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
                } else {
                    sageOneCustomersGrabbed = null;

                    System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                            "SageOneApiTemplate.class");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return (sageOneCustomersGrabbed != null && sageOneCustomersGrabbed.size() == 1) ? (T) sageOneCustomersGrabbed.get(0) : null;
    }

    public static <T> List<T> getEntitiesByPropertyValue(final String companyName, final SageOneEntityType sageOneEntityType,
                                                 final String propertyName, final String propertyValue) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<Object> sageOneCustomersGrabbed = new ArrayList<Object>();

        try {
            if (sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName) == null) {
                response = false;
            }
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
            response = false;
        }
        String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";

        if(response) {
            try {
                final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

                if (companyId == null) {
                    response = false;
                }

                if (response) {
                    System.out.println(endpointQuery +
                            URLEncoder.encode(propertyName + " eq " + "'" + propertyValue + "'", "UTF-8"));


                    sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                    URLEncoder.encode(propertyName + " eq " + "'" + propertyValue + "'", "UTF-8"),
                            sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<T>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
                } else {
                    sageOneCustomersGrabbed = null;

                    System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                            "SageOneApiTemplate.class");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return (sageOneCustomersGrabbed != null) ? (List<T>) sageOneCustomersGrabbed : (List<T>) sageOneCustomersGrabbed;
    }

    public static <T> List<T> searchEntitiesByAnyMatchedPropertyValues(final String companyName,
                                                                       final SageOneEntityType sageOneEntityType,
                                                                       final String[] propertyNames,
                                                                       final String[] propertyValues) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<T> sageOneCustomersGrabbed = new ArrayList<T>();

        try {
            if (propertyNames.length != propertyValues.length) {
                response = false;
                throw new Exception("Length of propertyNames array parameter does not equal to PropertyValues array parameter length");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = false;
        }

        if(response) {
            try {
                if (sageOneEntityType.GetObject.getClassProperty().getClass().getField("") == null) {
                    response = false;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                response = false;
            }
            String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";

            if (response) {
                try {
                    final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

                    if (companyId == null) {
                        response = false;
                    }

                    if (response) {
                        globalIterator = 0;
                        queryString = new StringBuilder(propertyNames.length * 200);
                        for (String propertyName : propertyNames) {
                            queryString.append(propertyName);
                            queryString.append(" eq '");
                            queryString.append(propertyValues[globalIterator]);
                            queryString.append(((propertyNames.length != globalIterator) ? "' or " : ""));
                            globalIterator++;
                        }
                        sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                URLEncoder.encode(queryString.toString(), "UTF-8"), SageOneSupplier.class, true, companyId);

                        if (sageOneResponseObject.getSuccess()) {
                            sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                    (List<T>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                        } else {
                            System.out.println(sageOneResponseObject.getResponseMessage());
                        }
                    } else {
                        sageOneCustomersGrabbed = null;

                        System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                                "SageOneApiTemplate.class");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return (sageOneCustomersGrabbed != null) ? sageOneCustomersGrabbed : new ArrayList<T>();
    }

    public static <T> List<T> searchEntitiesByAllMatchedPropertyValues(final String companyName,
                                                                    final SageOneEntityType sageOneEntityType,
                                                                    final String[] propertyNames,
                                                                    final String[] propertyValues) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<T> sageOneCustomersGrabbed = new ArrayList<T>();

        try {
            if (propertyNames.length != propertyValues.length) {
                response = false;
                throw new Exception("Length of propertyNames array parameter does not equal to PropertyValues array parameter length");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = false;
        }

        if(response) {
            try {
                if (sageOneEntityType.GetObject.getClassProperty().getClass().getField("") == null) {
                    response = false;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                response = false;
            }
            String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";

            if (response) {
                try {
                    final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

                    if (companyId == null) {
                        response = false;
                    }

                    if (response) {
                        globalIterator = 0;
                        queryString = new StringBuilder(propertyNames.length * 200);
                        for (String propertyName : propertyNames) {
                            queryString.append(propertyName);
                            queryString.append(" eq '");
                            queryString.append(propertyValues[globalIterator]);
                            queryString.append(((propertyNames.length != globalIterator) ? "' and " : ""));
                            globalIterator++;
                        }
                        sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                URLEncoder.encode(queryString.toString(), "UTF-8"), SageOneSupplier.class, true, companyId);

                        if (sageOneResponseObject.getSuccess()) {
                            sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                    (List<T>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                        } else {
                            System.out.println(sageOneResponseObject.getResponseMessage());
                        }
                    } else {
                        sageOneCustomersGrabbed = null;

                        System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                                "SageOneApiTemplate.class");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return (sageOneCustomersGrabbed != null) ? sageOneCustomersGrabbed : new ArrayList<T>();
    }

    public static <T> List<T> searchEntitiesByAnyValues(final String companyName,
                                                                       final SageOneEntityType sageOneEntityType,
                                                                       final String... values) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<T> sageOneCustomersGrabbed = new ArrayList<T>();

        try {
            if (sageOneEntityType.GetObject.getClassProperty().getClass().getField("") == null) {
                response = false;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            response = false;
        }
        String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";

        if (response) {
            try {
                final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

                if (companyId == null) {
                    response = false;
                }

                if (response) {;
                    queryString = new StringBuilder(values.length * 200);
                    for (Field field : sageOneEntityType.GetObject.getClassProperty().getDeclaredFields()) {
                        globalIterator = 0;
                        for (String propertyValue : values) {
                            queryString.append("startswith(");
                            queryString.append(field.getName());
                            queryString.append(",'");
                            queryString.append(propertyValue);
                            queryString.append("')");
                            queryString.append(((values.length < globalIterator) ? " or " : ""));
                            globalIterator++;
                        }
                    }
                    System.out.println(queryString);
                    sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                            URLEncoder.encode(queryString.toString(), "UTF-8"), SageOneSupplier.class, true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<T>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
                } else {
                    sageOneCustomersGrabbed = null;

                    System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                            "SageOneApiTemplate.class");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return (sageOneCustomersGrabbed != null) ? sageOneCustomersGrabbed : new ArrayList<T>();
    }

    public static List<SageOneCustomer> getCustomers(final String companyName) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneCustomer> sageOneCustomersGrabbed = new ArrayList<SageOneCustomer>();
        String endpointQuery = "Customer/Get";

        final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);

        if(companyId == null) {
            response = false;
        }

        if(response) {
            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery, SageOneCustomer.class,
                    true, companyId);
            SageOneResponseObject.deInitializeClass();

            if (sageOneResponseObject.getSuccess()) {
                sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                        (List<SageOneCustomer>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
            } else {
                System.out.println(sageOneResponseObject.getResponseMessage());
            }
        } else {
            sageOneCustomersGrabbed = null;

            System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                        "SageOneApiTemplate.class");
        }
        return sageOneCustomersGrabbed;
    }

    public static <T> T getSageOneEntity(final String companyName, final SageOneEntityType entityName, final int entityId) {
        String endpointQuery = entityName.GetObject.getStringProperty() + "Get/" + entityId;
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

        return (sageOneResponseObject != null && sageOneResponseObject.getSuccess() ) ?
                (T) sageOneResponseObject.getResponseObject() : null;
    }

    public static <T> T saveSageOneEntity(final String companyName, final Object entityToSave) {
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
                sageOneResponseObject = SageOneApiConnector.sageOneSaveData(entityTypeToUse.GetObject.getClassProperty(),
                        entityTypeToUse.GetObject.getStringProperty() + "Save?", gson.toJson(entityToSave), companyId);
            }
        } else {
            System.out.println("the object set to be saved and passed as a parameter is not a SageOne Entity " +
                    "(or is not listed in the SageOneEntityType enum class) -> SageOneApiTemplate.class");
        }

        return (response && sageOneResponseObject != null && sageOneResponseObject.getSuccess()) ?
                (T) sageOneResponseObject.getResponseObject() : null;
    }
}
