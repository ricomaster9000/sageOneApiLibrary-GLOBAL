/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.ReusableClasses;

/**
 * Created by Ricardo on 2017-07-16.
 */
public final class SageOneHttpMethod {
    private String Method;
    private boolean initialized = false;

    public SageOneHttpMethod() {
        this.initialized = true;
    }

    public final String getMethod() {
        return (this.initialized) ? this.Method : null;
    }

    public final void setMethod(final String Method) {
        this.Method = (this.initialized) ? Method : this.Method;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
