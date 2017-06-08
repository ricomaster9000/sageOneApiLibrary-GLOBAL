/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "**/
package SageOneIntegration;

/**
 * Created by ricardo on 2017/06/01.
 */
final class SageOneStringAndClassObject {
    private String stringProperty = "";
    private Class<?> classProperty;
    private boolean canBeUsedInRequest = true;
    private boolean initialized = false;

    SageOneStringAndClassObject(final String stringProperty, final Class<?> classProperty) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.initialized = true;
    }

    SageOneStringAndClassObject(final Class<?> classProperty,
                                final boolean canBeUsedInRequest) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.canBeUsedInRequest = canBeUsedInRequest;
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

    @Override
    public final Object clone() {
        return null;
    }
}
