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
package SageOneIntegration;


import SageOneIntegration.SA.SageOneSA;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.Properties;

import static SageOneIntegration.NationalityType.SA;


public final class SageOneApiConnector {
	private static final long serialVersionUID = 1L;
	public static CloseableHttpClient client;
	private NationalityType nationality;
	public static ObjectMapper objectMapper = new ObjectMapper();
	private SageOneSA templateSA;

	public SageOneApiConnector(final NationalityType nationality) {
		this.nationality = nationality;
		SageOneApiConnector.objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

		if(nationality.equals(NationalityType.SA)) {
			if(SageOneIntegration.SA.SageOneConstants.API_VERSION.equals("1.1.2")) {
				templateSA = new SageOneIntegration.SA.V1_1_2.SageOneApiTemplateImpl();
			}
		}
	}

	public void setupSageOneApi(final Properties properties) {

		if(nationality.equals(SA)) {
			templateSA.setupSageOneApi(properties);
		}
	}

	public void setupSageOneApi(final Map<String, String> properties) {
		if(nationality.equals(SA)) {
			this.templateSA.setupSageOneApi(properties);
		}
	}

	public void setupSageOneApi(final Environment properties) {
		if(nationality.equals(SA)) {
			this.templateSA.setupSageOneApi(properties);;
		}
	}

	public final <T> T getTemplate() {
		if(nationality.equals(SA)) {
			return (T) this.templateSA;
		} else {
			return null;
		}
	}


}
