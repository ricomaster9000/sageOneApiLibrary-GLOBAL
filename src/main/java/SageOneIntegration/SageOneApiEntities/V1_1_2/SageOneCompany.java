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


import SageOneIntegration.SageOneApiEntities.V1_1_2.SageEnum.SageOneCompanyStatus;

import java.sql.Date;


public final class SageOneCompany extends SageOneMainEntity {
    private String Name;
    private String CurrencySymbol;
    private Integer CurrencyDecimalDigits;
    private Integer NumberDecimalDigits;
    private String DecimalSeparator;
    private Integer HoursDecimalDigits;
    private Integer ItemCostPriceDecimalDigits;
    private Integer ItemSellingPriceDecimalDigits;
    private String PostalAddress1;
    private String PostalAddress2;
    private String PostalAddress3;
    private String PostalAddress4;
    private String PostalAddress5;
    private String GroupSeparator;
    private Integer RoundingValue;
    private SageOneTaxSystemClass TaxSystem;
    private SageOneRoundingTypeClass RoundingType;
    private Boolean AgeMonthly;
    private Boolean DisplayInactiveItems;
    private Boolean WarnWhenItemCostIsZero;
    private Boolean DoNotAllowProcessingIntoNegativeQuantities;
    private Boolean WarnWhenItemQuantityIsZero;
    private Boolean WarnWhenItemSellingBelowCost;
    private Integer CountryId;
    private Integer CompanyEntityTypeId;
    private Date TakeOnBalanceDate;
    private Boolean EnableCustomerZone;
    private Boolean EnableAutomaticBankFeedRefresh;
    private String ContactName;
    private String Telephone;
    private String Fax;
    private String Mobile;
    private String Email;
    private Boolean IsPrimarySendingEmail;
    private String PostalAddress01;
    private String PostalAddress02;
    private String PostalAddress03;
    private String PostalAddress04;
    private String PostalAddress05;
    private String CompanyInfo01;
    private String CompanyInfo02;
    private String CompanyInfo03;
    private String CompanyInfo04;
    private String CompanyInfo05;
    private Boolean IsOwner;
    private Boolean UseCCEmail;
    private String CCEmail;
    private Integer DateFormatId;
    private Boolean CheckForDuplicateCustomerReferences;
    private Boolean CheckForDuplicateSupplierReferences;
    private String DisplayName;
    private Boolean DisplayInactiveCustomers;
    private Boolean DisplayInactiveSuppliers;
    private Boolean DisplayInactiveTimeProjects;
    private Boolean UseInclusiveProcessingByDefault;
    private Boolean LockProcessing;
    private Date LockProcessingDate;
    private Boolean LockTimesheetProcessing;
    private Date LockTimesheetProcessingDate;
    private Integer TaxPeriodFrequency;
    private Date PreviousTaxPeriodEndDate;
    private Date PreviousTaxReturnDate;
    private Boolean UseNoreplyEmail;
    private Boolean AgeingBasedOnDueDate;
    private Boolean UseLogoOnEmails;
    private Boolean UseLogoOnCustomerZone;
    private String City;
    private String State;
    private String Country;
    private Integer HomeCurrencyId;
    private Integer CurrencyId;
    private Date Created;
    private Date Modified;
    private Boolean Active;
    private String TaxNumber;
    private String RegisteredName;
    private String RegistrationNumber;
    private Boolean IsPracticeAccount;
    private Integer LogoPositionID;
    private SageOneCompanyLogoClass Attachment;
    private String CompanyTaxNumber;
    private String TaxOffice;
    private String CustomerZoneGuid;
    private Integer ClientTypeId;
    private Integer DisplayTotalTypeId;
    private Boolean DisplayInCompanyConsole;
    private Date LastLoginDate;
    private SageOneCompanyStatus Status;

    public final String getName() {
        return this.Name;
    }

    public final void setName(final String Name) {
        this.Name = Name;
    }

    public final String getCurrencySymbol() {
        return this.CurrencySymbol;
    }

    public final void setCurrencySymbol(final String CurrencySymbol) {
        this.CurrencySymbol = CurrencySymbol;
    }

    public final Integer getCurrencyDecimalDigits() {
        return this.CurrencyDecimalDigits;
    }

    public final void setCurrencyDecimalDigits(final Integer CurrencyDecimalDigits) {
        this.CurrencyDecimalDigits = CurrencyDecimalDigits;
    }

    public final Integer getNumberDecimalDigits() {
        return this.NumberDecimalDigits;
    }

    public final void setNumberDecimalDigits(final Integer NumberDecimalDigits) {
        this.NumberDecimalDigits = NumberDecimalDigits;
    }

    public final String getDecimalSeparator() {
        return this.DecimalSeparator;
    }

    public final void setDecimalSeparator(final String DecimalSeparator) {
        this.DecimalSeparator = DecimalSeparator;
    }

    public final Integer getHoursDecimalDigits() {
        return this.HoursDecimalDigits;
    }

    public final void setHoursDecimalDigits(final Integer HoursDecimalDigits) {
        this.HoursDecimalDigits = HoursDecimalDigits;
    }

    public final Integer getItemCostPriceDecimalDigits() {
        return this.ItemCostPriceDecimalDigits;
    }

    public final void setItemCostPriceDecimalDigits(final Integer ItemCostPriceDecimalDigits) {
        this.ItemCostPriceDecimalDigits = ItemCostPriceDecimalDigits;
    }

    public final Integer getItemSellingPriceDecimalDigits() {
        return this.ItemSellingPriceDecimalDigits;
    }

    public final void setItemSellingPriceDecimalDigits(final Integer ItemSellingPriceDecimalDigits) {
        this.ItemSellingPriceDecimalDigits = ItemSellingPriceDecimalDigits;
    }

    public final String getPostalAddress1() {
        return this.PostalAddress1;
    }

    public final void setPostalAddress1(final String PostalAddress1) {
        this.PostalAddress1 = PostalAddress1;
    }

    public final String getPostalAddress2() {
        return this.PostalAddress2;
    }

    public final void setPostalAddress2(final String PostalAddress2) {
        this.PostalAddress2 = PostalAddress2;
    }

    public final String getPostalAddress3() {
        return this.PostalAddress3;
    }

    public final void setPostalAddress3(final String PostalAddress3) {
        this.PostalAddress3 = PostalAddress3;
    }

    public final String getPostalAddress4() {
        return this.PostalAddress4;
    }

    public final void setPostalAddress4(final String PostalAddress4) {
        this.PostalAddress2 = PostalAddress2;
    }

    public final String getPostalAddress5() {
        return this.PostalAddress5;
    }

    public final void setPostalAddress5(final String PostalAddress5) {
        this.PostalAddress5 = PostalAddress5;
    }

    public final String getGroupSeparator() {
        return this.GroupSeparator;
    }

    public final void setGroupSeparator(final String GroupSeparator) {
        this.GroupSeparator = GroupSeparator;
    }

    public final Integer getRoundingValue() {
        return this.RoundingValue;
    }

    public final void setRoundingValue(final Integer RoundingValue) {
        this.RoundingValue = RoundingValue;
    }

    public final SageOneTaxSystemClass getTaxSystem() {
        return this.TaxSystem;
    }

    public final void setTaxSystem(final SageOneTaxSystemClass TaxSystem) {
        this.TaxSystem = TaxSystem;
    }

    public final SageOneRoundingTypeClass getRoundingType() {
        return this.RoundingType;
    }

    public final void setRoundingType(final SageOneRoundingTypeClass RoundingType) {
        this.RoundingType = RoundingType;
    }

    public final Boolean getAgeMonthly() {
        return this.AgeMonthly;
    }

    public final void setAgeMonthly(final Boolean AgeMonthly) {
        this.AgeMonthly = AgeMonthly;
    }

    public final Boolean getDisplayInactiveItems() {
        return this.DisplayInactiveItems;
    }

    public final void setDisplayInactiveItems(final Boolean DisplayInactiveItems) {
        this.DisplayInactiveItems = DisplayInactiveItems;
    }

    public final Boolean getWarnWhenItemCostIsZero() {
        return this.WarnWhenItemCostIsZero;
    }

    public final void setWarnWhenItemCostIsZero(final Boolean WarnWhenItemCostIsZero) {
        this.WarnWhenItemCostIsZero = WarnWhenItemCostIsZero;
    }

    public final Boolean getDoNotAllowProcessingIntoNegativeQuantities() {
        return this.DoNotAllowProcessingIntoNegativeQuantities;
    }

    public final void setDoNotAllowProcessingIntoNegativeQuantities(final Boolean DoNotAllowProcessingIntoNegativeQuantities) {
        this.DoNotAllowProcessingIntoNegativeQuantities = DoNotAllowProcessingIntoNegativeQuantities;
    }

    public final Boolean getWarnWhenItemQuantityIsZero() {
        return this.WarnWhenItemQuantityIsZero;
    }

    public final void setWarnWhenItemQuantityIsZero(final Boolean WarnWhenItemQuantityIsZero) {
        this.WarnWhenItemQuantityIsZero = WarnWhenItemQuantityIsZero;
    }

    public final Boolean getWarnWhenItemSellingBelowCost() {
        return this.WarnWhenItemSellingBelowCost;
    }

    public final void setWarnWhenItemSellingBelowCost(final Boolean WarnWhenItemSellingBelowCost) {
        this.WarnWhenItemSellingBelowCost = WarnWhenItemSellingBelowCost;
    }

    public final Integer getCountryId() {
        return this.CountryId;
    }

    public final void setCountryId(final Integer CountryId) {
        this.CountryId = CountryId;
    }

    public final Integer getCompanyEntityTypeId() {
        return this.CompanyEntityTypeId;
    }

    public final void setCompanyEntityTypeId(final Integer CompanyEntityTypeId) {
        this.CompanyEntityTypeId = CompanyEntityTypeId;
    }

    public final Date getTakeOnBalanceDate() {
        return this.TakeOnBalanceDate;
    }

    public final void TakeOnBalanceDate(final Date TakeOnBalanceDate) {
        this.TakeOnBalanceDate = TakeOnBalanceDate;
    }

    public final Boolean getEnableCustomerZone() {
        return this.EnableCustomerZone;
    }

    public final void setEnableCustomerZone(final Boolean EnableCustomerZone) {
        this.EnableCustomerZone = EnableCustomerZone;
    }

    public final Boolean getEnableAutomaticBankFeedRefresh() {
        return this.EnableAutomaticBankFeedRefresh;
    }

    public final void setEnableAutomaticBankFeedRefresh(final Boolean EnableAutomaticBankFeedRefresh) {
        this.EnableAutomaticBankFeedRefresh = EnableAutomaticBankFeedRefresh;
    }

    public final String getContactName() {
        return this.ContactName;
    }

    public final void setContactName(final String ContactName) {
        this.ContactName = ContactName;
    }

    public final String getTelephone() {
        return this.Telephone;
    }

    public final void setTelephone(final String Telephone) {
        this.Telephone = Telephone;
    }

    public final String getFax() {
        return this.Fax;
    }

    public final void setFax(final String Fax) {
        this.Fax = Fax;
    }

    public final String getMobile() {
        return this.Mobile;
    }

    public final void setMobile(final String Mobile) {
        this.Mobile = Mobile;
    }

    public final String getEmail() {
        return this.Email;
    }

    public final void setEmail(final String Email) {
        this.Email = Email;
    }

    public final Boolean getIsPrimarySendingEmail() {
        return this.IsPrimarySendingEmail;
    }

    public final void setIsPrimarySendingEmail(final Boolean IsPrimarySendingEmail) {
        this.IsPrimarySendingEmail = IsPrimarySendingEmail;
    }

    public final String getPostalAddress01() {
        return this.PostalAddress01;
    }

    public final void setPostalAddress01(final String PostalAddress01) {
        this.PostalAddress01 = PostalAddress01;
    }

    public final String getPostalAddress02() {
        return this.PostalAddress02;
    }

    public final void setPostalAddress02(final String PostalAddress02) {
        this.PostalAddress02 = PostalAddress02;
    }

    public final String getPostalAddress03() {
        return this.PostalAddress03;
    }

    public final void setPostalAddress03(final String PostalAddress03) {
        this.PostalAddress03 = PostalAddress03;
    }

    public final String getPostalAddress04() {
        return this.PostalAddress04;
    }

    public final void setPostalAddress04(final String PostalAddress04) {
        this.PostalAddress04 = PostalAddress04;
    }

    public final String getPostalAddress05() {
        return this.PostalAddress05;
    }

    public final void setPostalAddress05(final String PostalAddress05) {
        this.PostalAddress05 = PostalAddress05;
    }

    public final String getCompanyInfo01() {
        return this.CompanyInfo01;
    }

    public final void setCompanyInfo01(final String CompanyInfo01) {
        this.CompanyInfo01 = CompanyInfo01;
    }

    public final String getCompanyInfo02() {
        return this.CompanyInfo02;
    }

    public final void setCompanyInfo02(final String CompanyInfo02) {
        this.CompanyInfo02 = CompanyInfo02;
    }

    public final String getCompanyInfo03() {
        return this.CompanyInfo03;
    }

    public final void setCompanyInfo03(final String CompanyInfo03) {
        this.CompanyInfo03 = CompanyInfo03;
    }

    public final String getCompanyInfo04() {
        return this.CompanyInfo04;
    }

    public final void setCompanyInfo04(final String CompanyInfo04) {
        this.CompanyInfo04 = CompanyInfo04;
    }

    public final String getCompanyInfo05() {
        return this.CompanyInfo05;
    }

    public final void setCompanyInfo05(final String CompanyInfo05) {
        this.CompanyInfo05 = CompanyInfo05;
    }

    public final Boolean getIsOwner() {
        return this.IsOwner;
    }

    public final void setIsOwner(final Boolean IsOwner) {
        this.IsOwner = IsOwner;
    }

    public final Boolean getUseCCEmail() {
        return this.UseCCEmail;
    }

    public final void setUseCCEmail(final Boolean UseCCEmail) {
        this.UseCCEmail = UseCCEmail;
    }

    public final String getCCEmail() {
        return this.CCEmail;
    }

    public final void setCCEmail(final String CCEmail) {
        this.CCEmail = CCEmail;
    }

    public final Integer getDateFormatId() {
        return this.DateFormatId;
    }

    public final void setDateFormatId(final Integer DateFormatId) {
        this.DateFormatId = DateFormatId;
    }

    public final Boolean getCheckForDuplicateCustomerReferences() {
        return this.CheckForDuplicateCustomerReferences;
    }

    public final void setCheckForDuplicateCustomerReferences(final Boolean CheckForDuplicateCustomerReferences) {
        this.CheckForDuplicateCustomerReferences = CheckForDuplicateCustomerReferences;
    }

    public final Boolean getCheckForDuplicateSupplierReferences() {
        return this.CheckForDuplicateSupplierReferences;
    }

    public final void setCheckForDuplicateSupplierReferences(final Boolean CheckForDuplicateSupplierReferences) {
        this.CheckForDuplicateSupplierReferences = CheckForDuplicateSupplierReferences;
    }

    public final String getDisplayName() {
        return this.DisplayName;
    }

    public final void setDisplayName(final String DisplayName) {
        this.DisplayName = DisplayName;
    }

    public final Boolean getDisplayInactiveCustomers() {
        return this.DisplayInactiveCustomers;
    }

    public final void setDisplayInactiveCustomers(final Boolean DisplayInactiveCustomers) {
        this.DisplayInactiveCustomers = DisplayInactiveCustomers;
    }

    public final Boolean getDisplayInactiveSuppliers() {
        return this.DisplayInactiveSuppliers;
    }

    public final void setDisplayInactiveSuppliers(final Boolean DisplayInactiveSuppliers) {
        this.DisplayInactiveSuppliers = DisplayInactiveSuppliers;
    }

    public final Boolean getDisplayInactiveTimeProjects() {
        return this.DisplayInactiveTimeProjects;
    }

    public final void setDisplayInactiveTimeProjects(final Boolean DisplayInactiveTimeProjects) {
        this.DisplayInactiveTimeProjects = DisplayInactiveTimeProjects;
    }

    public final Boolean getUseInclusiveProcessingByDefault() {
        return this.UseInclusiveProcessingByDefault;
    }

    public final void setUseInclusiveProcessingByDefault(final Boolean UseInclusiveProcessingByDefault) {
        this.UseInclusiveProcessingByDefault = UseInclusiveProcessingByDefault;
    }

    public final Boolean getLockProcessing() {
        return this.LockProcessing;
    }

    public final void setLockProcessing(final Boolean LockProcessing) {
        this.LockProcessing = LockProcessing;
    }

    public final Date getLockProcessingDate() {
        return this.LockProcessingDate;
    }

    public final void setLockProcessingDate(final Date LockProcessingDate) {
        this.LockProcessingDate = LockProcessingDate;
    }

    public final Boolean getLockTimesheetProcessing() {
        return this.LockTimesheetProcessing;
    }

    public final void setLockTimesheetProcessing(final Boolean LockTimesheetProcessing) {
        this.LockTimesheetProcessing = LockTimesheetProcessing;
    }

    public final Date getLockTimesheetProcessingDate() {
        return this.LockTimesheetProcessingDate;
    }

    public final void setLockTimesheetProcessingDate(final Date LockTimesheetProcessingDate) {
        this.LockTimesheetProcessingDate = LockTimesheetProcessingDate;
    }

    public final Integer getTaxPeriodFrequency() {
        return this.TaxPeriodFrequency;
    }

    public final void setTaxPeriodFrequency(final Integer TaxPeriodFrequency) {
        this.TaxPeriodFrequency = TaxPeriodFrequency;
    }

    public final Date getPreviousTaxPeriodEndDate() {
        return this.PreviousTaxPeriodEndDate;
    }

    public final void setPreviousTaxPeriodEndDate(final Date PreviousTaxPeriodEndDate) {
        this.PreviousTaxPeriodEndDate = PreviousTaxPeriodEndDate;
    }

    public final Date getPreviousTaxReturnDate() {
        return this.PreviousTaxReturnDate;
    }

    public final void setPreviousTaxReturnDate(final Date PreviousTaxReturnDate) {
        this.PreviousTaxReturnDate = PreviousTaxReturnDate;
    }

    public final Boolean getUseNoreplyEmail() {
        return this.UseNoreplyEmail;
    }

    public final void setUseNoreplyEmail(final Boolean UseNoreplyEmail) {
        this.UseNoreplyEmail = UseNoreplyEmail;
    }

    public final Boolean getAgeingBasedOnDueDate() {
        return this.AgeingBasedOnDueDate;
    }

    public final void setAgeingBasedOnDueDate(final Boolean AgeingBasedOnDueDate) {
        this.AgeingBasedOnDueDate = AgeingBasedOnDueDate;
    }

    public final Boolean getUseLogoOnEmails() {
        return this.UseLogoOnEmails;
    }

    public final void setUseLogoOnEmails(final Boolean UseLogoOnEmails) {
        this.UseLogoOnEmails = UseLogoOnEmails;
    }

    public final Boolean getUseLogoOnCustomerZone() {
        return this.UseLogoOnCustomerZone;
    }

    public final void setUseLogoOnCustomerZone(final Boolean UseLogoOnCustomerZone) {
        this.UseLogoOnCustomerZone = UseLogoOnCustomerZone;
    }

    public final String getCity() {
        return this.City;
    }

    public final void setCity(final String City) {
        this.City = City;
    }

    public final String getState() {
        return this.State;
    }

    public final void setState(final String State) {
        this.State = State;
    }

    public final String getCountry() {
        return this.Country;
    }

    public final void setCountry(final String Country) {
        this.Country = Country;
    }

    public final Integer getHomeCurrencyId() {
        return this.HomeCurrencyId;
    }

    public final void setHomeCurrencyId(final Integer HomeCurrencyId) {
        this.HomeCurrencyId = HomeCurrencyId;
    }

    public final Integer getCurrencyId() {
        return this.CurrencyId;
    }

    public final void setCurrencyId(final Integer CurrencyId) {
        this.CurrencyId = CurrencyId;
    }

    public final Date getCreated() {
        return this.Created;
    }

    public final void setCreated(final Date Created) {
        this.Created = Created;
    }

    public final Date getModified() {
        return this.Modified;
    }

    public final void setModified(final Date Modified) {
        this.Modified = Modified;
    }

    public final Boolean getActive() {
        return this.Active;
    }

    public final void setActive(final Boolean Active) {
        this.Active = Active;
    }

    public final String getTaxNumber() {
        return this.TaxNumber;
    }

    public final void setTaxNumber(final String TaxNumber) {
        this.TaxNumber = TaxNumber;
    }

    public final String getRegisteredName() {
        return this.RegisteredName;
    }

    public final void setRegisteredName(final String RegisteredName) {
        this.RegisteredName = RegisteredName;
    }

    public final String getRegistrationNumber() {
        return this.RegistrationNumber;
    }

    public final void setRegistrationNumber(final String RegistrationNumber) {
        this.RegistrationNumber = RegistrationNumber;
    }

    public final Boolean getIsPracticeAccount() {
        return this.IsPracticeAccount;
    }

    public final void setIsPracticeAccount(final Boolean IsPracticeAccount) {
        this.IsPracticeAccount = IsPracticeAccount;
    }

    public final Integer getLogoPositionID() {
        return this.LogoPositionID;
    }

    public final void setLogoPositionID(final Integer LogoPositionID) {
        this.LogoPositionID = LogoPositionID;
    }

    public final SageOneCompanyLogoClass getAttachment() {
        return this.Attachment;
    }

    public final void setAttachment(final SageOneCompanyLogoClass Attachment) {
        this.Attachment = Attachment;
    }

    public final String getCompanyTaxNumber() {
        return this.CompanyTaxNumber;
    }

    public final void setCompanyTaxNumber(final String CompanyTaxNumber) {
        this.CompanyTaxNumber = CompanyTaxNumber;
    }

    public final String getTaxOffice() {
        return this.TaxOffice;
    }

    public final void setTaxOffice(final String TaxOffice) {
        this.TaxOffice = TaxOffice;
    }

    public final String getCustomerZoneGuid() {
        return this.CustomerZoneGuid;
    }

    public final void setCustomerZoneGuid(final String CustomerZoneGuid) {
        this.CustomerZoneGuid = CustomerZoneGuid;
    }

    public final Integer getClientTypeId() {
        return this.ClientTypeId;
    }

    public final void setClientTypeId(final Integer ClientTypeId) {
        this.ClientTypeId = ClientTypeId;
    }

    public final Integer getDisplayTotalTypeId() {
        return this.DisplayTotalTypeId;
    }

    public final void setDisplayTotalTypeId(final Integer DisplayTotalTypeId) {
        this.DisplayTotalTypeId = DisplayTotalTypeId;
    }

    public final Boolean getDisplayInCompanyConsole() {
        return this.DisplayInCompanyConsole;
    }

    public final void setDisplayInCompanyConsole(final Boolean DisplayInCompanyConsole) {
        this.DisplayInCompanyConsole = DisplayInCompanyConsole;
    }

    public final Date getLastLoginDate() {
        return this.LastLoginDate;
    }

    public final void setLastLoginDate(final Date LastLoginDate) {
        this.LastLoginDate = LastLoginDate;
    }

    public final SageOneCompanyStatus getStatus() {
        return this.Status;
    }

    public final void setStatus(final SageOneCompanyStatus Status) {
        this.Status = Status;
    }
}
