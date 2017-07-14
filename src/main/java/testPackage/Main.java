package testPackage;



import SageOneIntegration.NationalityType;
import SageOneIntegration.SA.SageOneEntityType;
import SageOneIntegration.SA.SageOneSA;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer;
import SageOneIntegration.SageOneApiConnector;

import java.util.List;
import java.util.Properties;

/**
 * Created by Ricardo on 2017-07-05.
 */
public class Main {
        private static SageOneApiConnector sageOneApiConnector = new SageOneApiConnector(NationalityType.SA);

        public static void main(String[] args) {
                Properties properties = new Properties();

                properties.setProperty("sageOneApi.SA.clientUsername", "dagoraf@gmail.com");
                properties.setProperty("sageOneApi.SA.clientPassword", "Sonnyabcd5678@");
                properties.setProperty("sageOneApi.SA.apiKey", "71A42541-A543-4164-8CBA-5E0F0602B141");

                sageOneApiConnector.setupSageOneApi(properties);
                SageOneSA sageOneSATemplate = sageOneApiConnector.getTemplate();

                List<SageOneCustomer> customers =
                        sageOneSATemplate.getSageOneEntitiesByType("rotor",
                                SageOneEntityType.V_1_1_2.CUSTOMER);

                System.out.print(customers.get(0).getName());

                List<SageOneCustomer> searchedCustomer = sageOneSATemplate.searchEntitiesByAnyValues("rotor",
                        SageOneEntityType.V_1_1_2.CUSTOMER, "D", "OO");

                System.out.println(searchedCustomer.size());

        }
}
