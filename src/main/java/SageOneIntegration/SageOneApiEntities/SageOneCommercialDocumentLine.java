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

import SageOneIntegration.SageOneApiEntities.SageEnum.SageOneCommercialDocumentLineType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Created by brent on 2017/05/31.
 */
@JsonDeserialize(builder = SageOneCommercialDocumentLine.Builder.class)
public final class SageOneCommercialDocumentLine {
    //Gets or sets the selection identifier. This is the selected Item Id or Account Id.
    private final Integer ID;
    private final Integer SelectionId;
    private final Integer TaxTypeId;
    //String length: inclusive between 0 and 100
    private final String Description;
    private final SageOneCommercialDocumentLineType LineType;
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
    private final Integer AnalysisCategoryId1;
    private final Integer AnalysisCategoryId2;
    private final Integer AnalysisCategoryId3;
    //----------------------------------
    private final String $TrackingCode;
    private final Integer CurrencyId;
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
        private Integer SelectionId;
        private Integer TaxTypeId;
        private String Description;
        private SageOneCommercialDocumentLineType LineType;
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
        private Integer AnalysisCategoryId1;
        private Integer AnalysisCategoryId2;
        private Integer AnalysisCategoryId3;
        private String $TrackingCode;
        private Integer CurrencyId;
        private double UnitCost;

        public Builder withId(final Integer val){
            ID = val;
            return this;
        }

        public Builder withSelectionId(final Integer val){
            SelectionId = val;
            return this;
        }

        public Builder withTaxTypeId(final Integer val){
            TaxTypeId = val;
            return this;
        }

        public Builder withDescription(final String val){
            Description = val;
            return this;
        }

        public Builder withLineType(final SageOneCommercialDocumentLineType val){
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

        public Builder with$TrackingCode(final String val){
            $TrackingCode = val;
            return this;
        }

        public Builder withCurrencyId(final Integer val){
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

    public Integer getSelectionId() {
        return SelectionId;
    }

    public Integer getTaxTypeId() {
        return TaxTypeId;
    }

    public String getDescription() {
        return Description;
    }

    public SageOneCommercialDocumentLineType getLineType() {
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

    public Integer getAnalysisCategoryId1() {
        return AnalysisCategoryId1;
    }

    public Integer getAnalysisCategoryId2() {
        return AnalysisCategoryId2;
    }

    public Integer getAnalysisCategoryId3() {
        return AnalysisCategoryId3;
    }

    public String get$TrackingCode() {
        return $TrackingCode;
    }

    public Integer getCurrencyId() {
        return CurrencyId;
    }

    public double getUnitCost() {
        return UnitCost;
    }
}
