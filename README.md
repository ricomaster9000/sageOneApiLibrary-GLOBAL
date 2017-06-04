# sageOneApiLibrary-SA
A library that contains pre-written code to connect and access the SageOne South Africa Api (v.1.1.2), it also comes with a template that makes use of these pre-written component code to access the SageOne SA api, the template contains methods (mostly dynamic or generic) that a developer can use to build this library into his/her app.

### HOW TO USE

add as dependency by using jitpack.io, go to this link to see how https://jitpack.io/

``
USER = ricomaster9000
REPO/REPOSITORY = sageOneApiLibrary-SA
TAG/VERSION = v0.82b
``

Please run the method SageOneApiConnector.setupSageOneApiConnector(Properties properties) to initialize this library's code with your App's Properties class object (usually System.getProperties()) and make sure these below fields/properties appear in your properties file and have the required (also correct) assigned values.

```
sageOneApi.SA.clientUsername = 'your Sage One username';
sageOneApi.SA.clientPassword = 'your Sage One Password';
sageOneApi.SA.apiUrl = 'base url for api call'; (this isn't required as the default should work)
sageOneApi.SA.apiVersion = '1.1.2'; (default is 1.1.2)
sageOneApi.SA.apiKey = 'sd24d-....'; (don't include the brackets, it gets added automatically)
sageOneApi.SA.requestLimit = 100; (default is 100)
sageOneApi.SA.requestTimeout = 30000; (default is 30 seconds)
```
### important classes/methods you should use

```
SageOneEntityType enum class -> use this primarly as a parameter for template methods, currently only 4 enums is supported, will add more through time

SageOneConstants.getSageOneApiCompanyList() Map variable -> 
Gets the company list which was initialized with all the companies related to the user in the SageOneApiConnector.setupSageOneApiConnector(Properties properties) method, from here you can grab company id's by passing in the name of the company in the .get() method of getSageOneApiCompanyList()

SageOne Entities, all of them lies in the SageOneIntegration.SageOneApiEntities package, include them from here, these entity classes will especially be used to save/persist SageOne entities to the SageOne account

```

### Template Methods
```
SageOneApiTemplate.getCustomersByNameAndSurnameOrName(String companyName, String... customerNames) -> the second parameter can be one value or multiple values seperated by a comma
                                                                                   
SageOneApiTemplate.getSageOneEntity(String companyName, SageOneEntityType entityName, int entityId) -> grabs one sageOne entity by its id for a certain company

SageOneApiTemplate.saveSageOneEntity(String companyName, Object entityToSave) -> saves one SageOne entity by passing the company name and the SageOne entity object (look above to know where the SageOne entity classes/objects can be found)
```

https://github.com/ricomaster9000/sageOneApiLibrary-SA/
