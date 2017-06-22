/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "**/
package SageOneIntegration;


final class SageOneRequestEntitySettings {
    private String stringProperty = "";
    private Class<?> classProperty;
    private boolean canBeUsedInRequest = true;
    private boolean canBeDeleted = true;
    private boolean canBeSaved = true;
    private boolean initialized = false;

    SageOneRequestEntitySettings(final String stringProperty, final Class<?> classProperty) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.initialized = true;
    }

    SageOneRequestEntitySettings(final String stringProperty, final Class<?> classProperty, final boolean canBeDeleted) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.canBeDeleted = canBeDeleted;
        this.initialized = true;
    }

    SageOneRequestEntitySettings(final String stringProperty, final Class<?> classProperty, final boolean canBeDeleted,
                                 final boolean canBeSaved) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.canBeDeleted = canBeDeleted;
        this.canBeSaved = canBeSaved;
        this.initialized = true;
    }

    SageOneRequestEntitySettings(final Class<?> classProperty,
                                 final boolean canBeUsedInRequest) {
        this.classProperty = classProperty;
        this.canBeUsedInRequest = canBeUsedInRequest;
        this.initialized = true;
    }

    SageOneRequestEntitySettings(final Class<?> classProperty,
                                 final boolean canBeUsedInRequest, final boolean canBeDeleted) {
        this.classProperty = classProperty;
        this.canBeUsedInRequest = canBeUsedInRequest;
        this.canBeDeleted = canBeDeleted;
        this.initialized = true;
    }


    final String getStringProperty() {
        return (this.initialized) ? this.stringProperty : "";
    }

    final void setStringProperty(final String stringProperty) {
        this.stringProperty = (this.initialized) ? stringProperty : this.stringProperty;
    }

    final Class<?> getClassProperty() {
        return (this.initialized) ? this.classProperty : null;
    }

    final void setClassProperty(final Class<?> classProperty) {
        this.classProperty = (this.initialized) ? classProperty : this.classProperty;
    }

    final boolean getCanBeUsedInRequest() {
        return (this.initialized) ? this.canBeUsedInRequest : null;
    }

    final void setCanBeUsedInRequest(final boolean canBeUsedInRequest) {
        this.canBeUsedInRequest = canBeUsedInRequest;
    }

    final boolean getCanBeDeleted() {
        return (this.initialized && this.canBeDeleted);
    }

    final void setCanBeDeleted(final boolean canBeDeleted) {
        this.canBeDeleted = (this.initialized) ? canBeDeleted : this.canBeDeleted;
    }

    final boolean getCanBeSaved() {
        return (this.initialized) ? this.canBeSaved : null;
    }

    final void setCanBeSaved(final boolean canBeSaved) {
        this.canBeSaved = (this.initialized) ? canBeSaved : this.canBeSaved;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
