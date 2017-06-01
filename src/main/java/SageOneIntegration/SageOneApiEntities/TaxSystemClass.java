/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities;


enum TaxSystemClass {
    InvoiceBased(0), PaymentsBased(1), NoTax(2);

    private final int id;
    TaxSystemClass(int id) { this.id = id; }
    public int getValue() { return id; }


}
