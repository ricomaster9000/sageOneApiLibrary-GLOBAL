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
package SageOneIntegration.SageOneApiEntities.V1_1_2;


import java.util.Date;

public final class SageOneAccountantNote extends SageOneMainEntity {
    private String Subject;
    private Date EntryDate;
    private Date ActionDate;
    private Integer Status;
    private String Note;
    private Boolean HasAttachments;
    private Integer UserId;
    private Integer CompanyId;
    private String CompanyName;
    private String ToAccountant;
    private String StatusText;
    private Integer CreatedByUserId;
    private String CreatedBy;
    private String LastModified;
    private Integer CategoryId;
    private String Category;
    private Integer DocumentHeaderId;
    private Boolean IsOwner;

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

    public final Integer getStatus() {
        return (this.isInitialized()) ? this.Status : null;
    }

    public final void setStatus(final Integer Status) {
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

    public final Integer getUserId() {
        return (this.isInitialized()) ? this.UserId : null;
    }

    public final void setUserId(final Integer UserId) {
        this.UserId = (this.isInitialized()) ? UserId : this.UserId;
    }

    public final Integer getCompanyId() {
        return (this.isInitialized()) ? this.CompanyId : null;
    }

    public final void setCompanyId(final Integer CompanyId) {
        this.CompanyId = (this.isInitialized()) ? CompanyId : this.CompanyId;
    }

    public final String getCompanyName() {
        return (this.isInitialized()) ? this.CompanyName : null;
    }

    public final void setCompanyName(final String CompanyName) {
        this.CompanyName = (this.isInitialized()) ? CompanyName : this.CompanyName;
    }

    public final String getToAccountant() {
        return (this.isInitialized()) ? this.ToAccountant : null;
    }

    public final void setToAccountant(final String ToAccountant) {
        this.ToAccountant = (this.isInitialized()) ? ToAccountant : this.ToAccountant;
    }

    public final String getStatusText() {
        return (this.isInitialized()) ? this.StatusText : null;
    }

    public final void setStatusText(final String StatusText) {
        this.StatusText = (this.isInitialized()) ? StatusText : this.StatusText;
    }

    public final Integer getCreatedByUserId() {
        return (this.isInitialized()) ? this.CreatedByUserId : null;
    }

    public final void setCreatedByUserId(final Integer CreatedByUserId) {
        this.CreatedByUserId = (this.isInitialized()) ? CreatedByUserId : this.CreatedByUserId;
    }

    public final String getCreatedBy() {
        return (this.isInitialized()) ? this.CreatedBy : null;
    }

    public final void setCreatedBy(final String CreatedBy) {
        this.CreatedBy = (this.isInitialized()) ? CreatedBy : this.CreatedBy;
    }

    public final String getLastModified() {
        return (this.isInitialized()) ? this.LastModified : null;
    }

    public final void setLastModified(final String LastModified) {
        this.LastModified = (this.isInitialized()) ? LastModified : this.LastModified;
    }

    public final Integer getCategoryId() {
        return (this.isInitialized()) ? this.CategoryId : null;
    }

    public final void setCategoryId(final Integer CategoryId) {
        this.CategoryId = (this.isInitialized()) ? CategoryId : this.CategoryId;
    }

    public final String getCategory() {
        return (this.isInitialized()) ? this.Category : null;
    }

    public final void setCategory(final String Category) {
        this.Category = (this.isInitialized()) ? Category : this.Category;
    }

    public final Integer getDocumentHeaderId() {
        return (this.isInitialized()) ? this.DocumentHeaderId : null;
    }

    public final void setDocumentHeaderId(final Integer DocumentHeaderId) {
        this.DocumentHeaderId = (this.isInitialized()) ? DocumentHeaderId : this.DocumentHeaderId;
    }

    public final Boolean getIsOwner() {
        return (this.isInitialized()) ? this.IsOwner : null;
    }

    public final void setIsOwner(final Boolean IsOwner) {
        this.IsOwner = (this.isInitialized()) ? IsOwner : this.IsOwner;
    }
}
