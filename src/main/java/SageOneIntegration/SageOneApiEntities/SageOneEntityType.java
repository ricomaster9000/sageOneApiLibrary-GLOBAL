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
package SageOneIntegration.SageOneApiEntities;


import SageOneIntegration.SageOneApiEntities.V1_1_2.*;
import SageOneIntegration.SageOneApiEntities.V1_1_2.SageEnum.SageOneCommercialDocumentLineType;
import SageOneIntegration.SageOneApiEntities.V1_1_2.SageEnum.SageOnePaymentMethod;

public enum SageOneEntityType {
    CUSTOMER_RETURN("CustomerReturn/", SageOneCustomerReturn.class, false),
    CUSTOMER_RECEIPT("CustomerReceipt/", SageOneCustomerReceipt.class),
    SUPPLIER_RETURN("SupplierReturn/", SageOneSupplierReturn.class, false),
    CUSTOMER("Customer/", SageOneCustomer.class),
    CUSTOMER_NOTE("CustomerNote/", SageOneCustomerNote.class),
    SUPPLIER("Supplier/", SageOneSupplier.class),
    SUPPLIER_NOTE("SupplierNote/", SageOneSupplierNote.class),
    TAX_INVOICE("TaxInvoice/", SageOneTaxInvoice.class, false),
    SUPPLIER_INVOICE("SupplierInvoice/", SageOneSupplierInvoice.class, false),
    ACCOUNT_BALANCE("AccountBalance/", SageOneAccountBalance.class, false, false),
    COMPANY("Company/", SageOneCompany.class, false, false),
    ITEM("Item/", SageOneItem.class),
    BANK_ACCOUNT("BankAccount/", SageOneBankAccount.class),
    TAX_TYPE("TaxType/", SageOneTaxType.class),
    SUPPLIER_CATEGORY("SupplierCategory/", SageOneSupplierCategory.class),
    BANK_FEED_ACCOUNT(SageOneBankFeedAccount.class, false),
    ATTACHMENT(SageOneAttachment.class, false),
    BANK_FEED_ACCOUNT_GROUP(SageOneBankFeedAccountGroup.class, false),
    PAYMENT_METHOD("PaymentMethod/", SageOnePaymentMethod.class),
    ROUNDING_TYPE(SageOneRoundingTypeClass.class, false),
    ITEM_CATEGORY("ItemCategory/", SageOneItemCategory.class),
    CUSTOMER_CATEGORY("CustomerCategory/", SageOneCustomerCategory.class),
    ITEM_REPORT_GROUP("ItemReportGroup/", SageOneItemReportGroup.class),
    SALES_REPRESENTATIVE("SalesRepresentative/", SageOneSalesRepresentative.class),
    TAX_SYSTEM_CLASS(SageOneTaxSystemClass.class, false),
    COMMERCIAL_DOCUMENT_LINE(SageOneCommercialDocumentLine.class, false),
    ADDITIONAL_ITEM_PRICE("AdditionalItemPrice/", SageOneAdditionalItemPrice.class),
    ADDITIONAL_PRICE_LIST("AdditionalPriceList/", SageOneAdditionalPriceList.class),
    COMMERCIAL_DOCUMENT_LINE_TYPE(SageOneCommercialDocumentLineType.class, false),
    BANK_ACCOUNT_CATEGORY("BankAccountCategory/", SageOneBankAccountCategory.class),
    SAGE_ONE_ACCOUNT("Account/", SageOneAccount.class),
    SAGE_ONE_ACCOUNT_CATEGORY("AccountCategory/", SageOneAccountCategory.class, false),
    SAGE_ONE_ACCOUNTANT_NOTE("AccountantNote/", SageOneAccountantNote.class, true, false),
    SAGE_ONE_ACCOUNTANT_TASK_RECURRENCE("AccountantTaskRecurrence/", SageOneAccountantTaskRecurrence.class, true, false),
    QUOTE("Quote/", SageOneQuote.class);

    public SageOneRequestEntitySettings GetObject;
    SageOneEntityType(final String entityGetReqParamName, final Class<?> entityReqParamClass)  {
        this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass);
    }

    SageOneEntityType(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted)  {
        this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeDeleted);
    }

    SageOneEntityType(final String entityGetReqParamName, final Class<?> entityReqParamClass, final boolean entityCanBeDeleted,
                      final boolean entityCanBeSaved) {
        this.GetObject = new SageOneRequestEntitySettings(entityGetReqParamName, entityReqParamClass, entityCanBeDeleted, entityCanBeSaved);
    }

    SageOneEntityType(final Class<?> entityReqParamClass, final boolean entityCanBeUsedInRequest)  {
        this.GetObject = new SageOneRequestEntitySettings(entityReqParamClass, entityCanBeUsedInRequest);
    }
}
