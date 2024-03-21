import React, { useEffect, useState } from 'react'
import { getAllPosts } from '../service/PostsService'
import VoteComponent from './VoteComponent';
import { Link } from 'react-router-dom';
import './PostComponent.css'
import { getLoggedInUser } from '../service/AuthService';
import { getAllPostsFromSubscribedTopics } from '../service/PostsService';
import { useParams } from 'react-router-dom';
import { getAllPostsInTopic } from '../service/PostsService';
import { calculateDuration } from '../service/PostsService';

function PostComponent() {

    const [posts, setPosts] = useState([])
    const { topicName } = useParams()
    var [postState, setPostState] = useState(0);

    useEffect(() => {
        console.log('in use effect')
        if (topicName) {
            listAllPostsInTopic(topicName);
            setPostState(1);
        }
        else {
            listAllPostsBySubscription();
            setPostState(0);
        }
    }, [postState, topicName])

    function listAllPostsInTopic(topicName) {
        getAllPostsInTopic(topicName).then((response) => {
            setPosts(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    function listAllPosts() {
        getAllPosts().then((response) => {
            setPosts(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    function listAllPostsBySubscription() {
        const user = getLoggedInUser()
        getAllPostsFromSubscribedTopics(user).then((response) => {
            setPosts(response.data);
        }).catch(error => {
            console.log(error);
        })
    }


    const handlePostsChangeInVoteComp = () => {
        console.log('trigger post update');
        setPostState(2); // Update the value in the parent component
    };

    return (

        < div >

            {

                posts.map(post =>
                    <div className='row post' key={post.topicName + ":" + post.id}>
                        <div className="col-md-1">
                            <VoteComponent post={post} onChange={handlePostsChangeInVoteComp} />
                        </div>

                        <div className='col-md-11'>
                            <div className="post-title">
                                <Link to={`/view-post/${post.id}`}>
                                    <span className="postname">{post.postName}</span>
                                </Link>
                            </div>
                            <div>
                                <p className="post-text">{post.description}</p>
                            </div>
                            <hr />
                            <span className="subreddit-info">
                                <span className="subreddit-text">
                                    <Link className="posturl" to={`/home/${(post.topicName)}`}>
                                        {post.topicName}
                                    </Link>
                                </span> &nbsp;&nbsp;
                                <span>Posted by <span className="username">{post.userName}</span></span>
                                <span> {calculateDuration(post.duration)}</span>
                            </span> &nbsp;&nbsp;
                            <span>
                                &nbsp;&nbsp;
                                <Link to={`/view-post/${post.id}`}>
                                    Read Post
                                </Link>
                            </span>
                        </div>
                    </div>
                )
            }
        </div >
    )
}
export default PostComponent