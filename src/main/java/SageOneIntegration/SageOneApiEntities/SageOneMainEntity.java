/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities;

class SageOneMainEntity {
    private int id;
    private boolean initialized = false;

    public SageOneMainEntity() {
        this.initialized = true;
    }

    public int getId() { return (this.initialized) ? this.id : -1; }

    public void setId(final int id) { this.id = (this.initialized) ? id : this.id; }

    public boolean isInitialized() { return this.initialized; }

    public void setInitialized(final boolean initialized) { this.initialized = true; }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
