import React, { useEffect, useState } from 'react'
import { getAllPosts } from '../service/PostsService'
import VoteComponent from './VoteComponent';
import { Link } from 'react-router-dom';
import './PostComponent.css'

function PostComponent() {

    const [posts, setPosts] = useState([])

    useEffect(() => {
        listAllPosts();
    }, [])

    function listAllPosts() {
        getAllPosts().then((response) => {
            setPosts(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    function calculateDuration(duration){
        const dateString = "2024-03-11T03:16:44.668162Z";
        const providedDate = new Date(dateString);

        const currentDate = new Date();
    }

    return (
        <div>
            <h2 className='text-center'>List of Posts</h2>
            {
                posts.map(post =>
                    <div className='row post' key={post.id}>
                        <div className="col-md-1">
                            <VoteComponent post={post} />
                        </div>

                        <div className='col-md-11'>
                            <span className="subreddit-info">
                                <span className="subreddit-text"><a className="posturl">{post.topicName}</a></span>
                                <span> . Posted by <a className="username">{post.userName}</a></span>
                                <span> . Duration {post.duration}</span>
                            </span>
                            <hr />
                            <div className="post-title">
                                <a className="postname" href="{{post.url}}">{post.postName}</a>
                            </div>
                            <div>
                                <p className="post-text">{post.description}</p>
                            </div>
                            <hr />
                            <span>
                                <a className="btnCommments" role="button">
                                    Comments({post.commentNum})
                                </a>
                                <Link to={`/view-post/${post.id}`}>
                                    <button className="login">
                                        Read Post
                                    </button>
                                </Link>
                            </span>
                        </div>
                    </div>
                )
            }
        </div>
    )
}
export default PostComponent