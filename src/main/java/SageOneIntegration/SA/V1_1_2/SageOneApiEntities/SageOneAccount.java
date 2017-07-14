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

public final class SageOneAccount extends SageOneMainEntity {
    private String Name;
    private SageOneAccountCategory Category;
    private Boolean Active;
    private double Balance;
    private String Description;
    private Boolean UnallocatedAccount;
    private Boolean IsTaxLocked;
    private Date Modified;
    private Date Created;
    private Integer AccountType;
    private Boolean HasActivity;
    private Integer DefaultTaxTypeId;
    private SageOneTaxType DefaultTaxType;

    public final String getName() {
        return (this.isInitialized()) ? this.Name : null;
    }

    public final void setName(final String Name) {
        this.Name = (this.isInitialized()) ? Name : this.Name;
    }

    public final SageOneAccountCategory getCategory() {
        return (this.isInitialized()) ? this.Category : null;
    }

    public final void setCategory(final SageOneAccountCategory Category) {
        this.Category = (this.isInitialized()) ? Category : this.Category;
    }

    public final Boolean getActive() {
        return (this.isInitialized()) ? this.Active : null;
    }

    public final void setActive(final Boolean Active) {
        this.Active = (this.isInitialized()) ? Active : this.Active;
    }

    public final double getBalance() {
        return (this.isInitialized()) ? this.Balance : null;
    }

    public final void setBalance(final double Balance) {
        this.Balance = (this.isInitialized()) ? Balance : this.Balance;
    }

    public final String getDescription() {
        return (this.isInitialized()) ? this.Description : null;
    }

    public final void setDescription(final String Description) {
        this.Description = (this.isInitialized()) ? Description : this.Description;
    }

    public final Boolean getUnallocatedAccount() {
        return (this.isInitialized()) ? this.UnallocatedAccount : null;
    }

    public final void setUnallocatedAccount(final Boolean UnallocatedAccount) {
        this.UnallocatedAccount = (this.isInitialized()) ? UnallocatedAccount : this.UnallocatedAccount;
    }

    public final Boolean getIsTaxLocked() {
        return (this.isInitialized()) ? this.IsTaxLocked : null;
    }

    public final void setIsTaxLocked(final Boolean IsTaxLocked) {
        this.IsTaxLocked = (this.isInitialized()) ? IsTaxLocked : this.IsTaxLocked;
    }

    public final Date getModified() {
        return (this.isInitialized()) ? this.Modified : null;
    }

    public final void setModified(final Date Modified) {
        this.Modified = (this.isInitialized()) ? Modified : this.Modified;
    }

    public final Date getCreated() {
        return (this.isInitialized()) ? this.Created : null;
    }

    public final void setCreated(final Date Created) {
        this.Created = (this.isInitialized()) ? Created : this.Created;
    }

    public final Integer getAccountType() {
        return (this.isInitialized()) ? this.AccountType : null;
    }

    public final void setAccountType(final Integer AccountType) {
        this.AccountType = (this.isInitialized()) ? AccountType : this.AccountType;
    }

    public final Boolean getHasActivity() {
        return (this.isInitialized()) ? this.HasActivity : null;
    }

    public final void setHasActivity(final Boolean HasActivity) {
        this.HasActivity = (this.isInitialized()) ? HasActivity : this.HasActivity;
    }

    public final Integer getDefaultTaxTypeId() {
        return (this.isInitialized()) ? this.DefaultTaxTypeId : null;
    }

    public final void setDefaultTaxTypeId(final Integer DefaultTaxTypeId) {
        this.DefaultTaxTypeId = (this.isInitialized()) ? DefaultTaxTypeId : this.DefaultTaxTypeId;
    }

    public final SageOneTaxType getDefaultTaxType() {
        return (this.isInitialized()) ? this.DefaultTaxType : null;
    }

    public final void setDefaultTaxType(final SageOneTaxType DefaultTaxType) {
        this.DefaultTaxType = (this.isInitialized()) ? DefaultTaxType : this.DefaultTaxType;
    }
}
