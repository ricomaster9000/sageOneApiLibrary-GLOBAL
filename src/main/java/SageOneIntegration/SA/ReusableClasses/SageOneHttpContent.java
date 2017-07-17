/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.ReusableClasses;

import java.util.Collection;

/**
 * Created by Ricardo on 2017-07-16.
 */
public final class SageOneHttpContent {
    private Collection<Object> Headers;
    private boolean initialized = false;

    public SageOneHttpContent() {
        this.initialized = true;
    }

    public final Collection<Object> getHeaders() {
        return (this.initialized) ? this.Headers : null;
    }

    public final void setHeaders(final Collection<Object> Headers) {
        this.Headers = (this.initialized) ? Headers : this.Headers;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
