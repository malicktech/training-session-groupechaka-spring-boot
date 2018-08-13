# Chaka - Demo Formation Spring

## Stack
* Java 8
* Spring Boot 2
* Spring MVC
* Spring Data JPA

## Tools
* IDE : Eclipse tools suite [https://spring.io/tools/sts/all](https://spring.io/tools/sts/all)
* Build : Maven

## Session 1

* Quick Start projet

	- créer projet avec : https://start.spring.io/, télécharger le fichier zip et dézipper
	- importer le projet maven sur votre IDE
	- Exécuter le projet
		- command line : ./mvnw spring-boot:run
		- IDE : run main application class
	- Accéder à l'app : 
		- http://localhost:8080


* Service Web RESTful : Hello world !


* ApplicationRunner & CommandLineRunner : Exécuter du code juste avant la fin du démarrage de l'application


* Spring Boot Devtools : Automatic Restart & LiveReload 

	https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html

* Spring data JPA : Accés aux données 
	
	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

* H2 : in memory Embedded Database 

Accés à la console de la base de données embarqué :
	
	http://localhost:8080/h2-console
	
	jdbcurl : demo
	user: demo

* Refactoring - Repacking helloWorld controlleur hello wordl


* Service Web RESTful - Spring MVC - Accès aux entités user

Get all users

	http://localhost:8080/all-users

Get user from lastname
	
	http://localhost:8080/users-from-name/Bauer

* Test : Test d'intégration basique avec un serveur en cours d'exécution

	https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html

* Spring boot actuator : Monitoring, metrics, logs, traces

	http://localhost:8080/actuator

enpoints

	https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html

Ajout des informations de commit Git  

	https://docs.spring.io/spring-boot/docs/current/reference/html/howto-build.html#howto-build-info
	 
* Configuration applicative : properties

run profile : https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/maven-plugin/examples/run-profiles.html

	mvnw spring-boot:run -Dspring-boot.run.profiles=dev


* logging
	
	https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html 


* Créer un fichier JAR exécutable avec Maven

	./mvnw clean package
	java -jar target/*.jar
	
	java -jar target/*.jar --spring.profiles.active=dev

	mvnw -DskipTests
	mvn clean install -Dmaven.test.skip=true

* swagger 
http://localhost:8080/v2/api-docs
http://localhost:8080/swagger-ui.html

## Liens Utiles

* Application properties

	https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

* Site du projet spring boot 
	
	http://projects.spring.io/spring-boot/
	
* Guide de références Spring boot
	
	http://docs.spring.io/springboot/docs/current/reference/htmlsingle/
	
* Tutoriels

	http://www.baeldung.com/start-here

* Exemples de projets

	https://github.com/spring-projects/springboot/tree/master/spring-boot-samples
