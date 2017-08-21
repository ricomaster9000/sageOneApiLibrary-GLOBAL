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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * Created by Ricardo on 2017-08-21.
 */
@JsonDeserialize(builder = SageOneAccountPayment.Builder.class)
public class SageOneAccountPayment {
    private final Integer ID;
    private final Integer AccountId;
    private final Date Date;
    private final String Payee; // between 0 and 8000
    private final String Description; // between 0 and 100
    private final String Reference;
    private final Integer TaxTypeId;
    private final String Comment; // between 0 and 8000
    private final Double Exclusive;
    private final Double Tax;
    private final Boolean Reconciled;
    private final Integer BankAccountId;
    private final Integer AnalysisCategoryId1; // needs to be valid if specified
    private final Integer AnalysisCategoryId2; // needs to be valid if specified
    private final Integer AnalysisCategoryId3; // needs to be valid if specified
    private final Boolean Accepted;
    private final String BankUniqueIdentifier;
    private final Integer ImportTypeId;
    private final Integer BankImportMappingId;
    private final Integer BankAccount_CurrencyId;
    private final Double BankAccount_ExchangeRate;
    private final Date Modified;
    private final Date Created;
    private boolean initialized = false;

    public SageOneAccountPayment(Builder builder) {
        this.ID = builder.ID;
        this.AccountId = builder.AccountId;
        this.Date = builder.Date;
        this.Payee = builder.Payee; // between 0 and 8000
        this.Description = builder.Description; // between 0 and 100
        this.Reference = builder.Reference;
        this.TaxTypeId = builder.TaxTypeId;
        this.Comment = builder.Comment; // between 0 and 8000
        this.Exclusive = builder.Exclusive;
        this.Tax = builder.Tax;
        this.Reconciled = builder.Reconciled;
        this.BankAccountId = builder.BankAccountId;
        this.AnalysisCategoryId1 = builder.AnalysisCategoryId1; // needs to be valid if specified
        this.AnalysisCategoryId2 = builder.AnalysisCategoryId2; // needs to be valid if specified
        this.AnalysisCategoryId3 = builder.AnalysisCategoryId3; // needs to be valid if specified
        this.Accepted = builder.Accepted;
        this.BankUniqueIdentifier = builder.BankUniqueIdentifier;
        this.ImportTypeId = builder.ImportTypeId;
        this.BankImportMappingId = builder.BankImportMappingId;
        this.BankAccount_CurrencyId = builder.BankAccount_CurrencyId;
        this.BankAccount_ExchangeRate = builder.BankAccount_ExchangeRate;
        this.Modified = builder.Modified;
        this.Created = builder.Created;
        this.initialized = true;
    }

    public static class Builder {
        private Integer ID;
        private Integer AccountId;
        private Date Date;
        private String Payee; // between 0 and 8000
        private String Description; // between 0 and 100
        private String Reference;
        private Integer TaxTypeId;
        private String Comment; // between 0 and 8000
        private Double Exclusive;
        private Double Tax;
        private Boolean Reconciled;
        private Integer BankAccountId;
        private Integer AnalysisCategoryId1; // needs to be valid if specified
        private Integer AnalysisCategoryId2; // needs to be valid if specified
        private Integer AnalysisCategoryId3; // needs to be valid if specified
        private Boolean Accepted;
        private String BankUniqueIdentifier;
        private Integer ImportTypeId;
        private Integer BankImportMappingId;
        private Integer BankAccount_CurrencyId;
        private Double BankAccount_ExchangeRate;
        private Date Modified;
        private Date Created;

        public Builder withID(final Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder withAccountId(final Integer AccountId) {
            this.AccountId = AccountId;
            return this;
        }

        public Builder withDate(final Date Date) {
            this.Date = Date;
            return this;
        }

        public Builder withPayee(final String Payee) {
            this.Payee = Payee;
            return this;
        }

        public Builder withDescription(final String Description) {
            this.Description = Description;
            return this;
        }

        public Builder withReference(final String Reference) {
            this.Reference = Reference;
            return this;
        }

        public Builder withTaxTypeId(final Integer TaxTypeId) {
            this.TaxTypeId = TaxTypeId;
            return this;
        }

        public Builder withComment(final String Comment) {
            this.Comment = Comment;
            return this;
        }

        public Builder withExclusive(final Double Exclusive) {
            this.Exclusive = Exclusive;
            return this;
        }

        public Builder withTax(final Double Tax) {
            this.Tax = Tax;
            return this;
        }

        public Builder withReconciled(final Boolean Reconciled) {
            this.Reconciled = Reconciled;
            return this;
        }

        public Builder withBankAccountId(final Integer BankAccountId) {
            this.BankAccountId = BankAccountId;
            return this;
        }

        public Builder withAnalysisCategoryId1(final Integer AnalysisCategoryId1) {
            this.AnalysisCategoryId1 = AnalysisCategoryId1;
            return this;
        }

        public Builder withAnalysisCategoryId2(final Integer AnalysisCategoryId2) {
            this.AnalysisCategoryId2 = AnalysisCategoryId2;
            return this;
        }

        public Builder withAnalysisCategoryId3(final Integer AnalysisCategoryId3) {
            this.AnalysisCategoryId3 = AnalysisCategoryId3;
            return this;
        }

        public Builder withAccepted(final Boolean Accepted) {
            this.Accepted = Accepted;
            return this;
        }

        public Builder withBankUniqueIdentifier(final String BankUniqueIdentifier) {
            this.BankUniqueIdentifier = BankUniqueIdentifier;
            return this;
        }

        public Builder withImportTypeId(final Integer ImportTypeId) {
            this.ImportTypeId = ImportTypeId;
            return this;
        }

        public Builder withBankImportMappingId(final Integer BankImportMappingId) {
            this.BankImportMappingId = BankImportMappingId;
            return this;
        }

        public Builder withBankAccount_CurrencyId(final Integer BankAccount_CurrencyId) {
            this.BankAccount_CurrencyId = BankAccount_CurrencyId;
            return this;
        }

        public Builder withBankAccount_ExchangeRate(final Double BankAccount_ExchangeRate) {
            this.BankAccount_ExchangeRate = BankAccount_ExchangeRate;
            return this;
        }

        public Builder withModified(final Date Modified) {
            this.Modified = Modified;
            return this;
        }

        public Builder withCreated(final Date Created) {
            this.Created = Created;
            return this;
        }

        public SageOneAccountPayment build() {
            return new SageOneAccountPayment(this);
        }
    }

    public final Integer getID() {
        return (this.initialized) ? this.ID : null;
    }

    public final Integer getAccountId() {
        return (this.initialized) ? this.AccountId : null;
    }

    public final Date getDate() {
        return (this.initialized) ? this.Date : null;
    }

    public final String getPayee() {
        return (this.initialized) ? this.Payee : null;
    }

    public final String getDescription() {
        return (this.initialized) ? this.Description : null;
    }

    public final String getReference() {
        return (this.initialized) ? this.Reference : null;
    }

    public final Integer getTaxTypeId() {
        return (this.initialized) ? this.TaxTypeId : null;
    }

    public final String getComment() {
        return (this.initialized) ? this.Comment : null;
    }

    public final Double getExclusive() {
        return (this.initialized) ? this.Exclusive : null;
    }

    public final Double getTax() {
        return (this.initialized) ? this.Tax : null;
    }

    public final Boolean getReconciled() {
        return (this.initialized) ? this.Reconciled : null;
    }

    public final Integer getBankAccountId() {
        return (this.initialized) ? this.BankAccountId : null;
    }

    public final Integer getAnalysisCategoryId1() {
        return (this.initialized) ? this.AnalysisCategoryId1 : null;
    }

    public final Integer getAnalysisCategoryId2() {
        return (this.initialized) ? this.AnalysisCategoryId2 : null;
    }

    public final Integer getAnalysisCategoryId3() {
        return (this.initialized) ? this.AnalysisCategoryId3 : null;
    }

    public final Boolean getAccepted() {
        return (this.initialized) ? this.Accepted : null;
    }

    public final String getBankUniqueIdentifier() {
        return (this.initialized) ? this.BankUniqueIdentifier : null;
    }

    public final Integer getImportTypeId() {
        return (this.initialized) ? this.ImportTypeId : null;
    }

    public final Integer getBankImportMappingId() {
        return (this.initialized) ? this.BankImportMappingId : null;
    }

    public final Integer getBankAccount_CurrencyId() {
        return (this.initialized) ? this.BankAccount_CurrencyId : null;
    }

    public final Double getBankAccount_ExchangeRate() {
        return (this.initialized) ? this.BankAccount_ExchangeRate : null;
    }

    public final Date getModified() {
        return (this.initialized) ? this.Modified : null;
    }

    public final Date getCreated() {
        return (this.initialized) ? this.Created : null;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
