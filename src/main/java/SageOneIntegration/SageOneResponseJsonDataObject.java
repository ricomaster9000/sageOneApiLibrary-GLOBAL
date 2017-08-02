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

public final class SageOneResponseJsonDataObject {
    private boolean success = false;
    private String responseMessage = "";
    private String responseJson;
    private byte[] responseData;
    private static boolean classInitialized = false;
    private boolean initialized = false;

    public static void initializeClass() {
        SageOneResponseJsonDataObject.classInitialized = true;
    }
    public static void deInitializeClass() { SageOneResponseJsonDataObject.classInitialized = false; }

    public SageOneResponseJsonDataObject() {
        try {
            if (SageOneResponseJsonDataObject.classInitialized) {
                this.initialized = true;
            } else {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public SageOneResponseJsonDataObject(final boolean success, final String responseMessage) {
        try {
            if(SageOneResponseJsonDataObject.classInitialized) {
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

    public SageOneResponseJsonDataObject(final boolean success, final String responseMessage, final String responseJson) {
        try {
            if(SageOneResponseJsonDataObject.classInitialized) {
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

    public final void setSuccess(final boolean success) {
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

    public final void setResponseMessage(final String responseMessage) {
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

    public final void setResponseJson(final String responseJson) {
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

    public final void setResponseData(final byte[] responseData) {
        this.responseData = (this.initialized) ? responseData : this.responseData;
    }

    public final byte[] getResponseData() {
        try {
            if (!this.initialized) {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return responseData;
    }

    @Override
    public final String toString() {
        String toString = null;
        if(this.initialized) {

            toString = "AjaxResponseJsonObject{" +
                    " success = " + this.success + "," +
                    " responseMessage = '" + this.responseMessage + "'," +
                    " responseJson = " + this.responseJson + "," +
                    " responseData = \"";

            StringBuilder byteData = new StringBuilder();

            for(byte dataPiece : this.responseData) {
                byteData.append(dataPiece);
            }

            toString += byteData.toString() + "\"}";
        }
        return toString;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
