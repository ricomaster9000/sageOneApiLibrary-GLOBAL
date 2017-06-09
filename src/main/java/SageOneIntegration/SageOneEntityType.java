/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;


import SageOneIntegration.SageOneApiEntities.*;
import SageOneIntegration.SageOneApiEntities.SageEnum.SageOneCommercialDocumentLineType;
import SageOneIntegration.SageOneApiEntities.SageEnum.SageOnePaymentMethod;

public enum SageOneEntityType {
    CUSTOMER_RETURN("CustomerReturn/", SageOneCustomerReturn.class),
    CUSTOMER_RECEIPT("CustomerReceipt/", SageOneCustomerReceipt.class),
    SUPPLIER_RETURN("SupplierReturn/", SageOneSupplierReturn.class),
    CUSTOMER("Customer/", SageOneCustomer.class),
    SUPPLIER("Supplier/", SageOneSupplier.class),
    TAX_INVOICE("TaxInvoice/", SageOneTaxInvoice.class),
    SUPPLIER_INVOICE("SupplierInvoice/", SageOneSupplierInvoice.class),
    COMPANY("Company/", SageOneCompany.class),
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
    COMPANY_LOGO(SageOneCompanyLogoClass.class, false),
    COMPANY_STATUS(SageOneCompanyStatus.class, false),
    ITEM_REPORT_GROUP("ItemReportGroup/", SageOneItemReportGroup.class),
    SALES_REPRESENTATIVE("SalesRepresentative/", SageOneSalesRepresentative.class),
    TAX_SYSTEM_CLASS(SageOneTaxSystemClass.class, false),
    COMMERCIAL_DOCUMENT_LINE(SageOneCommercialDocumentLine.class, false),
    ADDITIONAL_ITEM_PRICE("AdditionalItemPrice/", SageOneAdditionalItemPrice.class),
    ADDITIONAL_PRICE_LIST("AdditionalPriceList/", SageOneAdditionalPriceList.class),
    COMMERCIAL_DOCUMENT_LINE_TYPE(SageOneCommercialDocumentLineType.class, false),
    BANK_ACCOUNT_CATEGORY("BankAccountCategory/", SageOneBankAccountCategory.class),
    QUOTE("Quote/", SageOneQuote.class);

    public SageOneStringAndClassObject GetObject;
    SageOneEntityType(final String entityGetReqParamName, final Class<?> entityGetReqParamClass)  {
        this.GetObject = new SageOneStringAndClassObject(entityGetReqParamName, entityGetReqParamClass);
    }

    SageOneEntityType(final Class<?> entityGetReqParamClass, final boolean entityCanBeUsedInRequest)  {
        this.GetObject = new SageOneStringAndClassObject(entityGetReqParamClass, entityCanBeUsedInRequest);
    }
}
