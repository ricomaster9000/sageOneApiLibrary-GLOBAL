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
package SageOneIntegration.SA;


import SageOneIntegration.NationalityType;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCompany;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneGrabbedResultsClass;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier;
import SageOneIntegration.SageOneApiConnector;
import SageOneIntegration.SageOneResponseJsonObject;
import SageOneIntegration.SageOneResponseObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

import static SageOneIntegration.SA.SageOneConstants.API_VERSION;
import static SageOneIntegration.SA.SageOneConstants.COMPANY_LIST;
import static SageOneIntegration.SA.SageOneCoreConnection.*;
import static SageOneIntegration.SageOneConstants.*;
import static SageOneIntegration.SageOneCoreHelperMethods.encodeCurlyBrackets;

public final class SageOneApiTemplateImpl extends SetupClass implements SageOneSA {
    private static final Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-dd").serializeNulls().create();
    private static StringBuilder queryString = new StringBuilder();
    private static String queryStringNorm;
    private static DateTime dateToUse = null;
    private static String dateStringGreaterThan = null;
    private static String dateStringSmallThan = null;

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
    private static boolean condFilterVal2 = false;
    private static boolean condFilterVal3 = false;

    private static final String sageOneTemplateError1 = "Cannot use the following Sage One Entity for Request in " +
    "SageOneApiTemplate.class, entity type is -> ####";
    private static final String sageOneTemplateError2 = "Company with specified company name doesn't exist";

    private static final String sageOneTemplateError3 = "Cannot use the following Sage One Entity for Request in " +
    "SageOneApiTemplate.class, entity type is -> ####";

    private static final String sageOneTemplateError4 = "Failed to delete $s Entity with the ID of %d from SageOneSA";

    private static final String sageOneTemplateSuccess1 = "Successfully Deleted %s Entity with the ID of %d from SageOneSA";

    private static final String sageOneTemplateError5 = "Failed to grab %s Entity with the specified parameters from SageOneSA";

    private static final String sageOneTemplateError6 = "Sage One Entity value type associated with the value type of %s " +
            "cannot be used with current value passed, current value format is invalid, %s";

    private static final String FS = "/";
    private static final String IDString = "ID";
    private static final String GetString = "Get";
    private static final String DeleteString = "Delete";
    private static final String UTF_8_STR = "UTF-8";
    private static final String DelReqSuffix = "?";
    private static final String ODataFilter1 = "?$filter=";
    private static final String ODataFilter2 = DeleteString + "?";
    private static final String ODataFilter3 = " eq ";
    private static final char ODataFilter4 = '\'';
    private static final String ODataFilter5 = "startswith(";
    private static final String ODataFilter6 = " eq ";
    private static final String ODataFilter7 = "datetime'";
    private static final String ODataFilter8 = "'";
    private static final String ODataFilter9 = ",'";
    private static final String ODataFilter10 = "')";
    private static final String ODataFilter11 = " or ";
    private static final String ODataFilter12 = " ge ";
    private static final String ODataFilter13 = " le ";
    private static final String ODataFilter14 = " and ";
    private static final String ODataFilter15 = " eq " + ODataFilter7;
    private static final String ODataFilter16 = "-";
    private static final String ODataFilter17 = GetString + "?$search=";
    private static final String ODataFilter18 = GetString + ODataFilter1;
    private static final String ODataFilter19 = "Name eq '";

    public SageOneApiTemplateImpl() {
    }

    @Override
    public void setupSageOneApi(final Properties properties) {
        super.setupSageOneApiSA(properties);
    }

    @Override
    public void setupSageOneApi(final Map<String, String> properties) {
        super.setupSageOneApiSA(properties);
    }

    @Override
    public void setupSageOneApi(final Environment properties) {
        super.setupSageOneApiSA(properties);
    }

    private static final boolean checkIfPropertyExistInEntity(final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                       final String... propertyNames) {
        boolean response = true;
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
            throw new IllegalArgumentException("Property value isn't the correct value type for the specified property " +
                    "name or it property doesn't exist -> SageOneApiTemplate.class");
        }
        return response;
    }

    private static final Class<?> checkAndSetupPropertyValueUsage(final Class<?> fieldClass, final String propertyValue,
                                                                  final boolean checkOnlyPropertyNotValue) {
        boolean response = true;
        condFilterVal1 = false;
        condFilterVal2 = false;
        if(fieldClass.isAssignableFrom(Integer.class) || fieldClass.isAssignableFrom(Long.class)) {
            response = (!checkOnlyPropertyNotValue) ? propertyValue.matches(GENERAL_DIGIT_REGEX) : checkOnlyPropertyNotValue;
            condFilterVal1 = response;
            condSearchAnyVal3 = response;
        } else if(fieldClass.isAssignableFrom(double.class) || fieldClass.isAssignableFrom(Double.class)) {
            response = (!checkOnlyPropertyNotValue) ? propertyValue.matches(GENERAL_PRICE_REGEX) : checkOnlyPropertyNotValue;
            condFilterVal1 = response;
            condSearchAnyVal4 = response;
        } else if(fieldClass.isAssignableFrom(String.class)) {
            response = (!checkOnlyPropertyNotValue) ? propertyValue.matches(GENERAL_STRING_REGEX) : checkOnlyPropertyNotValue;
            condSearchAnyVal5 = response;
        } else if(fieldClass.isAssignableFrom(Date.class)) {
            condFilterVal2 = false;
            if(!checkOnlyPropertyNotValue) {
                dateToUse = SageOneApiTemplateImpl.checkAndConvertDate(propertyValue, false);
                condFilterVal2 = (dateToUse != null);
            } else {
                condFilterVal2 = checkOnlyPropertyNotValue;
            }
            if(condFilterVal2) {
                response = condFilterVal2;
                condSearchAnyVal7 = response;
                dateStringGreaterThan = ODataFilter7 + dateToUse.getYear() + ODataFilter16 +
                        ((dateToUse.getMonthOfYear() > 9) ? dateToUse.getMonthOfYear() : "0" + dateToUse.getMonthOfYear()) +
                        ODataFilter16 + ((dateToUse.getDayOfMonth() > 9) ? dateToUse.getDayOfMonth() : "0" + dateToUse.getDayOfMonth());

                dateStringSmallThan = ODataFilter7 + dateToUse.getYear() + ODataFilter16 +
                        ((dateToUse.getMonthOfYear() > 9) ? dateToUse.getMonthOfYear() : "0" + dateToUse.getMonthOfYear()) +
                        ODataFilter16 + (((dateToUse.getDayOfMonth() + 1) > 9) ? (dateToUse.getDayOfMonth() + 1) : "0" +
                        (dateToUse.getDayOfMonth() + 1));
            }
        } else if(fieldClass.isAssignableFrom(Boolean.class)) {
            response = (!checkOnlyPropertyNotValue) ? (propertyValue.toUpperCase().equals(BooleanTrueString) || propertyValue.toUpperCase().equals(BooleanFalseString)) : checkOnlyPropertyNotValue;
            condFilterVal1 = response;
            condSearchAnyVal6 = response;
        } else {
            for (SageOneEntityType.V_1_1_2 sageOneEntity : SageOneEntityType.V_1_1_2.values()) {
                if (fieldClass.isAssignableFrom(sageOneEntity.GetObject.getClassProperty())) {
                    response = false;
                    condSearchAnyVal9 = true;
                    break;
                }
            }
        }
        if(!response) {
            if(checkOnlyPropertyNotValue) {
                return fieldClass;
            } else {
                throw new IllegalArgumentException(String.format(sageOneTemplateError6, fieldClass.getName(), propertyValue));
            }
        } else {
            return fieldClass;
        }
    }

    private static final Field getPropertyField(Class<?> objectClass, final String propertyName) {
        Field fieldToReturn = null;
        try {
            fieldToReturn = objectClass.getDeclaredField(propertyName);
            fieldToReturn.setAccessible(true);
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
        }

        return fieldToReturn;
    }

    private static final DateTime checkAndConvertDate(final String dateString, final boolean hideErrors) {
        DateTime dateToReturn = new DateTime();
        try {
            dateToReturn =  new DateTime().parse(dateString);

            if(!hideErrors && (dateString.length() != 10 || dateToReturn.getYear() <= 0 ||
               dateToReturn.getMonthOfYear() <= 0 || dateToReturn.getDayOfMonth() <= 0)) {
                throw new IllegalArgumentException();
            }

        } catch(IllegalArgumentException e) {
            if(!hideErrors) { e.printStackTrace(); }
            dateToReturn = null;
        }
        return dateToReturn;
    }

    private static final String checkAndManageEndPointQueryIfNeeded(String endpointQuery, final SageOneEntityType.V_1_1_2 entityType,
    final boolean mustGrabById, final Object ODataQueryTypeBasis, final boolean mustBeDeleted) {
        if(mustGrabById) {
            endpointQuery += GetString + FS + ODataQueryTypeBasis;
        } else if(!mustGrabById && !mustBeDeleted) {
            if(API_VERSION.equals("1.1.2")) {
                if(entityType.equals(SageOneEntityType.V_1_1_2.ACCOUNT_BALANCE)) {
                    endpointQuery += GetString + "AccountBudgets" + ODataQueryTypeBasis;
                } else {
                    endpointQuery += GetString + ODataQueryTypeBasis;
                }
            } else {
                endpointQuery += GetString + ODataQueryTypeBasis;
            }
        } else if(mustBeDeleted) {
            endpointQuery += DeleteString + FS + ODataQueryTypeBasis + DelReqSuffix;
        }
        return endpointQuery;
    }


    @Override
    public final List<SageOneCustomer> getCustomersByNameAndSurnameOrName(final String companyName,
                                                                           String... customerNames) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneCustomer> sageOneCustomersGrabbed = new ArrayList<SageOneCustomer>();
        String endpointQuery = checkAndManageEndPointQueryIfNeeded(SageOneEntityType.V_1_1_2.CUSTOMER.GetObject.getStringProperty(),
                SageOneEntityType.V_1_1_2.CUSTOMER, false, ODataFilter18, false);

        try {
            final Integer companyId = COMPANY_LIST.get(companyName);

            if(companyId == null) {
                response = false;
            }

            if(response) {
                for (String customerName : customerNames) {
                    sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery +
                    URLEncoder.encode(ODataFilter19 + customerName + ODataFilter4, UTF_8_STR), SageOneCustomer.class, true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        if (sageOneResponseObject.getTotalResponseObjects() <= 0) {
                            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery +
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
                System.out.println(sageOneTemplateError2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sageOneCustomersGrabbed;

    }

    @Override
    public final SageOneSupplier getSupplierByName(final String companyName, final String name) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneSupplier> sageOneCustomersGrabbed = new ArrayList<SageOneSupplier>();
        String endpointQuery = checkAndManageEndPointQueryIfNeeded(SageOneEntityType.V_1_1_2.SUPPLIER.GetObject.getStringProperty(),
                SageOneEntityType.V_1_1_2.SUPPLIER, false, ODataFilter18, false);

        try {
            final Integer companyId = COMPANY_LIST.get(companyName);

            if(companyId == null) {
                response = false;
            }

            if(response) {
                    sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery +
                                    URLEncoder.encode("Name eq " + "'" + name + "'", UTF_8_STR),
                                     SageOneSupplier.class, true, companyId);

                    if (sageOneResponseObject.getSuccess()) {
                        if (sageOneResponseObject.getTotalResponseObjects() <= 0) {

                            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery +
                                            "startswith(Name,'" + name + "')", SageOneSupplier.class,
                                            true, companyId);
                        }

                        sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<SageOneSupplier>) sageOneResponseObject.getResponseObject() :
                                new ArrayList<SageOneSupplier>());
                    } else {
                        System.out.println(sageOneResponseObject.getResponseMessage());
                    }
            } else {
                sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ? new ArrayList<SageOneSupplier>() :
                sageOneCustomersGrabbed;
                System.out.println(sageOneTemplateError2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return (sageOneCustomersGrabbed.size() > 0) ? sageOneCustomersGrabbed.get(0) : null;

    }

    @Override
    public final List<SageOneCustomer> getCustomers(final String companyName) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneCustomer> sageOneCustomersGrabbed = new ArrayList<SageOneCustomer>();
        String endpointQuery = checkAndManageEndPointQueryIfNeeded(SageOneEntityType.V_1_1_2.CUSTOMER.GetObject.getStringProperty(),
                SageOneEntityType.V_1_1_2.CUSTOMER, false, "", false);


        final Integer companyId = COMPANY_LIST.get(companyName);

        if(companyId == null) {
            response = false;
        }

        if(response) {
            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery, SageOneCustomer.class,
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
            System.out.println(sageOneTemplateError2);
        }
        return sageOneCustomersGrabbed;
    }

    @Override
    public final <T> T getEntityByPropertyValue(final String companyName, final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                 final String propertyName, final String propertyValue) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<Object> sageOneCustomersGrabbed = new ArrayList<Object>();

        if(sageOneEntityType.GetObject.getCanBeUsedInRequest()) {
            try {
                response = SageOneApiTemplateImpl.checkIfPropertyExistInEntity(sageOneEntityType, propertyName);
                if(response) {
                    SageOneApiTemplateImpl.checkAndSetupPropertyValueUsage(
                            sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType(),
                            propertyValue, false);
                }
            } catch(NoSuchFieldException e) {
                e.printStackTrace();
                response = false;
            }

            if(response) {
                String endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                sageOneEntityType, false, ODataFilter1, false);

                try {
                    final Integer companyId = COMPANY_LIST.get(companyName);

                    if (companyId == null) {
                        response = false;
                    }

                    if (response) {
                        endpointQuery += (condFilterVal1) ?
                        propertyName + URLEncoder.encode(" eq ", UTF_8_STR) +
                        propertyValue : (condFilterVal2) ?
                                URLEncoder.encode(ODataFilter12, UTF_8_STR) + dateStringGreaterThan + ODataFilter8 +
                                        URLEncoder.encode(ODataFilter14, UTF_8_STR) + propertyName +
                                        URLEncoder.encode(ODataFilter13, UTF_8_STR) + dateStringSmallThan +
                                        ODataFilter8 :
                                        propertyName + URLEncoder.encode(" eq '", UTF_8_STR) + propertyValue + "'";

                        sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery,
                        sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                        if (sageOneResponseObject.getSuccess()) {
                            sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<Object>) sageOneResponseObject.getResponseObject() : new ArrayList<Object>());
                        } else {
                            System.out.println(sageOneResponseObject.getResponseMessage());
                        }
                    } else {
                        sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ?
                        new ArrayList<Object>() : sageOneCustomersGrabbed;

                        System.out.println(sageOneTemplateError2);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                sageOneCustomersGrabbed = new ArrayList<Object>();
            }
        }  else {
            System.out.println(String.format(sageOneTemplateError1, sageOneEntityType.name()));
        }
        return (sageOneCustomersGrabbed.size() == 1) ? (T) sageOneCustomersGrabbed.get(0) : null;
    }

    @Override
    public final <T> List<T> getEntitiesByPropertyValue(final String companyName, final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                 final String propertyName, final String propertyValue) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<Object> list1 = new ArrayList<Object>();

        if(sageOneEntityType.GetObject.getCanBeUsedInRequest()) {
            try {
                response = SageOneApiTemplateImpl.checkIfPropertyExistInEntity(sageOneEntityType, propertyName);
                if(response) {
                    SageOneApiTemplateImpl.checkAndSetupPropertyValueUsage(
                            sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType(),
                            propertyValue, false);
                }
            } catch(NoSuchFieldException e) {
                e.printStackTrace();
                response = false;
            }
            if(response) {
                String endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                sageOneEntityType, false, ODataFilter18, false);

                try {
                    final Integer companyId = COMPANY_LIST.get(companyName);

                    if(companyId == null) {
                        response = false;
                    }

                    if(response) {
                        endpointQuery += (condFilterVal1) ?
                        propertyName + URLEncoder.encode(" eq ", UTF_8_STR) + propertyValue :
                        (condFilterVal2) ?
                                URLEncoder.encode(ODataFilter12, UTF_8_STR) + dateStringGreaterThan + ODataFilter8 +
                                        URLEncoder.encode(ODataFilter14, UTF_8_STR) + propertyName +
                                        URLEncoder.encode(ODataFilter13, UTF_8_STR) + dateStringSmallThan +
                                        ODataFilter8 : propertyName + URLEncoder.encode(" eq '", UTF_8_STR) +
                        propertyValue + "'";

                        sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery,
                        sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                        if(sageOneResponseObject.getSuccess()) {
                            list1.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<T>) sageOneResponseObject.getResponseObject() : new ArrayList<Object>());
                        } else {
                            System.out.println(sageOneResponseObject.getResponseMessage());
                        }
                    } else {
                        list1 = (list1.size() <= 0) ? new ArrayList<Object>() : list1;
                        System.out.println(sageOneTemplateError2);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                list1 = new ArrayList<Object>();

                System.out.println("property value isn't the correct value type for the specified property name or it property doesn't exist ->" +
                    " SageOneApiTemplate.class");
            }
        }  else {
            System.out.println(sageOneTemplateError1.replace("####", sageOneEntityType.name()));
        }
        return (List<T>) list1;
    }

    @Override
    public final <T> List<T> searchEntitiesByAnyMatchedPropertyValues(final String companyName,
                                                                       final SageOneEntityType.V_1_1_2 sageOneEntityType,
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

        if(sageOneEntityType.GetObject.getCanBeUsedInRequest()) {
            System.out.println("This SageOneEntityType cannot be used in a request '" + sageOneEntityType.name() + "' -> " +
                    "SageOneApiTemplate.class");
            response = false;
        }

        if(response) {
            response = SageOneApiTemplateImpl.checkIfPropertyExistInEntity(sageOneEntityType, propertyNames);
            if (response) {
                if(response) {
                    String endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                    sageOneEntityType, false, ODataFilter18, false);

                    try {
                        final Integer companyId = COMPANY_LIST.get(companyName);

                        if (companyId == null) {
                            response = false;
                        }

                        if (response) {
                            globalIterator = 0;
                            queryString = new StringBuilder(propertyNames.length * 200);
                            Class<?> var00_1 = null;
                            for (String propertyName : propertyNames) {
                                try {
                                    var00_1 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();

                                    SageOneApiTemplateImpl.checkAndSetupPropertyValueUsage(
                                            sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType(),
                                            propertyValues[globalIterator], false);

                                } catch(NoSuchFieldException e) {
                                    e.printStackTrace();
                                    break;
                                }
                                queryString.append(propertyName);
                                if(condFilterVal1) {
                                    queryString.append(URLEncoder.encode(" eq ", UTF_8_STR));
                                    queryString.append(propertyValues[globalIterator]);
                                } else if(condFilterVal2) {
                                    queryString.append(URLEncoder.encode(ODataFilter12, UTF_8_STR));
                                    queryString.append(dateStringGreaterThan);
                                    queryString.append(ODataFilter8);
                                    queryString.append(URLEncoder.encode(ODataFilter14, UTF_8_STR));
                                    queryString.append(propertyName);
                                    queryString.append(URLEncoder.encode(ODataFilter13, UTF_8_STR));
                                    queryString.append(dateStringSmallThan);
                                    queryString.append(ODataFilter8);
                                    queryString.append(URLEncoder.encode(" eq datetime'", UTF_8_STR));
                                    queryString.append(propertyValues[globalIterator]);
                                    queryString.append("'");
                                } else {
                                    queryString.append(URLEncoder.encode(" eq '", UTF_8_STR));
                                    queryString.append(propertyValues[globalIterator]);
                                    queryString.append("'");
                                }
                                globalIterator++;
                                queryString.append(((propertyNames.length > globalIterator) ? " or " : ""));
                            }
                            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery +
                                    queryString.toString(), sageOneEntityType.GetObject.getClassProperty(),
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
            }
        }
        return list1;
    }

    @Override
    public final <T> List<T> searchEntitiesByAllMatchedPropertyValues(final String companyName,
                                                                    final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                                    final String[] propertyNames,
                                                                    final String[] propertyValues) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<T> sageOneCustomersGrabbed = new ArrayList<T>();

        try {
            if (propertyNames.length != propertyValues.length) {
                response = false;
                throw new Exception("Length of propertyNames array parameter does not equal to PropertyValues array " +
                "parameter length");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = false;
        }

        if(!sageOneEntityType.GetObject.getCanBeUsedInRequest()) {
            System.out.println(String.format(sageOneTemplateError1, sageOneEntityType.name()));
            response = false;
        }

        if(response) {
            response = SageOneApiTemplateImpl.checkIfPropertyExistInEntity(sageOneEntityType, propertyNames);
            if (response) {
                String endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                        sageOneEntityType, false, ODataFilter18, false);
                try {
                    final Integer companyId = COMPANY_LIST.get(companyName);

                    if (companyId == null) {
                        response = false;
                    }

                    if (response) {
                        globalIterator = 0;
                        queryString = new StringBuilder(propertyNames.length * 200);
                        Class<?> var00_1 = null;
                        for (String propertyName : propertyNames) {
                            queryString.append(propertyName);
                            try {
                                var00_1 = sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType();

                                SageOneApiTemplateImpl.checkAndSetupPropertyValueUsage(
                                        sageOneEntityType.GetObject.getClassProperty().getDeclaredField(propertyName).getType(),
                                        propertyValues[globalIterator], false);

                            } catch(NoSuchFieldException e) {
                                e.printStackTrace();
                                break;
                            }
                            queryString.append(propertyName);
                            if(condFilterVal1) {
                                queryString.append(URLEncoder.encode(" eq ", UTF_8_STR));
                                queryString.append(propertyValues[globalIterator]);
                            } else if(condFilterVal2) {
                                queryString.append(URLEncoder.encode(ODataFilter12, UTF_8_STR));
                                queryString.append(dateStringGreaterThan);
                                queryString.append(ODataFilter8);
                                queryString.append(URLEncoder.encode(ODataFilter14, UTF_8_STR));
                                queryString.append(propertyName);
                                queryString.append(URLEncoder.encode(ODataFilter13, UTF_8_STR));
                                queryString.append(dateStringSmallThan);
                                queryString.append(ODataFilter8);
                            } else {
                                queryString.append(URLEncoder.encode(" eq '", UTF_8_STR));
                                queryString.append(propertyValues[globalIterator]);
                                queryString.append(ODataFilter8);
                            }
                            globalIterator++;
                            queryString.append(((propertyNames.length > globalIterator) ? " and " : ""));
                        }
                        sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery +
                                queryString.toString(), sageOneEntityType.GetObject.getClassProperty(),
                                true, companyId);

                        if (sageOneResponseObject.getSuccess()) {
                            sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                            (List<T>) sageOneResponseObject.getResponseObject() : new ArrayList<T>());
                        } else {
                            System.out.println(sageOneResponseObject.getResponseMessage());
                        }
                    } else {
                        sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ? new ArrayList<T>() : sageOneCustomersGrabbed;
                        System.out.println(sageOneTemplateError2);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return sageOneCustomersGrabbed;
    }

    @Override
    public final <T> List<T> searchEntitiesByAnyValues(final String companyName, final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                        final String... values) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<T> sageOneCustomersGrabbed = new ArrayList<T>();
        String endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
        sageOneEntityType, false, ODataFilter1, false);

        try {
            if (!sageOneEntityType.GetObject.getCanBeUsedInRequest()) {
                response = false;
                throw new IllegalArgumentException(String.format(sageOneTemplateError1, sageOneEntityType.name()));
            }
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            response = false;
        }

        if (response) {
            try {
                final Integer companyId = COMPANY_LIST.get(companyName);
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
                        condSearchAnyVal3 = false;
                        condSearchAnyVal4 = false;
                        condSearchAnyVal5 = false;
                        condSearchAnyVal6 = false;
                        condSearchAnyVal7 = false;
                        condSearchAnyVal8 = false;
                        condSearchAnyVal9 = false;
                        SageOneApiTemplateImpl.checkAndSetupPropertyValueUsage(
                                field.getType(), null, true);

                        for (String propertyValue : values) {
                            condSearchAnyVal10 = true;
                            if(condSearchAnyVal3) {
                                condSearchAnyVal10 = (propertyValue.matches(GENERAL_DIGIT_REGEX));
                            } else if(condSearchAnyVal4) {
                                condSearchAnyVal10 = (propertyValue.matches(GENERAL_PRICE_REGEX));
                            } else if(condSearchAnyVal5) {
                                condSearchAnyVal10 = (propertyValue.matches(GENERAL_STRING_REGEX));
                            } else if(condSearchAnyVal6) {
                                condSearchAnyVal10 = (propertyValue.toUpperCase().equals(BooleanTrueString) ||
                                propertyValue.toUpperCase().equals(BooleanFalseString));
                            } else if(condSearchAnyVal7) {
                                dateToUse = SageOneApiTemplateImpl.checkAndConvertDate(propertyValue, true);
                                condFilterVal3 = (dateToUse != null);
                                response = condFilterVal3;
                                if(condFilterVal3) {
                                    dateStringGreaterThan = ODataFilter7 + dateToUse.getYear() + ODataFilter16 + ((dateToUse.getMonthOfYear() > 9) ? dateToUse.getMonthOfYear() : "0" + dateToUse.getMonthOfYear()) + ODataFilter16 + ((dateToUse.getDayOfMonth() > 9) ? dateToUse.getDayOfMonth() : "0" + dateToUse.getDayOfMonth());
                                    dateStringSmallThan = ODataFilter7 + dateToUse.getYear() + ODataFilter16 + ((dateToUse.getMonthOfYear() > 9) ? dateToUse.getMonthOfYear() : "0" + dateToUse.getMonthOfYear()) + ODataFilter16 + (((dateToUse.getDayOfMonth() + 1) > 9) ? (dateToUse.getDayOfMonth() + 1) : "0" + (dateToUse.getDayOfMonth() + 1));
                                    condSearchAnyVal10 = true;
                                }
                                dateToUse = null;
                            } else if(condSearchAnyVal8) {
                                condSearchAnyVal10 = false;
                            } else if(condSearchAnyVal9) {
                                condSearchAnyVal10 = false;
                            }

                            condSearchAnyVal1++;
                            if(condSearchAnyVal10) {
                                condSearchAnyVal2 = true;
                                if(condSearchAnyVal3 || condSearchAnyVal4 || condSearchAnyVal6) {
                                    queryString.append(field.getName());
                                    queryString.append(URLEncoder.encode(ODataFilter6, UTF_8_STR));
                                    queryString.append(propertyValue);
                                } else if(condSearchAnyVal7) {
                                    queryString.append(field.getName());
                                    queryString.append(URLEncoder.encode(ODataFilter12, UTF_8_STR));
                                    queryString.append(dateStringGreaterThan);
                                    queryString.append(ODataFilter8);
                                    queryString.append(URLEncoder.encode(ODataFilter14, UTF_8_STR));
                                    queryString.append(field.getName());
                                    queryString.append(URLEncoder.encode(ODataFilter13, UTF_8_STR));
                                    queryString.append(dateStringSmallThan);
                                    queryString.append(ODataFilter8);
                                } else {
                                    queryString.append(ODataFilter5);
                                    queryString.append(field.getName());
                                    queryString.append(ODataFilter9);
                                    queryString.append(propertyValue);
                                    queryString.append(ODataFilter10);
                                }
                                queryString.append(URLEncoder.encode(ODataFilter11, UTF_8_STR));
                                condSearchAnyVal10 = false;
                            }
                            globalIteratorInner++;
                        }

                        if(response && condSearchAnyVal2 && (condSearchAnyVal1 > 10 || (sageOneEntityType.GetObject.getClassProperty().getDeclaredFields().length - globalIterator) < 10)) {
                            condSearchAnyVal1 = 0;
                            condSearchAnyVal2 = false;
                            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery +
                            queryString.substring(0, queryString.length() - 4),
                            sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                            if (sageOneResponseObject.getSuccess() && response) {
                                sageOneCustomersGrabbed.addAll((sageOneResponseObject.getResponseObject() != null) ?
                                (List<T>) sageOneResponseObject.getResponseObject() : new ArrayList<T>());
                                queryString = new StringBuilder(values.length * 200);
                            } else {
                                sageOneCustomersGrabbed = (sageOneCustomersGrabbed.size() <= 0) ?
                                new ArrayList<T>() : sageOneCustomersGrabbed;
                                throw new IOException(sageOneResponseObject.getResponseMessage());
                            }
                        }
                        globalIterator++;
                    }
                } else {
                    sageOneCustomersGrabbed = null;
                    throw new IllegalArgumentException(sageOneTemplateError2);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                response = false;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                response = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sageOneCustomersGrabbed;
    }

    @Override
    public final <T> T getSageOneEntity(final String companyName, final SageOneEntityType.V_1_1_2 entity, final int entityId) {
        String endpointQuery = checkAndManageEndPointQueryIfNeeded(entity.GetObject.getStringProperty(),
        entity, true, entityId, false);
        SageOneResponseObject sageOneResponseObject = null;

        final Integer companyId = COMPANY_LIST.get(companyName);
        try {
            if (companyId == null) {
                throw new IllegalArgumentException(sageOneTemplateError2);
            } else {
                if (entity.GetObject.getCanBeUsedInRequest() && entity.GetObject.getCanBeGrabbedById()) {
                    sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery, entity.GetObject.getClassProperty(),
                            false, companyId);
                } else {
                    throw new InvalidClassException(String.format(sageOneTemplateError1, entity.name()));
                }
            }
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        } catch(InvalidClassException e) {
            e.printStackTrace();
        }

        return (sageOneResponseObject != null && sageOneResponseObject.getSuccess() ) ?
                (T) sageOneResponseObject.getResponseObject() : null;
    }

    @Override
    public final <T> T saveSageOneEntity(final String companyName, final Object entityToSave) {
        boolean response = false;
        SageOneResponseObject sageOneResponseObject = null;
        SageOneEntityType.V_1_1_2 entityTypeToUse = null;
        Integer companyId = null;

        for(SageOneEntityType.V_1_1_2 sageOneEntityType : SageOneEntityType.V_1_1_2.values()) {
            if(entityToSave.getClass().getName().equals(sageOneEntityType.GetObject.getClassProperty().getName())) {
                entityTypeToUse = sageOneEntityType;
                response = true;
            }
        }

        if(!entityTypeToUse.GetObject.getCanBeUsedInRequest()) {
            response = false;
        }

        try {
            if (response) {
                companyId = COMPANY_LIST.get(companyName);
                if (companyId == null) {
                    sageOneResponseObject = null;
                    System.out.println(sageOneTemplateError2);
                } else {
                    sageOneResponseObject = SageOneCoreConnection.sageOneSaveData(entityTypeToUse.GetObject.getClassProperty(),
                    entityTypeToUse.GetObject.getStringProperty() + "Save?", gson.toJson(entityToSave), companyId);
                }
            } else {
                throw new IllegalArgumentException(String.format(sageOneTemplateError1, entityToSave.getClass().getName()));
            }
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }

        return (response && sageOneResponseObject != null && sageOneResponseObject.getSuccess()) ?
               (T) sageOneResponseObject.getResponseObject() : null;
    }

    @Override
    public final boolean deleteSageOneEntity(final String CompanyName, final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                    final Integer entityId) {
        boolean response = true;
        try {
            Integer companyId = COMPANY_LIST.get(CompanyName);

            if(companyId == null) {
                response = false;
                throw new IllegalArgumentException(sageOneTemplateError2);
            }

            if(sageOneEntityType.GetObject.getCanBeUsedInRequest() && sageOneEntityType.GetObject.getCanBeDeleted()) {
                queryStringNorm = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                sageOneEntityType, false, entityId, true);

                SageOneResponseObject responseObject = SageOneCoreConnection.deleteSageOneEntity(queryStringNorm, companyId);

                if(responseObject.getSuccess()) {
                    System.out.println(String.format(sageOneTemplateSuccess1, sageOneEntityType.GetObject.getClassProperty().getName(), entityId));
                } else {
                    System.out.println(String.format(sageOneTemplateError4, sageOneEntityType.GetObject.getClassProperty().getName(), entityId));
                    System.out.println(responseObject.getResponseMessage());
                }

            } else {
                throw new InvalidClassException(String.format(sageOneTemplateError1, sageOneEntityType.GetObject.getClassProperty().getName()));
            }
        } catch(InvalidClassException e) {
            e.printStackTrace();
            response = false;
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            response = false;
        }

        return response;
    }

    @Override
    public final boolean deleteSageOneEntitiesByPropertyValue(final String companyName, final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                       final String propertyName, final String propertyValue) {
        boolean response = true;
        condFilterVal3 = false;

        Integer companyId = COMPANY_LIST.get(companyName);

        if(companyId == null) {
            response = false;
        }

        response = sageOneEntityType.GetObject.getCanBeDeleted() && sageOneEntityType.GetObject.getCanBeUsedInRequest();

        try {
            if(response) {
                response = SageOneApiTemplateImpl.checkIfPropertyExistInEntity(sageOneEntityType, propertyName);
                if(response) {
                    Field field = getPropertyField(sageOneEntityType.GetObject.getClassProperty(), propertyName);

                    SageOneApiTemplateImpl.checkAndSetupPropertyValueUsage(
                    field.getType(), propertyValue, false);

                    if(response) {
                        String endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                        sageOneEntityType, false, ODataFilter1, false);

                        endpointQuery += propertyName +
                                ((field.getType().isAssignableFrom(Boolean.class) ||
                                  field.getType().isAssignableFrom(Integer.class) ||
                                  field.getType().isAssignableFrom(double.class) || condFilterVal3) ?
                                        ((condFilterVal3) ?
                                        URLEncoder.encode(ODataFilter12, UTF_8_STR) + dateStringGreaterThan + ODataFilter8 +
                                        URLEncoder.encode(ODataFilter14, UTF_8_STR) + propertyName +
                                        URLEncoder.encode(ODataFilter13, UTF_8_STR) + dateStringSmallThan +
                                        ODataFilter8 : URLEncoder.encode(ODataFilter6, UTF_8_STR)
                                        + propertyValue) : URLEncoder.encode(ODataFilter6,
                                        UTF_8_STR) + ODataFilter8 + propertyValue + ODataFilter8);

                        SageOneResponseObject sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(endpointQuery,
                        sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                        response = sageOneResponseObject.getSuccess();

                        List<Object> sageOneGrabbedObjectsToDelete = (response) ?
                        (ArrayList<Object>) sageOneResponseObject.getResponseObject() : new ArrayList<Object>();

                        if(response && sageOneGrabbedObjectsToDelete.size() > 0) {

                            endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                            sageOneEntityType, false, "", true);


                            for(Object object : sageOneGrabbedObjectsToDelete) {
                                int idOfEntity = (Integer) SageOneApiTemplateImpl.getPropertyField(sageOneEntityType.GetObject.getClassProperty(), IDString).get(object);

                                endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                                sageOneEntityType, false, idOfEntity, true);

                                if(SageOneCoreConnection.deleteSageOneEntity(endpointQuery, companyId).getSuccess()) {
                                    System.out.println(String.format(sageOneTemplateSuccess1,
                                    sageOneEntityType.GetObject.getClassProperty().getName(), idOfEntity));
                                } else {
                                    System.out.println(String.format(sageOneTemplateError4,
                                    sageOneEntityType.GetObject.getClassProperty().getName(), idOfEntity));
                                }
                            }
                        } else {
                            throw new IOException(String.format(sageOneTemplateError5,
                                    sageOneEntityType.GetObject.getClassProperty().getName()));
                        }
                    }
                }
            } else {
                throw new InvalidClassException(String.format(sageOneTemplateError1,
                        sageOneEntityType.GetObject.getClassProperty().getName()));
            }
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
            response = false;
        } catch(IllegalAccessException e) {
            e.printStackTrace();
            response = false;
        } catch(IOException e) {
            e.printStackTrace();
            response = false;
        }

        return response;
    }

    @Override
    public final <T> List<T> getSageOneEntitiesByType(final String companyName,
                                                      final SageOneEntityType.V_1_1_2 sageOneEntityType) {
        boolean response = true;
        List<T> listToReturn = new ArrayList<T>();

        Integer companyId = COMPANY_LIST.get(companyName);

        if(companyId == null) {
            response = false;
        }

        try {
            if (response) {
                String endpointQuery = checkAndManageEndPointQueryIfNeeded(sageOneEntityType.GetObject.getStringProperty(),
                 sageOneEntityType, false, "", false);

                if(sageOneEntityType.GetObject.getCanBeUsedInRequest()) {
                    SageOneResponseObject sageOneResponseObj = SageOneCoreConnection.sageOneGrabData(endpointQuery,
                    sageOneEntityType.GetObject.getClassProperty(), true, companyId);

                    response = sageOneResponseObj.getSuccess();
                    if (response) {
                        listToReturn = (List<T>) sageOneResponseObj.getResponseObject();
                    } else {
                        throw new IOException(sageOneResponseObj.getResponseMessage());
                    }
                } else {
                    throw new InvalidClassException(String.format(sageOneTemplateError1,
                            sageOneEntityType.GetObject.getClassProperty().getName()));
                }
            } else {
                throw new IllegalArgumentException(sageOneTemplateError2);
            }
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            response = false;
        } catch(IOException e) {
            e.printStackTrace();
            response = false;
        }

        return listToReturn;
    }
}
