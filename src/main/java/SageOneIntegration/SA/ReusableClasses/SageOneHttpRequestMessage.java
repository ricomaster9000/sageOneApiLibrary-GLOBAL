/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.ReusableClasses;

import java.net.URI;
import java.util.Collection;
import java.util.Properties;

/**
 * Created by Ricardo on 2017-07-16.
 */
public final class SageOneHttpRequestMessage {
    private SageOneVersion Version;
    private SageOneHttpContent Content;
    private SageOneHttpMethod Method;
    private URI RequestUri;
    private Collection<Object> Headers;
    private Properties Properties;
    private boolean initialized = false;

    public SageOneHttpRequestMessage() {
        this.initialized = true;
    }

    public final SageOneVersion getVersion() {
        return (this.initialized) ? this.Version : null;
    }

    public final void setVersion(final SageOneVersion Version) {
        this.Version = (this.initialized) ? Version : this.Version;
    }

    public final SageOneHttpContent getContent() {
        return (this.initialized) ? this.Content : null;
    }

    public final void setContent(final SageOneHttpContent Content) {
        this.Content = (this.initialized) ? Content : this.Content;
    }

    public final SageOneHttpMethod getMethod() {
        return (this.initialized) ? this.Method : null;
    }

    public final void setMethod(final SageOneHttpMethod Method) {
        this.Method = (this.initialized) ? Method : this.Method;
    }

    public final URI getRequestUri() {
        return (this.initialized) ? this.RequestUri : null;
    }

    public final void setRequestUri(final URI RequestUri) {
        this.RequestUri = (this.initialized) ? RequestUri : this.RequestUri;
    }

    public final Collection<Object> getHeaders() {
        return (this.initialized) ? this.Headers : null;
    }

    public final void setHeaders(final Collection<Object> Headers) {
        this.Headers = (this.initialized) ? Headers : this.Headers;
    }

    public final Properties getProperties() {
        return (this.initialized) ? this.Properties : null;
    }

    public final void setProperties(final Properties Properties) {
        this.Properties = (this.initialized) ? Properties : this.Properties;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
