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
        ACCOUNTANT_TASK("AccountantTask/", SageOneAccountantTask.class, true, false),
        ACCOUNT_BALANCE("AccountBalance/", SageOneAccountBalance.class, false, false, false),
        ADDITIONAL_ITEM_PRICE("AdditionalItemPrice/", SageOneAdditionalItemPrice.class),
        ADDITIONAL_PRICE_LIST("AdditionalPriceList/", SageOneAdditionalPriceList.class),
        ACCOUNT("Account/", SageOneAccount.class),
        ACCOUNT_NOTE("AccountNote/", SageOneAccountNote.class),
        ACCOUNT_NOTE_ATTACHMENT("AccountNoteAttachment/", SageOneAccountNoteAttachment.class, true, true, true, false, true),
        ACCOUNTANT_NOTE("AccountantNote/", SageOneAccountantNote.class, true, false),
        ACCOUNTANT_TASK_RECURRENCE("AccountantTaskRecurrence/", SageOneAccountantTaskRecurrence.class, true, false),
        ACCOUNT_CATEGORY("AccountCategory/", SageOneAccountCategory.class, false, false),

        BANK_ACCOUNT("BankAccount/", SageOneBankAccount.class),
        BANK_ACCOUNT_CATEGORY("BankAccountCategory/", SageOneBankAccountCategory.class),
        BANK_FEED_ACCOUNT(null, SageOneBankFeedAccount.class, false),
        BANK_FEED_ACCOUNT_GROUP(null, SageOneBankFeedAccountGroup.class, false),

        COMPANY("Company/", SageOneCompany.class, false, false),
        CUSTOMER_RETURN("CustomerReturn/", SageOneCustomerReturn.class, false),
        CUSTOMER_RECEIPT("CustomerReceipt/", SageOneCustomerReceipt.class),
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

        SUPPLIER_RETURN("SupplierReturn/", SageOneSupplierReturn.class, false),
        SUPPLIER("Supplier/", SageOneSupplier.class),
        SUPPLIER_NOTE("SupplierNote/", SageOneSupplierNote.class),
        SUPPLIER_INVOICE("SupplierInvoice/", SageOneSupplierInvoice.class, false),
        SUPPLIER_CATEGORY("SupplierCategory/", SageOneSupplierCategory.class),
        SALES_REPRESENTATIVE("SalesRepresentative/", SageOneSalesRepresentative.class),

        TAX_TYPE("TaxType/", SageOneTaxType.class),
        TAX_INVOICE("TaxInvoice/", SageOneTaxInvoice.class, false),
        TAX_SYSTEM_CLASS(null, SageOneTaxSystemClass.class, false);

        public SageOneRequestEntitySettings GetObject;

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeDeleted);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted,
                final boolean entityCanBeSaved) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeDeleted, entityCanBeSaved);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted,
                final boolean entityCanBeSaved, final boolean entityCanBeGrabbedByID) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass,
                    entityCanBeDeleted, entityCanBeSaved, entityCanBeGrabbedByID);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted,
                final boolean entityCanBeSaved, final boolean entityCanBeGrabbedByID, final boolean entityCanBeGrabbedWithoutId) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass,
                    entityCanBeDeleted, entityCanBeSaved, entityCanBeGrabbedByID, entityCanBeGrabbedWithoutId);
        }

        V_1_1_2(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted,
                final boolean entityCanBeSaved, final boolean entityCanBeGrabbedByID, final boolean entityCanBeGrabbedWithoutId,
                final boolean entityCanBeDownloaded) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass,
                    entityCanBeDeleted, entityCanBeSaved, entityCanBeGrabbedByID, entityCanBeGrabbedWithoutId,
                    entityCanBeDownloaded);
        }
    }

    public enum V_1_1_1 {

        QUOTE("Quote/", SageOneQuote.class);

        public SageOneRequestEntitySettings GetObject;

        V_1_1_1(final String entityGetReqParamName, final Class<?> entityReqParamClass) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass);
        }

        V_1_1_1(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeDeleted);
        }

        V_1_1_1(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted,
                final boolean entityCanBeSaved) {
            this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeDeleted, entityCanBeSaved);
        }
    }
}
