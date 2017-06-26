/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "**/
package SageOneIntegration.SageOneApiEntities;


public final class SageOneRequestEntitySettings {
    private String stringProperty = "";
    private Class<?> classProperty;
    private boolean canBeUsedInRequest = true;
    private boolean canBeDeleted = true;
    private boolean canBeSaved = true;
    private boolean canBeGrabbedById = true;
    private boolean initialized = false;

    public SageOneRequestEntitySettings(final String stringProperty, final Class<?> classProperty) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.initialized = true;
    }

    public SageOneRequestEntitySettings(final String stringProperty, final Class<?> classProperty, final boolean canBeDeleted) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.canBeDeleted = canBeDeleted;
        this.initialized = true;
    }

    public SageOneRequestEntitySettings(final String stringProperty, final Class<?> classProperty, final boolean canBeDeleted,
                                 final boolean canBeSaved) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.canBeDeleted = canBeDeleted;
        this.canBeSaved = canBeSaved;
        this.initialized = true;
    }

    public SageOneRequestEntitySettings(final String stringProperty, final Class<?> classProperty, final boolean canBeDeleted,
                                        final boolean canBeSaved, final boolean canBeGrabbedById) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.canBeDeleted = canBeDeleted;
        this.canBeSaved = canBeSaved;
        this.canBeGrabbedById = canBeGrabbedById;
        this.initialized = true;
    }

    public SageOneRequestEntitySettings(final Class<?> classProperty,
                                 final boolean canBeUsedInRequest) {
        this.classProperty = classProperty;
        this.canBeUsedInRequest = canBeUsedInRequest;
        this.initialized = true;
    }

    public SageOneRequestEntitySettings(final Class<?> classProperty,
                                 final boolean canBeUsedInRequest, final boolean canBeDeleted) {
        this.classProperty = classProperty;
        this.canBeUsedInRequest = canBeUsedInRequest;
        this.canBeDeleted = canBeDeleted;
        this.initialized = true;
    }


    public final String getStringProperty() {
        return (this.initialized) ? this.stringProperty : "";
    }

    public final void setStringProperty(final String stringProperty) {
        this.stringProperty = (this.initialized) ? stringProperty : this.stringProperty;
    }

    public final Class<?> getClassProperty() {
        return (this.initialized) ? this.classProperty : null;
    }

    public final void setClassProperty(final Class<?> classProperty) {
        this.classProperty = (this.initialized) ? classProperty : this.classProperty;
    }

    public final boolean getCanBeUsedInRequest() {
        return (this.initialized) ? this.canBeUsedInRequest : null;
    }

    public final void setCanBeUsedInRequest(final boolean canBeUsedInRequest) {
        this.canBeUsedInRequest = canBeUsedInRequest;
    }

    public final boolean getCanBeDeleted() {
        return (this.initialized && this.canBeDeleted);
    }

    public final void setCanBeDeleted(final boolean canBeDeleted) {
        this.canBeDeleted = (this.initialized) ? canBeDeleted : this.canBeDeleted;
    }

    public final boolean getCanBeSaved() {
        return (this.initialized) ? this.canBeSaved : null;
    }

    public final void setCanBeSaved(final boolean canBeSaved) {
        this.canBeSaved = (this.initialized) ? canBeSaved : this.canBeSaved;
    }

    public final boolean getCanBeGrabbedById() {
        return (this.initialized) ? this.canBeGrabbedById : null;
    }

    public final void setCanBeGrabbedById(final boolean canBeGrabbedById) {
        this.canBeGrabbedById = (this.initialized) ? canBeGrabbedById : this.canBeGrabbedById;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
