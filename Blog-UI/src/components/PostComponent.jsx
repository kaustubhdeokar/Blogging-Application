import React, { useEffect, useState } from 'react'
import { getAllPosts } from '../service/PostsService'
import VoteComponent from './VoteComponent';
import { Link } from 'react-router-dom';
import './PostComponent.css'
import { getLoggedInUser } from '../service/AuthService';
import { getAllPostsFromSubscribedTopics } from '../service/PostsService';
import { useParams } from 'react-router-dom';
import { getAllPostsInTopic } from '../service/PostsService';

function PostComponent() {

    const [posts, setPosts] = useState([])
    const { topicName } = useParams()
    var [postState, setPostState] = useState(0);

    useEffect(() => {
        if (topicName) {
            listAllPostsInTopic(topicName);
            postState = 1;
        }
        else {
            listAllPostsBySubscription();
            postState = 0;
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

    function getGenericTitle() {
        if (topicName) {
            <div>For Topic {topicName} </div>
        }
        else {

        }
    }

    function listAllPostsBySubscription() {
        const user = getLoggedInUser()
        getAllPostsFromSubscribedTopics(user).then((response) => {
            setPosts(response.data);
        }).catch(error => {
            console.log(error);
        })
    }


    function calculateDuration(duration) {
        const dateString = duration;
        const providedDate = new Date(dateString);

        const currentDate = new Date();
        const differenceInMilliseconds = currentDate - providedDate;
        const differenceInSeconds = differenceInMilliseconds / (1000 * 60 * 60 * 24);

        return Math.floor(differenceInSeconds) + ' days ago'
    }

    return (

        < div >
            <span>{getGenericTitle}</span>
            {

                posts.map(post =>
                    <div className='row post' key={post.topicName+":"+post.id}>
                        <div className="col-md-1">
                            <VoteComponent post={post} />
                        </div>

                        <div className='col-md-11'>


                            <div className="post-title">
                                <a className="postname" href="{{post.url}}">{post.postName}</a>
                            </div>
                            <div>
                                <p className="post-text">{post.description}</p>
                            </div>
                            <hr />
                            <span className="subreddit-info">
                                <span className="subreddit-text"><a className="posturl">
                                    <Link to={`/home/${(post.topicName)}`}>
                                        {post.topicName}
                                    </Link>
                                </a></span>
                                <span> . Posted by <a className="username">{post.userName}</a></span>
                                <span> {calculateDuration(post.duration)}</span>
                            </span> &nbsp;&nbsp;
                            <span>
                                <a className="btnCommments" role="button">
                                    Comments({post.commentNum})
                                </a>&nbsp;&nbsp;
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