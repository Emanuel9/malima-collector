# Malima Collector
### Overview
Malima Collector is a SpringBoot Web Application which collects data related to an in-development project from different 
development tools. The application can be configured to extract the information from custom addresses depending on the
particular setup of the development tools. It also provides extendable amounts of information with regards with the
different services. There are currently 7 tools supported by the application with different implementations: Confluence,
Gitlab, Jenkins, Jira, Mattermost, Rundeck and Sonar.

Confluence:
- confluence pages regarding the project
- links to the aforementioned pages

Gitlab:
- general project information
- link to project

Jenkins:
- display projects
- display pipeline status

Jira:
- display tasks related to projects
- links to the aforementioned tasks

Mattermost:
- display current user information
- ability to search throughout all posts in all channels

Rundeck:
- display project information
- display all running jobs

Sonar:
- display project information
- display information about coding issues
- display the status of issues

###Database
MySQL 8

### Configuration
application.yml

###Technologies used
Java, Spring Boot, JPA, Hibernate, MySQL, Thymeleaf
