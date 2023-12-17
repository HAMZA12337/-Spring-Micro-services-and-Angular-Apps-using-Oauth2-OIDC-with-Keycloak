# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web.security.oauth2.client)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

### Google Authentication

* First of All  we will create our project in google console 

![img.png](./Assets/img.png)

* Then we will ceate credentials

![img_1.png](./Assets/img_1.png)

* Create client OAuth ID

![img_2.png](./Assets/img_2.png)

*After Getting your id-Client * Secret Client you should add this conf in your application.properties  file

![img_3.png](./Assets/img_3.png)

### Github  Authentication

* Register a new OAuth application

* By acceding to this path : Settings > Developer setting > Register a new OAuth application

![img_4.png](./Assets/img_4.png)

* After Getting your id-Client * Secret Client you should add this conf in your application.properties  file

![img_5.png](./Assets/img_5.png)

### KeyCloak Authentication

**Step 1 : Launch KeyCloak in your Local Machine {./kc.bat start-dev }**

![img_6.png](./Assets/img_6.png)


**Step 2 : Create Realm**

![img_7.png](./Assets/img_7.png)

**Step 3 :Create Client** 

![img_8.png](./Assets/img_8.png)
![img_9.png](./Assets/img_9.png) 

**Step 4: Create Realm Roles**

![img_10.png](./Assets/img_10.png)

**Step 5:  Create Users**

![img_11.png](./Assets/img_11.png)

               add credentials for each user {In my case password = 1234}

![img_12.png](./Assets/img_12.png)

                Second user user 2

![img_13.png](./Assets/img_13.png)

**Step 6:  Assign Role for each user**
   
                For user 1

![img_14.png](./Assets/img_14.png)


                For user 2
![img_15.png](./Assets/img_15.png)

                Test KeyCloak Authentication
POST http://localhost:8080/realms/Braimi-app/protocol/openid-connect/token
Accept: application/json
Content-Type:application/x-www-form-urlencoded

grant_type=password&username=hamza-obihi&password=1234&client_id=app-client&client_secret={}


![img_16.png](./Assets/img_16.png)

                Let's Display the content of our access_Token

![img_17.png](./Assets/img_17.png)

**Step 7:Adding id-Client & Secret Client to application.properties**

![img_18.png](./Assets/img_18.png)

                Then we get this result

![img_19.png](./Assets/img_19.png)


# Implementation of Method Security

![img_20.png](./Assets/img_20.png)
![img_21.png](./Assets/img_21.png)

The problem that will face is in the getting token there is no roles -> we will fixe by checking Realm roles and Add to ID token 

![img_22.png](./Assets/img_22.png)

![img_23.png](./Assets/img_23.png)


# Add PreAuthorize

![img.png](img.png)

* And we will get something like that :

![img_1.png](img_1.png)

### How to assign Default roles during  registration phase ->{KeyCloak} <Realm Settings -> User  Registration -> Assign Roles >

![img_2.png](img_2.png)

### Add password Politics  {Authentication -> Policies -> Password Policy}

![img_3.png](img_3.png)


