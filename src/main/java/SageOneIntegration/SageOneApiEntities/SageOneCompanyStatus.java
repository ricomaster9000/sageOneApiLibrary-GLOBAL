/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities;

public enum SageOneCompanyStatus {
    None(0), RegistrationExpired(1), UserAccessDenied(2);

    private int valueOfEnum;
    SageOneCompanyStatus(final int valueOfEnum) {
        this.valueOfEnum = valueOfEnum;
    }

    public int getValue() {
        return this.valueOfEnum;
    }
}
