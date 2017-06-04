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
 * Created by ricardo on 2017/05/30.
 */
public final class SageOneCompany extends SageOneMainEntity {
    private String Name = "";
    private String CurrencySymbol = "";
    private int CurrencyDecimalDigits = 0;
    private int NumberDecimalDigits = 0;
    private String DecimalSeparator = "";
    private int HoursDecimalDigits = 0;
    private int ItemCostPriceDecimalDigits = 0;
    private int ItemSellingPriceDecimalDigits = 0;
    private String PostalAddress1 = "";
    private String PostalAddress2 = "";
    private String PostalAddress3 = "";
    private String PostalAddress4 = "";
    private String PostalAddress5 = "";
    private String GroupSeparator = "";
    private int RoundingValue = 0;
    private SageOneTaxSystemClass TaxSystem;
    private SageOneRoundingTypeClass RoundingType;
    private boolean AgeMonthly;
    private boolean DisplayInactiveItems;
    private boolean WarnWhenItemCostIsZero;
    private boolean DoNotAllowProcessingIntoNegativeQuantities;
    private boolean WarnWhenItemQuantityIsZero;
    private boolean WarnWhenItemSellingBelowCost;
    private int CountryId;
    private int CompanyEntityTypeId;
    private Date TakeOnBalanceDate;
    private boolean EnableCustomerZone;
    private boolean EnableAutomaticBankFeedRefresh;
    private String ContactName;
    private String Telephone;
    private String Fax;
    private String Mobile;
    private String Email;
    private boolean IsPrimarySendingEmail;
    private String PostalAddress01 = "";
    private String PostalAddress02 = "";
    private String PostalAddress03 = "";
    private String PostalAddress04 = "";
    private String PostalAddress05 = "";
    private String CompanyInfo01;
    private String CompanyInfo02;
    private String CompanyInfo03;
    private String CompanyInfo04;
    private String CompanyInfo05;
    private boolean IsOwner;
    private boolean UseCCEmail;
    private String CCEmail;
    private int DateFormatId;
    private boolean CheckForDuplicateCustomerReferences;
    private boolean CheckForDuplicateSupplierReferences;
    private String DisplayName;
    private boolean DisplayInactiveCustomers;
    private boolean DisplayInactiveSuppliers;
    private boolean DisplayInactiveTimeProjects;
    private boolean UseInclusiveProcessingByDefault;
    private boolean LockProcessing;
    private Date LockProcessingDate;
    private boolean LockTimesheetProcessing;
    private Date LockTimesheetProcessingDate;
    private int TaxPeriodFrequency;
    private Date PreviousTaxPeriodEndDate;
    private Date PreviousTaxReturnDate;
    private boolean UseNoreplyEmail;
    private boolean AgeingBasedOnDueDate;
    private boolean UseLogoOnEmails;
    private boolean UseLogoOnCustomerZone;
    private String City;
    private String State;
    private String Country;
    private int HomeCurrencyId;
    private int CurrencyId;
    private Date Created;
    private Date Modified;
    private boolean Active;
    private String TaxNumber;
    private String RegisteredName;
    private String RegistrationNumber;
    private boolean IsPracticeAccount;
    private int LogoPositionID;
    private SageOneCompanyLogoClass Attachment;
    private String CompanyTaxNumber;
    private String TaxOffice;
    private String CustomerZoneGuid;
    private int ClientTypeId;
    private int DisplayTotalTypeId;
    private boolean DisplayInCompanyConsole;
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

    public final int getCurrencyDecimalDigits() {
        return this.CurrencyDecimalDigits;
    }

    public final void setCurrencyDecimalDigits(final int CurrencyDecimalDigits) {
        this.CurrencyDecimalDigits = CurrencyDecimalDigits;
    }

    public final int getNumberDecimalDigits() {
        return this.NumberDecimalDigits;
    }

    public final void setNumberDecimalDigits(final int NumberDecimalDigits) {
        this.NumberDecimalDigits = NumberDecimalDigits;
    }

    public final String getDecimalSeparator() {
        return this.DecimalSeparator;
    }

    public final void setDecimalSeparator(final String DecimalSeparator) {
        this.DecimalSeparator = DecimalSeparator;
    }

    public final int getHoursDecimalDigits() {
        return this.HoursDecimalDigits;
    }

    public final void setHoursDecimalDigits(final int HoursDecimalDigits) {
        this.HoursDecimalDigits = HoursDecimalDigits;
    }

    public final int getItemCostPriceDecimalDigits() {
        return this.ItemCostPriceDecimalDigits;
    }

    public final void setItemCostPriceDecimalDigits(final int ItemCostPriceDecimalDigits) {
        this.ItemCostPriceDecimalDigits = ItemCostPriceDecimalDigits;
    }

    public final int getItemSellingPriceDecimalDigits() {
        return this.ItemSellingPriceDecimalDigits;
    }

    public final void setItemSellingPriceDecimalDigits(final int ItemSellingPriceDecimalDigits) {
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

    public final int getRoundingValue() {
        return this.RoundingValue;
    }

    public final void setRoundingValue(final int RoundingValue) {
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

    public final boolean getAgeMonthly() {
        return this.AgeMonthly;
    }

    public final void setAgeMonthly(final boolean AgeMonthly) {
        this.AgeMonthly = AgeMonthly;
    }

    public final boolean getDisplayInactiveItems() {
        return this.DisplayInactiveItems;
    }

    public final void setDisplayInactiveItems(final boolean DisplayInactiveItems) {
        this.DisplayInactiveItems = DisplayInactiveItems;
    }

    public final boolean getWarnWhenItemCostIsZero() {
        return this.WarnWhenItemCostIsZero;
    }

    public final void setWarnWhenItemCostIsZero(final boolean WarnWhenItemCostIsZero) {
        this.WarnWhenItemCostIsZero = WarnWhenItemCostIsZero;
    }

    public final boolean getDoNotAllowProcessingIntoNegativeQuantities() {
        return this.DoNotAllowProcessingIntoNegativeQuantities;
    }

    public final void setDoNotAllowProcessingIntoNegativeQuantities(final boolean DoNotAllowProcessingIntoNegativeQuantities) {
        this.DoNotAllowProcessingIntoNegativeQuantities = DoNotAllowProcessingIntoNegativeQuantities;
    }

    public final boolean getWarnWhenItemQuantityIsZero() {
        return this.WarnWhenItemQuantityIsZero;
    }

    public final void setWarnWhenItemQuantityIsZero(final boolean WarnWhenItemQuantityIsZero) {
        this.WarnWhenItemQuantityIsZero = WarnWhenItemQuantityIsZero;
    }

    public final boolean getWarnWhenItemSellingBelowCost() {
        return this.WarnWhenItemSellingBelowCost;
    }

    public final void setWarnWhenItemSellingBelowCost(final boolean WarnWhenItemSellingBelowCost) {
        this.WarnWhenItemSellingBelowCost = WarnWhenItemSellingBelowCost;
    }

    public final int getCountryId() {
        return this.CountryId;
    }

    public final void setCountryId(final int CountryId) {
        this.CountryId = CountryId;
    }

    public final int getCompanyEntityTypeId() {
        return this.CompanyEntityTypeId;
    }

    public final void setCompanyEntityTypeId(final int CompanyEntityTypeId) {
        this.CompanyEntityTypeId = CompanyEntityTypeId;
    }

    public final Date getTakeOnBalanceDate() {
        return this.TakeOnBalanceDate;
    }

    public final void TakeOnBalanceDate(final Date TakeOnBalanceDate) {
        this.TakeOnBalanceDate = TakeOnBalanceDate;
    }

    public final boolean getEnableCustomerZone() {
        return this.EnableCustomerZone;
    }

    public final void setEnableCustomerZone(final boolean EnableCustomerZone) {
        this.EnableCustomerZone = EnableCustomerZone;
    }

    public final boolean getEnableAutomaticBankFeedRefresh() {
        return this.EnableAutomaticBankFeedRefresh;
    }

    public final void setEnableAutomaticBankFeedRefresh(final boolean EnableAutomaticBankFeedRefresh) {
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

    public final boolean getIsPrimarySendingEmail() {
        return this.IsPrimarySendingEmail;
    }

    public final void setIsPrimarySendingEmail(final boolean IsPrimarySendingEmail) {
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

    public final boolean getIsOwner() {
        return this.IsOwner;
    }

    public final void setIsOwner(final boolean IsOwner) {
        this.IsOwner = IsOwner;
    }

    public final boolean getUseCCEmail() {
        return this.UseCCEmail;
    }

    public final void setUseCCEmail(final boolean UseCCEmail) {
        this.UseCCEmail = UseCCEmail;
    }

    public final String getCCEmail() {
        return this.CCEmail;
    }

    public final void setCCEmail(final String CCEmail) {
        this.CCEmail = CCEmail;
    }

    public final int getDateFormatId() {
        return this.DateFormatId;
    }

    public final void setDateFormatId(final int DateFormatId) {
        this.DateFormatId = DateFormatId;
    }

    public final boolean getCheckForDuplicateCustomerReferences() {
        return this.CheckForDuplicateCustomerReferences;
    }

    public final void setCheckForDuplicateCustomerReferences(final boolean CheckForDuplicateCustomerReferences) {
        this.CheckForDuplicateCustomerReferences = CheckForDuplicateCustomerReferences;
    }

    public final boolean getCheckForDuplicateSupplierReferences() {
        return this.CheckForDuplicateSupplierReferences;
    }

    public final void setCheckForDuplicateSupplierReferences(final boolean CheckForDuplicateSupplierReferences) {
        this.CheckForDuplicateSupplierReferences = CheckForDuplicateSupplierReferences;
    }

    public final String getDisplayName() {
        return this.DisplayName;
    }

    public final void setDisplayName(final String DisplayName) {
        this.DisplayName = DisplayName;
    }

    public final boolean getDisplayInactiveCustomers() {
        return this.DisplayInactiveCustomers;
    }

    public final void setDisplayInactiveCustomers(final boolean DisplayInactiveCustomers) {
        this.DisplayInactiveCustomers = DisplayInactiveCustomers;
    }

    public final boolean getDisplayInactiveSuppliers() {
        return this.DisplayInactiveSuppliers;
    }

    public final void setDisplayInactiveSuppliers(final boolean DisplayInactiveSuppliers) {
        this.DisplayInactiveSuppliers = DisplayInactiveSuppliers;
    }

    public final boolean getDisplayInactiveTimeProjects() {
        return this.DisplayInactiveTimeProjects;
    }

    public final void setDisplayInactiveTimeProjects(final boolean DisplayInactiveTimeProjects) {
        this.DisplayInactiveTimeProjects = DisplayInactiveTimeProjects;
    }

    public final boolean getUseInclusiveProcessingByDefault() {
        return this.UseInclusiveProcessingByDefault;
    }

    public final void setUseInclusiveProcessingByDefault(final boolean UseInclusiveProcessingByDefault) {
        this.UseInclusiveProcessingByDefault = UseInclusiveProcessingByDefault;
    }

    public final boolean getLockProcessing() {
        return this.LockProcessing;
    }

    public final void setLockProcessing(final boolean LockProcessing) {
        this.LockProcessing = LockProcessing;
    }

    public final Date getLockProcessingDate() {
        return this.LockProcessingDate;
    }

    public final void setLockProcessingDate(final Date LockProcessingDate) {
        this.LockProcessingDate = LockProcessingDate;
    }

    public final boolean getLockTimesheetProcessing() {
        return this.LockTimesheetProcessing;
    }

    public final void setLockTimesheetProcessing(final boolean LockTimesheetProcessing) {
        this.LockTimesheetProcessing = LockTimesheetProcessing;
    }

    public final Date getLockTimesheetProcessingDate() {
        return this.LockTimesheetProcessingDate;
    }

    public final void setLockTimesheetProcessingDate(final Date LockTimesheetProcessingDate) {
        this.LockTimesheetProcessingDate = LockTimesheetProcessingDate;
    }

    public final int getTaxPeriodFrequency() {
        return this.TaxPeriodFrequency;
    }

    public final void setTaxPeriodFrequency(final int TaxPeriodFrequency) {
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

    public final boolean getUseNoreplyEmail() {
        return this.UseNoreplyEmail;
    }

    public final void setUseNoreplyEmail(final boolean UseNoreplyEmail) {
        this.UseNoreplyEmail = UseNoreplyEmail;
    }

    public final boolean getAgeingBasedOnDueDate() {
        return this.AgeingBasedOnDueDate;
    }

    public final void setAgeingBasedOnDueDate(final boolean AgeingBasedOnDueDate) {
        this.AgeingBasedOnDueDate = AgeingBasedOnDueDate;
    }

    public final boolean getUseLogoOnEmails() {
        return this.UseLogoOnEmails;
    }

    public final void setUseLogoOnEmails(final boolean UseLogoOnEmails) {
        this.UseLogoOnEmails = UseLogoOnEmails;
    }

    public final boolean getUseLogoOnCustomerZone() {
        return this.UseLogoOnCustomerZone;
    }

    public final void setUseLogoOnCustomerZone(final boolean UseLogoOnCustomerZone) {
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

    public final int getHomeCurrencyId() {
        return this.HomeCurrencyId;
    }

    public final void setHomeCurrencyId(final int HomeCurrencyId) {
        this.HomeCurrencyId = HomeCurrencyId;
    }

    public final int getCurrencyId() {
        return this.CurrencyId;
    }

    public final void setCurrencyId(final int CurrencyId) {
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

    public final boolean getActive() {
        return this.Active;
    }

    public final void setActive(final boolean Active) {
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

    public final boolean getIsPracticeAccount() {
        return this.IsPracticeAccount;
    }

    public final void setIsPracticeAccount(final boolean IsPracticeAccount) {
        this.IsPracticeAccount = IsPracticeAccount;
    }

    public final int getLogoPositionID() {
        return this.LogoPositionID;
    }

    public final void setLogoPositionID(final int LogoPositionID) {
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

    public final int getClientTypeId() {
        return this.ClientTypeId;
    }

    public final void setClientTypeId(final int ClientTypeId) {
        this.ClientTypeId = ClientTypeId;
    }

    public final int getDisplayTotalTypeId() {
        return this.DisplayTotalTypeId;
    }

    public final void setDisplayTotalTypeId(final int DisplayTotalTypeId) {
        this.DisplayTotalTypeId = DisplayTotalTypeId;
    }

    public final boolean getDisplayInCompanyConsole() {
        return this.DisplayInCompanyConsole;
    }

    public final void setDisplayInCompanyConsole(final boolean DisplayInCompanyConsole) {
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
