/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.V1_1_2.SageOneApiEntities;

/**
 * Created by Ricardo on 2017-07-15.
 */
public final class SageOneStorageInformation {
    private Integer SizeUsed;
    private Integer MaxSizeAllowed;
    private boolean initialized;

    public SageOneStorageInformation() {
        this.initialized = true;
    }

    public final Integer getSizeUsed() {
        return (this.initialized) ? this.SizeUsed : null;
    }

    public final void setSizeUsed(final Integer SizeUsed) {
        this.SizeUsed = (this.initialized) ? SizeUsed: this.SizeUsed;
    }

    public final Integer getMaxSizeAllowed() {
        return (this.initialized) ? this.MaxSizeAllowed : null;
    }

    public final void setMaxSizeAllowed(final Integer MaxSizeAllowed) {
        this.SizeUsed = (this.initialized) ? MaxSizeAllowed : this.MaxSizeAllowed;
    }
}
