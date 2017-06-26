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

import SageOneIntegration.SageOneApiEntities.V1_1_2.SageEnum.SageOnePaymentMethod;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;


@JsonDeserialize(builder = SageOneBankAccount.Builder.class)
public final class SageOneBankAccount {
    //String length: inclusive between 0 and 100
    private final Integer ID;
    private final String Name;
    private final String BankName;
    private final String AccountNumber;
    private final String BranchName;
    private final String BranchNumber;
    //-------------------------------------
    private final SageOneBankAccountCategory Category;
    private final Boolean Active;
    private final Boolean Default;
    private final double Balance;
    //String length: inclusive between 0 and 4000
    private final String Description;
    private final SageOneBankFeedAccount BankFeedAccount;
    private final Date LastTransactionDate;
    private final Date LastImportDate;
    private final Boolean HasTransactionsWaitingForReview;
    private final Integer DefaultPaymentMethodId;
    private final SageOnePaymentMethod PaymentMethod;
    private final Date Modified;
    private final Date Created;
    private final Integer CurrencyId;

    public SageOneBankAccount(Builder builder) {
        ID = builder.ID;
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
        BankFeedAccount = builder.BankFeedAccount;
        LastTransactionDate = builder.LastTransactionDate;
        LastImportDate = builder.LastImportDate;
        HasTransactionsWaitingForReview = builder.HasTransactionsWaitingForReview;
        DefaultPaymentMethodId = builder.DefaultPaymentMethodId;
        PaymentMethod = builder.PaymentMethod;
        Modified = builder.Modified;
        Created = builder.Created;
        CurrencyId = builder.CurrencyId;
    }

    public static class Builder {
        private Integer ID;
        private String Name;
        private String BankName;
        private String AccountNumber;
        private String BranchName;
        private String BranchNumber;
        private SageOneBankAccountCategory Category;
        private Boolean         Active;
        private Boolean         Default;
        private double Balance;
        private String Description;
        private SageOneBankFeedAccount BankFeedAccount;
        private Date         LastTransactionDate;
        private Date         LastImportDate;
        private Boolean         HasTransactionsWaitingForReview;
        private Integer DefaultPaymentMethodId;
        private SageOnePaymentMethod PaymentMethod;
        private Date Modified;
        private Date Created;
        private Integer CurrencyId;

        public Builder withId(final Integer val){
            ID = val;
            return this;
        }

        public Builder withName(final String val){
            Name = val;
            return this;
        }

        public Builder withBankName(final String val){
            BankName = val;
            return this;
        }

        public Builder withAccountNumber(final String val){
            AccountNumber = val;
            return this;
        }

        public Builder withBranchName(final String val){
            BranchName = val;
            return this;
        }

        public Builder withBranchNumber(final String val){
            BranchNumber = val;
            return this;
        }

        public Builder withCategory(final SageOneBankAccountCategory val){
            Category = val;
            return this;
        }

        public Builder withActive(final Boolean val){
            Active = val;
            return this;
        }

        public Builder withDefault(final Boolean val){
            Default = val;
            return this;
        }

        public Builder withBalance(final double val){
            Balance = val;
            return this;
        }

        public Builder withDescription(final String val){
            Description = val;
            return this;
        }

        public Builder withBankFeedAccount(final SageOneBankFeedAccount val){
            BankFeedAccount = val;
            return this;
        }

        public Builder withLastTransactionDate(final Date val){
            LastTransactionDate = val;
            return this;
        }


        public Builder withLastImportDate(final Date val){
            LastImportDate = val;
            return this;
        }


        public Builder withHasTransactionsWaitingForReview(final Boolean val){
            HasTransactionsWaitingForReview = val;
            return this;
        }


        public Builder withDefaultPaymentMethodId(final Integer val){
            DefaultPaymentMethodId = val;
            return this;
        }


        public Builder withPaymentMethod(final SageOnePaymentMethod val){
            PaymentMethod = val;
            return this;
        }

        public Builder withModified(final Date val){
            Modified = val;
            return this;
        }

        public Builder withCreated(final Date val){
            Created = val;
            return this;
        }

        public Builder withCurrencyId(final Integer val){
            CurrencyId = val;
            return this;
        }

       public SageOneBankAccount build(){
            return new SageOneBankAccount(this);
       }

    }

    public Integer getId() {
        return ID;
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

    public Boolean isActive() {
        return Active;
    }

    public Boolean isDefault() {
        return Default;
    }

    public double getBalance() {
        return Balance;
    }

    public String getDescription() {
        return Description;
    }

    public SageOneBankFeedAccount getBankFeedAccount() {
        return BankFeedAccount;
    }

    public Date getLastTransactionDate() {
        return LastTransactionDate;
    }

    public Date getLastImportDate() {
        return LastImportDate;
    }

    public Boolean isHasTransactionsWaitingForReview() {
        return HasTransactionsWaitingForReview;
    }

    public Integer getDefaultPaymentMethodId() {
        return DefaultPaymentMethodId;
    }

    public SageOnePaymentMethod getPaymentMethod() {
        return PaymentMethod;
    }

    public Date getModified() {
        return Modified;
    }

    public Date getCreated() {
        return Created;
    }

    public Integer getCurrencyId() {
        return CurrencyId;
    }
}
