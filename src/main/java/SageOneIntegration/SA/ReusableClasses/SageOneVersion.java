/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.ReusableClasses;

/**
 * Created by Ricardo on 2017-07-16.
 */
public final class SageOneVersion {
    private Integer Major;
    private Integer Minor;
    private Integer Build;
    private Integer Revision;
    private Integer MajorRevision;
    private Integer MinorRevision;
    private boolean initialized;

    public SageOneVersion() {
        this.initialized = true;
    }

    public final Integer getMajor() {
        return (this.initialized) ? this.Major : null;
    }

    public final void setMajor(final Integer Major) {
        this.Major = (this.initialized) ? Major : this.Major;
    }

    public final Integer getMinor() {
        return (this.initialized) ? this.Minor : null;
    }

    public final void setMinor(final Integer Minor) {
        this.Minor = (this.initialized) ? Minor : this.Minor;
    }

    public final Integer getBuild() {
        return (this.initialized) ? this.Build : null;
    }

    public final void setBuild(final Integer Build) {
        this.Build = (this.initialized) ? Build : this.Build;
    }

    public final Integer getRevision() {
        return (this.initialized) ? this.Revision : null;
    }

    public final void setRevision(final Integer Revision) {
        this.Revision = (this.initialized) ? Revision : this.Revision;
    }

    public final Integer getMajorRevision() {
        return (this.initialized) ? this.MajorRevision : null;
    }

    public final void setMajorRevision(final Integer MajorRevision) {
        this.MajorRevision = (this.initialized) ? MajorRevision : this.MajorRevision;
    }

    public final Integer getMinorRevision() {
        return (this.initialized) ? this.MinorRevision : null;
    }

    public final void setMinorRevision(final Integer MinorRevision) {
        this.MinorRevision = (this.initialized) ? MinorRevision : this.MinorRevision;
    }

    @Override public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
