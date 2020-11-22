# API Upload/Download file

## Spring Boot Upload/Download File to/from Database

<br/>

## 🔗 Table of content

- [Prerequisites](#Prerequisites)

- [Installation](#Installation)
- [Execution](#Execution)
- [Endpoints](#Endpoints)
- [Project Structure](#Project-Structure)
- [Technologies](#Technologies)
- [Author](#Author)
- [References](#References)

---

<br/>

## Prerequisites

Before you get started, you need to install the following tools: Maven, Docker, java (8+)

<br/>

## Installation

```bash
# Clone this repository

## SSH
$ git clone git@github.com:PabloManoel/API-Upload-Or-Download-File.git

## HTTPS
$ git clone https://github.com/PabloManoel/API-Upload-Or-Download-File.git

# Open your terminal and go to current project directory
$ cd API-Upload-Or-Download-File/demo

# Install the dependencies
$ mvn clean install

```

<br/>

## Execution

```bash
# In the current project repository, run the .sh file to start postgres container
$ sh exec-container-postgres.sh

# In the current project directory, run the .jar file to initialize the application
$ java -jar API-Upload-Or-Download-File/demo/target/demo-0.0.1-SNAPSHOT.jar

# Tomcat will start the application on port(s): 8081 (http) with context path '/api'
```

<br/>

## Endpoints

- *POST* /files: Upload file
  - use Postman to send POST request
  - use form-data body type to attach files(multipart data)
  ``` 
  $ curl --location --request POST 'http://localhost:8081/api/files' \
  --form 'file=@"<full-path>/<filename>.<extension>"'
  ```
- *GET* /files: list all files 
  ``` 
  curl --location --request GET 'http://localhost:8081/api/files'
  ```

- *GET* /files/{fileId}: get a file
  ``` 
  curl --location --request GET 'http://localhost:8081/api/files/{fileId}'
  ```

<br/>

## Project Structure

![Project struture](https://raw.githubusercontent.com/PabloManoel/API-Upload-Or-Download-File/main/images/project-structure.png)

<br/>

## Technologies

👉 [Java](https://www.java.com/pt-BR/)

👉 [Spring Boot](https://spring.io/projects/spring-boot)

👉 [Hibernate](https://hibernate.org/)

👉 [PostgreSQL](https://www.postgresql.org/)

👉 [Docker](https://www.docker.com/)

👉 [Git](https://git-scm.com/)

<br/>

---

<br/>

## Author

<a href="https://github.com/PabloManoel">
 <img style="border-radius: 50% 50% 0 0; padding-top:10px" src="https://avatars1.githubusercontent.com/u/25345710?s=460&u=1a40ec32900c78618cf47314c0bf555b6bfba641&v=4" width="100px;" alt=""/>
</a>
<br />

### Feito por Pablo Manoel 🤘 Entre em contato!

[<img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" height="40" width="40" alt="Medium" />](https://github.com/PabloManoel)&nbsp;&nbsp;&nbsp;
[<img src="https://www.iconfinder.com/data/icons/social-messaging-ui-color-shapes-2-free/128/social-linkedin-circle-512.png" height="40" width="40" alt="Linkedin" />](https://www.linkedin.com/in/pablo-manoel/)&nbsp;&nbsp;
[<img src="https://www.iconfinder.com/data/icons/social-media-2210/24/Medium-512.png" height="40" width="40" alt="Medium" />](https://medium.com/@pablo.manoel)

<br/>

---
---

<br/>

## References

- https://bezkoder.com/spring-boot-upload-file-database/#Spring_Boot_Rest_APIs_for_uploading_Files_to_Database
