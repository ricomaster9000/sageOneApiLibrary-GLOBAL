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


import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.*;
import SageOneIntegration.SA.V1_1_2.SageOneEnumEntities.SageOneCommercialDocumentLineType;
import SageOneIntegration.SA.V1_1_2.SageOneEnumEntities.SageOneRoundingTypeClass;
import SageOneIntegration.SA.V1_1_2.SageOneEnumEntities.SageOneTaxSystemClass;
import SageOneIntegration.SageOneRequestEntitySettings;

public class SageOneEntityType {

    public enum V_1_1_2 {
        ATTACHMENT(null, SageOneAttachment.class, false),
        ACCOUNTANT_TASK("AccountantTask/", SageOneAccountantTask.class, true, true, false),
        ACCOUNT_BALANCE("AccountBalance/", SageOneAccountBalance.class, true, false, false, false),
        ADDITIONAL_ITEM_PRICE("AdditionalItemPrice/", SageOneAdditionalItemPrice.class),
        ADDITIONAL_PRICE_LIST("AdditionalPriceList/", SageOneAdditionalPriceList.class),
        ACCOUNT("Account/", SageOneAccount.class),
        ACCOUNT_NOTE("AccountNote/", SageOneAccountNote.class, true, true, true, true, true, false),
        ACCOUNT_NOTE_ATTACHMENT("AccountNoteAttachment/", SageOneAccountNoteAttachment.class, true, true, false, true, false, true),
        ACCOUNTANT_NOTE("AccountantNote/", SageOneAccountantNote.class, true, true, false),
        ACCOUNTANT_TASK_RECURRENCE("AccountantTaskRecurrence/", SageOneAccountantTaskRecurrence.class, true, true, false),
        ACCOUNT_CATEGORY("AccountCategory/", SageOneAccountCategory.class, true, false, false, true, true),
        ACCOUNT_OPENING_BALANCE("AccountOpeningBalance/", SageOneAccountOpeningBalance.class, true, false),
        ACCOUNT_PAYMENT("AccountPayment/", SageOneAccountPayment.class, true, false, true, false),

        BANK_ACCOUNT("BankAccount/", SageOneBankAccount.class),
        BANK_ACCOUNT_CATEGORY("BankAccountCategory/", SageOneBankAccountCategory.class),
        BANK_FEED_ACCOUNT(null, SageOneBankFeedAccount.class, false),
        BANK_FEED_ACCOUNT_GROUP(null, SageOneBankFeedAccountGroup.class, false),//Fix from here

        COMPANY("Company/", SageOneCompany.class, true, false, false),
        CUSTOMER_RETURN("CustomerReturn/", SageOneCustomerReturn.class, true, false),
        CUSTOMER_RECEIPT("CustomerReceipt/", SageOneCustomerReceipt.class, true, false),
        CUSTOMER("Customer/", SageOneCustomer.class),
        CUSTOMER_NOTE("CustomerNote/", SageOneCustomerNote.class),
        CUSTOMER_CATEGORY("CustomerCategory/", SageOneCustomerCategory.class),
        COMMERCIAL_DOCUMENT_LINE(null, SageOneCommercialDocumentLine.class, false),
        COMMERCIAL_DOCUMENT_LINE_TYPE(null, SageOneCommercialDocumentLineType.class, false),

        ITEM_CATEGORY("ItemCategory/", SageOneItemCategory.class),
        ITEM_REPORT_GROUP("ItemReportGroup/", SageOneItemReportGroup.class),
        ITEM("Item/", SageOneItem.class),

        ROUNDING_TYPE(null, SageOneRoundingTypeClass.class, false),

        QUOTE("Quote/", SageOneQuote.class),

        SUPPLIER_RETURN("SupplierReturn/", SageOneSupplierReturn.class, true, false),
        SUPPLIER("Supplier/", SageOneSupplier.class),
        SUPPLIER_NOTE("SupplierNote/", SageOneSupplierNote.class),
        SUPPLIER_INVOICE("SupplierInvoice/", SageOneSupplierInvoice.class, true, false),
        SUPPLIER_CATEGORY("SupplierCategory/", SageOneSupplierCategory.class),
        SALES_REPRESENTATIVE("SalesRepresentative/", SageOneSalesRepresentative.class),

        TAX_TYPE("TaxType/", SageOneTaxType.class),
        TAX_INVOICE("TaxInvoice/", SageOneTaxInvoice.class, true, false),
        TAX_SYSTEM_CLASS(null, SageOneTaxSystemClass.class, true, false);


        public SageOneRequestEntitySettings GetObject;

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeUsedInRequest);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest,
                final boolean entityCanBeDeleted) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeUsedInRequest, entityCanBeDeleted);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest,
                boolean entityCanBeDeleted, boolean entityCanBeSaved) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass,
                    entityCanBeUsedInRequest, entityCanBeDeleted, entityCanBeSaved);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest,
                final boolean entityCanBeDeleted, final boolean entityCanBeSaved, final boolean entityCanBeGrabbedByID) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass,
                    entityCanBeDeleted, entityCanBeUsedInRequest, entityCanBeSaved, entityCanBeGrabbedByID);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest,
                final boolean entityCanBeDeleted, final boolean entityCanBeSaved, final boolean entityCanBeGrabbedByID,
                final boolean entityCanBeGrabbedWithoutId) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass,
                    entityCanBeUsedInRequest, entityCanBeDeleted, entityCanBeSaved, entityCanBeGrabbedByID,
                    entityCanBeGrabbedWithoutId);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest,
                final boolean entityCanBeDeleted, final boolean entityCanBeSaved, final boolean entityCanBeGrabbedByID,
                final boolean entityCanBeGrabbedWithoutId, final boolean entityCanBeDownloaded) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass,
                    entityCanBeUsedInRequest, entityCanBeDeleted, entityCanBeSaved, entityCanBeGrabbedByID,
                    entityCanBeGrabbedWithoutId, entityCanBeDownloaded);
        }
    }

    public enum V_1_1_1 {

        QUOTE("Quote/", SageOneQuote.class);

        public SageOneRequestEntitySettings GetObject;

        V_1_1_1(final String entityGetReqParamName, final Class<?> entityReqParamClass) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass);
        }
    }
}
