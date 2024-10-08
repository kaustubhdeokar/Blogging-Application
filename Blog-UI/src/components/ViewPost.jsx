import React from 'react'
import { Link, useParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { createComment, getPost } from '../service/PostsService'
import { getLoggedInUser } from '../service/AuthService'
import { getAllCommentsByPost } from '../service/PostsService'
import VoteComponent from './VoteComponent'
import SideBarComponent from './AppSideBar/SideBarComponent'
import ViewTopicSidebarComponent from './TopicSideBar/ViewTopicSidebarComponent'
import './ViewPost.css'
import { calculateDuration } from '../service/PostsService'

function ViewPost() {

    const { id } = useParams()
    const [post, setPost] = useState([])
    const [comment, setComment] = useState('')

    const [allCommentsInPost, setAllCommentsInPost] = useState([])

    useEffect(() => {
        listCurrentPost();
        listAllComments();
    }, [])

    function listCurrentPost() {
        getPost({ id }.id).then((response) => {
            setPost(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    function listAllComments() {
        getAllCommentsByPost({ id }.id).then((response) => {
            setAllCommentsInPost(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    function editPost() {

    }


    async function postComment() {
        const postId = { id }.id;
        const text = comment;
        const userName = getLoggedInUser();

        const commentDto = { postId, text, userName };

        await createComment(commentDto).then((response) => {
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    return (
        <div className="container">
            <div className='row'>
                <hr />
                <div className='col-md-9'>
                    <div className='row post'>
                        <div className='col-md-1'>
                            <VoteComponent post={post} />
                        </div>
                        <div className="col-md-11">
                            <span>
                                <span className='subreddit-text'>
                                    <Link to={`/home/${(post.topicName)}`}>
                                        <span className='post-url'>{post.topicName}</span>
                                    </Link>

                                </span>
                                <span> Posted
                                    <span>, {calculateDuration(post.duration)}</span>
                                    <span>, by <a className="username">{post.userName}</a></span>
                                </span>
                            </span>
                            <hr />
                            <span className="post-title">
                                <span className="postname">{post.postName}</span>
                            </span>
                            <span>
                                <p className="post-text">{post.description}</p>
                            </span>
                            <hr />
                            <span>
                                <a>
                                    Comments({post.commentNum})
                                </a>
                            </span>
                            <hr></hr>

                            <div className="post-comment">
                                <form onSubmit={postComment}>
                                    <div className="form-group">
                                        <textarea className="form-control"
                                            value={comment}
                                            onChange={(e) => setComment(e.target.value)}
                                            placeholder="Your Thoughts?"></textarea>
                                    </div>

                                    <button type="submit">Comment</button>
                                </form>
                            </div >

                            <div style={{ margin: "60px" }}>
                                {
                                    allCommentsInPost.map(comment1 =>
                                        <div className='comment' key={comment1.commentId}>
                                            <div className="username">
                                                <Link to={`/user/${comment1.userName}`}>
                                                    {comment1.userName}
                                                </Link>
                                                <div>
                                                    <p>{comment1.createdDate}</p>
                                                </div>
                                                <div>
                                                    <p>{comment1.text}</p>
                                                </div>
                                                <hr />
                                            </div>
                                        </div>
                                    )

                                }
                            </div>
                        </div>
                    </div>
                </div>
                <div className='col-md-3'>
                    <SideBarComponent />
                    <ViewTopicSidebarComponent />
                </div>

            </div>

        </div >
    )
}

export default ViewPost