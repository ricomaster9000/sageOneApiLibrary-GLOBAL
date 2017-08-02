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


import SageOneIntegration.SA.ReusableClasses.SageOneHttpResponseMessage;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAttachment;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier;
import SageOneIntegration.SageOneResponseObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

import static SageOneIntegration.SA.SageOneConstants.API_VERSION;
import static SageOneIntegration.SA.SageOneConstants.COMPANY_LIST;
import static SageOneIntegration.SageOneConstants.*;

public abstract class SageOneApiTemplateMainImpl extends SetupClass implements SageOneSA {
    protected static final Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-dd").serializeNulls().create();
    protected static Map<String, Integer> CompanyList = COMPANY_LIST;
    protected static StringBuilder queryString = new StringBuilder();
    protected static String queryStringNorm;
    protected static DateTime dateToUse = null;
    protected static String dateStringGreaterThan = null;
    protected static String dateStringSmallThan = null;

    protected static int globalIterator = 0;
    protected static int globalIteratorInner = 0;

    protected static final String sageOneTemplateError1 = "Cannot use the following Sage One Entity for Request in " +
    "SageOneApiTemplate.class, entity type is -> ####";
    protected static final String sageOneTemplateError2 = "Company with specified company name doesn't exist";

    protected static final String sageOneTemplateError3 = "Cannot use the following Sage One Entity for Request in " +
    "SageOneApiTemplate.class, entity type is -> ####";

    protected static final String sageOneTemplateError4 = "Failed to delete $s Entity with the ID of %d from SageOneSA";

    protected static final String sageOneTemplateSuccess1 = "Successfully Deleted %s Entity with the ID of %d from SageOneSA";

    protected static final String sageOneTemplateError5 = "Failed to grab %s Entity with the specified parameters from SageOneSA";

    protected static final String sageOneTemplateError6 = "Sage One Entity value type associated with the value type of %s " +
            "cannot be used with current value passed, current value format is invalid, %s";

    protected static final String FS = "/";
    protected static final String IDString = "ID";
    protected static final String GetString = "Get";
    protected static final String DeleteString = "Delete";
    protected static final String SaveString = "Save?";
    protected static final String DownloadString = "Download";
    protected static final String UTF_8_STR = "UTF-8";
    protected static final String QuestionSuffix = "?";
    protected static final String ODataFilter1 = "?$filter=";
    protected static final String ODataFilter2 = DeleteString + "?";
    protected static final String ODataFilter3 = " eq ";
    protected static final char ODataFilter4 = '\'';
    protected static final String ODataFilter5 = "startswith(";
    protected static final String ODataFilter6 = " eq ";
    protected static final String ODataFilter7 = "datetime'";
    protected static final String ODataFilter8 = "'";
    protected static final String ODataFilter9 = ",'";
    protected static final String ODataFilter10 = "')";
    protected static final String ODataFilter11 = " or ";
    protected static final String ODataFilter12 = " ge ";
    protected static final String ODataFilter13 = " le ";
    protected static final String ODataFilter14 = " and ";
    protected static final String ODataFilter15 = " eq " + ODataFilter7;
    protected static final String ODataFilter16 = "-";
    protected static final String ODataFilter17 = GetString + "?$search=";
    protected static final String ODataFilter18 = GetString + ODataFilter1;
    protected static final String ODataFilter19 = "Name eq '";

    public SageOneApiTemplateMainImpl() {
    }

    protected static SageOneResponseObject sageOneGrabData(final int companyId,
                                                           final String endpointPlusQuery,
                                                           final Class<?> ObjectClassToMapTo,
                                                           final boolean mustReturnResultObject) {
        return SageOneCoreConnection.sageOneGrabData(companyId, endpointPlusQuery, ObjectClassToMapTo,
        mustReturnResultObject);
    }

    protected static SageOneResponseObject sageOneSaveData(final int companyId,
                                                           final Class<?> classToMapTo,
                                                           final String endpointPlusQuery,
                                                           final String jsonObject) {
        return SageOneCoreConnection.sageOneSaveData(companyId, classToMapTo, endpointPlusQuery,
                jsonObject);
    }

    protected static SageOneResponseObject sageOneUploadData(final int companyId,
                                                         final String endpointPlusQuery,
                                                         final Class<?> classToMapTo,
                                                         final String fileName,
                                                         final String objectType,
                                                         final Object objectTypeRelatedId,
                                                         final byte[] fileData) {
        return SageOneCoreConnection.sageOneUploadData(companyId, endpointPlusQuery, classToMapTo, fileName,
                objectType, objectTypeRelatedId, fileData);
    }

    protected static SageOneResponseObject deleteSageOneEntity(final int companyId,
                                                               final String endpointPlusQuery) {
        return SageOneCoreConnection.deleteSageOneEntity(companyId, endpointPlusQuery);
    }

    protected static SageOneResponseObject sageOneDownloadData(final int companyId,
                                                           final String endpointPlusQuery) {
        return SageOneCoreConnection.sageOneDownloadData(companyId, endpointPlusQuery);
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

    protected static final boolean checkIfPropertyExistInEntity(final SageOneEntityType.V_1_1_2 sageOneEntityType,
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

    protected static final Field getPropertyField(final Class<?> objectClass, final String propertyName) {
        Field fieldToReturn = null;
        try {
            fieldToReturn = objectClass.getDeclaredField(propertyName);
            fieldToReturn.setAccessible(true);
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
        }

        return fieldToReturn;
    }

    protected static final DateTime checkAndConvertDate(final String dateString, final boolean hideErrors) {
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

    protected static final String checkAndManageEndPointQueryIfNeeded(String endpointQuery, final SageOneEntityType.V_1_1_2 entityType,
                                                                      final boolean mustGrabById, final Object ODataQueryTypeBasis,
                                                                      final boolean mustBeDeleted, final boolean mustBeSaved,
                                                                      final boolean mustBeDownloaded, final boolean mustBeGrabbedWithoutId) {
        if(mustGrabById) {
            endpointQuery += GetString + FS + ODataQueryTypeBasis;
        } else if(mustBeGrabbedWithoutId) {
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
            endpointQuery += DeleteString + FS + ODataQueryTypeBasis + QuestionSuffix;
        } else if(mustBeSaved) {
            if(API_VERSION.equals("1.1.2")) {
                if(entityType.equals(SageOneEntityType.V_1_1_2.ACCOUNTANT_TASK)){
                    endpointQuery += "UpdateTaskStatus?";
                } else {
                    endpointQuery += FS + SaveString;
                }
            } else {
                endpointQuery += GetString + ODataQueryTypeBasis;
            }
        } else if(mustBeDownloaded) {
            endpointQuery += DownloadString + FS + ODataQueryTypeBasis + QuestionSuffix;
        }
        return endpointQuery;
    }

    @Override
    public final List<SageOneCustomer> getCustomersByNameAndSurnameOrName(final String companyName,
                                                                          final String... customerNames) {
        boolean response = true;
        SageOneResponseObject sageOneResponseObject;
        List<SageOneCustomer> sageOneCustomersGrabbed = new ArrayList<SageOneCustomer>();
        String endpointQuery = checkAndManageEndPointQueryIfNeeded(SageOneEntityType.V_1_1_2.CUSTOMER.GetObject.getStringProperty(),
                SageOneEntityType.V_1_1_2.CUSTOMER, false, ODataFilter18, false,
                false, false, true);

        try {
            final Integer companyId = COMPANY_LIST.get(companyName);

            if(companyId == null) {
                response = false;
            }

            if(response) {
                for (String customerName : customerNames) {
                    sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(companyId, endpointQuery +
                    URLEncoder.encode(ODataFilter19 + customerName + ODataFilter4, UTF_8_STR),
                    SageOneCustomer.class, true);

                    if (sageOneResponseObject.getSuccess()) {
                        if (sageOneResponseObject.getTotalResponseObjects() <= 0) {
                            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(companyId, endpointQuery +
                            ODataFilter5 + "Name,'" + customerName + "')", SageOneCustomer.class, true);
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
                SageOneEntityType.V_1_1_2.SUPPLIER, false, ODataFilter18, false,
                false, false, true);

        try {
            final Integer companyId = COMPANY_LIST.get(companyName);

            if(companyId == null) {
                response = false;
            }

            if(response) {
                    sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(companyId,
                    endpointQuery + URLEncoder.encode("Name eq " + "'" + name + "'", UTF_8_STR),
                                     SageOneSupplier.class, true);

                    if (sageOneResponseObject.getSuccess()) {
                        if (sageOneResponseObject.getTotalResponseObjects() <= 0) {

                            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(companyId,
                            endpointQuery + "startswith(Name,'" + name + "')", SageOneSupplier.class,
                                            true);
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
                SageOneEntityType.V_1_1_2.CUSTOMER, false, "", false,
                false, false, true);


        final Integer companyId = COMPANY_LIST.get(companyName);

        if(companyId == null) {
            response = false;
        }

        if(response) {
            sageOneResponseObject = SageOneCoreConnection.sageOneGrabData(companyId, endpointQuery,
            SageOneCustomer.class, true);
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
}
