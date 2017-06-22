# sageOneApiLibrary-SA V1.00b2 (Early Beta)
A library that contains pre-written code to connect and access the SageOne South Africa Api (v.1.1.2), it also comes with a template that makes use of these pre-written component code to access the SageOne SA api, the template contains methods (mostly dynamic or generic) that a developer can use to build this library into his/her app. Compatible with java 1.6 and upwards.

### HOW TO USE

add as dependency by using jitpack.io, go to this link to see how https://jitpack.io/
search for ricomaster9000/sageOneApiLibrary-SA

``
USER = ricomaster9000
REPO/REPOSITORY = sageOneApiLibrary-SA
TAG/VERSION = V1.00b2
``

Please run the method SageOneApiConnector.setupSageOneApiSA(Properties properties) to initialize this library's code with your App's Properties class object (usually System.getProperties()) and make sure the below first 3 fields/properties appear in your properties file and have the required (also correct) assigned values, the rest have default values but can be overriden.

You can now also initialize it with a Map<String, String> parameter "SageOneApiConnector.setupSageOneApiSA(Map<String, String> properties)". 

Spring-support (.yml and .properties files) -> You can now also initialize it with Spring's Environment object(org.springframework.core.env.Environment), like this :
"SageOneApiConnector.setupSageOneApiSA(Environment properties)"

```
sageOneApi.SA.clientUsername = 'your Sage One username'
sageOneApi.SA.clientPassword = 'your Sage One Password'
sageOneApi.SA.apiKey = 'sd24d-....' (don't include the brackets, it gets added automatically)
sageOneApi.SA.apiUrl = 'base url for api call' (default is 'https://accounting.sageone.co.za')
sageOneApi.SA.apiVersion = 'value' (default is 1.1.2)
sageOneApi.SA.requestLimitDay = 'value' (default is 6000)
sageOneApi.SA.requestLimitHour = 'value' (default is 250)
sageOneApi.SA.requestResultLimit = 'value' (default is 100)
sageOneApi.SA.requestTimeout = 'value' (default is 30000(30 seconds))
sageOneApi.SA.requestSocketTimeout = 'value' (default is 30000(30 seconds)) -> 
```
### important classes/methods you should use

```
SageOneEntityType enum class -> use this primarily as a parameter for template methods, currently only about 30-40% of the sage one entities is supported, will add more through time
```
```
SageOneConstants.getSageOneApiCompanyList() Map variable -> 
Gets the company list which was initialized with all the companies related to the user in the SageOneApiConnector.setupSageOneApiSA(Properties properties) method, from here you can grab company id's by passing in the name of the company in the .get() method of getSageOneApiCompanyList()
```
```
SageOne Entities, all of them lies in the SageOneIntegration.SageOneApiEntities package, include them from here, these entity classes will especially be used to save/persist SageOne entities to the SageOne account, use the SageOneEntityType enum class (enum will be used as parameter for template method)
```

### Template Methods
```
SageOneApiTemplate.getCustomersByNameAndSurnameOrName(String companyName, String... customerNames) -> the second parameter can be one value or multiple values seperated by a comma
```
```
SageOneApiTemplate.getSageOneEntity(String companyName, SageOneEntityType entityName, int entityId) -> grabs one sageOne entity by its id for a certain company
```
```
SageOneApiTemplate.saveSageOneEntity(String companyName, Object entityToSave) -> saves one SageOne entity by passing the company name and the SageOne entity object (look above to know where the SageOne entity classes/objects can be found), returns generated entity from SageOne Api as response.
```
```
SageOneApiTemplate.getCustomers(final String companyName) -> grabs all customers for specified company name
```
```
SageOneApiTemplate.getSupplierByName(final String Name) -> grabs a sage one supplier by name
```
```
SageOneApiTemplate.getEntityByPropertyValue(final String companyName, final SageOneEntityType sageOneEntityType,
                                            final String propertyName, final String propertyValue)

-> returns an entity which contains the passed property value for the passed property name, if more than one entity is found, only one is returned
```
```
SageOneApiTemplate.getEntitiesByPropertyValue(final String companyName, final SageOneEntityType sageOneEntityType,
                                              final String propertyName, final String propertyValue)

-> like above, but returns a list of entities
```
```
SageOneApiTemplate.searchEntitiesByAnyMatchedPropertyValues(final String companyName, final SageOneEntityType sageOneEntityType,
                                                            final String[] propertyNames, final String[] propertyValues)

-> filter the sage one entity based on the SageOneEntityType parameter passed, pass the property names you want to filter
   by as a parameter and make sure the values array parameter is the same length as the property name array parameter,
   if any of the property names is found with their matching value then it will be returned, don't use property names
   that has SageOneObject class value types, it will prevent you from using them.
```
```
SageOneApiTemplate.searchEntitiesByAllMatchedPropertyValues(final String companyName,
                                                            final SageOneEntityType sageOneEntityType,
                                                            final String[] propertyNames,
                                                            final String[] propertyValues)

-> filter sage one entities based on the SageOneEntityType parameter passed, pass the property names you want to filter
   by as a parameter and make sure the values array parameter is the same length as the property name array parameter,
   if all of the property names is found with their matching value then it will be returned, don't use property names
   that has SageOneObject class value types, it will prevent you from using them.
```
```
SageOneApiTemplate.searchEntitiesByAnyValues(final String companyName,
                                             final SageOneEntityType sageOneEntityType,
                                             final String... values)
-> searches all the property names (if they are not a sageOneObject class and the relevant value is correct type of value,
   for example 'a' won't be used to grab values from a int type property name) of the sageOne entity which is determined
   in the SageOneEntityType parameter, note that multiple requests can be send, all values are used in all property names.
```
```
deleteSageOneEntity(final String CompanyName, final SageOneEntityType sageOneEntityType,
                    final Integer entityId)

-> deletes the sage one entity based on the SageOneEntityType passed and with the entityId specified, note that not all
   entities are deletable. Returns a boolean response if the operation was successful or not
```
https://github.com/ricomaster9000/sageOneApiLibrary-SA/
