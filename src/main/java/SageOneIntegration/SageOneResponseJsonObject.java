/**
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 **/
package SageOneIntegration;

public final class SageOneResponseJsonObject {
    private boolean success = false;
    private String responseMessage = "";
    private String responseJson;
    private static boolean classInitialized = false;
    private boolean initialized = false;

    static void initializeClass() {
        SageOneResponseJsonObject.classInitialized = true;
    }
    static void deInitializeClass() { SageOneResponseJsonObject.classInitialized = false; }

    SageOneResponseJsonObject() {
        try {
            if (SageOneResponseJsonObject.classInitialized) {
                this.initialized = true;
            } else {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    SageOneResponseJsonObject(final boolean success, final String responseMessage) {
        try {
            if(SageOneResponseJsonObject.classInitialized) {
                this.initialized = true;
                this.success = success;
                this.responseMessage = responseMessage;
            } else {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    SageOneResponseJsonObject(final boolean success, final String responseMessage, final String responseJson) {
        try {
            if(SageOneResponseJsonObject.classInitialized) {
                this.initialized = true;
                this.success = success;
                this.responseMessage = responseMessage;
                this.responseJson = responseJson;
            } else {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    final void setSuccess(final boolean success) {
        this.success = (this.initialized) ? success : this.success;
    }

    public final boolean getSuccess() {
        try {
            if (!this.initialized) {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return success;
    }

    final void setResponseMessage(final String responseMessage) {
        this.responseMessage = (this.initialized) ? responseMessage : this.responseMessage;
    }

    public final String getResponseMessage() {
        try {
            if (!this.initialized) {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return responseMessage;
    }

    final void setResponseJson(final String responseJson) {
        this.responseJson = (this.initialized) ? responseJson : this.responseJson;
    }

    public final String getResponseJson() {
        try {
            if (!this.initialized) {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return responseJson;
    }

    @Override
    public final String toString() {
        return (this.initialized) ? "AjaxResponseJsonObject{" +
                " success = " + this.success + "," +
                " responseMessage = '" + this.responseMessage + "'," +
                " responseJson = " + this.responseJson + "," +
                "}" : null;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
