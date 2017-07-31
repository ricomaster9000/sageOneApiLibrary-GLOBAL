/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;

/**
 * Created by Ricardo on 2017-07-31.
 */
public class SageOneUploadDataWrapper {
    private String name = "";
    private byte[] Data;
    private boolean initialized;

    public SageOneUploadDataWrapper() {
        this.initialized = true;
    }

    public final String getName() {
        return (this.initialized) ? this.name : null;
    }

    public final void setName(final String name) {
        this.name = (this.initialized) ? name : this.name;
    }

    public final byte[] getData() {
        return (this.initialized) ? this.Data : null;
    }

    public final void setData(final byte[] fileData) {
        this.Data = (this.initialized) ? fileData : this.Data;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
