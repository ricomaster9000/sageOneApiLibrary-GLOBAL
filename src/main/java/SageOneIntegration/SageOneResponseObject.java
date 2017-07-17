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

public final class SageOneResponseObject {
    private boolean success = false;
    private String responseMessage = "";
    private Object responseObject;
    private int totalResponseObjects = 0;
    private static boolean classInitialized = false;
    private boolean initialized = false;

    public static void initializeClass() {
        SageOneResponseObject.classInitialized = true;
    }
    public static void deInitializeClass() { SageOneResponseObject.classInitialized = false; }

    public SageOneResponseObject() {
        try {
            if (SageOneResponseObject.classInitialized) {
                this.initialized = true;
            } else {
                throw new ClassNotFoundException("Cannot access class, initialize before usage");
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public SageOneResponseObject(final boolean success, final Object responseObject) {
        try {
            if(SageOneResponseObject.classInitialized) {
                this.initialized = true;
                this.success = success;
                this.responseObject = responseObject;
            } else {
                throw new ClassNotFoundException("Cannot access class, initialize before usage");
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public SageOneResponseObject(final boolean success, final Object responseObject,
                          final int totalResponseObjects) {
        try {
            if(SageOneResponseObject.classInitialized) {
                this.initialized = true;
                this.success = success;
                this.responseObject = responseObject;
                this.totalResponseObjects = totalResponseObjects;
            } else {
                throw new ClassNotFoundException("Cannot access class, initialize before usage");
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public SageOneResponseObject(final boolean success, final String responseMessage) {
        try {
            if(SageOneResponseObject.classInitialized) {
                this.initialized = true;
                this.success = success;
                this.responseMessage = responseMessage;
            } else {
                throw new ClassNotFoundException("Cannot access class, initialize before usage");
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public SageOneResponseObject(final boolean success, final String responseMessage, final Object responseObject) {
        try {
            if(SageOneResponseObject.classInitialized) {
                this.initialized = true;
                this.success = success;
                this.responseMessage = responseMessage;
                this.responseObject = responseObject;
            } else {
                throw new ClassNotFoundException("Cannot access class, initialize before usage");
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public SageOneResponseObject(final boolean success, final String responseMessage, final Object responseObject,
                          final int totalResponseObjects) {
        try {
            if(SageOneResponseObject.classInitialized) {
                this.initialized = true;
                this.success = success;
                this.responseMessage = responseMessage;
                this.responseObject = responseObject;
                this.totalResponseObjects = totalResponseObjects;
            } else {
                throw new ClassNotFoundException("Cannot access class, initialize before usage");
            }
        } catch(ClassNotFoundException e) {
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
        return this.success;
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
        return this.responseMessage;
    }

    public final void setResponseObject(final Object responseObject) {
        this.responseObject = (this.initialized) ? responseObject : this.responseObject;
    }

    public final Object getResponseObject() {
        try {
            if (!this.initialized) {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return this.responseObject;
    }

    public final void setTotalResponseObjects(final int totalResponseObjects) {
        this.totalResponseObjects = (this.initialized) ? totalResponseObjects : this.totalResponseObjects;
    }

    public final int getTotalResponseObjects() {
        try {
            if (!this.initialized) {
                throw new Exception("Cannot access class");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return this.totalResponseObjects;
    }

    @Override
    public final String toString() {
        return (this.initialized) ? "AjaxResponseJsonObject{" +
                " success = " + success + "," +
                " responseMessage = '" + responseMessage + "'," +
                " responseObject = " + responseObject + "," +
                "}" : null;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
