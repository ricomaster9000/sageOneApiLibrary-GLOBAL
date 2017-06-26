/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities.V1_1_2.SageEnum;

public enum SageOnePaymentMethod {
    Cash(1), Cheque(2), CreditCard(3), EFT(4);

    private final int id;
    SageOnePaymentMethod(int id) { this.id = id; }
    public int getValue() { return id; }
}
