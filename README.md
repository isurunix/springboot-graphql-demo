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