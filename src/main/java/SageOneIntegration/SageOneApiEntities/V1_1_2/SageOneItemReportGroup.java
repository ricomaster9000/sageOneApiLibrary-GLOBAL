/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities.V1_1_2;

/**
 * Created by ricardo on 2017/06/07.
 */
public final class SageOneItemReportGroup extends SageOneMainEntity {
    private String Name;
    private Integer ItemReportingGroupTypeId;
    private String ItemReportingGroupType;
    private Integer ReportingGroupId;

    public final String getName() {
        return (this.isInitialized()) ? this.Name : "";
    }

    public final void setName(final String Name) {
        this.Name = (this.isInitialized()) ? Name : this.Name;
    }

    public final Integer getItemReportingGroupTypeId() {
        return (this.isInitialized()) ? this.ItemReportingGroupTypeId : null;
    }

    public final void setItemReportingGroupTypeId(final Integer ItemReportingGroupTypeId) {
        this.ItemReportingGroupTypeId = (this.isInitialized()) ? ItemReportingGroupTypeId : this.ItemReportingGroupTypeId;
    }

    public final String getItemReportingGroupType() {
        return (this.isInitialized()) ? this.ItemReportingGroupType : null;
    }

    public final void setItemReportingGroupType(final String ItemReportingGroupType) {
        this.ItemReportingGroupType = (this.isInitialized()) ? ItemReportingGroupType:this.ItemReportingGroupType;
    }

    public final Integer getReportingGroupId() {
        return (this.isInitialized()) ? this.ReportingGroupId : null;
    }

    public final void setReportingGroupId(final Integer ReportingGroupId) {
        this.ReportingGroupId = (this.isInitialized()) ? ReportingGroupId : this.ReportingGroupId;
    }
}
