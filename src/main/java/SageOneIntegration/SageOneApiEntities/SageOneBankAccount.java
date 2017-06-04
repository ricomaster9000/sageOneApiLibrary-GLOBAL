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

import SageOneIntegration.SageOneApiEntities.SageEnum.PaymentMethod;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * Created by brent on 2017/05/31.
 */
@JsonDeserialize(builder = SageOneBankAccount.Builder.class)
public final class SageOneBankAccount {
    //String length: inclusive between 0 and 100
    private final int id;
    private final String Name;
    private final String BankName;
    private final String AccountNumber;
    private final String BranchName;
    private final String BranchNumber;
    //-------------------------------------
    private final SageOneBankAccountCategory Category;
    private final boolean Active;
    private final boolean Default;
    private final double Balance;
    //String length: inclusive between 0 and 4000
    private final String Description;
    private final SageOneBankFeedAccount SageOneBankFeedAccount;
    private final Date LastTransactionDate;
    private final Date LastImportDate;
    private final boolean HasTransactionsWaitingForReview;
    private final int DefaultPaymentMethodId;
    private final PaymentMethod PaymentMethod;
    private final Date Modified;
    private final Date Created;
    private final int CurrencyId;

    public SageOneBankAccount(Builder builder) {
        this.id = builder.getId();
        Name = builder.Name;
        BankName = builder.BankName;
        AccountNumber = builder.AccountNumber;
        BranchName = builder.BranchName;
        BranchNumber = builder.BranchNumber;
        Category = builder.Category;
        Active = builder.Active;
        Default = builder.Default;
        Balance = builder.Balance;
        Description = builder.Description;
        SageOneBankFeedAccount = builder.SageOneBankFeedAccount;
        LastTransactionDate = builder.LastTransactionDate;
        LastImportDate = builder.LastImportDate;
        HasTransactionsWaitingForReview = builder.HasTransactionsWaitingForReview;
        DefaultPaymentMethodId = builder.DefaultPaymentMethodId;
        PaymentMethod = builder.PaymentMethod;
        Modified = builder.Modified;
        Created = builder.Created;
        CurrencyId = builder.CurrencyId;
    }

    public static class Builder extends MainEntity{
        private String Name;
        private String BankName;
        private String AccountNumber;
        private String BranchName;
        private String BranchNumber;
        private SageOneBankAccountCategory Category;
        private boolean         Active;
        private boolean         Default;
        private double Balance;
        private String Description;
        private SageOneBankFeedAccount SageOneBankFeedAccount;
        private Date         LastTransactionDate;
        private Date         LastImportDate;
        private boolean         HasTransactionsWaitingForReview;
        private int DefaultPaymentMethodId;
        private PaymentMethod PaymentMethod;
        private Date Modified;
        private Date Created;
        private int CurrencyId;

        public Builder withId(final int val){
            setId(val);
            return this;
        }

        public Builder withName(final String val){
            Name = (this.isInitialized()) ? val:Name;
            return this;
        }

        public Builder withBankName(final String val){
            BankName = (this.isInitialized()) ? val:BankName;
            return this;
        }

        public Builder withAccountNumber(final String val){
            AccountNumber = (this.isInitialized()) ? val:AccountNumber;
            return this;
        }

        public Builder withBranchName(final String val){
            BranchName = (this.isInitialized()) ? val:BranchName;
            return this;
        }

        public Builder withBranchNumber(final String val){
            BranchNumber = (this.isInitialized()) ? val:BranchNumber;
            return this;
        }

        public Builder withCategory(final SageOneBankAccountCategory val){
            Category = (this.isInitialized()) ? val:Category;
            return this;
        }

        public Builder withActive(final boolean val){
            Active = (this.isInitialized()) ? val:Active;
            return this;
        }

        public Builder withDefault(final boolean val){
            Default = (this.isInitialized()) ? val:Default;
            return this;
        }

        public Builder withBalance(final double val){
            Balance = (this.isInitialized()) ? val:Balance;
            return this;
        }

        public Builder withDescription(final String val){
            Description = (this.isInitialized()) ? val:Description;
            return this;
        }

        public Builder withBankFeedAccount(final SageOneBankFeedAccount val){
            SageOneBankFeedAccount = (this.isInitialized()) ? val: SageOneBankFeedAccount;
            return this;
        }

        public Builder withLastTransactionDate(final Date val){
            LastTransactionDate = (this.isInitialized()) ? val:LastTransactionDate;
            return this;
        }


        public Builder withLastImportDate(final Date val){
            LastImportDate = (this.isInitialized()) ? val:LastImportDate;
            return this;
        }


        public Builder withHasTransactionsWaitingForReview(final boolean val){
            HasTransactionsWaitingForReview = (this.isInitialized()) ? val:HasTransactionsWaitingForReview;
            return this;
        }


        public Builder withDefaultPaymentMethodId(final int val){
            DefaultPaymentMethodId = (this.isInitialized()) ? val:DefaultPaymentMethodId;
            return this;
        }


        public Builder withPaymentMethod(final PaymentMethod val){
            PaymentMethod = (this.isInitialized()) ? val:PaymentMethod;
            return this;
        }

        public Builder withModified(final Date val){
            Modified = (this.isInitialized()) ? val:Modified;
            return this;
        }

        public Builder withCreated(final Date val){
            Created = (this.isInitialized()) ? val:Created;
            return this;
        }

        public Builder withCurrencyId(final int val){
            CurrencyId = (this.isInitialized()) ? val:CurrencyId;
            return this;
        }

       public SageOneBankAccount build(){
            return new SageOneBankAccount(this);
       }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getBankName() {
        return BankName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getBranchName() {
        return BranchName;
    }

    public String getBranchNumber() {
        return BranchNumber;
    }

    public SageOneBankAccountCategory getCategory() {
        return Category;
    }

    public boolean isActive() {
        return Active;
    }

    public boolean isDefault() {
        return Default;
    }

    public double getBalance() {
        return Balance;
    }

    public String getDescription() {
        return Description;
    }

    public SageOneBankFeedAccount getSageOneBankFeedAccount() {
        return SageOneBankFeedAccount;
    }

    public Date getLastTransactionDate() {
        return LastTransactionDate;
    }

    public Date getLastImportDate() {
        return LastImportDate;
    }

    public boolean isHasTransactionsWaitingForReview() {
        return HasTransactionsWaitingForReview;
    }

    public int getDefaultPaymentMethodId() {
        return DefaultPaymentMethodId;
    }

    public PaymentMethod getPaymentMethod() {
        return PaymentMethod;
    }

    public Date getModified() {
        return Modified;
    }

    public Date getCreated() {
        return Created;
    }

    public int getCurrencyId() {
        return CurrencyId;
    }

    @Override
    public String toString() {
        return "SageOneBankAccount{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", BankName='" + BankName + '\'' +
                ", AccountNumber='" + AccountNumber + '\'' +
                ", BranchName='" + BranchName + '\'' +
                ", BranchNumber='" + BranchNumber + '\'' +
                ", Category=" + Category +
                ", Active=" + Active +
                ", Default=" + Default +
                ", Balance=" + Balance +
                ", Description='" + Description + '\'' +
                ", SageOneBankFeedAccount=" + SageOneBankFeedAccount +
                ", LastTransactionDate=" + LastTransactionDate +
                ", LastImportDate=" + LastImportDate +
                ", HasTransactionsWaitingForReview=" + HasTransactionsWaitingForReview +
                ", DefaultPaymentMethodId=" + DefaultPaymentMethodId +
                ", PaymentMethod=" + PaymentMethod +
                ", Modified=" + Modified +
                ", Created=" + Created +
                ", CurrencyId=" + CurrencyId +
                '}';
    }
}
