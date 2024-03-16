
Following are the API calls allowed. 

#### Sign Up

![sign up](../src/main/resources/static/signup.png)

```
Method: Signup 
Protocol: POST
    
    /api/auth/signup
    {
        {
            "email":"<>",
            "username":"<>",
            "password":"<>"
        }
    }

```
> After the user is registered, we send a verification mail on a mock third party service
mail service as mailTrap. 
> Configurations can be found in application.properties.
![verify account](../src/main/resources/static/mailtrap.png)


> Use the <strong>Verification Code</strong> sent to the mail id to verify the user: on url 
```
Method: Account Verification 
Protocol: GET
    
    /api/auth/accountVerification/{code}

```

![verify account](../src/main/resources/static/verification.png)

#### Login

Method: POST

![login](../src/main/resources/static/login.png)
```
http://localhost:8080/api/auth/login
{
    "userName":"<>",
    "password":"<>"
}
```

If users try to login without verifying themselves, we send message as follows:

![User logs in without verifying](../src/main/resources/static/user_verification_fail.png)

Using the authentication token for all further calls, in order to validate the user making the call before executing the request each time.

#### Refresh token

JWT tokens have a longer expiry. 
Refresh tokens are recalculated and used in span of 5 mins.

![refresh token](../src/main/resources/static/refresh-expired-token.png)

### TOPICS

| Calls                | Method   | URL                 |
| :------------------: | :------: | :--------------:    |
| Get All Subreddits   | GET      | /api/topic      |
| Create Subreddit     | POST     | /api/topic      |
| Get One Subreddit    | GET      |	/api/topic/{id} |

##### Create Subreddit
```
http://localhost:8080/api/topic
{
    "name":"Subreddit2",
    "description":"description2"
}
```

![topic post query](src/main/resources/static/topic/create.png)

#### Get Subreddit. 

![topic get all](src/main/resources/static/topic/get_all.png)

##### Get by id

![topic result](src/main/resources/static/topic/by_id.png)

### POSTS

API calls for posts.

| Calls                | Method   | URL                 |
| :------------------: | :------: | :--------------:    |
| /api/posts |	 POST|	createPost |
| /api/posts/ |	GET | getAllPosts |
| /api/posts/{id} | GET | getPost |
| /api/posts/by-topic/{id} |GET |getPostsBySubreddit |
| /api/posts/by-user/{name} | GET |	getPostsByUsername |

#### Create Post

![create post](../src/main/resources/static/posts/create.png)

#### Get Posts

![get posts](../src/main/resources/static/posts/list.png)

#### By id
![get by id](../src/main/resources/static/posts/byid.png)

#### By topic
![get by id](../src/main/resources/static/posts/bysubreddit.png)

#### COMMENTS

| Endpoint                | Method   | Calls To                 |
| :------------------: | :------: | :--------------:    |
| /api/comments |	 POST|	createPost |
| /api/comments/by-post/{postId} |	GET | get By Post |
| /api/comments/by-user/{userName} | GET | get comments by user |

1. ADD comment

![add comment](../src/main/resources/static/comment/create.png)

```
"postId":"<>",
"text":"Comment 3",
"userName":"<>"
```

Fetch comments by post.

![fetch comments by post](../src/main/resources/static/comment/getbypost.png)

Fetch comments by user.

![fetch comments by user](../src/main/resources/static/comment/byuser.png)

#### VOTE

![vote](../src/main/resources/static/vote/votebypost.png)


Add Vote : POST method.
```
{
    "postId":27,
    "voteType":"UPVOTE"
}
```

#### Refresh tokens

/api/auth/refresh/token
"refreshToken":<>,
"username":<>

#### Logout

/api/auth/logout
"refreshToken":<>,
"username":<>
