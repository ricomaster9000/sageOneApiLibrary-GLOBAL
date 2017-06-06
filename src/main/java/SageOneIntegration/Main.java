package SageOneIntegration;

import SageOneIntegration.SageOneApiEntities.SageOneCommercialDocumentLine;
import SageOneIntegration.SageOneApiEntities.SageOneSupplier;
import SageOneIntegration.SageOneApiEntities.SageOneSupplierReturn;

import java.util.Date;
import java.util.Properties;

/**
 * Created by ricardo on 2017/06/06.
 */
public class Main {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("sageOneApi.SA.apiVersion","1.1.2");
        properties.setProperty("sageOneApi.SA.requestResultLimit","100");
        properties.setProperty("sageOneApi.SA.requestTimeout","30000");
        properties.setProperty("sageOneApi.SA.requestLimitDay","5000");
        properties.setProperty("sageOneApi.SA.requestLimitHour","100");


        SageOneApiConnector.setupSageOneApiSA(properties);

        Date dateToUse = new Date();

        SageOneSupplier supplier = SageOneApiTemplate.getSupplierByName("Testy555555", "sdfsdfsdf");

        SageOneSupplierReturn sageOneSupplierReturn = new SageOneSupplierReturn.Builder().withDate(dateToUse)
                .withTotal(5000).withSupplierName("sdfsdfsdf").withSupplier(supplier)
                .withSupplierId(supplier.getId()).withLines(new SageOneCommercialDocumentLine[]{new SageOneCommercialDocumentLine.Builder().build()}).build();

        sageOneSupplierReturn = SageOneApiTemplate.saveSageOneEntity("Testy555555", sageOneSupplierReturn);

        System.out.println(sageOneSupplierReturn.getId());

    }
}
