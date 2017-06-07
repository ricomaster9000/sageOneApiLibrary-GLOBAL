package SageOneIntegration;

import SageOneIntegration.SageOneApiEntities.*;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

/**
 * Created by ricardo on 2017/06/06.
 */
public class Main {
    static boolean x = false;

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.setProperty("sageOneApi.SA.clientUsername", "ricorpwd@yahoo.co.za");
        properties.setProperty("sageOneApi.SA.clientPassword","StartingSmall500*");
        properties.setProperty("sageOneApi.SA.apiVersion","1.1.2");
        properties.setProperty("sageOneApi.SA.apiKey","71A42541-A543-4164-8CBA-5E0F0602B141");
        properties.setProperty("sageOneApi.SA.requestResultLimit","100");
        properties.setProperty("sageOneApi.SA.requestTimeout","30000");
        properties.setProperty("sageOneApi.SA.requestLimitDay","5000");
        properties.setProperty("sageOneApi.SA.requestLimitHour","100");


        SageOneApiConnector.setupSageOneApiSA(properties);

        Date dateToUse = new Date();

        SageOneSupplier supplier = SageOneApiTemplate.getEntityByPropertyValue("Testy555555", SageOneEntityType.SUPPLIER, "Name", "DS");
        SageOneItem item = SageOneApiTemplate.getEntityByPropertyValue("Testy555555", SageOneEntityType.ITEM, "Code", "ID");
        List<SageOneBankAccount> account = SageOneApiTemplate.getEntitiesByPropertyValue("Testy555555", SageOneEntityType.BANK_ACCOUNT, "Name", "test55");

        System.out.println(account.get(0).getId() + " sdfsdfsdf");
        SageOneSupplierInvoice sageOneSupplierInvoice = new SageOneSupplierInvoice.Builder().withDate(dateToUse).withDueDate(dateToUse)
                .withTotal(5000.00).withSupplier(supplier)
                .withSupplierId(supplier.getId())
                .withLines(new SageOneCommercialDocumentLine[]{new SageOneCommercialDocumentLine.Builder().withSelectionId(item.getId()).build()})
                .build();

        sageOneSupplierInvoice = SageOneApiTemplate.saveSageOneEntity("Testy555555", sageOneSupplierInvoice);
    }
}
