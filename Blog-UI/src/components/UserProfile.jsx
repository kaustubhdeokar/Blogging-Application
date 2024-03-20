import React from 'react'
import { getLoggedInUser, getAllSubscribedTopicsByUser } from '../service/AuthService'
import { useState } from 'react';
import { useEffect } from 'react';
import { Link } from 'react-router-dom';
import { getAllPostsByUser } from '../service/PostsService';

function UserProfile() {

  const loggedInUserName = getLoggedInUser();
  const [subscribedTopics, setSubscribedTopics] = useState([])
  const [posts, setPosts] = useState([])

  useEffect(() => {
    listSubscribedTopics();
    listUserPosts();
  }, [])

  function listUserPosts() {
    getAllPostsByUser(loggedInUserName).then((response) => {
      setPosts(response.data);
    }).catch(error => {
      console.log(error);
    })
  }

  function listSubscribedTopics() {
    getAllSubscribedTopicsByUser().then((response) => {
      setSubscribedTopics(response.data);
    }).catch(error => {
      console.log(error);
    })
  }

  return (
    <div className='container'>
      
      <div className="row">
        <hr />
        
        <div className="col-md-9">
          <h2>Subscribed Topics</h2>
          <ul>
            {
              subscribedTopics.map(topic =>
                <li key={topic.topicid}>
                  <Link to={`/view-topic/${topic.name}`}>{topic.name}</Link>

                </li>
              )
            }
          </ul>
        </div>

        <div className="col-md-9">
          <h2>Posts by user</h2>
          <ul>
            {
              posts.map(post =>
                <li key={post.postName}>

                  <Link to={`/view-post/${post.id}`}>{post.postName}</Link>
                </li>
              )
            }
          </ul>
        </div>


      </div>

    </div >
  )
}

export default UserProfile