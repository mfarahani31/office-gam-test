##Office Microservice

You have to implement a microservice which handles the office related operations. The operations include *CREATE*, *READ*, *UPDATE* and *DELETE*. 


####MUST
- use spring boot with maven as build tool
- use spring devtools to ease development process
- use `flyway` as database version controling machnism
- use `h2` db
- use *java bean validation* as the validation mechanism
- the endpoints must follow the `RESTful API` best practices
- cover all the codes you write by using unit tests
- cover all the controllers by using integration tests
- log the input and output of the servcie methods
- log the request and response
- create a uuid for each request to make the whole action happening in a request traceable
- enhance the build to create an executable standalone jar
- dockerize the service using a `Dockerfile`
- create a `kubernetes` deployment for the service
- create a `jenkins` job to automate the process of deployment



###Office Entity
Office entity fields are as following:

- *id*
- *name*: Office name, it should not be null and should start with a letter and its length should be greater than 5 and lower than 30
- *code*: Office code, it should be a valid string of numbers, greater than 11 characters. the validitiy check must be done by using `Luhn Algorithm`[^footnote] 
- *provider*: Office provider, it may have three possible values including *huawei*, *aban-eshop*, *hami-mymci* and it should not be null
- *inactive*: Boolean indicating the active/inactive state of the office


### Operational Constraints

#### create
- office name should be unique
- office code should be unique
#### update
- office name is updatable
- office code is not updatable
- office provider is updatable
- office inactive is updatable

[^footnote]: Luhn Algorithm, [Wikipedia](https://en.wikipedia.org/wiki/Luhn_algorithm)
