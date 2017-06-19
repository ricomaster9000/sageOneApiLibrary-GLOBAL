package SageOneIntegration;

import SageOneIntegration.SageOneApiEntities.SageOneSupplier;

import java.util.List;
import java.util.Properties;

/**
 * Created by ricardo on 2017/06/15.
 */
public class Main {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("sageOneApi.SA.clientUsername", "ricorpwd@yahoo.co.za");

        properties.setProperty("sageOneApi.SA.clientPassword", "");

        properties.setProperty("sageOneApi.SA.apiKey", "");

        SageOneApiConnector.setupSageOneApiSA(properties);


        List<SageOneSupplier> supplier =
        SageOneApiTemplate.getEntitiesByPropertyValue("Testy555555", SageOneEntityType.SUPPLIER,
        "Name", "DS");


        System.out.println(supplier.get(0).getId());

        List<SageOneSupplier> listReturned = SageOneApiTemplate.getSageOneEntitiesByType("Testy555555",
        SageOneEntityType.CUSTOMER);

        System.out.println(listReturned.size());
    }
}
