## Overview 

> This a backend part project of Blogging application using spring boot technologies such as spring data jpa, spring security and authenticates users via JWT tokens with MySQL DB.

> Supports functionality for
    >> User authentication & authorization via spring security using with JWT tokens.<br>
    >> Supports CRUD operation regarding creation of Topics.<br>
    >> Supports CRUD operation regarding creation of posts inside topics.<br>
    >> Posts can have comments. <br>
    >> Comments can have voting.

> Collection of APIs through Postman is found in file <strong>Messaging - app.postman_collection.json</strong>(ready to import)

> Endpoints documented via OpenAPI/Swagger-UI. 
<br>http://localhost:8080/swagger-ui/index.html

> The schema for the same can be found in file `schema.sql` in the root directory.

> Documentation can be found in the file <strong>documentation.md</strong>

> For running it locally, <strong> setup.md </strong> can be used to download the required additional applications.<br>
> After which, <strong> mvnw clean install</strong> will download required dependencies required for this project. (Make sure JAVA_HOME is set - will save a stack overflow visit :-)