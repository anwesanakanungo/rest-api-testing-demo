REST ASSURED - API automation framework
Java library (API) for testing RESTful web services.
Used to test XML and JSON based web services.
Supports GET, POST, PATCH, PUT, DELETE, HEAD, OPTIONS. Can be integrated with testing frameworks like JUnit, TestNG.
Rest Assured is implement in Groovy. It uses Groovy under the hood to fetch the JSON object (GPath Expression)


Design pattern used : Builder design pattern ( for Post and PUT request ) and it also support the predefined user input data like JSON file and make changes on the same is also taken care in ApiUtilClass .
Each response of the API will be stored in the OUTPUT folder .
Configuration file will be shared both by API and UI classes .
Response of the each Post request will be shared by GET and PUT APIS using DataStore class .
Faker API is used for uniquely creating data for each test . Assumption:
