/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities.V1_1_2;

class SageOneMainEntity {
    private Integer ID;
    private boolean initialized = false;

    public SageOneMainEntity() {
        this.initialized = true;
    }

    public Integer getId() { return (this.initialized) ? this.ID : -1; }

    public void setId(final Integer ID) { this.ID = (this.initialized) ? ID : this.ID; }

    public boolean isInitialized() { return this.initialized; }

    public void setInitialized(final boolean initialized) { this.initialized = true; }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
