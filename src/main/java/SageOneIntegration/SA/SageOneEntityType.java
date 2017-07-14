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



import SageOneIntegration.SA.SageOneEntityType;
import SageOneIntegration.SA.SageOneRequestEntitySettings;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.*;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOneCommercialDocumentLineType;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOnePaymentMethod;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOneRoundingTypeClass;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOneTaxSystemClass;

public class SageOneEntityType {

    public enum V_1_1_2 {
        CUSTOMER_RETURN("CustomerReturn/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomerReturn.class, false),
        CUSTOMER_RECEIPT("CustomerReceipt/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomerReceipt.class),
        SUPPLIER_RETURN("SupplierReturn/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplierReturn.class, false),
        CUSTOMER("Customer/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer.class),
        CUSTOMER_NOTE("CustomerNote/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomerNote.class),
        SUPPLIER("Supplier/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier.class),
        SUPPLIER_NOTE("SupplierNote/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplierNote.class),
        TAX_INVOICE("TaxInvoice/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneTaxInvoice.class, false),
        SUPPLIER_INVOICE("SupplierInvoice/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplierInvoice.class, false),
        ACCOUNT_BALANCE("AccountBalance/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountBalance.class, false, false),
        COMPANY("Company/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCompany.class, false, false),
        ITEM("Item/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneItem.class),
        BANK_ACCOUNT("BankAccount/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneBankAccount.class),
        TAX_TYPE("TaxType/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneTaxType.class),
        SUPPLIER_CATEGORY("SupplierCategory/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplierCategory.class),
        BANK_FEED_ACCOUNT(SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneBankFeedAccount.class, false),
        ATTACHMENT(SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAttachment.class, false),
        BANK_FEED_ACCOUNT_GROUP(SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneBankFeedAccountGroup.class, false),
        PAYMENT_METHOD("PaymentMethod/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOnePaymentMethod.class),
        ROUNDING_TYPE(SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOneRoundingTypeClass.class, false),
        ITEM_CATEGORY("ItemCategory/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneItemCategory.class),
        CUSTOMER_CATEGORY("CustomerCategory/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomerCategory.class),
        ITEM_REPORT_GROUP("ItemReportGroup/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneItemReportGroup.class),
        SALES_REPRESENTATIVE("SalesRepresentative/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSalesRepresentative.class),
        TAX_SYSTEM_CLASS(SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOneTaxSystemClass.class, false),
        COMMERCIAL_DOCUMENT_LINE(SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCommercialDocumentLine.class, false),
        ADDITIONAL_ITEM_PRICE("AdditionalItemPrice/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAdditionalItemPrice.class),
        ADDITIONAL_PRICE_LIST("AdditionalPriceList/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAdditionalPriceList.class),
        COMMERCIAL_DOCUMENT_LINE_TYPE(SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOneCommercialDocumentLineType.class, false),
        BANK_ACCOUNT_CATEGORY("BankAccountCategory/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneBankAccountCategory.class),
        SAGE_ONE_ACCOUNT("Account/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccount.class),
        SAGE_ONE_ACCOUNT_CATEGORY("AccountCategory/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountCategory.class, false),
        SAGE_ONE_ACCOUNTANT_NOTE("AccountantNote/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountantNote.class, true, false),
        SAGE_ONE_ACCOUNTANT_TASK_RECURRENCE("AccountantTaskRecurrence/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountantTaskRecurrence.class, true, false),
        QUOTE("Quote/", SageOneQuote.class);

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

        V_1_1_2(final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest) {
            this.GetObject = new SageOneRequestEntitySettings(entityReqParamClass, entityCanBeUsedInRequest);
        }
    }

    public enum V_1_1_1 {

        QUOTE("Quote/", SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneQuote.class);

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

        V_1_1_1(final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest) {
            this.GetObject = new SageOneRequestEntitySettings(entityReqParamClass, entityCanBeUsedInRequest);
        }
    }
}
