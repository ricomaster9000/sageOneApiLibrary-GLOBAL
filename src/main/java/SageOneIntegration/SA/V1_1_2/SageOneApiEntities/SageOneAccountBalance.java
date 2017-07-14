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

import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOneAccountType;

import java.util.Date;


public final class SageOneAccountBalance extends SageOneMainEntity {
    private SageOneAccountType Type;
    private Date Date;
    private String Description;
    private Integer CategoryId;
    private String CategoryDescription;
    private Integer AnalysisCategoryId;
    private String AnalysisCategoryDescription;
    private Double Debit;
    private Double Credit;
    private Double Total;
    private SageOneBudgetItemPeriod[] BudgetItemPeriods;

    public final SageOneAccountType getType() {
        return (this.isInitialized()) ? this.Type : null;
    }

    public final void setType(final SageOneAccountType Type) {
        this.Type = (this.isInitialized()) ? Type : this.Type;
    }

    public final Date getDate() {
        return (this.isInitialized()) ? this.Date : null;
    }

    public final void setDate(final Date Date) {
        this.Date = (this.isInitialized()) ? Date : this.Date;
    }

    public final String getDescription() {
        return (this.isInitialized()) ? this.Description : null;
    }

    public final void setDescription(final String Description) {
        this.Description = (this.isInitialized()) ? Description : this.Description;
    }

    public final Integer getCategoryId() {
        return (this.isInitialized()) ? this.CategoryId : null;
    }

    public final void setCategoryId(final Integer CategoryId) {
        this.CategoryId = (this.isInitialized()) ? CategoryId : this.CategoryId;
    }

    public final String getCategoryDescription() {
        return (this.isInitialized()) ? this.CategoryDescription : null;
    }

    public final void setCategoryDescription(final String CategoryDescription) {
        this.CategoryDescription = (this.isInitialized()) ? CategoryDescription : this.CategoryDescription;
    }

    public final Integer getAnalysisCategoryId() {
        return (this.isInitialized()) ? this.AnalysisCategoryId : null;
    }

    public final void setAnalysisCategoryId(final Integer AnalysisCategoryId) {
        this.AnalysisCategoryId = (this.isInitialized()) ? AnalysisCategoryId : this.AnalysisCategoryId;
    }

    public final Double getDebit() {
        return (this.isInitialized()) ? this.Debit : null;
    }

    public final void set(final Double Debit) {
        this.Debit = (this.isInitialized()) ? Debit : this.Debit;
    }

    public final Double getCredit() {
        return (this.isInitialized()) ? this.Credit : null;
    }

    public final void setCredit(final Double Credit) {
        this.Credit = (this.isInitialized()) ? Credit : this.Credit;
    }

    public final Double getTotal() {
        return (this.isInitialized()) ? this.Total : null;
    }

    public final void setTotal(final Double Total) {
        this.Total = (this.isInitialized()) ? Total : this.Total;
    }

    public final SageOneBudgetItemPeriod[] getBudgetItemPeriods() {
        return (this.isInitialized()) ? this.BudgetItemPeriods : null;
    }

    public final void setBudgetItemPeriods(final SageOneBudgetItemPeriod[] BudgetItemPeriods) {
        this.BudgetItemPeriods = (this.isInitialized()) ? BudgetItemPeriods : this.BudgetItemPeriods;
    }
}
