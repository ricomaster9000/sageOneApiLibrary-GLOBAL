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
 * Created by Ricardo on 2017-07-13.
 */
// Only saveable/updateable with ID and StatusType
public final class SageOneAccountantTask extends SageOneMainEntity {
    private Integer AccountantTaskRecurrenceId;
    private Integer CompanyId;
    private String CompanyName;
    private Integer UserId;
    private String Name;//Required 0-255
    private String Notes;
    private Integer StatusType;
    private Integer ReminderType;
    private Integer ReminderDaysBefore;
    private Boolean AutomaticallyChangeStatusWhenStart;
    private Date NotificationDate;
    private Boolean Notified;
    private Date StartDate;
    private Date EndDate;
    private Integer Duration;

    public final Integer getAccountantTaskRecurrenceId() {
        return (this.isInitialized()) ? this.AccountantTaskRecurrenceId : null;
    }

    public final void setAccountantTaskRecurrenceId(final Integer AccountantTaskRecurrenceId) {
        this.AccountantTaskRecurrenceId = (this.isInitialized()) ? AccountantTaskRecurrenceId : this.AccountantTaskRecurrenceId;
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

    public final Integer getUserId() {
        return (this.isInitialized()) ? this.UserId : null;
    }

    public final void setUserId(final Integer UserId) {
        this.UserId = (this.isInitialized()) ? UserId : this.UserId;
    }

    public final String getName() {
        return (this.isInitialized()) ? this.Name : null;
    }

    public final void setName(final String Name) {
        this.Name = (this.isInitialized()) ? Name : this.Name;
    }

    public final String getNotes() {
        return (this.isInitialized()) ? this.Notes : null;
    }

    public final void setNotes(final String Notes) {
        this.Notes = (this.isInitialized()) ? Notes : this.Notes;
    }

    public final Integer getStatusType() {
        return (this.isInitialized()) ? this.StatusType : null;
    }

    public final void setStatusType(final Integer StatusType) {
        this.StatusType = (this.isInitialized()) ? StatusType : this.StatusType;
    }

    public final Integer getReminderType() {
        return (this.isInitialized()) ? this.ReminderType : null;
    }

    public final void setReminderType(final Integer ReminderType) {
        this.ReminderType = (this.isInitialized()) ? ReminderType : this.ReminderType;
    }

    public final Integer getReminderDaysBefore() {
        return (this.isInitialized()) ? this.ReminderDaysBefore : null;
    }

    public final void setReminderDaysBefore(final Integer ReminderDaysBefore) {
        this.ReminderDaysBefore = (this.isInitialized()) ? ReminderDaysBefore : this.ReminderDaysBefore;
    }

    public final Date getNotificationDate() {
        return (this.isInitialized()) ? this.NotificationDate : null;
    }

    public final void setNotificationDate(final Date NotificationDate) {
        this.NotificationDate = (this.isInitialized()) ? NotificationDate : this.NotificationDate;
    }

    public final Boolean getNotified() {
        return (this.isInitialized()) ? this.Notified : null;
    }

    public final void setNotified(final Boolean Notified) {
        this.Notified = (this.isInitialized()) ? Notified : this.Notified;
    }

    public final Date getStartDate() {
        return (this.isInitialized()) ? this.StartDate : null;
    }

    public final void setStartDate(final Date StartDate) {
        this.StartDate = (this.isInitialized()) ? StartDate : this.StartDate;
    }

    public final Date getEndDate() {
        return (this.isInitialized()) ? this.EndDate : null;
    }

    public final void setEndDate(final Date EndDate) {
        this.EndDate = (this.isInitialized()) ? EndDate : this.EndDate;
    }

    public final Integer getDuration() {
        return (this.isInitialized()) ? this.Duration : null;
    }

    public final void setDuration(final Integer Duration) {
        this.Duration = (this.isInitialized()) ? Duration : this.Duration;
    }
}
