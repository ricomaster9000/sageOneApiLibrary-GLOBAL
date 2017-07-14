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

/**
 * Created by ricardo on 2017/05/30.
 */
public final class SageOneGrabbedResultsClass {
    private int TotalResults;
    private int ReturnedResults;
    private Object[] Results;

    public final int getTotalResults() {
        return this.TotalResults;
    }

    public final void setTotalResults(final int TotalResults) {
        this.TotalResults = TotalResults;
    }

    public final int getReturnedResults() {
        return this.ReturnedResults;
    }

    public final void setReturnedResults(final int ReturnedResults) {
        this.ReturnedResults = ReturnedResults;
    }

    public final Object[] getResults() {
        return Results;
    }

    public final void setResults(final Object[] Results) {
        this.Results = Results;
    }

}
