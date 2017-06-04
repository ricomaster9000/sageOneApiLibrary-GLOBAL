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
 * Created by brent on 2017/05/31.
 */
public final class SageOneBankFeedAccountGroup extends SageOneMainEntity {
    private int BankFeedProviderId;
    private int BankFeedProviderTypeId;
    private String Description;
    private String Identifier;
    private boolean RequiresAdditionalAuthentication;
    private int LastRefreshStatusId;

    public SageOneBankFeedAccountGroup(){
        this.setInitialized(true);
    }

    public int getBankFeedProviderId() {
        return BankFeedProviderId;
    }

    public void setBankFeedProviderId(int bankFeedProviderId) {
        BankFeedProviderId = bankFeedProviderId;
    }

    public int getBankFeedProviderTypeId() {
        return BankFeedProviderTypeId;
    }

    public void setBankFeedProviderTypeId(int bankFeedProviderTypeId) {
        BankFeedProviderTypeId = bankFeedProviderTypeId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public boolean isRequiresAdditionalAuthentication() {
        return RequiresAdditionalAuthentication;
    }

    public void setRequiresAdditionalAuthentication(boolean requiresAdditionalAuthentication) {
        RequiresAdditionalAuthentication = requiresAdditionalAuthentication;
    }

    public int getLastRefreshStatusId() {
        return LastRefreshStatusId;
    }

    public void setLastRefreshStatusId(int lastRefreshStatusId) {
        LastRefreshStatusId = lastRefreshStatusId;
    }

    @Override
    public String toString() {
        return "SageOneBankFeedAccountGroup{" +
                "BankFeedProviderId=" + BankFeedProviderId +
                ", BankFeedProviderTypeId=" + BankFeedProviderTypeId +
                ", Description='" + Description + '\'' +
                ", Identifier='" + Identifier + '\'' +
                ", RequiresAdditionalAuthentication=" + RequiresAdditionalAuthentication +
                ", LastRefreshStatusId=" + LastRefreshStatusId +
                '}';
    }
}
