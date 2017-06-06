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

/**
 * Created by brent on 2017/05/31.
 */
@JsonDeserialize(builder = SageOneCommercialDocumentLine.Builder.class)
public final class SageOneCommercialDocumentLine {
    //Gets or sets the selection identifier. This is the selected Item Id or Account Id.
    private final Integer ID;
    private final int SelectionId;
    private final int TaxTypeId;
    //String length: inclusive between 0 and 100
    private final String Description;
    private final SageOneCommercialDocumentLine LineType;
    private final double Quantity;
    private final double UnitPriceExclusive;
    private final double Unit;
    private final double UnitPriceInclusive;
    private final double TaxPercentage;
    private final double DiscountPercentage;
    private final double Exclusive;
    private final double Discount;
    private final double Tax;
    private final double Total;
    private final String Comments;
    //Gets or sets the Analysis Category identifier. This needs to be a valid AnalysisCategoryId.
    private final int AnalysisCategoryId1;
    private final int AnalysisCategoryId2;
    private final int AnalysisCategoryId3;
    //----------------------------------
    private final String $TrackingCode;
    private final int CurrencyId;
    //Gets the UnitCost identifier. This is the Unit Cost of the Item at Time of Sale (only available on TaxInvoices for Item Lines).
    private final double UnitCost;

    public SageOneCommercialDocumentLine(Builder builder) {
        ID = builder.ID;
        SelectionId = builder.SelectionId;
        TaxTypeId = builder.TaxTypeId;
        Description = builder.Description;
        LineType = builder.LineType;
        Quantity = builder.Quantity;
        UnitPriceExclusive = builder.UnitPriceExclusive;
        Unit = builder.Unit;
        UnitPriceInclusive = builder.UnitPriceInclusive;
        TaxPercentage = builder.TaxPercentage;
        DiscountPercentage = builder.DiscountPercentage;
        Exclusive = builder.Exclusive;
        Discount = builder.Discount;
        Tax = builder.Tax;
        Total = builder.Total;
        Comments = builder.Comments;
        AnalysisCategoryId1 = builder.AnalysisCategoryId1;
        AnalysisCategoryId2 = builder.AnalysisCategoryId2;
        AnalysisCategoryId3 = builder.AnalysisCategoryId3;
        $TrackingCode = builder.$TrackingCode;
        CurrencyId = builder.CurrencyId;
        UnitCost = builder.UnitCost;
    }

    public static class Builder {
        private Integer ID;
        private int SelectionId;
        private int TaxTypeId;
        private String Description;
        private SageOneCommercialDocumentLine LineType;
        private double Quantity;
        private double UnitPriceExclusive;
        private double Unit;
        private double UnitPriceInclusive;
        private double TaxPercentage;
        private double DiscountPercentage;
        private double Exclusive;
        private double Discount;
        private double Tax;
        private double Total;
        private String Comments;
        private int AnalysisCategoryId1;
        private int AnalysisCategoryId2;
        private int AnalysisCategoryId3;
        private String $TrackingCode;
        private int CurrencyId;
        private double UnitCost;

        public Builder withId(final int val){
            ID = val;
            return this;
        }

        public Builder withSelectionId(final int val){
            SelectionId = val;
            return this;
        }

        public Builder withTaxTypeId(final int val){
            TaxTypeId = val;
            return this;
        }

        public Builder withDescription(final String val){
            Description = val;
            return this;
        }

        public Builder withLineType(final SageOneCommercialDocumentLine val){
            LineType = val;
            return this;
        }

        public Builder withQuantity(final double val){
            Quantity = val;
            return this;
        }

        public Builder withUnitPriceExclusive(final double val){
            UnitPriceExclusive = val;
            return this;
        }

        public Builder withUnit(final double val){
            Unit = val;
            return this;
        }

        public Builder withUnitPriceInclusive(final double val){
            UnitPriceInclusive = val;
            return this;
        }

        public Builder withTaxPercentage(final double val){
            TaxPercentage = val;
            return this;
        }

        public Builder withDiscountPercentage(final double val){
            DiscountPercentage = val;
            return this;
        }

        public Builder withExclusive(final double val){
            Exclusive = val;
            return this;
        }

        public Builder withDiscount(final double val){
            Discount = val;
            return this;
        }

        public Builder withTax(final double val){
            Tax = val;
            return this;
        }

        public Builder withTotal(final double val){
            Total = val;
            return this;
        }

        public Builder withComments(final String val){
            Comments = val;
            return this;
        }
        public Builder withAnalysisCategoryId1(final int val){
            AnalysisCategoryId1 = val;
            return this;
        }

        public Builder withAnalysisCategoryId2(final int val){
            AnalysisCategoryId2 = val;
            return this;
        }

        public Builder withAnalysisCategoryId3(final int val){
            AnalysisCategoryId3 = val;
            return this;
        }

        public Builder with$TrackingCode(final String val){
            $TrackingCode = val;
            return this;
        }

        public Builder withCurrencyId(final int val){
            CurrencyId = val;
            return this;
        }

        public Builder withUnitCost(final double val){
            UnitCost = val;
            return this;
        }

        public SageOneCommercialDocumentLine build(){
            return new SageOneCommercialDocumentLine(this);
        }
    }

    public Integer getId() {
        return ID;
    }

    public int getSelectionId() {
        return SelectionId;
    }

    public int getTaxTypeId() {
        return TaxTypeId;
    }

    public String getDescription() {
        return Description;
    }

    public SageOneCommercialDocumentLine getLineType() {
        return LineType;
    }

    public double getQuantity() {
        return Quantity;
    }

    public double getUnitPriceExclusive() {
        return UnitPriceExclusive;
    }

    public double getUnit() {
        return Unit;
    }

    public double getUnitPriceInclusive() {
        return UnitPriceInclusive;
    }

    public double getTaxPercentage() {
        return TaxPercentage;
    }

    public double getDiscountPercentage() {
        return DiscountPercentage;
    }

    public double getExclusive() {
        return Exclusive;
    }

    public double getDiscount() {
        return Discount;
    }

    public double getTax() {
        return Tax;
    }

    public double getTotal() {
        return Total;
    }

    public String getComments() {
        return Comments;
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

    public String get$TrackingCode() {
        return $TrackingCode;
    }

    public int getCurrencyId() {
        return CurrencyId;
    }

    public double getUnitCost() {
        return UnitCost;
    }

    @Override
    public String toString() {
        return "SageOneCommercialDocumentLine{" +
                "id=" + ID +
                ", SelectionId=" + SelectionId +
                ", TaxTypeId=" + TaxTypeId +
                ", Description='" + Description + '\'' +
                ", LineType=" + LineType +
                ", Quantity=" + Quantity +
                ", UnitPriceExclusive=" + UnitPriceExclusive +
                ", Unit=" + Unit +
                ", UnitPriceInclusive=" + UnitPriceInclusive +
                ", TaxPercentage=" + TaxPercentage +
                ", DiscountPercentage=" + DiscountPercentage +
                ", Exclusive=" + Exclusive +
                ", Discount=" + Discount +
                ", Tax=" + Tax +
                ", Total=" + Total +
                ", Comments='" + Comments + '\'' +
                ", AnalysisCategoryId1=" + AnalysisCategoryId1 +
                ", AnalysisCategoryId2=" + AnalysisCategoryId2 +
                ", AnalysisCategoryId3=" + AnalysisCategoryId3 +
                ", $TrackingCode='" + $TrackingCode + '\'' +
                ", CurrencyId=" + CurrencyId +
                ", UnitCost=" + UnitCost +
                '}';
    }
}
