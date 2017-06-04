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
package SageOneIntegration.SageOneApiEntities;

import java.util.Date;

/**
 * Created by brent on 2017/05/31.
 */
public final class SageOneSalesRepresentative extends SageOneMainEntity {
    //String length: inclusive between 0 and 50
    private String FirstName;
    //String length: inclusive between 0 and 50
    private String LastName;
    private String Name;
    private boolean Active;
    private String Email;
    //String length: inclusive between 0 and 30
    private String Mobile;
    //String length: inclusive between 0 and 30
    private String Telephone;
    private Date Created;
    private Date Modified;

    public SageOneSalesRepresentative() {
        this.setInitialized(true);
    }

    public String getFirstName() {
        return (this.isInitialized()) ? FirstName: "";
    }

    public void setFirstName(String firstName) {
        FirstName = (this.isInitialized()) ? firstName: this.FirstName;
    }

    public String getLastName() {
        return (this.isInitialized()) ? LastName: "";
    }

    public void setLastName(String lastName) {
        LastName = (this.isInitialized()) ? lastName: this.LastName;
    }

    public String getName() {
        return (this.isInitialized()) ? Name: "";
    }

    public void setName(String name) {
        Name = (this.isInitialized()) ? name: this.Name;
    }

    public boolean isActive() {
        return (this.isInitialized()) && this.Active;
    }

    public void setActive(boolean active) {
        Active = (this.isInitialized()) ? active: this.Active;
    }

    public String getEmail() {
        return (this.isInitialized()) ? Email: "";
    }

    public void setEmail(String email) {
        Email = (this.isInitialized()) ? email: this.Email;
    }

    public String getMobile() {
        return (this.isInitialized()) ? Mobile: "";
    }

    public void setMobile(String mobile) {
        Mobile = (this.isInitialized()) ? mobile: this.Email;
    }

    public String getTelephone() {
        return (this.isInitialized()) ? Telephone: "";
    }

    public void setTelephone(String telephone) {
        Telephone = (this.isInitialized()) ? telephone: this.Telephone;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }

    public Date getModified() {
        return Modified;
    }

    public void setModified(Date modified) {
        Modified = (this.isInitialized()) ? modified:this.Modified;
    }

    @Override
    public String toString() {
        return "SageOneSalesRepresentative{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Name='" + Name + '\'' +
                ", Active=" + Active +
                ", Email='" + Email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Created=" + Created +
                ", Modified=" + Modified +
                '}';
    }
}
