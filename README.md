# Spring Boot + GraphQL Demo

This is sample application using Springboot and GraphQL based on the following scenario.

## Scenario

A Customer registration portal.
Customers get registered in the portal, and then they can manage services enabled for their account.
Services are managed by Portal Managers.

## User Roles

* CUSTOMER - Registered Customer
  - Can register and manage services enabled under the account
* ADMIN - Administrator
  - Has all permissions including customer removal and management, service removal and management
* PORTAL_AGENT - Portal Manager
  - Permitted to add/manage services
  
## How to Test

1. Clone the project and checkout develop branch
    ```bash
   git clone <clone-url>
   git checkout develop
    ```
2. Go to the project folder
    ```bash
    cd springboot-graphql-demo
    ```
3. Build the project with Maven  
    ```bash
   mvn clean package -DskipTests
    ```
4. Go to the target folder and run the application
    ```bash
   cd target
   java -jar  graphql-demo-0.0.1-SNAPSHOT.jar
    ```
 5. Once the application started you can test the graphql queries using a suitable GraphQL
 client using `http://127.0.0.1:8080/graphql` as the API endpoint.
 
 ### Implemented Queries and Mutations
 
 * Login
     ```graphql
      mutation LoginMutation{
       login(username:"cx_usr",password: "1234"){
         username
         token
         profile{
           customerCode
           contactNo
           address
         }
       }
     }
     ```
   
 * Query unsecured endpoint
    
     ```graphql
     query findAllApps {
       findAllApps {
         appId
         appName
       }
     }
     ```
 
 * Secured endpoint
 
    * You will get Access Denied as the response unless you pass the token
     obtained after login as the Authorization header  
     
     ```graphql
      Authorization: Bearer <token>
     ```
   
     ```graphql
       query findAllCustomers {
         findAllCustomers {
           customerCode
           contactNo
           address
           user {
             username
           }
         }
       }
     ```