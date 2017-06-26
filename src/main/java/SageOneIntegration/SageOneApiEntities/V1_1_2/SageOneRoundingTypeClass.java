/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities.V1_1_2;

public enum SageOneRoundingTypeClass {
    Up(0), Down(1), Normal(2), None(3);

    private int valueOfEnum = 0;
    SageOneRoundingTypeClass(final int valueOfEnum) {
        this.valueOfEnum = valueOfEnum;
    }

    public int getValue() {
        return this.valueOfEnum;
    }
}
