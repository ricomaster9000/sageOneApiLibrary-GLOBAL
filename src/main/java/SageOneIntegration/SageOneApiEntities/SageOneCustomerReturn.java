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

@JsonDeserialize(builder = SageOneCustomerReturn.Builder.class)
public final class SageOneCustomerReturn {
    private final int id;
    private final String FromDocument;
    private final boolean Locked;
    private final int CustomerId;
    private final String CustomerName;
    private final SageOneCustomer SageOneCustomer;
    private final int SalesRepresentativeId;
    private final SageOneSalesRepresentative SageOneSalesRepresentative;
    private final int StatusId;
    private final Date Modified;
    private final Date Created;
    private final Date Date;
    private final boolean Inclusive;
    private final double DiscountPercentage;
    //String length: inclusive between 0 and 30
    private final String TaxReference;
    //String length: inclusive between 0 and 100
    private final String DocumentNumber;
    //String length: inclusive between 0 and 100
    private final String Reference;
    //String length: inclusive between 0 and 8000
    private final String Message;
    private final double Discount;
    private final double Exclusive;
    private final double Tax;
    private final double Rounding;
    private final double Total;
    //Data type: Currency
    private final double AmountDue;
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
    //--------------------------------------
    private final int CurrencyId;
    private final double ExchangeRate;
    private final int TaxPeriodId;
    private final boolean Editable;
    private final boolean HasAttachments;
    private final boolean HasNotes;
    private final boolean HasAnticipatedDate;
    private final Date AnticipatedDate;
    //String length: inclusive between 0 and 100
    private final String ExternalReference;
    private final SageOneCommercialDocumentLine Lines;

    public SageOneCustomerReturn(Builder builder) {
        this.id = builder.getId();
        FromDocument = builder.FromDocument;
        Locked = builder.Locked;
        CustomerId = builder.CustomerId;
        CustomerName = builder.CustomerName;
        SageOneCustomer = builder.SageOneCustomer;
        SalesRepresentativeId = builder.SalesRepresentativeId;
        SageOneSalesRepresentative = builder.SageOneSalesRepresentative;
        StatusId = builder.StatusId;
        Modified = builder.Modified;
        Created = builder.Created;
        Date = builder.Date;
        Inclusive = builder.Inclusive;
        DiscountPercentage = builder.DiscountPercentage;
        TaxReference = builder.TaxReference;
        DocumentNumber = builder.DocumentNumber;
        Reference = builder.Reference;
        Message = builder.Message;
        Discount = builder.Discount;
        Exclusive = builder.Exclusive;
        Tax = builder.Tax;
        Rounding = builder.Rounding;
        Total = builder.Total;
        AmountDue = builder.AmountDue;
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
        CurrencyId = builder.CurrencyId;
        ExchangeRate = builder.ExchangeRate;
        TaxPeriodId = builder.TaxPeriodId;
        Editable = builder.Editable;
        HasAttachments = builder.HasAttachments;
        HasNotes = builder.HasNotes;
        HasAnticipatedDate = builder.HasAnticipatedDate;
        AnticipatedDate = builder.AnticipatedDate;
        ExternalReference = builder.ExternalReference;
        Lines = builder.Lines;
    }

    public static class Builder extends SageOneMainEntity {
        private String FromDocument;
        private boolean Locked;
        private int CustomerId;
        private String CustomerName;
        private SageOneCustomer SageOneCustomer;
        private int SalesRepresentativeId;
        private SageOneSalesRepresentative SageOneSalesRepresentative;
        private int StatusId;
        private Date Modified;
        private Date Created;
        private Date Date;
        private boolean Inclusive;
        private double DiscountPercentage;
        private String TaxReference;
        private String DocumentNumber;
        private String Reference;
        private String Message;
        private double Discount;
        private double Exclusive;
        private double Tax;
        private double Rounding;
        private double Total;
        private double AmountDue;
        private String PostalAddress01 = "";
        private String PostalAddress02 = "";
        private String PostalAddress03 = "";
        private String PostalAddress04 = "";
        private String PostalAddress05 = "";
        private String DeliveryAddress01 = "";
        private String DeliveryAddress02 = "";
        private String DeliveryAddress03 = "";
        private String DeliveryAddress04 = "";
        private String DeliveryAddress05 = "";
        private int CurrencyId;
        private double ExchangeRate;
        private int TaxPeriodId;
        private boolean Editable;
        private boolean HasAttachments;
        private boolean HasNotes;
        private boolean HasAnticipatedDate;
        private Date AnticipatedDate;
        private String ExternalReference;
        private SageOneCommercialDocumentLine Lines;

        public Builder withId(final int val){
            setId(val);
            return this;
        }

        public Builder withFromDocument(final String val){
            FromDocument = (this.isInitialized()) ? val:FromDocument;
            return this;
        }

        public Builder withLocked(final boolean val){
            Locked = (this.isInitialized()) ? val:Locked;
            return this;
        }

        public Builder withCustomerId(final int val){
            CustomerId = (this.isInitialized()) ? val:CustomerId;
            return this;
        }

        public Builder withCustomerName(final String val){
            CustomerName = (this.isInitialized()) ? val:CustomerName;
            return this;
        }

        public Builder withCustomer(final SageOneCustomer val){
            SageOneCustomer = (this.isInitialized()) ? val: SageOneCustomer;
            return this;
        }

        public Builder withSalesRepresentativeId(final int val){
            SalesRepresentativeId = (this.isInitialized()) ? val:SalesRepresentativeId;
            return this;
        }

        public Builder withSalesRepresentative(final SageOneSalesRepresentative val){
            SageOneSalesRepresentative = (this.isInitialized()) ? val: SageOneSalesRepresentative;
            return this;
        }

        public Builder withStatusId(final int val){
            StatusId = (this.isInitialized()) ? val:StatusId;
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

        public Builder withDate(final Date val){
            Date = (this.isInitialized()) ? val:Date;
            return this;
        }

        public Builder withInclusive(final boolean val){
            Inclusive = (this.isInitialized()) ? val:Inclusive;
            return this;
        }

        public Builder withDiscountPercentage(final double val){
            DiscountPercentage = (this.isInitialized()) ? val:DiscountPercentage;
            return this;
        }

        public Builder withTaxReference(final String val){
            TaxReference = (this.isInitialized()) ? val:TaxReference;
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

        public Builder withMessage(final String val){
            Message = (this.isInitialized()) ? val:Message;
            return this;
        }

        public Builder withDiscount(final double val){
            Discount = (this.isInitialized()) ? val:Discount;
            return this;
        }

        public Builder withExclusive(final double val){
            Exclusive = (this.isInitialized()) ? val:Exclusive;
            return this;
        }

        public Builder withTax(final double val){
            Tax = (this.isInitialized()) ? val:Tax;
            return this;
        }

        public Builder withRounding(final double val){
            Rounding = (this.isInitialized()) ? val:Rounding;
            return this;
        }


        public Builder withTotal(final double val){
            Total = (this.isInitialized()) ? val:Total;
            return this;
        }

        public Builder withAmountDue(final double val){
            AmountDue = (this.isInitialized()) ? val:AmountDue;
            return this;
        }

        public Builder withPostalAddress01(final String val){
            PostalAddress01 = (this.isInitialized()) ? val:PostalAddress01;
            return this;
        }

        public Builder withPostalAddress02(final String val){
            PostalAddress02 = (this.isInitialized()) ? val:PostalAddress02;
            return this;
        }

        public Builder withPostalAddress03(final String val){
            PostalAddress03 = (this.isInitialized()) ? val:PostalAddress03;
            return this;
        }

        public Builder withPostalAddress04(final String val){
            PostalAddress04 = (this.isInitialized()) ? val:PostalAddress04;
            return this;
        }

        public Builder withPostalAddress05(final String val){
            PostalAddress05 = (this.isInitialized()) ? val:PostalAddress05;
            return this;
        }

        public Builder withDeliveryAddress01(final String val){
            DeliveryAddress01 = (this.isInitialized()) ? val:DeliveryAddress01;
            return this;
        }

        public Builder withDeliveryAddress02(final String val){
            DeliveryAddress02 = (this.isInitialized()) ? val:DeliveryAddress02;
            return this;
        }

        public Builder withDeliveryAddress03(final String val){
            DeliveryAddress03 = (this.isInitialized()) ? val:DeliveryAddress03;
            return this;
        }

        public Builder withDeliveryAddress04(final String val){
            DeliveryAddress04 = (this.isInitialized()) ? val:DeliveryAddress04;
            return this;
        }

        public Builder withDeliveryAddress05(final String val){
            DeliveryAddress05 = (this.isInitialized()) ? val:DeliveryAddress05;
            return this;
        }

        public Builder withCurrencyId(final int val){
            CurrencyId = (this.isInitialized()) ? val:CurrencyId;
            return this;
        }

        public Builder withExchangeRate(final double val){
            ExchangeRate = (this.isInitialized()) ? val:ExchangeRate;
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

        public Builder withHasAttachments(final boolean val){
            HasAttachments = (this.isInitialized()) ? val:HasAttachments;
            return this;
        }

        public Builder withHasNotes(final boolean val){
            HasNotes = (this.isInitialized()) ? val:HasNotes;
            return this;
        }

        public Builder withHasAnticipatedDate(final boolean val){
            HasAnticipatedDate = (this.isInitialized()) ? val:HasAnticipatedDate;
            return this;
        }

        public Builder withAnticipatedDate(final Date val){
            AnticipatedDate = (this.isInitialized()) ? val:AnticipatedDate;
            return this;
        }

        public Builder withExternalReference(final String val){
            ExternalReference = (this.isInitialized()) ? val:ExternalReference;
            return this;
        }

        public Builder withLines(final SageOneCommercialDocumentLine val){
            Lines = (this.isInitialized()) ? val:Lines;
            return this;
        }

        public SageOneCustomerReturn build(){
            return new SageOneCustomerReturn(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getFromDocument() {
        return FromDocument;
    }

    public boolean isLocked() {
        return Locked;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public SageOneCustomer getSageOneCustomer() {
        return SageOneCustomer;
    }

    public int getSalesRepresentativeId() {
        return SalesRepresentativeId;
    }

    public SageOneSalesRepresentative getSageOneSalesRepresentative() {
        return SageOneSalesRepresentative;
    }

    public int getStatusId() {
        return StatusId;
    }

    public java.util.Date getModified() {
        return Modified;
    }

    public java.util.Date getCreated() {
        return Created;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public boolean isInclusive() {
        return Inclusive;
    }

    public double getDiscountPercentage() {
        return DiscountPercentage;
    }

    public String getTaxReference() {
        return TaxReference;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public String getReference() {
        return Reference;
    }

    public String getMessage() {
        return Message;
    }

    public double getDiscount() {
        return Discount;
    }

    public double getExclusive() {
        return Exclusive;
    }

    public double getTax() {
        return Tax;
    }

    public double getRounding() {
        return Rounding;
    }

    public double getTotal() {
        return Total;
    }

    public double getAmountDue() {
        return AmountDue;
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

    public int getCurrencyId() {
        return CurrencyId;
    }

    public double getExchangeRate() {
        return ExchangeRate;
    }

    public int getTaxPeriodId() {
        return TaxPeriodId;
    }

    public boolean isEditable() {
        return Editable;
    }

    public boolean isHasAttachments() {
        return HasAttachments;
    }

    public boolean isHasNotes() {
        return HasNotes;
    }

    public boolean isHasAnticipatedDate() {
        return HasAnticipatedDate;
    }

    public java.util.Date getAnticipatedDate() {
        return AnticipatedDate;
    }

    public String getExternalReference() {
        return ExternalReference;
    }

    public SageOneCommercialDocumentLine getLines() {
        return Lines;
    }

    @Override
    public String toString() {
        return "CustomerReturn{" +
                "id=" + id +
                ", FromDocument='" + FromDocument + '\'' +
                ", Locked=" + Locked +
                ", CustomerId=" + CustomerId +
                ", CustomerName='" + CustomerName + '\'' +
                ", SageOneCustomer=" + SageOneCustomer +
                ", SalesRepresentativeId=" + SalesRepresentativeId +
                ", SageOneSalesRepresentative=" + SageOneSalesRepresentative +
                ", StatusId=" + StatusId +
                ", Modified=" + Modified +
                ", Created=" + Created +
                ", Date=" + Date +
                ", Inclusive=" + Inclusive +
                ", DiscountPercentage=" + DiscountPercentage +
                ", TaxReference='" + TaxReference + '\'' +
                ", DocumentNumber='" + DocumentNumber + '\'' +
                ", Reference='" + Reference + '\'' +
                ", Message='" + Message + '\'' +
                ", Discount=" + Discount +
                ", Exclusive=" + Exclusive +
                ", Tax=" + Tax +
                ", Rounding=" + Rounding +
                ", Total=" + Total +
                ", AmountDue=" + AmountDue +
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
                ", CurrencyId=" + CurrencyId +
                ", ExchangeRate=" + ExchangeRate +
                ", TaxPeriodId=" + TaxPeriodId +
                ", Editable=" + Editable +
                ", HasAttachments=" + HasAttachments +
                ", HasNotes=" + HasNotes +
                ", HasAnticipatedDate=" + HasAnticipatedDate +
                ", AnticipatedDate=" + AnticipatedDate +
                ", ExternalReference='" + ExternalReference + '\'' +
                ", Lines=" + Lines +
                '}';
    }
}
