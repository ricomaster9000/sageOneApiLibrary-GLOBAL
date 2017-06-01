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
public final class BankFeedAccount extends MainEntity {
    private int BankFeedAccountGroupId;
    private BankFeedAccountGroup BankFeedAccountGroup;
    private String Description;
    private String Identifier;
    private Date LastRefreshDate;
    private Date FirstImportDate;
    private double Balance;
    private int BankAccountId;
    private String BankAccountName;
    private int LastRefreshStatusId;

    public BankFeedAccount(){
        this.setInitialized(true);
    }

    public int getBankFeedAccountGroupId() {
        return BankFeedAccountGroupId;
    }

    public void setBankFeedAccountGroupId(int bankFeedAccountGroupId) {
        BankFeedAccountGroupId = bankFeedAccountGroupId;
    }

    public BankFeedAccountGroup getBankFeedAccountGroup() {
        return BankFeedAccountGroup;
    }

    public void setBankFeedAccountGroup(BankFeedAccountGroup bankFeedAccountGroup) {
        BankFeedAccountGroup = bankFeedAccountGroup;
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

    public int getBankAccountId() {
        return BankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        BankAccountId = bankAccountId;
    }

    public String getBankAccountName() {
        return BankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        BankAccountName = bankAccountName;
    }

    public int getLastRefreshStatusId() {
        return LastRefreshStatusId;
    }

    public void setLastRefreshStatusId(int lastRefreshStatusId) {
        LastRefreshStatusId = lastRefreshStatusId;
    }

    @Override
    public String toString() {
        return "BankFeedAccount{" +
                "BankFeedAccountGroupId=" + BankFeedAccountGroupId +
                ", BankFeedAccountGroup=" + BankFeedAccountGroup +
                ", Description='" + Description + '\'' +
                ", Identifier='" + Identifier + '\'' +
                ", LastRefreshDate=" + LastRefreshDate +
                ", FirstImportDate=" + FirstImportDate +
                ", Balance=" + Balance +
                ", BankAccountId=" + BankAccountId +
                ", BankAccountName='" + BankAccountName + '\'' +
                ", LastRefreshStatusId=" + LastRefreshStatusId +
                '}';
    }
}
