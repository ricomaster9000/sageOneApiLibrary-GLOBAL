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

import java.util.Date;


public final class SageOneBudgetItemPeriod extends SageOneMainEntity {
    private Date Date;
    private Double Total;

    public final Date getDate() {
        return (this.isInitialized()) ? this.Date : null;
    }

    public final void setDate(final Date Date) {
        this.Date = (this.isInitialized()) ? Date : this.Date;
    }

    public final Double getTotal() {
        return (this.isInitialized()) ? this.Total : null;
    }

    public final void setTotal(final Double Total) {
        this.Total = (this.isInitialized()) ? Total : this.Total;
    }
}
