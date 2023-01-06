# Ecommerce-Application

This repository contains two part:
- **The backend**
- **The frontend**

## I- THE BACKEND
It contains five microservices in total. Three functional microservices and 2 technical microservices.
- **Functional microservices:**
    - eureka-discovery
    - gateway service
- **Technical microservices:**
    - customer-service
    - inventory-service
    - billing-service

![image](https://user-images.githubusercontent.com/84817425/209443380-5b117372-91bc-41e2-9031-c8d262244f73.png)

## 1. Eureka discovery
It is a registration service that allows services to find and communicate with each other without hard-coding the hostname and port.
It contains all the addresses of the microservices.
Use the following URL to access eureka discovery : <https://localhost:8761>

![image](https://user-images.githubusercontent.com/84817425/209443317-550e9346-cb2c-481e-aeb9-bfe69d3d7d6e.png)

## 2. Gateway service
It is a proxy that uses an API with non-blocking I/O.
It receives external requests, and for each request received, it calls the right microservice.

## 3. Customer service
This microservice concerns everything that is customer management.
You can consult the list of all the customers and all the detailed information of each customer.

### - List of all customers:
To access the customers list through the Gateway service, we need to type: <http://localhost:8888/CUSTOMER-SERVICE/customers>

![image](https://user-images.githubusercontent.com/84817425/209443429-477202b4-418d-4ee8-9479-143871996367.png)

### - Customer details:
To access the customer's details through the Gateway service, we need to type: <http://localhost:8888/CUSTOMER-SERVICE/customers/{customerId}>

![image](https://user-images.githubusercontent.com/84817425/209443508-97545d2c-a738-4c5e-b6fb-50684b8906b3.png)

## 4. Inventory service
This microservice concerns everything that is product management.
You can consult the list of all the products and all the detailed information of each product.

### - List of all products:
To access the products list through the Gateway service, we need to type: <http://localhost:8888/INVENTORY-SERVICE/products>

![image](https://user-images.githubusercontent.com/84817425/209443552-685410c6-c40c-4b19-877c-4266c1910350.png)

### - Product details:
To access the product's details through the Gateway service, we need to type: <http://localhost:8888/INVENTORY-SERVICE/products/{productId}>

![image](https://user-images.githubusercontent.com/84817425/209443566-4873fc5c-0ef0-4bcb-bd32-73723e93929e.png)

## 5. Billing service
This microservice concerns everything that is billing.
You can consult the list of all the bills that exist, the details of each bill and the bills of a specific customer.

### - List of all bills:
To access the bills list through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/bills>

![image](https://user-images.githubusercontent.com/84817425/209443599-e43bb401-8696-491f-a5ca-bbd767ba51a2.png)

### - Bill details:
To access a specific bill infos through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/bills/{billId}>

![image](https://user-images.githubusercontent.com/84817425/209443611-f0586a9f-02a9-40cd-a19f-759344eecaf1.png)

### - Bills of a specific customer:
To access the bills of a specific customer through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/customerBills/{customerId}>

![image](https://user-images.githubusercontent.com/84817425/209443752-1c8b4a38-9e9f-4027-957f-1ed68dc6331b.png)

### - Full details of a specific bill:
To access the full details of specific bill through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/fullBill/{billId}>

![image](https://user-images.githubusercontent.com/84817425/209443771-088eeea2-e8ab-4f2c-b43e-6f2a973acbad.png)

## II- THE FRONTEND
## 1. Products
In this section, the user can view the list of products that exist:
- the product name
- the product price
- the quantity of the product in stock

![products-list-front](https://user-images.githubusercontent.com/84817425/209433679-4e1cece3-e45c-421f-b0cf-8f63e24eac15.png)
## 2. Customers
In this section, the user can view the list of customers that exist:
- the customer full name
- the customer email

![customers-list-front](https://user-images.githubusercontent.com/84817425/209433691-8bac982d-3936-4e0e-9e61-36a3e2e18eea.png)
### - Account Details:
From the list of customers, the user can view the account details of each customer, by clicking on the "Account details" button.

![customer-details](https://user-images.githubusercontent.com/84817425/209433736-817458a1-8e27-484f-ad66-8dab1e673c90.png)
## 3. Bills:
The user can also view the list of bills of each customers by clicking on the "Bills" button.

![customer-bills](https://user-images.githubusercontent.com/84817425/209433753-ad7b770a-12bd-4477-88a2-f258f2570fa9.png)
### - Bills Details:
The user can also view the bill details, meaning the list of products purchased, their quantity and price, by clicking on the "bill details" button.

![bill-details](https://user-images.githubusercontent.com/84817425/209433757-672242cd-67f3-4849-a26a-084108889fb2.png)

## III- SECURITY USING KEYCLOAK

Keycloak is an open source **identity and access management** solution.

###  a. Setting Up a Keycloak Server
To be able to use it to secure our application, we must configure it.
To do so:
- we created a realm called **"Ecom-realm"**, and added the clients which are the applications to secure.

![image](https://user-images.githubusercontent.com/84817425/209444585-b6b7f5a6-ab0c-4800-a847-2a77ff25ae8e.png)

- we added the different users.

![image](https://user-images.githubusercontent.com/84817425/209444605-4da7fdc4-4771-4fde-a103-9c510cfd8c18.png)

- we added the different roles that we need and assign them to each corresponding user.

![Capture d’écran (315)](https://user-images.githubusercontent.com/84817425/210899346-64849336-6b10-47f5-851f-e10d59bfb5fb.png)

#### Testing the different authentication modes using Postman
##### Using the access token 
To do so:

- We made a POST request to the token endpoint of the Keycloak server. <http://localhost:8080/realms/Ecom-realm/protocol/openid-connect/token>
- In the "Body" tab, we selected the "x-www-form-urlencoded" option, and then we added the following key-value pairs to the request:
   - "username".
   - "password".
   - "grant_type": password
   - "client_id": (The client ID of your application)

![Capture d’écran (317)](https://user-images.githubusercontent.com/84817425/210899597-80a1d7d6-840f-40c5-ac61-c80769afcf09.png)

##### Using the refresh token
To do so:

1. We made a POST request to the token endpoint of the Keycloak server. <http://localhost:8080/realms/Ecom-realm/protocol/openid-connect/token>
2. In the "Body" tab, we selected the "x-www-form-urlencoded" option, and then we added the following key-value pairs to the request:
   - "username".
   - "password".
   - "grant_type": refresh_token
   - "refresh_token": (the refresh tokent to refresh/retrieve a new the access token)

![Capture d’écran (321)](https://user-images.githubusercontent.com/84817425/210899660-628693e3-8d04-4a09-9aed-1922c200d1bf.png)

### b. Securing the microservices
To secure each microservices we took the following steps:
1. we added the following dependencies in pom.xml
```xml		
<dependency> 
    <groupId>org.keycloak</groupId>
    <artifactId>keycloak-spring-boot-starter</artifactId>
    <version>20.0.1</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>		
    <version>2.7.7</version>
</dependency>
```
2. we added keycloak configuration in application.properties :
```
keycloak.realm=Ecom-realm
keycloak.resource=EcommerceApp
keycloak.bearer-only=true
keycloak.auth-server-url=http://localhost:8080
keycloak.ssl-required=none
```
3. We then added configuration classes inside of the **`security`** package.
   We created **`KeycloakSecurityConfig`** class to configure the security settings for our application that is protected by Keycloak.
   We then created the **`KeycloakAdapterConfig`** class to easily integrate Keycloak with our application.


