package testPackage;



import SageOneIntegration.NationalityType;
import SageOneIntegration.SA.ReusableClasses.SageOneHttpResponseMessage;
import SageOneIntegration.SA.SageOneCoreConnection;
import SageOneIntegration.SA.SageOneEntityType;
import SageOneIntegration.SA.SageOneSA;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAttachment;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer;
import SageOneIntegration.SageOneApiConnector;
import org.apache.tika.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by Ricardo on 2017-07-05.
 */
public class Main {
        private static SageOneApiConnector sageOneApiConnector = new SageOneApiConnector(NationalityType.SA);

        public static void main(String[] args) {
                Properties properties = new Properties();

                // Version 2.0.0
                properties.setProperty("sageOneApi.SA.clientUsername", "dagoraf@gmail.com");
                properties.setProperty("sageOneApi.SA.clientPassword", "Sonnyabcd5678@");
                properties.setProperty("sageOneApi.SA.apiKey", "71A42541-A543-4164-8CBA-5E0F0602B141");

                sageOneApiConnector.setupSageOneApi(properties);
                SageOneSA sageOneSATemplate = sageOneApiConnector.getTemplate();

                List<SageOneCustomer> customers = sageOneSATemplate.getSageOneEntitiesByType("rotor",
                SageOneEntityType.V_1_1_2.CUSTOMER);

                System.out.println(customers.get(0).getName());

                List<SageOneCustomer> searchedCustomer = sageOneSATemplate.searchEntitiesByAnyValues("rotor",
                SageOneEntityType.V_1_1_2.CUSTOMER, "D", "OO");

                System.out.println(searchedCustomer.size());

                List<SageOneCustomer> sageOneCustomers =
                sageOneSATemplate.searchEntitiesByAnyMatchedPropertyValues("rotor",
                SageOneEntityType.V_1_1_2.CUSTOMER, new String[]{"Name"}, new String[]{"DC"});

                System.out.println("hello");

                System.out.println(sageOneCustomers.size());
                // End of Version 2.0.0

                File file = new File(FileSystemView.getFileSystemView().getHomeDirectory() + File.separator + File.separator +
                File.separator + "helloTest.txt");

                try {

                        // Version 2.1.0
                        SageOneAttachment attachment = new SageOneAttachment();
                        FileInputStream inputStream = new FileInputStream(file);
                        byte[] fileData = new byte[]{};
                        System.out.println(file.length());
                        fileData = IOUtils.toByteArray(inputStream);
                        System.out.println(fileData.length);

                        attachment.setName(file.getName());
                        attachment.setSize(file.length());
                        attachment.setData(fileData);
                        attachment.setAttachmentUID(UUID.randomUUID());

                        SageOneAttachment attchmentSaved = sageOneSATemplate.saveSageOneAttachment("rotor",
                        SageOneEntityType.V_1_1_2.ACCOUNT_NOTE_ATTACHMENT, attachment);
                } catch(FileNotFoundException e) {
                        e.printStackTrace();
                } catch(IOException e) {
                        e.printStackTrace();
                }

                        //SageOneHttpResponseMessage downloadResponse




        }
}
