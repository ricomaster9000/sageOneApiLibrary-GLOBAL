# sageOneApiLibrary-SA
A library that contains pre-written code to connect and access the SageOne South Africa Api (v.1.1.2), it also comes with a template that makes use of these pre-written component code to access the SageOne SA api, the template contains methods (mostly dynamic or generic) that a developer can use to build this library into his/her app.

### HOW TO USE

add as dependency by using jitpack.io , go to this link https://jitpack.io/

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

https://github.com/ricomaster9000/sageOneApiLibrary-SA/
