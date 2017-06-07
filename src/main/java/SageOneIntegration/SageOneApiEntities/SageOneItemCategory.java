package SageOneIntegration.SageOneApiEntities;

import java.util.Date;

/**
 * Created by ricomaster9000 on 2017/06/06.
 */
public final class SageOneItemCategory extends SageOneMainEntity {
    private String Description;
    private Date Modified;
    private Date Created;

    public final String getDescription() {
        return (this.isInitialized()) ? this.Description : "";
    }

    public final void setDescription(final String Description) {
       this.Description = Description;
    }
}
