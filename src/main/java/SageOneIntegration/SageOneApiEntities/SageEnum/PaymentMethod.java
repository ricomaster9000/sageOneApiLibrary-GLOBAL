/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/

package SageOneIntegration.SageOneApiEntities.SageEnum;

public enum PaymentMethod {
    Cash(1), Cheque(2), CreditCard(3), EFT(4);

    private final int id;
    PaymentMethod(int id) { this.id = id; }
    public int getValue() { return id; }
}
