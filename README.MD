# Spring Cloud Samples

## Spring cloud Config (Server/Client)


1. Open **Cloud\_Config\_Server** folder. Here it will contain two files bootstrap.yml and application.yml. **bootstrap.yml** contains the details of the FILE LOCATION (also **GIT LOCATION / CONSUL Server/ ETCD** ) etc. And **applicationl.yml** will contain the properties related to the application.  This forms the basis of Spring Cloud config server that will acts as the single interface for all the client application that need to fetch the properties from diff sources. Run it via **"mvn spring-boot:run"** or via  directly by java -jar **name**.jar 
2. Open **Cloud\_Config\_Client** folder.This is the client application, that will fetch the property from the Spring cloud config server and will refresh it automatically, so in this way your applications are independent of the place where the properties file are being kept. 
3. **CONFIG** folder will contain the configuration files that will be picked up by the Spring\_Cloud__\Config_\Server. 


## Spring CLOUD *Service Discovery*  - Netflix Eureka
1. This example will contain three different things. 
	1. Folder **CLOUD\_Eureka\_Server** : This will contain the EUREKA Server that will be created via using a SPRING BOOT application (via using a specific starter). Once you run it via mvn spring-boot:run  it will open up a EUREKA Server (a service discovery server) that will be open to registering the clients. You can access the WEB portal at **http://localhost:8761/eureka**. 
	2. Folder **CLOUD\_Eureka\_Client\_LicensingService** contains a LICENSE service having ID **LICENSINGSERVICE** which will be registered in the EUREKA Server and visible on the Web portal. This service will call **ORGANIZATIONSERVICE** to get a specific organization details. URL of this service would be http://localhost:8090/license/MyOrganzationCode. 
	3. Folder **Cloud\_Eureka\_Client_OrganizationService**  contains a Organization service, given the org Id will be give the complete organization details ( Just as a String). you can run multiple instances of Organization server ( on a different port on a single system remember via using **mvn spring-boot:run** -Dserver.port=8000) and all will be appear in the Eureka Portal. 
	4. **NOTE:** Once you will be using the **@EnableDiscoveryClient** on the client application, you can use the **RESTTEMPLATE** (which will be load balanced internally via **NETFLIX RIBBON**). [ Check LicensingService code for this]. 

## Spring CLOUD - Failing Services - Netflix Hysterix