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

import java.sql.Date;

/**
 * Created by ricomaster9000 on 2017/06/09.
 */
public final class SageOneSupplierNote extends SageOneMainEntity {
    private Integer SupplierId;
    private Integer UserId;
    private Integer Priority;
    private Integer NoteCategoryId;
    private Boolean NotifyAssignee;
    private String Subject;
    private Date EntryDate;
    private Date ActionDate;
    private Boolean Status;
    private String Note;
    private Boolean HasAttachments;

    public SageOneSupplierNote() {

    }

    public final Integer getSupplierId() {
        return (this.isInitialized()) ? this.SupplierId: null;
    }

    public final void setSupplierId(final Integer SupplierId) {
        this.SupplierId = (this.isInitialized()) ? SupplierId : this.SupplierId;
    }

    public final Integer getUserId() {
        return (this.isInitialized()) ? this.UserId : null;
    }

    public final void setUserId(final Integer UserId) {
        this.UserId = (this.isInitialized()) ? UserId : this.UserId;
    }

    public final Integer getPriority() {
        return (this.isInitialized()) ? this.Priority : null;
    }

    public final void setPriority(final Integer Priority) {
        this.Priority = (this.isInitialized()) ? Priority : this.Priority;
    }

    public final Integer getNoteCategoryId() {
        return (this.isInitialized()) ? this.NoteCategoryId : null;
    }

    public final void setNoteCategoryId(final Integer NoteCategoryId) {
        this.NoteCategoryId = (this.isInitialized()) ? NoteCategoryId : this.NoteCategoryId;
    }

    public final Boolean getNotifyAssignee() {
        return (this.isInitialized()) ? this.NotifyAssignee : null;
    }

    public final void setNotifyAssignee(final Boolean NotifyAssignee) {
        this.NotifyAssignee = (this.isInitialized()) ? NotifyAssignee : this.NotifyAssignee;
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
