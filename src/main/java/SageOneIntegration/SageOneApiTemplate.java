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
    private static boolean condSearchAnyVal10 = false;

    private static boolean condFilterVal1 = false;

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
                        (List<SageOneCustomer>) sageOneResponseObject.getResponseObject() : new ArrayList<SageOneCustomer>());
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
                                (List<SageOneSupplier>) sageOneResponseObject.getResponseObject() : new ArrayList<SageOneSupplier>());
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
            } else {
                sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ? new ArrayList<SageOneSupplier>() : sageOneCustomersGrabbed;

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
                condFilterVal1 = false;
                Class<?> var_01 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();
                if(var_01.isAssignableFrom(Integer.class) || var_01.isAssignableFrom(Long.class)) {
                    condFilterVal1 = true;
                    response = (propertyValue.matches(GENERAL_DIGIT_REGEX));
                } else if(var_01.isAssignableFrom(double.class)) {
                    condFilterVal1 = true;
                    response = (propertyValue.matches(GENERAL_PRICE_REGEX));
                } else if(var_01.isAssignableFrom(String.class)) {
                    response = true;
                } else if(var_01.isAssignableFrom(Date.class)) {
                    response = true;
                } else if(var_01.isAssignableFrom(Boolean.class)) {
                    response = (propertyValue.toUpperCase().equals("TRUE") ||
                            propertyValue.toUpperCase().equals("FALSE"));
                } else {
                    for (SageOneEntityType sageOneEntity : SageOneEntityType.values()) {
                        if (var_01.isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                            response = false;
                            break;
                        }
                    }
                    if(!response) {
                        throw new NoSuchFieldException("Value passed as parameter is incompatible with value type of property name " +
                                "'" + propertyName + "' in SageOneApiTemplate class");
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
                            URLEncoder.encode(((condFilterVal1) ? propertyName + " eq " + propertyValue  : propertyName + " eq " + "'" + propertyValue + "'"), "UTF-8"),
                            sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<Object>) sageOneResponseObject.getResponseObject() : new ArrayList<Object>());
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
                } else {
                    sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ? new ArrayList<Object>() : sageOneCustomersGrabbed;

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
        List<Object> list1 = new ArrayList<Object>();

        try {
            if (sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName) == null) {
                response = false;
            }
            if(response) {
                condFilterVal1 = false;
                Class<?> var_01 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();
                if(var_01.isAssignableFrom(Integer.class) || var_01.isAssignableFrom(Long.class)) {
                    condFilterVal1 = true;
                    response = (propertyValue.matches(GENERAL_DIGIT_REGEX));
                } else if(var_01.isAssignableFrom(double.class)) {
                    condFilterVal1 = true;
                    response = (propertyValue.matches(GENERAL_PRICE_REGEX));
                } else if(var_01.isAssignableFrom(String.class)) {
                    response = true;
                } else if(var_01.isAssignableFrom(Date.class)) {
                    response = true;
                } else if(var_01.isAssignableFrom(Boolean.class)) {
                    response = (propertyValue.toUpperCase().equals("TRUE") ||
                            propertyValue.toUpperCase().equals("FALSE"));
                } else {
                    for (SageOneEntityType sageOneEntity : SageOneEntityType.values()) {
                        if (var_01.isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                            response = false;
                            break;
                        }
                    }
                    if(!response) {
                        throw new NoSuchFieldException("Value passed as parameter is incompatible with value type of property name " +
                                "'" + propertyName + "' in SageOneApiTemplate class");
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
                            URLEncoder.encode(((condFilterVal1) ? propertyName + " eq " + propertyValue : propertyName + " eq " + "'" + propertyValue + "'"), "UTF-8"),
                            sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        list1.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<T>) sageOneResponseObject.getResponseObject() : new ArrayList<Object>());
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
                } else {
                    list1 = (list1.size() <= 0) ? new ArrayList<Object>() : list1;

                    System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                            "SageOneApiTemplate.class");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            list1 = new ArrayList<Object>();

            System.out.println("property value isn't the correct value type for the specified property name or it property doesn't exist ->" +
                    " SageOneApiTemplate.class");
        }
        return (list1 != null) ? (List<T>) list1 : (List<T>) list1;
    }

    public static <T> List<T> searchEntitiesByAnyMatchedPropertyValues(final String companyName,
                                                                       final SageOneEntityType sageOneEntityType,
                                                                       final String[] propertyNames,
                                                                       final String[] propertyValues) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<T> list1 = new ArrayList<T>();

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
                    globalIterator = 0;
                    for(String propertyName : propertyNames) {
                        condFilterVal1 = false;
                        Class<?> var00_1 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();
                        if(var00_1.isAssignableFrom(Integer.class) || var00_1.isAssignableFrom(Long.class)) {
                            response = (propertyValues[globalIterator].matches(GENERAL_DIGIT_REGEX));
                        } else if(var00_1.isAssignableFrom(double.class)) {
                            response = (propertyValues[globalIterator].matches(GENERAL_PRICE_REGEX));
                        } else if(var00_1.isAssignableFrom(String.class)) {
                            response = true;
                        } else if(var00_1.isAssignableFrom(Date.class)) {
                            response = true;
                        } else if(var00_1.isAssignableFrom(Boolean.class)) {
                            response = (propertyValues[globalIterator].toUpperCase().equals("TRUE") ||
                                    propertyValues[globalIterator].toUpperCase().equals("FALSE"));
                        } else {
                            for (SageOneEntityType sageOneEntity : SageOneEntityType.values()) {
                                if (var00_1.isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                                    response = false;
                                    break;
                                }
                            }
                            if(!response) {
                                break;
                            }
                        }
                        globalIterator++;
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
                            Class<?> var00_1 = null;
                            for (String propertyName : propertyNames) {
                                condFilterVal1 = false;
                                try {
                                    var00_1 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();
                                    if(var00_1.isAssignableFrom(Integer.class) || var00_1.isAssignableFrom(Long.class) || var00_1.isAssignableFrom(double.class)) {
                                        condFilterVal1 = true;
                                    }
                                } catch(NoSuchFieldException e) {
                                    e.printStackTrace();
                                    break;
                                }
                                queryString.append(propertyName);
                                if(condFilterVal1) {
                                    queryString.append(" eq ");
                                    queryString.append(propertyValues[globalIterator]);
                                } else {
                                    queryString.append(" eq '");
                                    queryString.append(propertyValues[globalIterator]);
                                    queryString.append("'");
                                }
                                globalIterator++;
                                queryString.append(((propertyNames.length > globalIterator) ? " or " : ""));
                            }
                            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                            URLEncoder.encode(queryString.toString(), "UTF-8"),
                                    sageOneEntityType.GetObject.getClassProperty(),
                                    true, companyId);

                            if (sageOneResponseObject.getSuccess()) {
                                list1.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                        (List<T>) sageOneResponseObject.getResponseObject() : new ArrayList<T>());
                            } else {
                                System.out.println(sageOneResponseObject.getResponseMessage());
                            }
                        } else {
                            list1 = (list1.size() <= 0) ? new ArrayList<T>() : list1;

                            System.out.println("SageOneCompany does not exist for the specified Sage One User -> " +
                                    "SageOneApiTemplate.class");
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                list1 = new ArrayList<T>();
                System.out.println("Property name doesn't exist in sageOneEntityType parameter class object -> " +
                        "SageOneApiTemplate.class");

            }
        }
        return (list1 != null) ? list1 : new ArrayList<T>();
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
                    globalIterator = 0;
                    for(String propertyName : propertyNames) {
                        Class<?> var00_1 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();
                        if(var00_1.isAssignableFrom(Integer.class) || var00_1.isAssignableFrom(Long.class)) {
                            response = (propertyValues[globalIterator].matches(GENERAL_DIGIT_REGEX));
                        } else if(var00_1.isAssignableFrom(double.class)) {
                            response = (propertyValues[globalIterator].matches(GENERAL_PRICE_REGEX));
                        } else if(var00_1.isAssignableFrom(String.class)) {
                            response = true;
                        } else if(var00_1.isAssignableFrom(Date.class)) {
                            response = true;
                        } else if(var00_1.isAssignableFrom(Boolean.class)) {
                            response = (propertyValues[globalIterator].toUpperCase().equals("TRUE") ||
                                        propertyValues[globalIterator].toUpperCase().equals("FALSE"));
                        } else {
                            for (SageOneEntityType sageOneEntity : SageOneEntityType.values()) {
                                if (var00_1.isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                                    response = false;
                                    break;
                                }
                            }
                            if(!response) {
                                break;
                            }
                        }
                        globalIterator++;
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
                        Class<?> var00_1 = null;
                        for (String propertyName : propertyNames) {
                            queryString.append(propertyName);
                            condFilterVal1 = false;
                            try {
                                var00_1 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();
                                if(var00_1.isAssignableFrom(Integer.class) || var00_1.isAssignableFrom(Long.class) || var00_1.isAssignableFrom(double.class)) {
                                    condFilterVal1 = true;
                                }
                            } catch(NoSuchFieldException e) {
                                e.printStackTrace();
                                break;
                            }
                            queryString.append(propertyName);
                            if(condFilterVal1) {
                                queryString.append(" eq ");
                                queryString.append(propertyValues[globalIterator]);
                            } else {
                                queryString.append(" eq '");
                                queryString.append(propertyValues[globalIterator]);
                                queryString.append("'");
                            }
                            globalIterator++;
                            queryString.append(((propertyNames.length > globalIterator) ? " and " : ""));
                        }
                        sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery +
                                URLEncoder.encode(queryString.toString(), "UTF-8"), sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                        if (sageOneResponseObject.getSuccess()) {
                            sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                    (List<T>) sageOneResponseObject.getResponseObject() : new ArrayList<T>());
                        } else {
                            System.out.println(sageOneResponseObject.getResponseMessage());
                        }
                    } else {
                        sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ? new ArrayList<T>() : sageOneCustomersGrabbed;
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
                            condSearchAnyVal10 = true;
                            if(condSearchAnyVal3) {
                                condSearchAnyVal10 = (propertyValue.matches(GENERAL_DIGIT_REGEX));
                            } else if(condSearchAnyVal4) {
                                condSearchAnyVal10 = (propertyValue.matches(GENERAL_PRICE_REGEX));
                            } else if(condSearchAnyVal5) {
                                condSearchAnyVal10 = (propertyValue.matches(GENERAL_STRING_REGEX));
                            } else if(condSearchAnyVal6) {
                                condSearchAnyVal10 = (propertyValue.toUpperCase().equals("TRUE") || propertyValue.toUpperCase().equals("FALSE"));
                            } else if(condSearchAnyVal7) {
                                condSearchAnyVal10 = false;
                            } else if(condSearchAnyVal8) {
                                condSearchAnyVal10 = false;
                            } else if(condSearchAnyVal9) {
                                condSearchAnyVal10 = false;
                            }

                            condSearchAnyVal1++;
                            if(condSearchAnyVal10) {
                                condSearchAnyVal2 = true;
                                if((condSearchAnyVal3 || condSearchAnyVal4)) {
                                    queryString.append(field.getName());
                                    queryString.append(URLEncoder.encode(" eq ", "UTF-8"));
                                    queryString.append(propertyValue);
                                } else {
                                    queryString.append("startswith(");
                                    queryString.append(field.getName());
                                    queryString.append(",'");

                                    queryString.append(propertyValue);
                                    queryString.append("')");
                                }
                                queryString.append(URLEncoder.encode(" or ", "UTF-8"));
                                condSearchAnyVal10 = false;
                            }
                            globalIteratorInner++;
                        }

                        if(response && condSearchAnyVal2 && (condSearchAnyVal1 > 10 || (sageOneEntityType.GetObject.getClassProperty().getDeclaredFields().length - globalIterator) < 10)) {
                            condSearchAnyVal1 = 0;
                            condSearchAnyVal2 = false;

                            System.out.println(queryString.substring(0, queryString.length() - 4));

                            sageOneResponseObject = SageOneApiConnector.sageOneGrabData(endpointQuery + queryString.substring(0, queryString.length() - 4),
                            sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                            if (sageOneResponseObject.getSuccess() && response) {
                                sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                        (List<T>) sageOneResponseObject.getResponseObject() : new ArrayList<T>());
                                queryString = new StringBuilder(values.length * 200);
                            } else {
                                sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ? new ArrayList<T>() : sageOneCustomersGrabbed;
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
                        (List<SageOneCustomer>) sageOneResponseObject.getResponseObject() : new ArrayList<SageOneCustomer>());
            } else {
                System.out.println(sageOneResponseObject.getResponseMessage());
            }
        } else {
            sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ? new ArrayList<SageOneCustomer>() : sageOneCustomersGrabbed;

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
