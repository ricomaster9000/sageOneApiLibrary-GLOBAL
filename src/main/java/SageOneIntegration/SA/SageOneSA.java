package SageOneIntegration.SA;

import SageOneIntegration.NationalityType;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneCustomer;
import SageOneIntegration.SA.V1_1_2.SageOneApiEntities.SageOneSupplier;
import SageOneIntegration.SageOneResponseObject;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Ricardo on 2017-07-05.
 */
public interface SageOneSA {

    public void setupSageOneApi(final Properties properties);

    public void setupSageOneApi(final Map<String, String> properties);

    public void setupSageOneApi(final Environment properties);

    public List<SageOneCustomer> getCustomersByNameAndSurnameOrName(String companyName,
                                                                    String... customerNames);

    public SageOneSupplier getSupplierByName(final String companyName,
                                             final String name);

    public List<SageOneCustomer> getCustomers(final String companyName);

    public <T> T getEntityByPropertyValue(final String companyName,
                                          final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                          final String propertyName,
                                          final String propertyValue);

    public <T> List<T> getEntitiesByPropertyValue(final String companyName,
                                                  final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                  final String propertyName,
                                                  final String propertyValue);

    public <T> List<T> searchEntitiesByAnyMatchedPropertyValues(final String companyName,
                                                                                final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                                                final String[] propertyNames,
                                                                                final String[] propertyValues);

    public <T> List<T> searchEntitiesByAllMatchedPropertyValues(final String companyName,
                                                                                final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                                                final String[] propertyNames,
                                                                                final String[] propertyValues);

    public <T> List<T> searchEntitiesByAnyValues(final String companyName,
                                                 final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                 final String... values);

    public <T> T getSageOneEntity(final String companyName,
                                  final SageOneEntityType.V_1_1_2 entity,
                                  final int entityId);

    public <T> T saveSageOneEntity(final String companyName,
                                   final Object entityToSave);

    public boolean deleteSageOneEntity(final String companyName,
                                       final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                       final Integer entityId);

    public boolean deleteSageOneEntitiesByPropertyValue(final String companyName,
                                                        final SageOneEntityType.V_1_1_2 sageOneEntityType,
                                                        final String propertyName,
                                                        final String propertyValue);

    public <T> List<T> getSageOneEntitiesByType(final String companyName,
                                                final SageOneEntityType.V_1_1_2 sageOneEntityType);
}
