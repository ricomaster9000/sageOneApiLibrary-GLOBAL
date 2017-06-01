# sageOne-SA
A library that contains pre-written code to connect and access the SageOne SA Api (v.1.1.2), it also comes with a template that makes use of these pre-written component code to access the SageOne SA api, the template will contain methods (mostly dynamic or generic) that a developer will use to build this library into his app.

HOW TO USE

Please Initialize SageOneApiConnector with your App's Properties class object (usually System.getProperties()) and make sure these below fields/properties appear in your properties file and have the required (also correct) assigned values -> 

sageOneApi.SA.clientUsername
sageOneApi.SA.clientPassword
sageOneApi.SA.apiUrl (this isn't required as the default should work)
sageOneApi.SA.apiVersion (default is 1.1.2)
sageOneApi.SA.apiKey (don't include the brackets, it gets added automatically)
sageOneApi.SA.requestLimit (default is 100)
sageOneApi.SA.requestTimeout (default is 30 seconds)

https://github.com/ricomaster9000/sageOneApiLibrary-SA/
