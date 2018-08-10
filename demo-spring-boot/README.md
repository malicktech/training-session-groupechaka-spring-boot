# Chaka - Demo Formation Spring

## Stack
* Java 8
* Spring Boot 2
* Spring MVC
* Spring Data JPA

## Tools
* IDE - Eclipse tools suite [https://spring.io/tools/sts/all](https://spring.io/tools/sts/all)
* Outils de build : Maven

Maven

Bootstrap (UI Presentation)
## Session 1

* Quick Start projet

	https://start.spring.io/ 

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

## Liens Utiles

* Application properties

	https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

* Site du projet spring boot 
	
	http://projects.spring.io/spring-boot/
	
* Docs

Guide de références Spring boot
	
	http://docs.spring.io/springboot/docs/current/reference/htmlsingle/
	
* Tutoriels

	http://www.baeldung.com/start-here

* Exemples de projets

	https://github.com/spring-projects/springboot/tree/master/spring-boot-samples
