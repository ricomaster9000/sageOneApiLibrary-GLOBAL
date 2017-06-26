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

/**
 * Created by brent on 2017/05/31.
 */
public final class SageOneBankFeedAccount extends SageOneMainEntity {
    private Integer BankFeedAccountGroupId;
    private SageOneBankFeedAccountGroup SageOneBankFeedAccountGroup;
    private String Description;
    private String Identifier;
    private Date LastRefreshDate;
    private Date FirstImportDate;
    private double Balance;
    private Integer BankAccountId;
    private String BankAccountName;
    private Integer LastRefreshStatusId;

    public SageOneBankFeedAccount(){
        this.setInitialized(true);
    }

    public Integer getBankFeedAccountGroupId() {
        return BankFeedAccountGroupId;
    }

    public void setBankFeedAccountGroupId(Integer bankFeedAccountGroupId) {
        BankFeedAccountGroupId = bankFeedAccountGroupId;
    }

    public SageOneBankFeedAccountGroup getSageOneBankFeedAccountGroup() {
        return SageOneBankFeedAccountGroup;
    }

    public void setSageOneBankFeedAccountGroup(SageOneBankFeedAccountGroup sageOneBankFeedAccountGroup) {
        SageOneBankFeedAccountGroup = sageOneBankFeedAccountGroup;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public Date getLastRefreshDate() {
        return LastRefreshDate;
    }

    public void setLastRefreshDate(Date lastRefreshDate) {
        LastRefreshDate = lastRefreshDate;
    }

    public Date getFirstImportDate() {
        return FirstImportDate;
    }

    public void setFirstImportDate(Date firstImportDate) {
        FirstImportDate = firstImportDate;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public Integer getBankAccountId() {
        return BankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        BankAccountId = bankAccountId;
    }

    public String getBankAccountName() {
        return BankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        BankAccountName = bankAccountName;
    }

    public Integer getLastRefreshStatusId() {
        return LastRefreshStatusId;
    }

    public void setLastRefreshStatusId(Integer lastRefreshStatusId) {
        LastRefreshStatusId = lastRefreshStatusId;
    }
}
