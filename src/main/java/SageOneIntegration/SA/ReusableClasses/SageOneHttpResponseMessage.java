/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SA.ReusableClasses;

import org.apache.http.HttpResponse;

import java.util.Collection;

/**
 * Created by Ricardo on 2017-07-16.
 */
public final class SageOneHttpResponseMessage {
    private SageOneVersion Version;
    private SageOneHttpContent Content;
    private SageOneHttpStatusCode StatusCode;
    private String ReasonPhrase;
    private Collection<Object> Headers;
    private SageOneHttpRequestMessage RequestMessage;
    private Boolean IsSuccessStatusCode;
    private boolean classInitialized;
    private boolean initialized;

    public final void initializedClass() {
        this.classInitialized = true;
    }

    public final void deInitializeClass() {
        this.classInitialized = false;
    }

    public SageOneHttpResponseMessage() {
        try {
            if (classInitialized) {
                this.initialized = true;
            } else {
                throw new ClassNotFoundException("Cannot access class, initialize before usage");
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public final SageOneHttpStatusCode getStatusCode() {
        return (this.initialized) ? this.StatusCode : null;
    }

    public final void setStatusCode(final SageOneHttpStatusCode StatusCode) {
        this.StatusCode = (this.initialized) ? StatusCode : this.StatusCode;
    }

    public final String getReasonPhrase() {
        return (this.initialized) ? this.ReasonPhrase : null;
    }

    public final void setReasonPhrase(final String ReasonPhrase) {
        this.ReasonPhrase = (this.initialized) ? ReasonPhrase : this.ReasonPhrase;
    }

    public final Collection<Object> getHeaders() {
        return (this.initialized) ? this.Headers : null;
    }

    public final void setHeaders(final Collection<Object> Headers) {
        this.Headers = (this.initialized) ? Headers : this.Headers;
    }

    public final SageOneHttpRequestMessage getRequestMessage() {
        return (this.initialized) ? this.RequestMessage : null;
    }

    public final void setRequestMessage(final SageOneHttpRequestMessage RequestMessage) {
        this.RequestMessage = (this.initialized) ? RequestMessage : this.RequestMessage;
    }

    public final Boolean getIsSuccessStatusCode() {
        return (this.initialized) ? this.IsSuccessStatusCode : null;
    }

    public final void setIsSuccessStatusCode(final Boolean IsSuccessStatusCode) {
        this.IsSuccessStatusCode = (this.initialized) ? IsSuccessStatusCode : this.IsSuccessStatusCode;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
