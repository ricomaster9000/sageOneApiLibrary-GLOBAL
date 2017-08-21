# sageOneApiLibrary-GLOBAL V2.1.11 (Early Beta)
A library that contains pre-written code to connect and access the different SageOne Api's (currently only South Africa Api),
it comes with a template for each nationality that makes use of these pre-written component code to access the defirrent SageOne api's,
the template contains methods (mostly dynamic or generic) that a developer can use to build this library into his/her app. Compatible with java 1.6 and upwards.

## Table Of Contents
#### 1 <a href="#Features">Features</a>
#### 2 <a href="#HowToUse">How to Use</a>
#### 3 <a href="#ICMYSUOKA">Important classes/methods you should use or know about</a>
#### 4 <a href="#TemplateMethods">Template Methods</a><div id="Features" style="visibility:hidden"></div>
### 1. Features

#### Methods run recursively if to get all results and to do all operations,for example: if there are more results that can be returned but the max result limit is reached,then another request will be sent until all results are grabbed

#### If template methods fail, then the app won't stop running or come to a halt, this can be helpful when you expect network problems, so check for null values returned when a method doesn't return a boolean value to see if operations was successful.

#### Some methods will return results even if errors occur, like internal server error (500) on API hosting site or when max requests per day or hour is made.

#### Code is set in place to prevent you from getting blocked by the API hosting server by checking how many times you make a request based on the current day and hour. <div id="HowToUse" style="visibility:hidden"></div>

### 2. HOW TO USE (Variables used throughout readme is right below 'How to use' heading, very important)
#### **<NationalityType**> = NationalityType.name() -> the name of the enum (NationalityType.SA will be SA)
#### **<Version**> = The version of the enum class to use in SageOneEntityType.{VERSION_ENUM_CLASS} (current one for SA for example is ".V_1_1_2")


#### A tester package is included in the master branch (inside src\main\testPackage), not in released instances, use it as an example of how to use this library.

add as dependency by using jitpack.io, go to this link https://jitpack.io/#ricomaster9000/sageOneApiLibrary-GLOBAL/2.16

``
USER = ricomaster9000
REPO/REPOSITORY = sageOneApiLibrary-GLOBAL
TAG/VERSION = 2.1.11
``

To set up one must create a new instance of the SageOneApiConnector class, and in the constructor method one must pass in the NationalityType Enum value, it will then set up the instance to work with that nationality.
After that you should create a new variable with which to store the SageOneApiConnector.getTemplate() object which can take any nationality Sage One Api interface class as its value (SageOneSA for SA, SageOneUK for Uk, etc..),
this template will then be used to do all operations, you can also include it only locally in method bodies by following the same procudere above, note that the SageOne interface class variable should corrospond with
the NationalityType enum you speicfied when you constructed a new instance with SageOneApiConnector class, you can initialize multiple SageOneApiConnector class
instances which will work with different nationalities but never for the same

Please run the method SageOne<NationalityType>.setupSageOneApi(Properties properties) to initialize this library's code with your App's Properties class object (usually System.getProperties()) and make sure the below first 3 fields/properties appear in your properties file and have the required (also correct) assigned values, the rest have default values but can be overriden.

You can now also initialize it with a Map<String, String> parameter "SageOne<NationalityType>.setupSageOneApi.setupSageOneApi(Map<String, String> properties)".

Spring-support (.yml and .properties files) -> You can now also initialize it with Spring's Environment object(org.springframework.core.env.Environment), like this :
"SageOne<NationalityType>.setupSageOneApi(Environment properties)"

```
sageOneApi.<NationalityType>.clientUsername = 'your Sage One username'
sageOneApi.<NationalityType>.clientPassword = 'your Sage One Password'
sageOneApi.<NationalityType>.apiKey = 'your Sage One Api Key' (don't include the brackets, it gets added automatically)
sageOneApi.<NationalityType>.apiUrl = 'base url for api call' (default is 'https://accounting.sageone.co.za' for SA)
sageOneApi.<NationalityType>.apiVersion = 'value' (default is 1.1.2 for SA)
sageOneApi.<NationalityType>.requestLimitDay = 'value' (default is 6000 for SA)
sageOneApi.<NationalityType>.requestLimitHour = 'value' (default is 250 for SA)
sageOneApi.<NationalityType>.requestResultLimit = 'value' (default is 100 for SA)
sageOneApi.<NationalityType>.requestTimeout = 'value' (default is 30000(30 seconds))
sageOneApi.<NationalityType>.requestSocketTimeout = 'value' (default is 30000(30 seconds)) ->
```
#### ________________________________  <div id="ICMYSUOKA" style="visibility:hidden"></div>
### 3. important classes/methods you should use or know about

```
SageOneEntityType enum class holder -> Every Nationality has one, for instance SageOneEntityType class for SA will be SageOneIntegration.SA.SageOneEntityType.{VERSION}, use this primarily as a parameter for template methods, (currently only about 30-40% of the sage one entities is supported for SA, will add more through time)
```
```
SageOneIntegration.<NationalityType>.SageOneConstants.getSageOneApiCompanyList() Map variable ->
Gets the company list which was initialized with all the companies related to the user for the specific nationality in the SageOneApiConnector.setupSageOneApi(Properties properties) method, from here you can grab company id's by passing in the name of the company in the .get() method of getSageOneApiCompanyList()
```
```
SageOne Entities, all of them lies in the SageOneIntegration.<NationalityType>.<Version>SageOneApiEntities package, include them from here, these entity classes will especially be used to save/persist SageOne entities to the SageOne account, use the SageOneEntityType enum class (enum will be used as parameter for template method)
```
#### _____________________  <div id="TemplateMethods" style="visibility:hidden"></div>
### 4. Template Methods

#### save method without id specified is a creation of new entity, if id is specified however then entity is edited
```
SageOne<NationalityType>.getCustomersByNameAndSurnameOrName(String companyName, String... customerNames) -> the second parameter can be one value or multiple values seperated by a comma
```
```
SageOne<NationalityType>.getSageOneEntity(String companyName, SageOneEntityType<Version> entityName, int entityId) -> grabs one sageOne entity by its id for a certain company
```
```
SageOne<NationalityType>.saveSageOneEntity(String companyName, Object entityToSave) -> saves (AND also edits if id is present in object) one SageOne entity by passing the company name and the SageOne entity object (look above to know where the SageOne entity classes/objects can be found), returns generated entity from SageOne Api as response, Version for api will automatically be detected.
```
```
SageOne<NationalityType>.getCustomers(final String companyName) -> grabs all customers for specified company name
```
```
SageOne<NationalityType>.getSupplierByName(final String Name) -> grabs a sage one supplier by name
```
```
SageOne<NationalityType>.getEntityByPropertyValue(final String companyName, final SageOneEntityType<Version> sageOneEntityType,
                                            final String propertyName, final String propertyValue)

-> returns an entity which contains the passed property value for the passed property name, if more than one entity is found, only one is returned
```
```
SageOne<NationalityType>.getEntitiesByPropertyValue(final String companyName, final SageOneEntityType<Version> sageOneEntityType,
                                              final String propertyName, final String propertyValue)

-> like above, but returns a list of entities
```
```
SageOne<NationalityType>.searchEntitiesByAnyMatchedPropertyValues(final String companyName, final SageOneEntityType<Version> sageOneEntityType,
                                                            final String[] propertyNames, final String[] propertyValues)

-> filter the sage one entity based on the SageOneEntityType parameter passed, pass the property names you want to filter
   by as a parameter and make sure the values array parameter is the same length as the property name array parameter,
   if any of the property names is found with their matching value then it will be returned, don't use property names
   that has SageOneObject class value types, it will prevent you from using them.
```
```
SageOne<NationalityType>.searchEntitiesByAllMatchedPropertyValues(final String companyName,
                                                            final SageOneEntityType<Version> sageOneEntityType,
                                                            final String[] propertyNames,
                                                            final String[] propertyValues)

-> filter sage one entities based on the SageOneEntityType parameter passed, pass the property names you want to filter
   by as a parameter and make sure the values array parameter is the same length as the property name array parameter,
   if all of the property names is found with their matching value then it will be returned, don't use property names
   that has SageOneObject class value types, it will prevent you from using them.
```
```
SageOne<NationalityType>.searchEntitiesByAnyValues(final String companyName,
                                             final SageOneEntityType<Version> sageOneEntityType,
                                             final String... values)
-> searches all the property names (if they are not a sageOneObject class and the relevant value is correct type of value,
   for example 'a' won't be used to grab values from a int type property name) of the sageOne entity which is determined
   in the SageOneEntityType parameter, note that multiple requests can be send, all values are used in all property names.
```
```
SageOne<NationalityType>.deleteSageOneEntity(final String CompanyName, final SageOneEntityType<Version> sageOneEntityType,
                    final Integer entityId)

-> deletes the sage one entity based on the SageOneEntityType passed and with the entityId specified, note that not all
   entities are deletable. Returns a boolean response if the operation was successful or not
```
```
SageOne<NationalityType>.deleteSageOneEntitiesByPropertyValue(final String companyName, final SageOneEntityType<Version> sageOneEntityType,
                                     final String propertyName, final String propertyValue)

-> deletes the SageOneEntityType parameter entity based on a property name and its value, entities will first be
   grabbed based on the property name and property value, then the grabbed entities will be deleted one by one by
   by its id, note that not all entities are deletable. Returns a boolean response if the operation was successful or not
```
```
SageOne<NationalityType>.getSageOneEntitiesByType(final String companyName, final SageOneEntityType<Version> sageOneEntityType)

-> gets all the entities by the entity type specified in the second parameter of this method, note that entities that
   cannot be grabbed, will not be grabbed and a error will be thrown if you do pass them as a parameter
```
```
SageOne<NationalityType>.saveSageOneAttachment(final String companyName, final SageOneEntityType<Version> entityTypeToUse,
                                               final Object objectTypeRelatedId, final SageOneUploadDataWrapper attchmentObject)

-> saves a sageOne attachment for specified SageOneEntityType Parameter combined with its related identifier as the next
   paremeter (can be string or numerical), the last paremeter is the actual information being uploaded which will be a
   SageOneUploadDataWrapper instance, if all went well an SageOneAttachment object which contains the attachment UID is returned which
   is essential if you wish to grab/download the attachment later, otherwise returns null if operation fails.
```
```
SageOne<NationalityType>.downloadSageOneEntity(final String companyName,
                                               final String entityGlobalUniqueIdentifier,
                                               final SageOneEntityType<Version> entity)

-> gets a sageOne attachment for specified SageOneEntityType Parameter based on the attachment's global unique identifier,
   which should not be duplicated, a SageOneDownloadDataWrapper will be returned as response and null will be returned
   if operation failed.
```
https://github.com/ricomaster9000/sageOneApiLibrary-GLOBAL
