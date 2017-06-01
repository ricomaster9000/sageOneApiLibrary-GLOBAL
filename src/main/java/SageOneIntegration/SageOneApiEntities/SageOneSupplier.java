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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;

/**
 * Created by brent on 2017/05/31.
 */
@JsonDeserialize(builder = SageOneSupplier.Builder.class)
public final class SageOneSupplier {
    private final int id;
    //String length: inclusive between 0 and 100
    private final String Name;
    private final SupplierCategory Category;
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
    private final boolean Active;
    private final double Balance;
    private final double CreditLimit;
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
    private final boolean AutoAllocateToOldestInvoice;
    //String length: inclusive between 0 and 100
    private final String TextField1;
    private final String TextField2;
    private final String TextField3;
    //---------------------------------------
    private final double NumericField1;
    private final double NumericField2;
    private final double NumericField3;
    private final boolean YesNoField1;
    private final boolean YesNoField2;
    private final boolean YesNoField3;
    private final Date DateField1;
    private final Date DateField2;
    private final Date DateField3;
    private final Date Modified;
    private final Date Created;
    private final String BusinessRegistrationNumber;
    private final String RMCDApprovalNumber;
    private final Date TaxStatusVerified;
    private final int CurrencyId;
    private final boolean HasActivity;
    private final double DefaultDiscountPercentage;
    private final int DefaultTaxTypeId;
    private final TaxType DefaultTaxType;
    private final int DueDateMethodId;
    private final int DueDateMethodValue;
    private final String CurrencySymbol;

    public SageOneSupplier(Builder builder) {
        this.id = builder.getId();
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
        this.RMCDApprovalNumber = builder.RMCDApprovalNumber;
        TaxStatusVerified = builder.TaxStatusVerified;
        CurrencyId = builder.CurrencyId;
        HasActivity = builder.HasActivity;
        DefaultDiscountPercentage = builder.DefaultDiscountPercentage;
        DefaultTaxTypeId = builder.DefaultTaxTypeId;
        DefaultTaxType = builder.DefaultTaxType;
        DueDateMethodId = builder.DueDateMethodId;
        DueDateMethodValue = builder.DueDateMethodValue;
        CurrencySymbol = builder.CurrencySymbol;
    }

    public static class Builder extends MainEntity{

        private String Name;
        private SupplierCategory Category;
        private String TaxReference;
        private String ContactName;
        private String Telephone;
        private String Fax;
        private String Mobile;
        private String Email;
        private String WebAddress;
        private boolean Active;
        private double Balance;
        private double CreditLimit;
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
        private boolean AutoAllocateToOldestInvoice;
        private String TextField1;
        private String TextField2;
        private String TextField3;
        private double NumericField1;
        private double NumericField2;
        private double NumericField3;
        private boolean YesNoField1;
        private boolean YesNoField2;
        private boolean YesNoField3;
        private Date DateField1;
        private Date DateField2;
        private Date DateField3;
        private Date Modified;
        private Date Created;
        private String BusinessRegistrationNumber;
        private String RMCDApprovalNumber;
        private Date TaxStatusVerified;
        private int CurrencyId;
        private boolean HasActivity;
        private double DefaultDiscountPercentage;
        private int DefaultTaxTypeId;
        private TaxType DefaultTaxType;
        private int DueDateMethodId;
        private int DueDateMethodValue;
        private String CurrencySymbol;

        public Builder withId(final int val){
           setId(val);
            return this;
        }

        public Builder withName(final String val){
            Name = (this.isInitialized()) ? val: Name;
            return this;
        }

        public Builder withCategory(final SupplierCategory val){
            Category = (this.isInitialized()) ? val: Category;
            return this;
        }

        public Builder withTaxReference(final String val){
            TaxReference = (this.isInitialized()) ? val: TaxReference;
            return this;
        }

        public Builder withContactName(final String val){
            ContactName = (this.isInitialized()) ? val: ContactName;
            return this;
        }

        public Builder withTelephone(final String val){
            Telephone = (this.isInitialized()) ? val: Telephone;
            return this;
        }

        public Builder withFax(final String val){
            Fax = (this.isInitialized()) ? val: Fax;
            return this;
        }

        public Builder withMobile(final String val){
            Mobile = (this.isInitialized()) ? val: Mobile;
            return this;
        }

        public Builder withEmail(final String val){
            Email = (this.isInitialized()) ? val: Email;
            return this;
        }

        public Builder withWebAddress(final String val){
            WebAddress = (this.isInitialized()) ? val: WebAddress;
            return this;
        }

        public Builder withActive(final boolean val){
            Active = (this.isInitialized()) ? val: Active;
            return this;
        }

        public Builder withBalance(final double val){
            Balance = (this.isInitialized()) ? val: Balance;
            return this;
        }

        public Builder withCreditLimit(final double val){
            CreditLimit = (this.isInitialized()) ? val: CreditLimit;
            return this;
        }

        public Builder withPostalAddress01(final String val){
            PostalAddress01 = (this.isInitialized()) ? val: PostalAddress01;
            return this;
        }

        public Builder withPostalAddress02(final String val){
            PostalAddress02 = (this.isInitialized()) ? val: PostalAddress02;
            return this;
        }

        public Builder withPostalAddress03(final String val){
            PostalAddress03 = (this.isInitialized()) ? val: PostalAddress03;
            return this;
        }

        public Builder withPostalAddress04(final String val){
            PostalAddress04 = (this.isInitialized()) ? val: PostalAddress04;
            return this;
        }

        public Builder withPostalAddress05(final String val){
            PostalAddress05 = (this.isInitialized()) ? val: PostalAddress05;
            return this;
        }

        public Builder withDeliveryAddress01(final String val){
            DeliveryAddress01 = (this.isInitialized()) ? val: DeliveryAddress01;
            return this;
        }

        public Builder withDeliveryAddress02(final String val){
            DeliveryAddress02 = (this.isInitialized()) ? val: DeliveryAddress02;
            return this;
        }

        public Builder withDeliveryAddress03(final String val){
            DeliveryAddress03 = (this.isInitialized()) ? val: DeliveryAddress03;
            return this;
        }

        public Builder withDeliveryAddress04(final String val){
            DeliveryAddress04 = (this.isInitialized()) ? val: DeliveryAddress04;
            return this;
        }

        public Builder withDeliveryAddress05(final String val){
            DeliveryAddress05 = (this.isInitialized()) ? val: DeliveryAddress05;
            return this;
        }

        public Builder withAutoAllocateToOldestInvoice(final boolean val){
            AutoAllocateToOldestInvoice = (this.isInitialized()) ? val: AutoAllocateToOldestInvoice;
            return this;
        }

        public Builder withTextField1(final String val){
            TextField1 = (this.isInitialized()) ? val: TextField1;
            return this;
        }

        public Builder withTextField2(final String val){
            TextField2 = (this.isInitialized()) ? val: TextField2;
            return this;
        }

        public Builder withTextField3(final String val){
            TextField3 = (this.isInitialized()) ? val: TextField3;
            return this;
        }

        public Builder withNumericField1(final double val){
            NumericField1 = (this.isInitialized()) ? val: NumericField1;
            return this;
        }

        public Builder withNumericField2(final double val){
            NumericField2 = (this.isInitialized()) ? val: NumericField2;
            return this;
        }

        public Builder withNumericField3(final double val){
            NumericField3 = (this.isInitialized()) ? val: NumericField3;
            return this;
        }

        public Builder withYesNoField1(final boolean val){
            YesNoField1 = (this.isInitialized()) ? val: YesNoField1;
            return this;
        }

        public Builder withNumericYesNoField2Field3(final boolean val){
            YesNoField2 = (this.isInitialized()) ? val: YesNoField2;
            return this;
        }

        public Builder withYesNoField3(final boolean val){
            YesNoField3 = (this.isInitialized()) ? val: YesNoField3;
            return this;
        }

        public Builder withDateField1(final Date val){
            DateField1 = (this.isInitialized()) ? val: DateField1;
            return this;
        }

        public Builder withDateField2(final Date val){
            DateField2 = (this.isInitialized()) ? val: DateField2;
            return this;
        }

        public Builder withDateField3(final Date val){
            DateField3 = (this.isInitialized()) ? val: DateField3;
            return this;
        }

        public Builder withModified(final Date val){
            Modified = (this.isInitialized()) ? val: Modified;
            return this;
        }

        public Builder withCreated(final Date val){
            Created = (this.isInitialized()) ? val: Created;
            return this;
        }

        public Builder withTaxStatusVerified(final Date val){
            TaxStatusVerified = (this.isInitialized()) ? val: TaxStatusVerified;
            return this;
        }

        public Builder withBusinessRegistrationNumber(final String val){
            BusinessRegistrationNumber = (this.isInitialized()) ? val: BusinessRegistrationNumber;
            return this;
        }

        public Builder withRMCDApprovalNumber(final String val){
            RMCDApprovalNumber = (this.isInitialized()) ? val: RMCDApprovalNumber;
            return this;
        }

        public Builder withCurrencyId(final int val){
            CurrencyId = (this.isInitialized()) ? val: CurrencyId;
            return this;
        }

        public Builder withDefaultTaxTypeId(final int val){
            DefaultTaxTypeId = (this.isInitialized()) ? val: DefaultTaxTypeId;
            return this;
        }

        public Builder withDueDateMethodId(final int val){
            DueDateMethodId = (this.isInitialized()) ? val: DueDateMethodId;
            return this;
        }

        public Builder withDueDateMethodValue(final int val){
            DueDateMethodValue = (this.isInitialized()) ? val: DueDateMethodValue;
            return this;
        }

        public Builder withHasActivity(final boolean val){
            HasActivity = (this.isInitialized()) ? val: HasActivity;
            return this;
        }

        public Builder withDefaultDiscountPercentage(final double val){
            DefaultDiscountPercentage = (this.isInitialized()) ? val: DefaultDiscountPercentage;
            return this;
        }

        public Builder withDefaultTaxType(final TaxType val){
            DefaultTaxType = (this.isInitialized()) ? val: DefaultTaxType;
            return this;
        }

        public Builder withCurrencySymbol(final String val){
            CurrencySymbol = (this.isInitialized()) ? val: CurrencySymbol;
            return this;
        }

        public SageOneSupplier build(){
            return new SageOneSupplier(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public SupplierCategory getCategory() {
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

    public boolean isActive() {
        return Active;
    }

    public double getBalance() {
        return Balance;
    }

    public double getCreditLimit() {
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

    public boolean isAutoAllocateToOldestInvoice() {
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

    public double getNumericField1() {
        return NumericField1;
    }

    public double getNumericField2() {
        return NumericField2;
    }

    public double getNumericField3() {
        return NumericField3;
    }

    public boolean isYesNoField1() {
        return YesNoField1;
    }

    public boolean isYesNoField2() {
        return YesNoField2;
    }

    public boolean isYesNoField3() {
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

    public int getCurrencyId() {
        return CurrencyId;
    }

    public boolean isHasActivity() {
        return HasActivity;
    }

    public double getDefaultDiscountPercentage() {
        return DefaultDiscountPercentage;
    }

    public int getDefaultTaxTypeId() {
        return DefaultTaxTypeId;
    }

    public TaxType getDefaultTaxType() {
        return DefaultTaxType;
    }

    public int getDueDateMethodId() {
        return DueDateMethodId;
    }

    public int getDueDateMethodValue() {
        return DueDateMethodValue;
    }

    public String getCurrencySymbol() {
        return CurrencySymbol;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Category=" + Category +
                ", TaxReference='" + TaxReference + '\'' +
                ", ContactName='" + ContactName + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Fax='" + Fax + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Email='" + Email + '\'' +
                ", WebAddress='" + WebAddress + '\'' +
                ", Active=" + Active +
                ", Balance=" + Balance +
                ", CreditLimit=" + CreditLimit +
                ", PostalAddress01='" + PostalAddress01 + '\'' +
                ", PostalAddress02='" + PostalAddress02 + '\'' +
                ", PostalAddress03='" + PostalAddress03 + '\'' +
                ", PostalAddress04='" + PostalAddress04 + '\'' +
                ", PostalAddress05='" + PostalAddress05 + '\'' +
                ", DeliveryAddress01='" + DeliveryAddress01 + '\'' +
                ", DeliveryAddress02='" + DeliveryAddress02 + '\'' +
                ", DeliveryAddress03='" + DeliveryAddress03 + '\'' +
                ", DeliveryAddress04='" + DeliveryAddress04 + '\'' +
                ", DeliveryAddress05='" + DeliveryAddress05 + '\'' +
                ", AutoAllocateToOldestInvoice=" + AutoAllocateToOldestInvoice +
                ", TextField1='" + TextField1 + '\'' +
                ", TextField2='" + TextField2 + '\'' +
                ", TextField3='" + TextField3 + '\'' +
                ", NumericField1=" + NumericField1 +
                ", NumericField2=" + NumericField2 +
                ", NumericField3=" + NumericField3 +
                ", YesNoField1=" + YesNoField1 +
                ", YesNoField2=" + YesNoField2 +
                ", YesNoField3=" + YesNoField3 +
                ", DateField1=" + DateField1 +
                ", DateField2=" + DateField2 +
                ", DateField3=" + DateField3 +
                ", Modified=" + Modified +
                ", Created=" + Created +
                ", BusinessRegistrationNumber='" + BusinessRegistrationNumber + '\'' +
                ", RMCDApprovalNumber='" + RMCDApprovalNumber + '\'' +
                ", TaxStatusVerified=" + TaxStatusVerified +
                ", CurrencyId=" + CurrencyId +
                ", HasActivity=" + HasActivity +
                ", DefaultDiscountPercentage=" + DefaultDiscountPercentage +
                ", DefaultTaxTypeId=" + DefaultTaxTypeId +
                ", DefaultTaxType=" + DefaultTaxType +
                ", DueDateMethodId=" + DueDateMethodId +
                ", DueDateMethodValue=" + DueDateMethodValue +
                ", CurrencySymbol='" + CurrencySymbol + '\'' +
                '}';
    }
}
