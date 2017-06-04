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
public final class SageOneContact extends SageOneMainEntity {
    private String description;
    private double quantity;
    private double unit_price;
    private double net_amount;
    private double tax_amount;
    private SageOneDatabaseEntityRelationshipSageOne[] tax_code;
    private double tax_rate_percentage;
    private boolean unit_price_includes_tax;
    private SageOneDatabaseEntityRelationshipSageOne[] ledger_account;
    private String product_code;
    private SageOneDatabaseEntityRelationshipSageOne[] product;
    private SageOneDatabaseEntityRelationshipSageOne[] service;

    public final String getDescription() { return (this.isInitialized()) ? this.description : ""; }

    public final void setDescription(final String description) {
        this.description = (this.isInitialized()) ? description : this.description;
    }

    public final double getQuantity() { return (this.isInitialized()) ? this.quantity : -0.00; }

    public final void setQuantity(final double quantity) {
        this.quantity = (this.isInitialized()) ? quantity : this.quantity;
    }

    public final double getUnit_price() { return (this.isInitialized()) ? this.unit_price : -0.00; }

    public final void setUnit_price(final double unit_price) {
        this.unit_price = (this.isInitialized()) ? unit_price : this.unit_price;
    }

    public final double getNet_amount() { return (this.isInitialized()) ? this.net_amount : -0.00; }

    public final void setNet_amount(final double net_amount) {
        this.net_amount = (this.isInitialized()) ? net_amount : this.net_amount;
    }

    public final double getTax_amount() { return (this.isInitialized()) ? this.tax_amount : -0.00; }

    public final void setTax_amount(final double tax_amount) {
        this.tax_amount = (this.isInitialized()) ? tax_amount : this.tax_amount;
    }

    public final SageOneDatabaseEntityRelationshipSageOne[] getTax_code() {
        return (this.isInitialized()) ? this.tax_code : new SageOneDatabaseEntityRelationshipSageOne[0];
    }

    public final void setQuantity(final SageOneDatabaseEntityRelationshipSageOne[] tax_code) {
        this.tax_code = (this.isInitialized()) ? tax_code : this.tax_code;
    }

    public final double getTax_rate_percentage() { return (this.isInitialized()) ? this.tax_rate_percentage : -0.00; }

    public final void setTax_rate_percentage(final double tax_rate_percentage) {
        this.tax_rate_percentage = (this.isInitialized()) ? tax_rate_percentage : this.tax_rate_percentage;
    }

    public final boolean getUnit_price_includes_tax() { return (this.isInitialized() && this.unit_price_includes_tax); }

    public final void setUnit_price_includes_tax(final boolean unit_price_includes_tax) {
        this.unit_price_includes_tax = (this.isInitialized()) ? unit_price_includes_tax : this.unit_price_includes_tax;
    }

    public final SageOneDatabaseEntityRelationshipSageOne[] getLedger_account() {
        return (this.isInitialized()) ? this.ledger_account : new SageOneDatabaseEntityRelationshipSageOne[0];
    }

    public final void setLedger_account(final SageOneDatabaseEntityRelationshipSageOne[] ledger_account) {
        this.ledger_account = (this.isInitialized()) ? ledger_account : this.ledger_account;
    }

    public final String getProduct_code() { return (this.isInitialized()) ? this.product_code : ""; }

    public final void setProduct_code(final String product_code) {
        this.product_code = (this.isInitialized()) ? product_code : this.product_code;
    }

    public final SageOneDatabaseEntityRelationshipSageOne[] getProduct() {
        return (this.isInitialized()) ? this.product : new SageOneDatabaseEntityRelationshipSageOne[0];
    }

    public final void setProduct(final SageOneDatabaseEntityRelationshipSageOne[] product) {
        this.product = (this.isInitialized()) ? product : this.product;
    }

    public final SageOneDatabaseEntityRelationshipSageOne[] getService() {
        return (this.isInitialized()) ? this.service : new SageOneDatabaseEntityRelationshipSageOne[0];
    }

    public final void setService(final SageOneDatabaseEntityRelationshipSageOne[] service) {
        this.service = (this.isInitialized()) ? service : this.service;
    }
}
