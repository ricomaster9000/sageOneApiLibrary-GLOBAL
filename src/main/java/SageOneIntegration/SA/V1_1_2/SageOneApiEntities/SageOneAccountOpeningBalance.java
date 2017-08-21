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

import java.util.Date;

/**
 * Created by Ricardo on 2017-08-21.
 */
public final class SageOneAccountOpeningBalance extends SageOneMainEntity {
    private Integer AccountId;
    private double Balance;
    private String Reason;
    private Date Date;

    public final Integer getAccountId() {
        return (this.isInitialized()) ? this.AccountId : null;
    }

    public final void setAccountId(final Integer AccountId) {
        this.AccountId = (this.isInitialized()) ? AccountId : this.AccountId;
    }

    public final double getBalance() {
        return (this.isInitialized()) ? this.Balance : 0.00;
    }

    public final void setBalance(final double Balance) {
        this.Balance = (this.isInitialized()) ? Balance : this.Balance;
    }

    public final String getReason() {
        return (this.isInitialized()) ? this.Reason : null;
    }

    public final void setReason(final String Reason) {
        this.Reason = (this.isInitialized()) ? Reason : this.Reason;
    }

    public final Date getDate() {
        return (this.isInitialized()) ? this.Date : null;
    }

    public final void setDate(final Date Date) {
        this.Date = (this.isInitialized()) ? Date : this.Date;
    }
}
