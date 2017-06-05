# sageOneApiLibrary-SA
A library that contains pre-written code to connect and access the SageOne South Africa Api (v.1.1.2), it also comes with a template that makes use of these pre-written component code to access the SageOne SA api, the template contains methods (mostly dynamic or generic) that a developer can use to build this library into his/her app.

### HOW TO USE

add as dependency by using jitpack.io, go to this link to see how https://jitpack.io/

``
USER = ricomaster9000
REPO/REPOSITORY = sageOneApiLibrary-SA
TAG/VERSION = v0.90a
``

Please run the method SageOneApiConnector.setupSageOneApiSA(Properties properties) to initialize this library's code with your App's Properties class object (usually System.getProperties()) and make sure the below first 3 fields/properties appear in your properties file and have the required (also correct) assigned values, the rest have default values but can be overriden. You can now also initialize it with a Map<String, String> parameter "SageOneApiConnector.setupSageOneApiSA(Map<String, String> properties)".

```
sageOneApi.SA.clientUsername = 'your Sage One username';
sageOneApi.SA.clientPassword = 'your Sage One Password';
sageOneApi.SA.apiKey = 'sd24d-....'; (don't include the brackets, it gets added automatically)

sageOneApi.SA.apiUrl = 'base url for api call'; (this isn't required as the default should work)
sageOneApi.SA.apiVersion = '1.1.2'; (default is 1.1.2)
sageOneApi.SA.requestLimitDay = 5000; (default is 5000)
sageOneApi.SA.requestLimitHour = 100; (default is 100)
sageOneApi.SA.requestResultLimit = 100; (default is 100)
sageOneApi.SA.requestTimeout = 30000; (default is 30 seconds)
```
### important classes/methods you should use

```
SageOneEntityType enum class -> use this primarily as a parameter for template methods, currently only 5 enums is supported, will add more through time
```
```
SageOneConstants.getSageOneApiCompanyList() Map variable -> 
Gets the company list which was initialized with all the companies related to the user in the SageOneApiConnector.setupSageOneApiSA(Properties properties) method, from here you can grab company id's by passing in the name of the company in the .get() method of getSageOneApiCompanyList()
```
```
SageOne Entities, all of them lies in the SageOneIntegration.SageOneApiEntities package, include them from here, these entity classes will especially be used to save/persist SageOne entities to the SageOne account, use them SageOneEntityType enum class (enum will be used as parameter for template method)
```

### Template Methods
```
SageOneApiTemplate.getCustomersByNameAndSurnameOrName(String companyName, String... customerNames) -> the second parameter can be one value or multiple values seperated by a comma
                                                                                   
SageOneApiTemplate.getSageOneEntity(String companyName, SageOneEntityType entityName, int entityId) -> grabs one sageOne entity by its id for a certain company

SageOneApiTemplate.saveSageOneEntity(String companyName, Object entityToSave) -> saves one SageOne entity by passing the company name and the SageOne entity object (look above to know where the SageOne entity classes/objects can be found), returns generated entity from SageOne Api as response.

getCustomers(final String companyName) -> grabs all customers for specified company name
```

https://github.com/ricomaster9000/sageOneApiLibrary-SA/
