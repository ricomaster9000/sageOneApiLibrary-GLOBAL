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

/**
 * Created by ricomaster9000 on 2017/05/24.
 */

public final class PurchaseInvoice extends MainEntity {
    private SageOneDatabaseEntityRelationship[] status;
    private String due_date;
    private String date;
    private String void_reason;
    private double outstanding_amount;
    private double total_net_amount;
    private double total_tax_amount;
    private int tax_scheme_period_id;
    private SageOneDatabaseEntityRelationship[] contact;
    private String contact_name;
    private String main_address;
    private String delivery_address;
    private boolean delivery_address_same_as_main;
    private String reference;
    private String notes;
    private String terms_and_conditions;
    private SageOneContact[] line_items;

    public PurchaseInvoice() {
        this.setInitialized(true);
    }

    public final SageOneDatabaseEntityRelationship[] getStatus() {
        return (this.isInitialized()) ? this.status : new SageOneDatabaseEntityRelationship[0];
    }

    public final void setStatus(final SageOneDatabaseEntityRelationship[] status) {
        this.status = (this.isInitialized()) ? status : this.status;
    }

    public final String getDue_date() {
        return (this.isInitialized()) ? this.due_date : "";
    }

    public final void setDue_date(final String due_date) {
        this.due_date = (this.isInitialized()) ? due_date : this.due_date;
    }

    public final String getDate() { return (this.isInitialized()) ? date : ""; }

    public final void setDate(final String date) { this.date = (this.isInitialized()) ? date : this.date; }


    public final String getVoid_reason() { return (this.isInitialized()) ? this.void_reason : ""; }

    public final void setVoid_reason(final String void_reason) {
        this.void_reason = (this.isInitialized()) ? void_reason : this.void_reason;
    }

    public final double getOutstanding_amount() {
        return (this.isInitialized()) ? this.outstanding_amount : -0.01;
    }

    public final void setOutstanding_amount(final double outstanding_amount) {
        this.outstanding_amount = (this.isInitialized()) ? outstanding_amount : this.outstanding_amount;
    }

    public final double getTotal_net_amount() {
        return (this.isInitialized()) ? this.total_net_amount : -0.01;
    }

    public final void setTotal_net_amount(final double total_net_amount) {
        this.total_net_amount = (this.isInitialized()) ? total_net_amount : this.total_net_amount;
    }

    public final double getTotal_tax_amount() {
        return (this.isInitialized()) ? this.total_tax_amount : -0.01;
    }

    public final void setTotal_tax_amount(final double total_tax_amount) {
        this.total_tax_amount = (this.isInitialized()) ? total_tax_amount : this.total_tax_amount;
    }

    public final int getTax_scheme_period_id() {
        return (this.isInitialized()) ? this.tax_scheme_period_id : -1;
    }

    public final void setTax_scheme_period_id(final int tax_scheme_period_id) {
        this.tax_scheme_period_id = (this.isInitialized()) ? tax_scheme_period_id : this.tax_scheme_period_id;
    }

    public final SageOneDatabaseEntityRelationship[] getContact() {
        return (this.isInitialized()) ? this.contact : new SageOneDatabaseEntityRelationship[0];
    }

    public void setContact(final SageOneDatabaseEntityRelationship[] contact) {
        this.contact = (this.isInitialized()) ? contact : this.contact;
    }

    public final String getContact_name() {
        return (this.isInitialized()) ? this.contact_name : "";
    }

    public final void setContact_name(final String contact_name) {
        this.contact_name = (this.isInitialized()) ? contact_name : this.contact_name;
    }

    public final String getMain_address() {
        return (this.isInitialized()) ? this.main_address : "";
    }

    public final void setMain_addresse(final String main_address) {
        this.main_address = (this.isInitialized()) ? main_address : this.main_address;
    }

    public final String getDelivery_address() {
        return (this.isInitialized()) ? this.delivery_address : "";
    }

    public final void setDelivery_address(final String delivery_address) {
        this.delivery_address = (this.isInitialized()) ? delivery_address : this.delivery_address;
    }

    public final boolean getDelivery_address_same_as_main() {
        return (this.isInitialized() && this.delivery_address_same_as_main);
    }

    public final void setDelivery_address_same_as_main(final boolean delivery_address_same_as_main) {
        this.delivery_address_same_as_main = (this.isInitialized()) ? delivery_address_same_as_main : this.delivery_address_same_as_main;
    }

    public final String getReference() { return (this.isInitialized()) ? this.reference : ""; }

    public final void setReference(final String reference) {
        this.reference = (this.isInitialized()) ? reference : this.reference;
    }

    public final String getNotes() { return (this.isInitialized()) ? this.notes : ""; }

    public final void setNotes(final String notes) {
        this.notes = (this.isInitialized()) ? notes.substring(0, 1000) : this.notes;
    }

    public final String getTerms_and_conditions() { return (this.isInitialized()) ? this.terms_and_conditions : ""; }

    public final void setTerms_and_conditions(final String terms_and_conditions) {
        this.terms_and_conditions = (this.isInitialized()) ? terms_and_conditions : this.terms_and_conditions;
    }

    public final SageOneContact[] getLine_items() {
        return (this.isInitialized()) ? this.line_items : new SageOneContact[0];
    }

    public final void setLine_items(final SageOneContact[] line_items) {
        this.line_items = (this.isInitialized()) ? line_items : this.line_items;
    }
}
