/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;

/**
 * Created by ricomaster9000 on 2017/06/05.
 */
public final class SageOneSaveEntityResponse {
    private boolean success = false;
    private int savedEntityId = 0;
    private boolean initialized = false;

    SageOneSaveEntityResponse(final boolean success, final int savedEntityId) {
        this.success = success;
        this.savedEntityId = savedEntityId;
        this.initialized = true;
    }

    public final boolean getSuccess() {
        return (this.initialized && this.success);
    }

    public final void setSuccess(final boolean success) {
        this.success = (this.initialized) ? success : this.success;
    }

    public final int getSavedEntityId() {
        return (this.initialized) ? this.savedEntityId : -1;
    }

    public final void setSavedEntityId(final int savedEntityId) {
        this.savedEntityId = (this.initialized) ? savedEntityId : this.savedEntityId;
    }
}
