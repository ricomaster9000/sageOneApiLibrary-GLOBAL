/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.V1_1_2.SageOneApiEntities;

import java.util.UUID;

public final class SageOneAttachment {
    private String Name;
    private Long Size;
    private UUID AttachmentUID;
    private byte[] Data;
    private transient boolean initialized;

    public SageOneAttachment() {
        this.initialized = true;
    }

    public final String getName() {
        return (this.initialized) ? this.Name : "";
    }

    public final void setName(final String Name) {
        this.Name = (this.initialized) ? Name : this.Name;
    }

    public final Long getSize() {
        return (this.initialized) ? this.Size : null;
    }

    public final void setSize(final Long Size) {
        this.Size = (this.initialized) ? Size : this.Size;
    }

    public final UUID getAttachmentUID() {
        return (this.initialized) ? this.AttachmentUID : null;
    }

    public final void setAttachmentUID(final UUID AttachmentUID) {
        this.AttachmentUID = (this.initialized) ? AttachmentUID : this.AttachmentUID;
    }

    public final byte[] getData() {
        return (this.initialized) ? this.Data : null;
    }

    public final void setData(final byte[] Data) {
        this.Data = (this.initialized) ? Data : this.Data;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
