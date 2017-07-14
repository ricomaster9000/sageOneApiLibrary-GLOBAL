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

import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageEnum.SageOnePaymentMethod;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;


@JsonDeserialize(builder = SageOneCustomerReceipt.Builder.class)
public final class SageOneCustomerReceipt {
   private final Integer ID;
   private final Integer CustomerId;
   private final Date Date;
   private final String Payee;
   //String length: inclusive between 0 and 100
   private final String DocumentNumber;
   //String length: inclusive between 0 and 100
   private final String Reference;
   //String length: inclusive between 0 and 100
   private final String Description;
   //String length: inclusive between 0 and 8000
   private final String Comments;
   private final Double Total;
   private final Double Discount;
   private final Double TotalUnallocated;
   private final Boolean Reconciled;
   private final Integer BankAccountId;
   private final SageOnePaymentMethod SageOnePaymentMethod;
   private final Integer TaxPeriodId;
   private final Boolean Editable;
   private final Boolean Accepted;
   private final Boolean Locked;
   //Gets or sets the Analysis Category identifier. This needs to be a valid AnalysisCategoryId.
   private final Integer AnalysisCategoryId1;
   // Gets or sets the Analysis Category identifier. This needs to be a valid AnalysisCategoryId.
   private final Integer AnalysisCategoryId2;
   //Gets or sets the Analysis Category identifier. This needs to be a valid AnalysisCategoryId.
   private final Integer AnalysisCategoryId3;
   private final Boolean Printed;
   private final String BankUniqueIdentifier;
   private final Integer ImportTypeId;
   private final Integer BankImportMappingId;
   private final Integer BankAccountCurrencyId;
   private final Double BankAccountExchangeRate;
   private final Integer CustomerCurrencyId;
   private final Double CustomerExchangeRate;
   private final Date Modified;
   private final Date Created;
   private final SageOneCustomer Customer;
   private final SageOneSalesRepresentative SalesRepresentative;
   private final SageOneBankAccount BankAccount;

    public SageOneCustomerReceipt(Builder builder) {
        ID                      = builder.ID;
        CustomerId              = builder.CustomerId;
        Date                    = builder.Date;
        Payee                   = builder.Payee;
        DocumentNumber          = builder.DocumentNumber;
        Reference               = builder.Reference;
        Description             = builder.Description;
        Comments                = builder.Comments;
        Total                   = builder.Total;
        Discount                = builder.Discount;
        TotalUnallocated        = builder.TotalUnallocated;
        Reconciled              = builder.Reconciled;
        BankAccountId           = builder.BankAccountId;
        SageOnePaymentMethod = builder.SageOnePaymentMethod;
        TaxPeriodId             = builder.TaxPeriodId;
        Editable                = builder.Editable;
        Accepted                = builder.Accepted;
        Locked                  = builder.Locked;
        AnalysisCategoryId1     = builder.AnalysisCategoryId1;
        AnalysisCategoryId2     = builder.AnalysisCategoryId2;
        AnalysisCategoryId3     = builder.AnalysisCategoryId3;
        Printed                 = builder.Printed;
        BankUniqueIdentifier    = builder.BankUniqueIdentifier;
        ImportTypeId            = builder.ImportTypeId;
        BankImportMappingId     = builder.BankImportMappingId;
        BankAccountCurrencyId   = builder.BankAccountCurrencyId;
        BankAccountExchangeRate = builder.BankAccountExchangeRate;
        CustomerCurrencyId      = builder.CustomerCurrencyId;
        CustomerExchangeRate    = builder.CustomerExchangeRate;
        Modified                = builder.Modified;
        Created                 = builder.Created;
        Customer                = builder.Customer;
        SalesRepresentative     = builder.SalesRepresentative;
        BankAccount             = builder.BankAccount;
    }

    public static class Builder {
        private Integer ID;
        private Integer CustomerId;
        private Date Date;
        private String Payee;
        private String DocumentNumber;
        private String Reference;
        private String Description;
        private String Comments;
        private Double Total;
        private Double Discount;
        private Double TotalUnallocated;
        private Boolean Reconciled;
        private Integer BankAccountId;
        private SageOnePaymentMethod SageOnePaymentMethod;
        private Integer TaxPeriodId;
        private Boolean Editable;
        private Boolean Accepted;
        private Boolean Locked;
        private Integer AnalysisCategoryId1;
        private Integer AnalysisCategoryId2;
        private Integer AnalysisCategoryId3;
        private Boolean Printed;
        private String BankUniqueIdentifier;
        private Integer ImportTypeId;
        private Integer BankImportMappingId;
        private Integer BankAccountCurrencyId;
        private Double BankAccountExchangeRate;
        private Integer CustomerCurrencyId;
        private Double CustomerExchangeRate;
        private Date Modified;
        private Date Created;
        private SageOneCustomer Customer;
        private SageOneSalesRepresentative SalesRepresentative;
        private SageOneBankAccount BankAccount;

       public Builder withId(final Integer val){
           ID = val;
           return this;
       }

       public Builder withCustomerId(final Integer val) {
           CustomerId = val;
           return this;
       }

       public Builder withDate(final java.util.Date val){
           Date = val;
           return this;
       }

       public Builder withPayee(final String val){
           Payee = val;
           return this;
       }

        public Builder withDocumentNumber(final String val){
            DocumentNumber = val;
            return this;
        }

        public Builder withReference(final String val){
            Reference = val;
            return this;
        }

        public Builder withDescription(final String val){
            Description = val;
            return this;
        }

        public Builder withComments(final String val){
            Comments = val;
            return this;
        }

        public Builder withTotal(final Double val){
            Total = val;
            return this;
        }

        public Builder withDiscount(final Double val){
            Discount = val;
            return this;
        }

        public Builder withTotalUnallocated(final Double val){
            TotalUnallocated = val;
            return this;
        }

        public Builder withReconciled(final Boolean val){
            Reconciled = val;
            return this;
        }

        public Builder withBankAccountId(final Integer val){
            BankAccountId = val;
            return this;
        }

        public Builder withPaymentMethod(final SageOnePaymentMethod val){
            SageOnePaymentMethod =  val;
            return this;
        }

        public Builder withTaxPeriodId(final Integer val){
            TaxPeriodId = val;
            return this;
        }

        public Builder withEditable(final Boolean val){
            Editable = val;
            return this;
        }

        public Builder withAccepted(final Boolean val){
            Accepted = val;
            return this;
        }

        public Builder withLocked(final Boolean val){
            Locked = val;
            return this;
        }

        public Builder withAnalysisCategoryId1(final Integer val){
            AnalysisCategoryId1 = val;
            return this;
        }

        public Builder withAnalysisCategoryId2(final Integer val){
            AnalysisCategoryId2 = val;
            return this;
        }

        public Builder withAnalysisCategoryId3(final Integer val){
            AnalysisCategoryId3 = val;
            return this;
        }

        public Builder withPrinted(final Boolean val){
            Printed = val;
            return this;
        }

        public Builder withBankUniqueIdentifier(final String val){
            BankUniqueIdentifier = val;
            return this;
        }

        public Builder withImportTypeId(final Integer val){
            ImportTypeId = val;
            return this;
        }

        public Builder withBankImportMappingId(final Integer val){
            BankImportMappingId = val;
            return this;
        }

        public Builder withBankAccountCurrencyId(final Integer val){
            BankAccountCurrencyId = val;
            return this;
        }

        public Builder withBankAccountExchangeRate(final Double val){
            BankAccountExchangeRate = val;
            return this;
        }

        public Builder withCustomerCurrencyId(final Integer val){
            CustomerCurrencyId = val;
            return this;
        }

        public Builder withCustomerExchangeRate(final Double val){
            CustomerExchangeRate = val;
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

        public Builder withCustomer(final SageOneCustomer val){
            Customer =  val;
            return this;
        }

        public Builder withSalesRepresentative(final SageOneSalesRepresentative val){
            SalesRepresentative =  val;
            return this;
        }

        public Builder withBankAccount(final SageOneBankAccount val){
            BankAccount =  val;
            return this;
        }

        public SageOneCustomerReceipt build(){
            return new SageOneCustomerReceipt(this);
        }
   }

    public Integer getId() {
        return ID;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public String getPayee() {
        return Payee;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public String getReference() {
        return Reference;
    }

    public String getDescription() {
        return Description;
    }

    public String getComments() {
        return Comments;
    }

    public double getTotal() {
        return Total;
    }

    public Double getDiscount() {
        return Discount;
    }

    public Double getTotalUnallocated() {
        return TotalUnallocated;
    }

    public Boolean isReconciled() {
        return Reconciled;
    }

    public Integer getBankAccountId() {
        return BankAccountId;
    }

    public SageOnePaymentMethod getSageOnePaymentMethod() {
        return SageOnePaymentMethod;
    }

    public Integer getTaxPeriodId() {
        return TaxPeriodId;
    }

    public Boolean isEditable() {
        return Editable;
    }

    public Boolean isAccepted() {
        return Accepted;
    }

    public Boolean isLocked() {
        return Locked;
    }

    public Integer getAnalysisCategoryId1() {
        return AnalysisCategoryId1;
    }

    public Integer getAnalysisCategoryId2() {
        return AnalysisCategoryId2;
    }

    public Integer getAnalysisCategoryId3() {
        return AnalysisCategoryId3;
    }

    public Boolean getPrinted() {
        return Printed;
    }

    public String getBankUniqueIdentifier() {
        return BankUniqueIdentifier;
    }

    public Integer getImportTypeId() {
        return ImportTypeId;
    }

    public Integer getBankImportMappingId() {
        return BankImportMappingId;
    }

    public Integer getBankAccountCurrencyId() {
        return BankAccountCurrencyId;
    }

    public Double getBankAccountExchangeRate() {
        return BankAccountExchangeRate;
    }

    public Integer getCustomerCurrencyId() {
        return CustomerCurrencyId;
    }

    public Double getCustomerExchangeRate() {
        return CustomerExchangeRate;
    }

    public Date getModified() {
        return Modified;
    }

    public Date getCreated() {
        return Created;
    }

    public final SageOneCustomer getCustomer() {
        return Customer;
    }

    public final SageOneSalesRepresentative getSalesRepresentative() {
        return SalesRepresentative;
    }

    public final SageOneBankAccount getBankAccount() {
        return BankAccount;
    }
}
