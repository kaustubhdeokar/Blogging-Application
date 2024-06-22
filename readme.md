### Summary video : https://www.youtube.com/watch?v=Ba7ENNN3b3E

```
### HLD

+-------------------------+
|     User Interface      |
|       - Web UI          |
+-------------------------+
        |
        V
+--------------------------+         +--------------------------+
| Authentication Service   |<------> |    User Management       |
| - Login                  |         |  - Register              |
| - JWT Token Generation   |         |  - Profile               |
+--------------------------+         +--------------------------+
        |                                    |
        V                                    V
+------------------------------+        +------------------------------+
|     Topic Management         |        |      Post Management         |
|  - Create/Read/Update/Delete |        |  - Create/Read/Update/Delete |
+------------------------------+        +------------------------------+
        |                                    |
        V                                    V
  +--------------------------+        +-------------------------+
  |    Subscription Service  |        |    Comment Management   |
  |  - Subscribe/Unsubscribe |        |    - Add/Edit/Delete    |
  +--------------------------+        +-------------------------+
          |                                  |
          V                                  V
+--------------------------+        +----------------------------+
|    Search Topic Service  |        |   Voting Service           |
|                          |        |  Upvote/Downvote Posts     |
+--------------------------+        +----------------------------+                                             

+--------------------------+   DB   +----------------------------+                                             
                    +-------------------------+
                    |     MySQL               |
                    +-------------------------+

```

## Overview

### A blogging application created using spring boot, reddit, MySQL DB.<br>

Supports functionality for
- User authentication & authorization via spring security using with JWT tokens.<br>
- Supports CRUD operation regarding creation of Topics.<br>
- Supports CRUD operation regarding creation of posts inside topics.<br>
- Topics, multiple posts under each topic
- User - topic subscription
- Comments under post.
- Votes for each posts.
- Search functionality for topics.

### Note
- Collection of APIs through Postman is found in file <strong>bloApp.postman_collection.json</strong>(ready to import)
- Endpoints documented via OpenAPI/Swagger-UI. http://localhost:8080/swagger-ui/index.html
- The schema for the same can be found in file `schema.sql` in the root directory.
- For running it locally, <strong> setup.md </strong> can be used to download the required additional applications.<br>


