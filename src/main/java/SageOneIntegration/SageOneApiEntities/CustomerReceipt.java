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


@JsonDeserialize(builder = CustomerReceipt.Builder.class)
public final class CustomerReceipt {
    private final int id;
   private final int CustomerId;
   private final java.util.Date Date;
   private final String Payee;
   //String length: inclusive between 0 and 100
   private final String DocumentNumber;
   //String length: inclusive between 0 and 100
   private final String Reference;
   //String length: inclusive between 0 and 100
   private final String Description;
   //String length: inclusive between 0 and 8000
   private final String Comments;
   private final double Total;
   private final double Discount;
   private final double TotalUnallocated;
   private final boolean Reconciled;
   private final int BankAccountId;
   private final PaymentMethod PaymentMethod;
   private final int TaxPeriodId;
   private final boolean Editable;
   private final boolean Accepted;
   private final boolean Locked;
   //Gets or sets the Analysis Category identifier. This needs to be a valid AnalysisCategoryId.
   private final int AnalysisCategoryId1;
   // Gets or sets the Analysis Category identifier. This needs to be a valid AnalysisCategoryId.
   private final int AnalysisCategoryId2;
   //Gets or sets the Analysis Category identifier. This needs to be a valid AnalysisCategoryId.
   private final int AnalysisCategoryId3;
   private final boolean Printed;
   private final String BankUniqueIdentifier;
   private final int ImportTypeId;
   private final int BankImportMappingId;
   private final int BankAccountCurrencyId;
   private final double BankAccountExchangeRate;
   private final int CustomerCurrencyId;
   private final double CustomerExchangeRate;
   private final java.util.Date Modified;
   private final java.util.Date Created;
   private final SageOneCustomer SageOneCustomer;
   private final SalesRepresentative SalesRepresentative;
   private final SageOneBankAccount SageOneBankAccount;

    public CustomerReceipt(Builder builder) {
        this.id                 = builder.getId();
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
        PaymentMethod           = builder.PaymentMethod;
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
        SageOneCustomer = builder.SageOneCustomer;
        SalesRepresentative     = builder.SalesRepresentative;
        SageOneBankAccount = builder.SageOneBankAccount;

    }

    public static class Builder extends MainEntity{
       private int CustomerId;
       private java.util.Date Date;
        private String Payee;
        private String DocumentNumber;
        private String Reference;
        private String Description;
        private String Comments;
        private double Total;
        private double Discount;
        private double TotalUnallocated;
        private boolean Reconciled;
        private int BankAccountId;
        private PaymentMethod PaymentMethod;
        private int TaxPeriodId;
        private boolean Editable;
        private boolean Accepted;
        private boolean Locked;
        private int AnalysisCategoryId1;
        private int AnalysisCategoryId2;
        private int AnalysisCategoryId3;
        private boolean Printed;
        private String BankUniqueIdentifier;
        private int ImportTypeId;
        private int BankImportMappingId;
        private int BankAccountCurrencyId;
        private double BankAccountExchangeRate;
        private int CustomerCurrencyId;
        private double CustomerExchangeRate;
        private java.util.Date Modified;
        private java.util.Date Created;
        private SageOneCustomer SageOneCustomer;
        private SalesRepresentative SalesRepresentative;
        private SageOneBankAccount SageOneBankAccount;

       public Builder withId(final int val){
           setId(val);
           return this;
       }

       public Builder withCustomerId(final int val) {
           CustomerId = (this.isInitialized()) ? val:CustomerId;
           return this;
       }

       public Builder withDate(final java.util.Date val){
           Date = (this.isInitialized()) ? val:Date;
           return this;
       }

       public Builder withPayee(final String val){
           Payee = (this.isInitialized()) ? val:Payee;
           return this;
       }

        public Builder withDocumentNumber(final String val){
            DocumentNumber = (this.isInitialized()) ? val:DocumentNumber;
            return this;
        }

        public Builder withReference(final String val){
            Reference = (this.isInitialized()) ? val:Reference;
            return this;
        }

        public Builder withDescription(final String val){
            Description = (this.isInitialized()) ? val:Description;
            return this;
        }

        public Builder withComments(final String val){
            Comments = (this.isInitialized()) ? val:Comments;
            return this;
        }

        public Builder withTotal(final double val){
            Total = (this.isInitialized()) ? val:Total;
            return this;
        }

        public Builder withDiscount(final double val){
            Discount = (this.isInitialized()) ? val:Discount;
            return this;
        }

        public Builder withTotalUnallocated(final double val){
            TotalUnallocated = (this.isInitialized()) ? val:TotalUnallocated;
            return this;
        }

        public Builder withReconciled(final boolean val){
            Reconciled = (this.isInitialized()) ? val:Reconciled;
            return this;
        }

        public Builder withBankAccountId(final int val){
            BankAccountId = (this.isInitialized()) ? val:BankAccountId;
            return this;
        }

        public Builder withPaymentMethod(final PaymentMethod val){
            PaymentMethod = (this.isInitialized()) ? val:PaymentMethod;
            return this;
        }

        public Builder withTaxPeriodId(final int val){
            TaxPeriodId = (this.isInitialized()) ? val:TaxPeriodId;
            return this;
        }

        public Builder withEditable(final boolean val){
            Editable = (this.isInitialized()) ? val:Editable;
            return this;
        }

        public Builder withAccepted(final boolean val){
            Accepted = (this.isInitialized()) ? val:Accepted;
            return this;
        }

        public Builder withLocked(final boolean val){
            Locked = (this.isInitialized()) ? val:Locked;
            return this;
        }

        public Builder withAnalysisCategoryId1(final int val){
            AnalysisCategoryId1 = (this.isInitialized()) ? val:AnalysisCategoryId1;
            return this;
        }

        public Builder withAnalysisCategoryId2(final int val){
            AnalysisCategoryId2 = (this.isInitialized()) ? val:AnalysisCategoryId2;
            return this;
        }

        public Builder withAnalysisCategoryId3(final int val){
            AnalysisCategoryId3 = (this.isInitialized()) ? val:AnalysisCategoryId3;
            return this;
        }

        public Builder withPrinted(final boolean val){
            Printed = (this.isInitialized()) ? val:Printed;
            return this;
        }

        public Builder withBankUniqueIdentifier(final String val){
            BankUniqueIdentifier = (this.isInitialized()) ? val:BankUniqueIdentifier;
            return this;
        }

        public Builder withImportTypeId(final int val){
            ImportTypeId = (this.isInitialized()) ? val:ImportTypeId;
            return this;
        }

        public Builder withBankImportMappingId(final int val){
            BankImportMappingId = (this.isInitialized()) ? val:BankImportMappingId;
            return this;
        }

        public Builder withBankAccountCurrencyId(final int val){
            BankAccountCurrencyId = (this.isInitialized()) ? val:BankAccountCurrencyId;
            return this;
        }

        public Builder withBankAccountExchangeRate(final double val){
            BankAccountExchangeRate = (this.isInitialized()) ? val:BankAccountExchangeRate;
            return this;
        }

        public Builder withCustomerCurrencyId(final int val){
            CustomerCurrencyId = (this.isInitialized()) ? val:CustomerCurrencyId;
            return this;
        }

        public Builder withCustomerExchangeRate(final double val){
            CustomerExchangeRate = (this.isInitialized()) ? val:CustomerExchangeRate;
            return this;
        }

        public Builder withModified(final java.util.Date val){
            Modified = (this.isInitialized()) ? val:Modified;
            return this;
        }

        public Builder withCreated(final java.util.Date val){
            Created = (this.isInitialized()) ? val:Created;
            return this;
        }

        public Builder withCustomer(final SageOneCustomer val){
            SageOneCustomer = (this.isInitialized()) ? val: SageOneCustomer;
            return this;
        }

        public Builder withSalesRepresentative(final SalesRepresentative val){
            SalesRepresentative = (this.isInitialized()) ? val:SalesRepresentative;
            return this;
        }

        public Builder withBankAccount(final SageOneBankAccount val){
            SageOneBankAccount = (this.isInitialized()) ? val: SageOneBankAccount;
            return this;
        }

        public CustomerReceipt build(){
            return new CustomerReceipt(this);
        }
   }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
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

    public double getDiscount() {
        return Discount;
    }

    public double getTotalUnallocated() {
        return TotalUnallocated;
    }

    public boolean isReconciled() {
        return Reconciled;
    }

    public int getBankAccountId() {
        return BankAccountId;
    }

    public PaymentMethod getPaymentMethod() {
        return PaymentMethod;
    }

    public int getTaxPeriodId() {
        return TaxPeriodId;
    }

    public boolean isEditable() {
        return Editable;
    }

    public boolean isAccepted() {
        return Accepted;
    }

    public boolean isLocked() {
        return Locked;
    }

    public int getAnalysisCategoryId1() {
        return AnalysisCategoryId1;
    }

    public int getAnalysisCategoryId2() {
        return AnalysisCategoryId2;
    }

    public int getAnalysisCategoryId3() {
        return AnalysisCategoryId3;
    }

    public boolean isPrinted() {
        return Printed;
    }

    public String getBankUniqueIdentifier() {
        return BankUniqueIdentifier;
    }

    public int getImportTypeId() {
        return ImportTypeId;
    }

    public int getBankImportMappingId() {
        return BankImportMappingId;
    }

    public int getBankAccountCurrencyId() {
        return BankAccountCurrencyId;
    }

    public double getBankAccountExchangeRate() {
        return BankAccountExchangeRate;
    }

    public int getCustomerCurrencyId() {
        return CustomerCurrencyId;
    }

    public double getCustomerExchangeRate() {
        return CustomerExchangeRate;
    }

    public java.util.Date getModified() {
        return Modified;
    }

    public java.util.Date getCreated() {
        return Created;
    }

    @Override
    public String toString() {
        return "CustomerReceipt{" +
                "id=" + id +
                ", CustomerId=" + CustomerId +
                ", Date=" + Date +
                ", Payee='" + Payee + '\'' +
                ", DocumentNumber='" + DocumentNumber + '\'' +
                ", Reference='" + Reference + '\'' +
                ", Description='" + Description + '\'' +
                ", Comments='" + Comments + '\'' +
                ", Total=" + Total +
                ", Discount=" + Discount +
                ", TotalUnallocated=" + TotalUnallocated +
                ", Reconciled=" + Reconciled +
                ", BankAccountId=" + BankAccountId +
                ", PaymentMethod=" + PaymentMethod +
                ", TaxPeriodId=" + TaxPeriodId +
                ", Editable=" + Editable +
                ", Accepted=" + Accepted +
                ", Locked=" + Locked +
                ", AnalysisCategoryId1=" + AnalysisCategoryId1 +
                ", AnalysisCategoryId2=" + AnalysisCategoryId2 +
                ", AnalysisCategoryId3=" + AnalysisCategoryId3 +
                ", Printed=" + Printed +
                ", BankUniqueIdentifier='" + BankUniqueIdentifier + '\'' +
                ", ImportTypeId=" + ImportTypeId +
                ", BankImportMappingId=" + BankImportMappingId +
                ", BankAccountCurrencyId=" + BankAccountCurrencyId +
                ", BankAccountExchangeRate=" + BankAccountExchangeRate +
                ", CustomerCurrencyId=" + CustomerCurrencyId +
                ", CustomerExchangeRate=" + CustomerExchangeRate +
                ", Modified=" + Modified +
                ", Created=" + Created +
                '}';
    }
}
