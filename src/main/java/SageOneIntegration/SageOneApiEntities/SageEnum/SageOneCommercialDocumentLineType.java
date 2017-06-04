/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities.SageEnum;

public enum SageOneCommercialDocumentLineType {
    Item(0), Account(1), Time(3), TimeEntry(2), Recharge(5);

    private final int id;
    SageOneCommercialDocumentLineType(int id) { this.id = id; }
    public int getValue() { return id; }
}
