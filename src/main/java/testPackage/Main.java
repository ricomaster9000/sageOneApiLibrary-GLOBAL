package testPackage;



import SageOneIntegration.NationalityType;
import SageOneIntegration.SA.ReusableClasses.SageOneHttpResponseMessage;
import SageOneIntegration.SA.SageOneCoreConnection;
import SageOneIntegration.SA.SageOneEntityType;
import SageOneIntegration.SA.SageOneSA;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAttachment;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer;
import SageOneIntegration.SageOneApiConnector;
import SageOneIntegration.SageOneDownloadDataWrapper;
import SageOneIntegration.SageOneUploadDataWrapper;
import org.apache.tika.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Callable;


public class Main {
        private static SageOneApiConnector sageOneApiConnector = new SageOneApiConnector(NationalityType.SA);

        public static void main(String[] args) {
                Properties properties = new Properties();

                // Version 2.0.*

                properties.setProperty("sageOneApi.SA.clientUsername", "ricbus98@gmail.com");
                properties.setProperty("sageOneApi.SA.clientPassword", "Sonnyabcd5678@");
                properties.setProperty("sageOneApi.SA.apiKey", "");

                sageOneApiConnector.setupSageOneApi(properties);
                SageOneSA sageOneSATemplate = sageOneApiConnector.getTemplate();

                List<SageOneCustomer> customerListLinearTest = sageOneSATemplate.getCustomers("rotor5");

                System.out.println(customerListLinearTest.size());

                List<SageOneCustomer> customers = sageOneSATemplate.getSageOneEntitiesByType("rotor5",
                SageOneEntityType.V_1_1_2.CUSTOMER);

                System.out.println((customers.size() > 0) ? customers.get(0).getName() : null);

                List<SageOneCustomer> searchedCustomer = sageOneSATemplate.searchEntitiesByAnyValues("rotor5",
                SageOneEntityType.V_1_1_2.CUSTOMER, "D", "OO");

                System.out.println(searchedCustomer.size());

                List<SageOneCustomer> sageOneCustomers =
                sageOneSATemplate.searchEntitiesByAnyMatchedPropertyValues("rotor5",
                SageOneEntityType.V_1_1_2.CUSTOMER, new String[]{"Name"}, new String[]{"DC"});

                System.out.println("hello");

                System.out.println(sageOneCustomers.size());
                // End of Version 2.0.0

                // Version 2.1.*
                List<SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccount> grabbedFirstAccount =
                sageOneSATemplate.getSageOneEntitiesByType("rotor5", SageOneEntityType.V_1_1_2.ACCOUNT);


                SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountNote newAccountNote =
                new SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountNote();

                newAccountNote.setId(3370);//0
                newAccountNote.setSubject("TestingForAttachments");
                newAccountNote.setActionDate(new DateTime().plusDays(3).toDate());

                SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountNote saveAccountNote =
                sageOneSATemplate.saveSageOneEntity("rotor5", newAccountNote);

                if(saveAccountNote != null) {

                        File file = new File(FileSystemView.getFileSystemView().getHomeDirectory() +
                        File.separator + File.separator + File.separator + "helloTest.txt");

                        try {
                                FileInputStream inputStream = new FileInputStream(file);
                                byte[] fileData = new byte[]{};
                                System.out.println(file.length());
                                fileData = IOUtils.toByteArray(inputStream);
                                System.out.println(fileData.length);

                                SageOneUploadDataWrapper fileToUpload = new SageOneUploadDataWrapper();


                                fileToUpload.setName(file.getName());
                                fileToUpload.setData(fileData);

                                SageOneAttachment attchmentSaved = sageOneSATemplate.saveSageOneAttachment("rotor5",
                                SageOneEntityType.V_1_1_2.ACCOUNT_NOTE_ATTACHMENT, saveAccountNote.getId(), fileToUpload);


                                SageOneDownloadDataWrapper sageOneGrabbedAttachment =
                                sageOneSATemplate.downloadSageOneEntity("rotor5",
                                attchmentSaved.getAttachmentUID().toString(),
                                SageOneEntityType.V_1_1_2.ACCOUNT_NOTE_ATTACHMENT);

                                System.out.println(sageOneGrabbedAttachment.getContentLength());

                        } catch(FileNotFoundException e) {
                                e.printStackTrace();
                        } catch(IOException e) {
                                e.printStackTrace();
                        }
                }




        }
}
