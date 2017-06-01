/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "**/
package SageOneIntegration;

/**
 * Created by ricardo on 2017/06/01.
 */
final class StringAndClassObject {
    private String stringProperty = "";
    private Class<?> classProperty;
    private boolean initialized = false;

    StringAndClassObject(final String stringProperty, final Class<?> classProperty) {
        this.stringProperty = stringProperty;
        this.classProperty = classProperty;
        this.initialized = true;
    }

    final String getStringProperty() {
        return (this.initialized) ? this.stringProperty : "";
    }

    public final void setStringProperty(final String stringProperty) {
        this.stringProperty = (this.initialized) ? stringProperty : this.stringProperty;
    }

    final Class<?> getClassProperty() {
        return (this.initialized) ? this.classProperty : null;
    }

    public final void setClassProperty(final Class<?> classProperty) {
        this.classProperty = (this.initialized) ? classProperty : this.classProperty;
    }

    @Override
    public final Object clone() {
        return null;
    }
}
