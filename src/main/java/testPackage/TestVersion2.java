package testPackage;



import SageOneIntegration.NationalityType;
import SageOneIntegration.SA.SageOneEntityType;
import SageOneIntegration.SA.SageOneSA;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAttachment;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer;
import SageOneIntegration.SageOneApiConnector;
import SageOneIntegration.SageOneDownloadDataWrapper;
import SageOneIntegration.SageOneUploadDataWrapper;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Properties;
import org.junit.*;


public class TestVersion2 {
    private static SageOneApiConnector sageOneApiConnector = new SageOneApiConnector(NationalityType.SA);
    private static Properties properties = new Properties();
    private static SageOneSA sageOneSATemplate;
    private static boolean MUST_CONTINUE_TESTING = true;
    private static String COMPANY_NAME_TO_USE = "Nerdyre";

    @BeforeClass
    public static void setupTestEnvironment() {
        properties.setProperty("sageOneApi.SA.clientUsername", "");
        properties.setProperty("sageOneApi.SA.clientPassword", "4");
        properties.setProperty("sageOneApi.SA.apiKey", "");

        sageOneApiConnector.setupSageOneApi(properties);
        sageOneSATemplate = sageOneApiConnector.getTemplate();

/*        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer newCustomer =
        new SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer.Builder().withName("testCustomer").build();

        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer saveCustomer =
        sageOneSATemplate.saveSageOneEntity(COMPANY_NAME_TO_USE, newCustomer);

        if(saveCustomer == null) {
            MUST_CONTINUE_TESTING = false;
        }*/
    }

    // Tests for version 2.0.* , ALL GENERAL TESTING, coverage is bad, but there
    @Test
    public void saveEntity2_0() {
        if(!MUST_CONTINUE_TESTING) {
            throw new IllegalArgumentException("Setup Environment failed, no tests will be run");
        }

        // Check if save entity works
        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier newSupplier =
        new SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier.Builder().withName("Suppplierjj").build();

        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier saveSupplier =
        sageOneSATemplate.saveSageOneEntity(COMPANY_NAME_TO_USE, newSupplier);

        Assert.assertTrue(saveSupplier != null);
    }

    @Test
    public void deleteEntity2_0() {
        if(!MUST_CONTINUE_TESTING) {
            throw new IllegalArgumentException("Setup Environment failed, no tests will be run");
        }
        // Check if delete entity works after saving an entity
        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier newSupplier =
        new SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier.Builder().withName("SuppplierToDelete").build();

        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier saveSupplier =
        sageOneSATemplate.saveSageOneEntity(COMPANY_NAME_TO_USE, newSupplier);

        if(saveSupplier == null) {
            throw new IllegalArgumentException("Unable to save entity which will be used for deletion");
        }

        Assert.assertTrue(sageOneSATemplate.deleteSageOneEntity(COMPANY_NAME_TO_USE,
        saveSupplier.getId(), SageOneEntityType.V_1_1_2.SUPPLIER));

    }

    @Test
    public void getEntity2_0() {
        if(!MUST_CONTINUE_TESTING) {
            throw new IllegalArgumentException("Setup Environment failed, no tests will be run");
        }

        // Check if get Customer works
        List<SageOneCustomer> customerListLinearTest = sageOneSATemplate.getCustomers(COMPANY_NAME_TO_USE);

        Assert.assertTrue(customerListLinearTest != null && customerListLinearTest.size() > 0);
    }

    @Test
    public void getEntitiesByType2_0() {
        if(!MUST_CONTINUE_TESTING) {
            throw new IllegalArgumentException("Setup Environment failed, no tests will be run");
        }

        // Check if get Sage One Entities by type works
        List<SageOneCustomer> customers = sageOneSATemplate.getSageOneEntitiesByType(COMPANY_NAME_TO_USE,
        SageOneEntityType.V_1_1_2.CUSTOMER);


        Assert.assertTrue(customers != null && customers.size() > 0);
    }

    @Test
    public void searchEntitiesByAnyValue2_0() {
        if(!MUST_CONTINUE_TESTING) {
            throw new IllegalArgumentException("Setup Environment failed, no tests will be run");
        }

        // Check if Searching works for searching by any value, must return one customer
        List<SageOneCustomer> searchedCustomer = sageOneSATemplate.searchEntitiesByAnyValues(COMPANY_NAME_TO_USE,
        SageOneEntityType.V_1_1_2.CUSTOMER, "test", "OO");

        Assert.assertTrue(searchedCustomer.size() > 0);
    }

    @Test
    public void searchEntitiesByAnyMatchedValues2_0() {
        if(!MUST_CONTINUE_TESTING) {
            throw new IllegalArgumentException("Setup Environment failed, no tests will be run");
        }

        // Check if searching by any matched property values works, must return one customer
        List<SageOneCustomer> sageOneCustomers = sageOneSATemplate.searchEntitiesByAnyMatchedPropertyValues(COMPANY_NAME_TO_USE,
        SageOneEntityType.V_1_1_2.CUSTOMER, new String[]{"Name"}, new String[]{"testCustomer"});


        Assert.assertTrue(sageOneCustomers.size() > 0);
    }

    // Tests for version 2.1.* , ALL GENERAL TESTING, coverage is bad, but there
    @Test
    public void uploadFileAndDownloadFile2_1() {
        if(!MUST_CONTINUE_TESTING) {
            throw new IllegalArgumentException("Setup Environment failed, no tests will be run");
        }
        // Upload text file with content of 'hello', after successfully creating an account note
        List<SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccount> grabbedFirstAccount =
        sageOneSATemplate.getSageOneEntitiesByType(COMPANY_NAME_TO_USE, SageOneEntityType.V_1_1_2.ACCOUNT);


        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountNote newAccountNote =
        new SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountNote();

        newAccountNote.setSubject("TestingForAttachments");
        newAccountNote.setActionDate(new DateTime().plusDays(3).toDate());

        SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneAccountNote saveAccountNote =
        sageOneSATemplate.saveSageOneEntity(COMPANY_NAME_TO_USE, newAccountNote);

        if(saveAccountNote != null) {

            byte[] fileData = "hello".getBytes();

            SageOneUploadDataWrapper fileToUpload = new SageOneUploadDataWrapper();

            fileToUpload.setName("helloTest.txt");
            fileToUpload.setData(fileData);

            SageOneAttachment attachmentSaved = sageOneSATemplate.saveSageOneAttachment(COMPANY_NAME_TO_USE,
            SageOneEntityType.V_1_1_2.ACCOUNT_NOTE_ATTACHMENT, saveAccountNote.getId(), fileToUpload);

            Assert.assertTrue(attachmentSaved != null);


            SageOneDownloadDataWrapper sageOneGrabbedAttachment = sageOneSATemplate.downloadSageOneEntity(COMPANY_NAME_TO_USE,
            attachmentSaved.getAttachmentUID().toString(), SageOneEntityType.V_1_1_2.ACCOUNT_NOTE_ATTACHMENT);

            Assert.assertTrue(sageOneGrabbedAttachment != null && sageOneGrabbedAttachment.getContentLength() > 0);
        }
    }
}
