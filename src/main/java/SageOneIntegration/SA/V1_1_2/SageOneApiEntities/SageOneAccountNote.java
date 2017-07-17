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
package SageOneIntegration.SA.V1_1_2.SageOneApiEntities;

import java.util.Date;

/**
 * Created by Ricardo on 2017-07-15.
 */
public final class SageOneAccountNote extends SageOneMainEntity {//ID required
    private Integer AccountId;
    private Integer UserId;
    private String Subject; //Required, between 0 and 100
    private Date EntryDate;
    private Date ActionDate; //Required
    private Boolean Status;
    private String Note;
    private Boolean HasAttachments;

    public final Integer getAccountId() {
        return (this.isInitialized()) ? this.AccountId : null;
    }

    public final void setAccountId(final Integer AccountId) {
        this.AccountId = (this.isInitialized()) ? AccountId : this.AccountId;
    }

    public final Integer getUserId() {
        return (this.isInitialized()) ? this.UserId : null;
    }

    public final void setUserId(final Integer UserId) {
        this.UserId = (this.isInitialized()) ? UserId : this.UserId;
    }

    public final String getSubject() {
        return (this.isInitialized()) ? this.Subject : null;
    }

    public final void setSubject(final String Subject) {
        this.Subject = (this.isInitialized()) ? Subject : this.Subject;
    }

    public final Date getEntryDate() {
        return (this.isInitialized()) ? this.EntryDate : null;
    }

    public final void setEntryDate(final Date EntryDate) {
        this.EntryDate = (this.isInitialized()) ? EntryDate : this.EntryDate;
    }

    public final Date getActionDate() {
        return (this.isInitialized()) ? this.ActionDate : null;
    }

    public final void setActionDate(final Date ActionDate) {
        this.ActionDate = (this.isInitialized()) ? ActionDate : this.ActionDate;
    }

    public final Boolean getStatus() {
        return (this.isInitialized()) ? this.Status : null;
    }

    public final void setStatus(final Boolean Status) {
        this.Status = (this.isInitialized()) ? Status : this.Status;
    }

    public final String getNote() {
        return (this.isInitialized()) ? this.Note : null;
    }

    public final void setNote(final String Note) {
        this.Note = (this.isInitialized()) ? Note : this.Note;
    }

    public final Boolean getHasAttachments() {
        return (this.isInitialized()) ? this.HasAttachments : null;
    }

    public final void setHasAttachments(final Boolean HasAttachments) {
        this.HasAttachments = (this.isInitialized()) ? HasAttachments : this.HasAttachments;
    }

}
