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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static SageOneIntegration.SageOneConstants.GENERAL_DIGIT_REGEX;
import static SageOneIntegration.SageOneConstants.GENERAL_PRICE_REGEX;
import static SageOneIntegration.SageOneConstants.GENERAL_STRING_REGEX;

public final class SageOneApiTemplate {
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    private static StringBuilder queryString = new StringBuilder();
    private static int globalIterator = 0;
    private static int globalIteratorInner = 0;

    // Conditional Variables
    private static int condSearchAnyVal1 = 0;
    private static boolean condSearchAnyVal2 = false;
    private static boolean condSearchAnyVal3 = false;
    private static boolean condSearchAnyVal4 = false;
    private static boolean condSearchAnyVal5 = false;
    private static boolean condSearchAnyVal6 = false;
    private static boolean condSearchAnyVal7 = false;
    private static boolean condSearchAnyVal8 = false;
    private static boolean condSearchAnyVal9 = false;


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
            if(response) {
                Field field = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName);
                for (SageOneEntityType sageOneEntity : sageOneEntityType.values()) {
                    if (field.getType().isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                        response = false;
                        break;
                    }
                }
            }
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
            response = false;
        }

        if(response) {
            String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";
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
        } else {
            sageOneCustomersGrabbed = new ArrayList<Object>();

            System.out.println("property value isn't the correct value type for the specified property name or it property doesn't exist ->" +
                    " SageOneApiTemplate.class");
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
            if(response) {
                Field field = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName);
                for (SageOneEntityType sageOneEntity : sageOneEntityType.values()) {
                    if (field.getType().isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                        response = false;
                        break;
                    }
                }
            }
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
            response = false;
        }
        if(response) {
            String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";
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
        } else {
            sageOneCustomersGrabbed = new ArrayList<Object>();

            System.out.println("property value isn't the correct value type for the specified property name or it property doesn't exist ->" +
                    " SageOneApiTemplate.class");
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
            int propertiesFound = 0;
            for(Field field : sageOneEntityType.GetObject.getClassProperty().getDeclaredFields()) {
                for (String propertyName : propertyNames) {
                    if (field.getName().equals(propertyName)) {
                        propertiesFound++;
                    }
                }
            }
            if(propertiesFound != propertyNames.length) {
                response = false;
            }
            if (response) {
                try {
                    for(String propertyName : propertyNames) {
                        Field field = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName);
                        for (SageOneEntityType sageOneEntity : sageOneEntityType.values()) {
                            if (field.getType().isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                                response = false;
                                break;
                            }
                        }
                        if(!response) {
                            break;
                        }
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    response = false;
                }
                if(response) {
                    String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";
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
                                queryString.append("'");
                                globalIterator++;
                                queryString.append(((propertyNames.length > globalIterator) ? " or " : ""));
                            }
                            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                            URLEncoder.encode(queryString.toString(), "UTF-8"),
                                    sageOneEntityType.GetObject.getClassProperty(),
                                    true, companyId);

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
            } else {
                sageOneCustomersGrabbed = new ArrayList<T>();
                System.out.println("Property name doesn't exist in sageOneEntityType parameter class object -> " +
                        "SageOneApiTemplate.class");

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
            int propertiesFound = 0;
            for(Field field :  sageOneEntityType.GetObject.getClassProperty().getDeclaredFields()) {
                for (String propertyName : propertyNames) {
                    if (field.getName().equals(propertyName)) {
                        propertiesFound++;
                    }
                }
            }
            if(propertiesFound != propertyNames.length) {
                response = false;
            }

            if (response) {
                try {
                    for(String propertyName : propertyNames) {
                        Field field = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName);
                        for (SageOneEntityType sageOneEntity : sageOneEntityType.values()) {
                            if (field.getType().isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                                response = false;
                                break;
                            }
                        }
                        if(!response) {
                            break;
                        }
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    response = false;
                }
                String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";
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
                            queryString.append("'");
                            globalIterator++;
                            queryString.append(((propertyNames.length > globalIterator) ? " and " : ""));
                        }
                        sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                URLEncoder.encode(queryString.toString(), "UTF-8"), sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                        if (sageOneResponseObject.getSuccess()) {
                            sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                    (List<T>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                        } else {
                            System.out.println(sageOneResponseObject.getResponseMessage());
                        }
                    } else {
                        sageOneCustomersGrabbed = new ArrayList<T>();
                        System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                                "SageOneApiTemplate.class");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                sageOneCustomersGrabbed = new ArrayList<T>();
                System.out.println("Property name doesn't exist in sageOneEntityType parameter class object -> " +
                "SageOneApiTemplate.class");

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
        String endpointQuery = sageOneEntityType.GetObject.getStringProperty() + "Get?$filter=";

        if (response) {
            try {
                final Integer companyId = SageOneConstants.COMPANY_LIST.get(companyName);
                if (companyId == null) {
                    response = false;
                }

                if (response) {
                    queryString = new StringBuilder(values.length * 200);
                    globalIterator = 0;
                    condSearchAnyVal1 = 0;
                    condSearchAnyVal2 = false;
                    for (Field field : sageOneEntityType.GetObject.getClassProperty().getDeclaredFields()) {
                        globalIteratorInner = 0;
                        Class<?> fieldClass = field.getType();
                        condSearchAnyVal3 = false;
                        condSearchAnyVal4 = false;
                        condSearchAnyVal5 = false;
                        condSearchAnyVal6 = false;
                        condSearchAnyVal7 = false;
                        condSearchAnyVal8 = false;
                        condSearchAnyVal9 = false;
                        if(fieldClass.isAssignableFrom(Integer.class) || fieldClass.isAssignableFrom(Long.class)) {
                            condSearchAnyVal3 = true;
                        } else if(fieldClass.isAssignableFrom(float.class) || fieldClass.isAssignableFrom(double.class)) {
                            condSearchAnyVal4 = true;
                        } else if(fieldClass.isAssignableFrom(String.class) || fieldClass.isAssignableFrom(char.class)) {
                            condSearchAnyVal5 = true;
                        } else if(fieldClass.isAssignableFrom(Boolean.class)) {
                            condSearchAnyVal6 = true;
                        } else if(fieldClass.isAssignableFrom(Date.class)) {
                            condSearchAnyVal7 = true;
                        } else {
                            for (SageOneEntityType entity : SageOneEntityType.values()) {
                                if (fieldClass.isAssignableFrom(entity.GetObject.getClassProperty())) {
                                    condSearchAnyVal8 = true;
                                    break;
                                }
                            }
                            if(!condSearchAnyVal8) {
                                condSearchAnyVal9 = true;
                            }
                        }

                        for (String propertyValue : values) {
                            boolean mustContinue = true;
                            if(condSearchAnyVal3) {
                                mustContinue = (propertyValue.matches(GENERAL_DIGIT_REGEX));
                            } else if(condSearchAnyVal4) {
                                mustContinue = (propertyValue.matches(GENERAL_PRICE_REGEX));
                            } else if(condSearchAnyVal5) {
                                mustContinue = (propertyValue.matches(GENERAL_STRING_REGEX));
                            } else if(condSearchAnyVal6) {
                                mustContinue = (propertyValue.toUpperCase().equals("TRUE") || propertyValue.toUpperCase().equals("FALSE"));
                            } else if(condSearchAnyVal7) {
                                mustContinue = false;
                            } else if(condSearchAnyVal8) {
                                mustContinue = false;
                            } else if(condSearchAnyVal9) {
                                mustContinue = false;
                            }

                            condSearchAnyVal1++;
                            if(mustContinue) {
                                condSearchAnyVal2 = true;
                                queryString.append("startswith(");
                                queryString.append(field.getName());
                                queryString.append(",'");
                                queryString.append(propertyValue);
                                queryString.append("')");
                                queryString.append(URLEncoder.encode(" or ", "UTF-8"));
                            }
                            globalIteratorInner++;
                        }

                        if(response && condSearchAnyVal2 && (condSearchAnyVal1 > 5 || (sageOneEntityType.GetObject.getClassProperty().getDeclaredFields().length - globalIterator) < 5)) {
                            condSearchAnyVal1 = 0;
                            condSearchAnyVal2 = false;

                            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery + queryString.substring(0, queryString.length() - 4),
                            sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                            if (sageOneResponseObject.getSuccess() && response) {
                                sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                        (List<T>) sageOneResponseObject.getResponseObject() : sageOneCustomersGrabbed);
                                queryString = new StringBuilder(values.length * 200);
                            } else {
                                sageOneCustomersGrabbed = new ArrayList<T>();
                                response = false;
                                System.out.println(sageOneResponseObject.getResponseMessage());
                            }
                        }
                        globalIterator++;
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
