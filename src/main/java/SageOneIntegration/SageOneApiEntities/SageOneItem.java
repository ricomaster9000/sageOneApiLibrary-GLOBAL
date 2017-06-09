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

import java.sql.Date;

/**
 * Created by ricomaster9000 on 2017/06/06.
 */
public final class SageOneItem extends SageOneMainEntity {
    private String Description;
    private SageOneItemCategory Category;
    private String Code;
    private Boolean Active;
    private double PriceInclusive;
    private double PriceExclusive;
    private Boolean Physical;
    private Integer TaxTypeIdSales;
    private SageOneTaxType TaxTypesSales;
    private Integer TaxTypeIdPurchases;
    private SageOneTaxType TaxTypePurchases;
    private double LastCost;
    private double AverageCost;
    private double QuantityOnHand;
    private Boolean HasAttachments;
    private Boolean HasActivity;
    private String Unit;
    private Integer ItemReportingGroupId_Sales;
    private SageOneItemReportGroup ItemReportingGroupSales;
    private Integer ItemReportingGroupId_Purchases;
    private SageOneItemReportGroup ItemReportingGroupPurchases;
    private String TextUserField1;
    private String TextUserField2;
    private String TextUserField3;
    private double NumericUserField1;
    private double NumericUserField2;
    private double NumericUserField3;
    private Date DateUserField1;
    private Date DateUserField2;
    private Date DateUserField3;
    private Boolean YesNoUserField1;
    private Boolean YesNoUserField2;
    private Boolean YesNoUserField3;
    private Date Modified;
    private Date Created;
    private Integer MajorIndustryCodeId;
    private SageOneAdditionalItemPrice[] AdditionalItemPrices;
    private double GPPercentage;
    private double GPAmount;
    private String ItemReportingGroupPurchasesName;
    private String ItemReportingGroupSalesName;
    private SageOneAttachment[] Attachments;

    public final String getDescription() {
        return (this.isInitialized()) ? this.Description : "";
    }

    public final void setDescription(final String Description) {
        this.Description = (this.isInitialized()) ? Description : this.Description;
    }

    public final SageOneItemCategory getCategory() {
        return (this.isInitialized()) ? this.Category : null;
    }

    public final void setCategory(final SageOneItemCategory Category) {
        this.Category = (this.isInitialized()) ? Category : this.Category;
    }

    public final String getCode() {
        return (this.isInitialized()) ? this.Code : null;
    }

    public final void setCode(final String Code) {
        this.Code = (this.isInitialized()) ? Code : this.Code;
    }

    public final Boolean getActive() {
        return (this.isInitialized()) ? this.Active : null;
    }

    public final void setActive(final Boolean Active) {
        this.Active = (this.isInitialized()) ? Active : this.Active;
    }

    public final double getPriceInclusive() {
        return (this.isInitialized()) ? this.PriceInclusive : null;
    }

    public final void setPriceInclusive(final double PriceInclusive) {
        this.PriceInclusive = (this.isInitialized()) ? PriceInclusive : this.PriceInclusive;
    }

    public final double getPriceExclusive() {
        return (this.isInitialized()) ? this.PriceExclusive : null;
    }

    public final void setPriceExclusive(final double PriceExclusive) {
        this.PriceExclusive = (this.isInitialized()) ? PriceExclusive : this.PriceExclusive;
    }

    public final Boolean getPhysical() {
        return (this.isInitialized()) ? this.Physical : null;
    }

    public final void setPhysical(final Boolean Physical) {
        this.Physical = (this.isInitialized()) ? Physical : this.Physical;
    }

    public final Integer getTaxTypeIdSales() {
        return (this.isInitialized()) ? this.TaxTypeIdSales : null;
    }

    public final void setTaxTypeIdSales(final Integer TaxTypeIdSales) {
        this.TaxTypeIdSales = (this.isInitialized()) ? TaxTypeIdSales : this.TaxTypeIdSales;
    }

    public final SageOneTaxType getTaxTypesSales() {
        return (this.isInitialized()) ? this.TaxTypesSales : null;
    }

    public final void setTaxTypesSales(final SageOneTaxType TaxTypesSales) {
        this.TaxTypesSales = (this.isInitialized()) ? TaxTypesSales : this.TaxTypesSales;
    }

    public final Integer getTaxTypeIdPurchases() {
        return (this.isInitialized()) ? this.TaxTypeIdPurchases : null;
    }

    public final void setTaxTypeIdPurchases(final Integer TaxTypeIdPurchases) {
        this.TaxTypeIdPurchases = (this.isInitialized()) ? TaxTypeIdPurchases : this.TaxTypeIdPurchases;
    }

    public final SageOneTaxType getTaxTypePurchases() {
        return (this.isInitialized()) ? this.TaxTypePurchases : null;
    }

    public final void setTaxTypePurchases(final SageOneTaxType TaxTypePurchases) {
        this.TaxTypePurchases = (this.isInitialized()) ? TaxTypePurchases : this.TaxTypePurchases;
    }

    public final double getLastCost() {
        return (this.isInitialized()) ? this.LastCost : null;
    }

    public final void setLastCost(final double LastCost) {
        this.LastCost = (this.isInitialized()) ? LastCost : this.LastCost;
    }

    public final double getAverageCost() {
        return (this.isInitialized()) ? this.AverageCost : null;
    }

    public final void setAverageCost(final double AverageCost) {
        this.AverageCost = (this.isInitialized()) ? AverageCost : this.AverageCost;
    }

    public final double getQuantityOnHand() {
        return (this.isInitialized()) ? this.QuantityOnHand : null;
    }

    public final void setQuantityOnHand(final double QuantityOnHand) {
        this.QuantityOnHand = (this.isInitialized()) ? QuantityOnHand : this.QuantityOnHand;
    }

    public final Boolean getHasAttachments() {
        return (this.isInitialized()) ? this.HasAttachments : null;
    }

    public final void setHasAttachments(final Boolean HasAttachments) {
        this.HasAttachments = (this.isInitialized()) ? HasAttachments : this.HasAttachments;
    }

    public final Boolean getHasActivity() {
        return (this.isInitialized()) ? this.HasActivity : null;
    }

    public final void setHasActivity(final Boolean HasActivity) {
        this.HasActivity = (this.isInitialized()) ? HasActivity : this.HasActivity;
    }

    public final String getUnit() {
        return (this.isInitialized()) ? this.Unit : null;
    }

    public final void setUnit(final String Unit) {
        this.Unit = (this.isInitialized()) ? Unit : this.Unit;
    }

    public final Integer getItemReportingGroupId_Sales() {
        return (this.isInitialized()) ? this.ItemReportingGroupId_Sales : null;
    }

    public final void setItemReportingGroupId_Sales(final Integer ItemReportingGroupId_Sales) {
        this.ItemReportingGroupId_Sales = (this.isInitialized()) ? ItemReportingGroupId_Sales : this.ItemReportingGroupId_Sales;
    }

    public final SageOneItemReportGroup getItemReportingGroupSales() {
        return (this.isInitialized()) ? this.ItemReportingGroupSales : null;
    }

    public final void setItemReportingGroupSales(final SageOneItemReportGroup ItemReportingGroupSales) {
        this.ItemReportingGroupSales = (this.isInitialized()) ? ItemReportingGroupSales : this.ItemReportingGroupSales;
    }

    public final Integer getItemReportingGroupId_Purchases() {
        return (this.isInitialized()) ? this.ItemReportingGroupId_Purchases : null;
    }

    public final void setItemReportingGroupId_Purchases(final Integer ItemReportingGroupId_Purchases) {
        this.ItemReportingGroupId_Purchases = (this.isInitialized()) ? ItemReportingGroupId_Purchases : this.ItemReportingGroupId_Purchases;
    }

    public final SageOneItemReportGroup getItemReportingGroupPurchases() {
        return (this.isInitialized()) ? this.ItemReportingGroupPurchases : null;
    }

    public final void setItemReportingGroupPurchases(final SageOneItemReportGroup ItemReportingGroupPurchases) {
        this.ItemReportingGroupPurchases = (this.isInitialized()) ? ItemReportingGroupPurchases : this.ItemReportingGroupPurchases;
    }

    public final String getTextUserField1() {
        return (this.isInitialized()) ? this.TextUserField1 : null;
    }

    public final void setTextUserField1(final String TextUserField1) {
        this.TextUserField1 = (this.isInitialized()) ? TextUserField1 : this.TextUserField1;
    }

    public final String getTextUserField2() {
        return (this.isInitialized()) ? this.TextUserField2 : null;
    }

    public final void setTextUserField2(final String TextUserField2) {
        this.TextUserField2 = (this.isInitialized()) ? TextUserField2 : this.TextUserField2;
    }

    public final String getTextUserField3() {
        return (this.isInitialized()) ? this.TextUserField3 : null;
    }

    public final void setTextUserField3(final String TextUserField3) {
        this.TextUserField3 = (this.isInitialized()) ? TextUserField3 : this.TextUserField3;
    }

    public final double getNumericUserField1() {
        return (this.isInitialized()) ? this.NumericUserField1 : null;
    }

    public final void setNumericUserField1(final double NumericUserField1) {
        this.NumericUserField1 = (this.isInitialized()) ? NumericUserField1 : this.NumericUserField1;
    }

    public final double getNumericUserField2() {
        return (this.isInitialized()) ? this.NumericUserField2 : null;
    }

    public final void setNumericUserField2(final double NumericUserField2) {
        this.NumericUserField2 = (this.isInitialized()) ? NumericUserField2 : this.NumericUserField2;
    }

    public final double getNumericUserField3() {
        return (this.isInitialized()) ? this.NumericUserField3 : null;
    }

    public final void setNumericUserField3(final double NumericUserField3) {
        this.NumericUserField3 = (this.isInitialized()) ? NumericUserField3 : this.NumericUserField3;
    }

    public final Date getDateUserField1() {
        return (this.isInitialized()) ? this.DateUserField1 : null;
    }

    public final void setDateUserField1(final Date DateUserField1) {
        this.DateUserField1 = (this.isInitialized()) ? DateUserField1 : this.DateUserField1;
    }

    public final Date getDateUserField2() {
        return (this.isInitialized()) ? this.DateUserField2 : null;
    }

    public final void setDateUserField2(final Date DateUserField2) {
        this.DateUserField2 = (this.isInitialized()) ? DateUserField2 : this.DateUserField2;
    }

    public final Date getDateUserField3() {
        return (this.isInitialized()) ? this.DateUserField3 : null;
    }

    public final void setDateUserField3(final Date DateUserField3) {
        this.DateUserField3 = (this.isInitialized()) ? DateUserField3 : this.DateUserField3;
    }

    public final Boolean getYesNoUserField1() {
        return (this.isInitialized()) ? this.YesNoUserField1 : null;
    }

    public final void setYesNoUserField1(final Boolean YesNoUserField1) {
        this.YesNoUserField1 = (this.isInitialized()) ? YesNoUserField1 : this.YesNoUserField1;
    }

    public final Boolean getYesNoUserField2() {
        return (this.isInitialized()) ? this.YesNoUserField2 : null;
    }

    public final void setYesNoUserField2(final Boolean YesNoUserField2) {
        this.YesNoUserField2 = (this.isInitialized()) ? YesNoUserField2 : this.YesNoUserField2;
    }

    public final Boolean getYesNoUserField3() {
        return (this.isInitialized()) ? this.YesNoUserField3 : null;
    }

    public final void setYesNoUserField3(final Boolean YesNoUserField3) {
        this.YesNoUserField3 = (this.isInitialized()) ? YesNoUserField3 : this.YesNoUserField3;
    }

    public final Date getModified() {
        return (this.isInitialized()) ? this.Modified : null;
    }

    public final void setModified(final Date Modified) {
        this.Modified = (this.isInitialized()) ? Modified : this.Modified;
    }

    public final Date getCreated() {
        return (this.isInitialized()) ? this.Created : null;
    }

    public final void setCreated(final Date Created) {
        this.Created = (this.isInitialized()) ? Created : this.Created;
    }

    public final Integer getMajorIndustryCodeId() {
        return (this.isInitialized()) ? this.MajorIndustryCodeId : null;
    }

    public final void setMajorIndustryCodeId(final Integer MajorIndustryCodeId) {
        this.MajorIndustryCodeId = (this.isInitialized()) ? MajorIndustryCodeId : this.MajorIndustryCodeId;
    }

    public final SageOneAdditionalItemPrice[] getAdditionalItemPrices() {
        return (this.isInitialized()) ? this.AdditionalItemPrices : null;
    }

    public final void setAdditionalItemPrices(final SageOneAdditionalItemPrice[] AdditionalItemPrices) {
        this.AdditionalItemPrices = (this.isInitialized()) ? AdditionalItemPrices : this.AdditionalItemPrices;
    }

    public final double getGPPercentage() {
        return (this.isInitialized()) ? this.GPPercentage : null;
    }

    public final void setGPPercentage(final double GPPercentage) {
        this.GPPercentage = (this.isInitialized()) ? GPPercentage : this.GPPercentage;
    }

    public final double getGPAmount() {
        return (this.isInitialized()) ? this.GPAmount : null;
    }

    public final void setGPAmount(final double GPAmount) {
        this.GPAmount = (this.isInitialized()) ? GPAmount : this.GPAmount;
    }

    public final String getItemReportingGroupPurchasesName() {
        return (this.isInitialized()) ? this.ItemReportingGroupPurchasesName : null;
    }

    public final void setItemReportingGroupPurchasesName(final String ItemReportingGroupPurchasesName) {
        this.ItemReportingGroupPurchasesName = (this.isInitialized()) ? ItemReportingGroupPurchasesName : this.ItemReportingGroupPurchasesName;
    }

    public final String getItemReportingGroupSalesName() {
        return (this.isInitialized()) ? this.ItemReportingGroupSalesName : null;
    }

    public final void setItemReportingGroupSalesName(final String ItemReportingGroupSalesName) {
        this.ItemReportingGroupSalesName = (this.isInitialized()) ? ItemReportingGroupSalesName : this.ItemReportingGroupSalesName;
    }

    public final SageOneAttachment[] getAttachments() {
        return (this.isInitialized()) ? this.Attachments : null;
    }

    public final void setAttachments(final SageOneAttachment[] Attachments) {
        this.Attachments = (this.isInitialized()) ? Attachments : this.Attachments;
    }
}
