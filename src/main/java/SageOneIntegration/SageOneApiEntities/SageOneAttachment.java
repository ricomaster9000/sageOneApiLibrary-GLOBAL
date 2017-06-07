package SageOneIntegration.SageOneApiEntities;

import java.util.UUID;

/**
 * Created by ricardo on 2017/06/07.
 */
public final class SageOneAttachment {
    private String Name;
    private Integer Size;
    private UUID AttachmentUID;
    private byte[] Data;
    private boolean initialized;

    public SageOneAttachment() {
        this.initialized = true;
    }

    public final String getName() {
        return (this.initialized) ? this.Name : "";
    }

    public final void setName(final String Name) {
        this.Name = (this.initialized) ? Name : this.Name;
    }

    public final Integer getSize() {
        return (this.initialized) ? this.Size : null;
    }

    public final void setSize(final Integer Size) {
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
}
