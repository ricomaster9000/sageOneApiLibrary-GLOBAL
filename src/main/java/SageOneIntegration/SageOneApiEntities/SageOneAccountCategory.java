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


public final class SageOneAccountCategory extends SageOneMainEntity {
    private String Comment;
    private Integer Order;
    private String Description;
    private Date Modified;
    private Date Created;

    public final String getComment() {
        return (this.isInitialized()) ? this.Comment : null;
    }

    public final void setComment(final String Comment) {
        this.Comment = (this.isInitialized()) ? Comment : this.Comment;
    }

    public final Integer getOrder() {
        return (this.isInitialized()) ? this.Order : null;
    }

    public final void setOrder(final Integer Order) {
        this.Order = (this.isInitialized()) ? Order : this.Order;
    }

    public final String getDescription() {
        return (this.isInitialized()) ? this.Description : null;
    }

    public final void setDescription(final String Description) {
        this.Description = (this.isInitialized()) ? Description : this.Description;
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
}
