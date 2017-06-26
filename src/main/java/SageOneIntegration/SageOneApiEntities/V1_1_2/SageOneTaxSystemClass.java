/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities.V1_1_2;


public enum SageOneTaxSystemClass {
    InvoiceBased(0), PaymentsBased(1), NoTax(2);

    private final int ID;
    SageOneTaxSystemClass(int ID) { this.ID = ID; }
    public int getValue() { return ID; }


}
