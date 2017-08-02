/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration;

/**
 * Created by modmaster9000 on 8/2/17.
 */
public final class SageOneDownloadDataWrapper {
    private String contentType;
    private Integer contentLength;
    private byte[] responseData;
    private String fileName;
    private boolean initialized = false;

    public SageOneDownloadDataWrapper() {
        this.initialized = true;
    }

    public final String getContentType() {
        return (this.initialized) ? this.contentType : null;
    }

    public final void setContentType(final String contentType) {
        this.contentType = (this.initialized) ? contentType : this.contentType;
    }

    public final Integer getContentLength() {
        return (this.initialized) ? this.contentLength : null;
    }

    public final void setContentLength(final Integer contentLength) {
        this.contentLength = (this.initialized) ? contentLength : this.contentLength;
    }

    public final byte[] getResponseData() {
        return (this.initialized) ? this.responseData : null;
    }

    public final void setResponseData(final byte[] responseData) {
        this.responseData = (this.initialized) ? responseData : this.responseData;
    }

    public final String getFileName() {
        return (this.initialized) ? this.fileName : null;
    }

    public final void setFileName(final String fileName) {
        this.fileName = (this.initialized) ? fileName : this.fileName;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
