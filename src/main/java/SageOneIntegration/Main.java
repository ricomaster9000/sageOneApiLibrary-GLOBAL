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
        SageOneApiTemplate.searchEntitiesByAnyValues("Testy555555", SageOneEntityType.SUPPLIER,"DS");

        System.out.println(supplier.get(0).getId() + "sdfsdf");

        System.out.println("aaaaaa " +
                SageOneApiTemplate.deleteSageOneEntitiesByPropertyValue("Testy555555", SageOneEntityType.SUPPLIER,
                        "Name", "helloMense"));

        SageOneSupplier supplierToSave =
                SageOneApiTemplate.saveSageOneEntity("Testy555555",
                new SageOneSupplier.Builder().withName("helloMense").build());


        System.out.println(supplier.get(0).getId());
        System.out.println(supplierToSave.getId());

        System.out.println("dfasa " + SageOneApiTemplate.deleteSageOneEntity("Testy555555", SageOneEntityType.SUPPLIER, supplierToSave.getId()));

        supplierToSave = SageOneApiTemplate.saveSageOneEntity("Testy555555",
                        new SageOneSupplier.Builder().withName("helloMense").build());

        System.out.println("sdfsdf " + supplierToSave.getCreated().toString() + " " +
        SageOneApiTemplate.deleteSageOneEntitiesByPropertyValue("Testy555555", SageOneEntityType.SUPPLIER,
        "Created","2017-06-22"));


        List<SageOneSupplier> listReturned = SageOneApiTemplate.getSageOneEntitiesByType("Testy555555",
        SageOneEntityType.CUSTOMER);

        System.out.println(listReturned.size());
    }
}
