/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;


import SageOneIntegration.SageOneApiEntities.*;

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
    BANK_ACCOUNT("BankAccount/", SageOneBankAccount.class);

    public SageOneStringAndClassObject GetObject;
    SageOneEntityType(final String entityGetReqParamName, final Class<?> entityGetReqParamClass)  {
        this.GetObject = new SageOneStringAndClassObject(entityGetReqParamName, entityGetReqParamClass);
    }
}
