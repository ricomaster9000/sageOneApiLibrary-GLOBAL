/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities.V1_1_2;

import java.util.Date;


public final class SageOneSupplierCategory extends SageOneMainEntity {
    //String length: inclusive between 0 and 100
    private String Description;
    private Date Modified;
    private Date Created;

    public SageOneSupplierCategory(){
        this.setInitialized(true);
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getModified() {
        return Modified;
    }

    public void setModified(Date modified) {
        Modified = modified;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }
}
