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
 * Created by brent on 2017/05/31.
 */
@JsonDeserialize(builder = SageOneSupplier.Builder.class)
public final class SageOneSupplier {
    private final Integer ID;
    //String length: inclusive between 0 and 100
    private final String Name;
    private final SageOneSupplierCategory Category;
    //String length: inclusive between 0 and 30
    private final String TaxReference;
    //String length: inclusive between 0 and 100
    private final String ContactName;
    //String length: inclusive between 0 and 30
    private final String Telephone;
    private final String Fax;
    private final String Mobile;
    //--------------------------------------
    private final String Email;
    //String length: inclusive between 0 and 100
    private final String WebAddress;
    private final Boolean Active;
    private final Double Balance;
    private final Double CreditLimit;
    //String length: inclusive between 0 and 100
    private final String PostalAddress01;
    private final String PostalAddress02;
    private final String PostalAddress03;
    private final String PostalAddress04;
    private final String PostalAddress05;
    private final String DeliveryAddress01;
    private final String DeliveryAddress02;
    private final String DeliveryAddress03;
    private final String DeliveryAddress04;
    private final String DeliveryAddress05;
    //---------------------------------------
    private final Boolean AutoAllocateToOldestInvoice;
    //String length: inclusive between 0 and 100
    private final String TextField1;
    private final String TextField2;
    private final String TextField3;
    //---------------------------------------
    private final Double NumericField1;
    private final Double NumericField2;
    private final Double NumericField3;
    private final Boolean YesNoField1;
    private final Boolean YesNoField2;
    private final Boolean YesNoField3;
    private final Date DateField1;
    private final Date DateField2;
    private final Date DateField3;
    private final Date Modified;
    private final Date Created;
    private final String BusinessRegistrationNumber;
    private final String RMCDApprovalNumber;
    private final Date TaxStatusVerified;
    private final Integer CurrencyId;
    private final Boolean HasActivity;
    private final Double DefaultDiscountPercentage;
    private final Integer DefaultTaxTypeId;
    private final SageOneTaxType defaultSageOneTaxType;
    private final Integer DueDateMethodId;
    private final Integer DueDateMethodValue;
    private final String CurrencySymbol;

    public SageOneSupplier(Builder builder) {
        ID = builder.ID;
        Name = builder.Name;
        Category = builder.Category;
        TaxReference = builder.TaxReference;
        ContactName = builder.ContactName;
        Telephone = builder.Telephone;
        Fax = builder.Fax;
        Mobile = builder.Mobile;
        Email = builder.Email;
        WebAddress = builder.WebAddress;
        Active = builder.Active;
        Balance = builder.Balance;
        CreditLimit = builder.CreditLimit;
        PostalAddress01 = builder.PostalAddress01;
        PostalAddress02 = builder.PostalAddress02;
        PostalAddress03 = builder.PostalAddress03;
        PostalAddress04 = builder.PostalAddress04;
        PostalAddress05 = builder.PostalAddress05;
        DeliveryAddress01 = builder.DeliveryAddress01;
        DeliveryAddress02 = builder.DeliveryAddress02;
        DeliveryAddress03 = builder.DeliveryAddress03;
        DeliveryAddress04 = builder.DeliveryAddress04;
        DeliveryAddress05 = builder.DeliveryAddress05;
        AutoAllocateToOldestInvoice = builder.AutoAllocateToOldestInvoice;
        TextField1 = builder.TextField1;
        TextField2 = builder.TextField2;
        TextField3 = builder.TextField3;
        NumericField1 = builder.NumericField1;
        NumericField2 = builder.NumericField2;
        NumericField3 = builder.NumericField3;
        YesNoField1 = builder.YesNoField1;
        YesNoField2 = builder.YesNoField2;
        YesNoField3 = builder.YesNoField3;
        DateField1 = builder.DateField1;
        DateField2 = builder.DateField2;
        DateField3 = builder.DateField3;
        Modified = builder.Modified;
        Created = builder.Created;
        BusinessRegistrationNumber = builder.BusinessRegistrationNumber;
        RMCDApprovalNumber = builder.RMCDApprovalNumber;
        TaxStatusVerified = builder.TaxStatusVerified;
        CurrencyId = builder.CurrencyId;
        HasActivity = builder.HasActivity;
        DefaultDiscountPercentage = builder.DefaultDiscountPercentage;
        DefaultTaxTypeId = builder.DefaultTaxTypeId;
        defaultSageOneTaxType = builder.defaultSageOneTaxType;
        DueDateMethodId = builder.DueDateMethodId;
        DueDateMethodValue = builder.DueDateMethodValue;
        CurrencySymbol = builder.CurrencySymbol;
    }

    public static class Builder {
        private Integer ID;
        private String Name;
        private SageOneSupplierCategory Category;
        private String TaxReference;
        private String ContactName;
        private String Telephone;
        private String Fax;
        private String Mobile;
        private String Email;
        private String WebAddress;
        private Boolean Active;
        private Double Balance;
        private Double CreditLimit;
        private String PostalAddress01;
        private String PostalAddress02;
        private String PostalAddress03;
        private String PostalAddress04;
        private String PostalAddress05;
        private String DeliveryAddress01;
        private String DeliveryAddress02;
        private String DeliveryAddress03;
        private String DeliveryAddress04;
        private String DeliveryAddress05;
        private Boolean AutoAllocateToOldestInvoice;
        private String TextField1;
        private String TextField2;
        private String TextField3;
        private Double NumericField1;
        private Double NumericField2;
        private Double NumericField3;
        private Boolean YesNoField1;
        private Boolean YesNoField2;
        private Boolean YesNoField3;
        private Date DateField1;
        private Date DateField2;
        private Date DateField3;
        private Date Modified;
        private Date Created;
        private String BusinessRegistrationNumber;
        private String RMCDApprovalNumber;
        private Date TaxStatusVerified;
        private Integer CurrencyId;
        private Boolean HasActivity;
        private Double DefaultDiscountPercentage;
        private Integer DefaultTaxTypeId;
        private SageOneTaxType defaultSageOneTaxType;
        private Integer DueDateMethodId;
        private Integer DueDateMethodValue;
        private String CurrencySymbol;

        public Builder withId(final Integer val){
           ID = val;
           return this;
        }

        public Builder withName(final String val){
            Name = val;
            return this;
        }

        public Builder withCategory(final SageOneSupplierCategory val){
            Category = val;
            return this;
        }

        public Builder withTaxReference(final String val){
            TaxReference = val;
            return this;
        }

        public Builder withContactName(final String val){
            ContactName = val;
            return this;
        }

        public Builder withTelephone(final String val){
            Telephone = val;
            return this;
        }

        public Builder withFax(final String val){
            Fax = val;
            return this;
        }

        public Builder withMobile(final String val){
            Mobile = val;
            return this;
        }

        public Builder withEmail(final String val){
            Email = val;
            return this;
        }

        public Builder withWebAddress(final String val){
            WebAddress = val;
            return this;
        }

        public Builder withActive(final Boolean val){
            Active = val;
            return this;
        }

        public Builder withBalance(final Double val){
            Balance = val;
            return this;
        }

        public Builder withCreditLimit(final Double val){
            CreditLimit = val;
            return this;
        }

        public Builder withPostalAddress01(final String val){
            PostalAddress01 = val;
            return this;
        }

        public Builder withPostalAddress02(final String val){
            PostalAddress02 = val;
            return this;
        }

        public Builder withPostalAddress03(final String val){
            PostalAddress03 = val;
            return this;
        }

        public Builder withPostalAddress04(final String val){
            PostalAddress04 = val;
            return this;
        }

        public Builder withPostalAddress05(final String val){
            PostalAddress05 = val;
            return this;
        }

        public Builder withDeliveryAddress01(final String val){
            DeliveryAddress01 = val;
            return this;
        }

        public Builder withDeliveryAddress02(final String val){
            DeliveryAddress02 = val;
            return this;
        }

        public Builder withDeliveryAddress03(final String val){
            DeliveryAddress03 = val;
            return this;
        }

        public Builder withDeliveryAddress04(final String val){
            DeliveryAddress04 = val;
            return this;
        }

        public Builder withDeliveryAddress05(final String val){
            DeliveryAddress05 = val;
            return this;
        }

        public Builder withAutoAllocateToOldestInvoice(final Boolean val){
            AutoAllocateToOldestInvoice = val;
            return this;
        }

        public Builder withTextField1(final String val){
            TextField1 = val;
            return this;
        }

        public Builder withTextField2(final String val){
            TextField2 = val;
            return this;
        }

        public Builder withTextField3(final String val){
            TextField3 = val;
            return this;
        }

        public Builder withNumericField1(final Double val){
            NumericField1 = val;
            return this;
        }

        public Builder withNumericField2(final Double val){
            NumericField2 = val;
            return this;
        }

        public Builder withNumericField3(final Double val){
            NumericField3 = val;
            return this;
        }

        public Builder withYesNoField1(final Boolean val){
            YesNoField1 = val;
            return this;
        }

        public Builder withYesNoField2(final Boolean val){
            YesNoField2 = val;
            return this;
        }

        public Builder withYesNoField3(final Boolean val){
            YesNoField3 = val;
            return this;
        }

        public Builder withDateField1(final Date val){
            DateField1 = val;
            return this;
        }

        public Builder withDateField2(final Date val){
            DateField2 = val;
            return this;
        }

        public Builder withDateField3(final Date val){
            DateField3 = val;
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

        public Builder withTaxStatusVerified(final Date val){
            TaxStatusVerified = val;
            return this;
        }

        public Builder withBusinessRegistrationNumber(final String val){
            BusinessRegistrationNumber = val;
            return this;
        }

        public Builder withRMCDApprovalNumber(final String val){
            RMCDApprovalNumber = val;
            return this;
        }

        public Builder withCurrencyId(final Integer val){
            CurrencyId = val;
            return this;
        }

        public Builder withDefaultTaxTypeId(final Integer val){
            DefaultTaxTypeId = val;
            return this;
        }

        public Builder withDueDateMethodId(final Integer val){
            DueDateMethodId = val;
            return this;
        }

        public Builder withDueDateMethodValue(final Integer val){
            DueDateMethodValue = val;
            return this;
        }

        public Builder withHasActivity(final Boolean val){
            HasActivity = val;
            return this;
        }

        public Builder withDefaultDiscountPercentage(final Double val){
            DefaultDiscountPercentage = val;
            return this;
        }

        public Builder withDefaultTaxType(final SageOneTaxType val){
            defaultSageOneTaxType = val;
            return this;
        }

        public Builder withCurrencySymbol(final String val){
            CurrencySymbol = val;
            return this;
        }

        public SageOneSupplier build(){
            return new SageOneSupplier(this);
        }
    }

    public Integer getId() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public SageOneSupplierCategory getCategory() {
        return Category;
    }

    public String getTaxReference() {
        return TaxReference;
    }

    public String getContactName() {
        return ContactName;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getFax() {
        return Fax;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public String getWebAddress() {
        return WebAddress;
    }

    public Boolean isActive() {
        return Active;
    }

    public Double getBalance() {
        return Balance;
    }

    public Double getCreditLimit() {
        return CreditLimit;
    }

    public String getPostalAddress01() {
        return PostalAddress01;
    }

    public String getPostalAddress02() {
        return PostalAddress02;
    }

    public String getPostalAddress03() {
        return PostalAddress03;
    }

    public String getPostalAddress04() {
        return PostalAddress04;
    }

    public String getPostalAddress05() {
        return PostalAddress05;
    }

    public String getDeliveryAddress01() {
        return DeliveryAddress01;
    }

    public String getDeliveryAddress02() {
        return DeliveryAddress02;
    }

    public String getDeliveryAddress03() {
        return DeliveryAddress03;
    }

    public String getDeliveryAddress04() {
        return DeliveryAddress04;
    }

    public String getDeliveryAddress05() {
        return DeliveryAddress05;
    }

    public Boolean isAutoAllocateToOldestInvoice() {
        return AutoAllocateToOldestInvoice;
    }

    public String getTextField1() {
        return TextField1;
    }

    public String getTextField2() {
        return TextField2;
    }

    public String getTextField3() {
        return TextField3;
    }

    public Double getNumericField1() {
        return NumericField1;
    }

    public Double getNumericField2() {
        return NumericField2;
    }

    public Double getNumericField3() {
        return NumericField3;
    }

    public Boolean getYesNoField1() {
        return YesNoField1;
    }

    public Boolean getYesNoField2() {
        return YesNoField2;
    }

    public Boolean getYesNoField3() {
        return YesNoField3;
    }

    public Date getDateField1() {
        return DateField1;
    }

    public Date getDateField2() {
        return DateField2;
    }

    public Date getDateField3() {
        return DateField3;
    }

    public Date getModified() {
        return Modified;
    }

    public Date getCreated() {
        return Created;
    }

    public String getBusinessRegistrationNumber() {
        return BusinessRegistrationNumber;
    }

    public String getRMCDApprovalNumber() {
        return RMCDApprovalNumber;
    }

    public Date getTaxStatusVerified() {
        return TaxStatusVerified;
    }

    public Integer getCurrencyId() {
        return CurrencyId;
    }

    public Boolean getHasActivity() {
        return HasActivity;
    }

    public Double getDefaultDiscountPercentage() {
        return DefaultDiscountPercentage;
    }

    public Integer getDefaultTaxTypeId() {
        return DefaultTaxTypeId;
    }

    public SageOneTaxType getDefaultSageOneTaxType() {
        return defaultSageOneTaxType;
    }

    public Integer getDueDateMethodId() {
        return DueDateMethodId;
    }

    public Integer getDueDateMethodValue() {
        return DueDateMethodValue;
    }

    public String getCurrencySymbol() {
        return CurrencySymbol;
    }
}
