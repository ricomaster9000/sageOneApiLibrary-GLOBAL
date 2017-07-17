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

public final class SageOneAccountantTaskRecurrence extends SageOneMainEntity {
    private Integer CompanyId;
    private Integer FrequencyType;
    private Integer FrequencyInterval;
    private Integer FrequencyRelativeInterval;
    private Integer FrequencyRecurrenceFactor;
    private Integer FrequencyYearlyMonth;
    private Integer RecurrenceRangeType;
    private Date StartDate;
    private Date EndDate;
    private Integer NumberOfOccurrences;
    private Integer TaskDuration;

    public final Integer getCompanyId() {
        return (this.isInitialized()) ? this.CompanyId : null;
    }

    public final void setCompanyId(final Integer CompanyId) {
        this.CompanyId = (this.isInitialized()) ? CompanyId : this.CompanyId;
    }

    public final Integer getFrequencyType() {
        return (this.isInitialized()) ? this.FrequencyType : null;
    }

    public final void setFrequencyType(final Integer FrequencyType) {
        this.FrequencyType = (this.isInitialized()) ? FrequencyType : this.FrequencyType;
    }

    public final Integer getFrequencyInterval() {
        return (this.isInitialized()) ? this.FrequencyInterval : null;
    }

    public final void setFrequencyInterval(final Integer FrequencyInterval) {
        this.FrequencyInterval = (this.isInitialized()) ? FrequencyInterval : this.FrequencyInterval;
    }

    public final Integer getFrequencyRelativeInterval() {
        return (this.isInitialized()) ? this.FrequencyRelativeInterval : null;
    }

    public final void setFrequencyRelativeInterval(final Integer FrequencyRelativeInterval) {
        this.FrequencyRelativeInterval = (this.isInitialized()) ? FrequencyRelativeInterval : this.FrequencyRelativeInterval;
    }

    public final Integer getFrequencyRecurrenceFactor() {
        return (this.isInitialized()) ? this.FrequencyRecurrenceFactor : null;
    }

    public final void setFrequencyRecurrenceFactor(final Integer FrequencyRecurrenceFactor) {
        this.FrequencyRecurrenceFactor = (this.isInitialized()) ? FrequencyRecurrenceFactor : this.FrequencyRecurrenceFactor;
    }

    public final Integer getFrequencyYearlyMonth() {
        return (this.isInitialized()) ? this.FrequencyYearlyMonth : null;
    }

    public final void setFrequencyYearlyMonth(final Integer FrequencyYearlyMonth) {
        this.FrequencyYearlyMonth = (this.isInitialized()) ? FrequencyYearlyMonth : this.FrequencyYearlyMonth;
    }

    public final Integer getRecurrenceRangeType() {
        return (this.isInitialized()) ? this.RecurrenceRangeType : null;
    }

    public final void setRecurrenceRangeType(final Integer RecurrenceRangeType) {
        this.RecurrenceRangeType = (this.isInitialized()) ? RecurrenceRangeType : this.RecurrenceRangeType;
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

    public final Integer getNumberOfOccurrences() {
        return (this.isInitialized()) ? this.NumberOfOccurrences : null;
    }

    public final void setNumberOfOccurrences(final Integer NumberOfOccurrences) {
        this.NumberOfOccurrences = (this.isInitialized()) ? NumberOfOccurrences : this.NumberOfOccurrences;
    }

    public final Integer getTaskDuration() {
        return (this.isInitialized()) ? this.TaskDuration : null;
    }

    public final void setTaskDuration(final Integer TaskDuration) {
        this.TaskDuration = (this.isInitialized()) ? TaskDuration : this.TaskDuration;
    }
}
