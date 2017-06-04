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

import java.util.Date;

/**
 * Created by brent on 2017/05/31.
 */
public final class SageOneTaxType extends SageOneMainEntity {
    private String Name;
    private double Percentage;
    private boolean IsDefault;
    private boolean HasActivity;
    private boolean IsManualTax;
    private Date Created;
    private Date Modified;

    public SageOneTaxType() {
        this.setInitialized(true);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPercentage() {
        return Percentage;
    }

    public void setPercentage(double percentage) {
        Percentage = percentage;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean aDefault) {
        IsDefault = aDefault;
    }

    public boolean isHasActivity() {
        return HasActivity;
    }

    public void setHasActivity(boolean hasActivity) {
        HasActivity = hasActivity;
    }

    public boolean isManualTax() {
        return IsManualTax;
    }

    public void setManualTax(boolean manualTax) {
        IsManualTax = manualTax;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }

    public Date getModified() {
        return Modified;
    }

    public void setModified(Date modified) {
        Modified = modified;
    }

    @Override
    public String toString() {
        return "SageOneTaxType{" +
                "Name='" + Name + '\'' +
                ", Percentage=" + Percentage +
                ", IsDefault=" + IsDefault +
                ", HasActivity=" + HasActivity +
                ", IsManualTax=" + IsManualTax +
                ", Created=" + Created +
                ", Modified=" + Modified +
                '}';
    }
}
