import React from 'react'
import { faArrowUp, faArrowDown } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import './VoteComponent.css'
import { votePost } from '../service/VoteService';

const VoteComponent = ({ post }) => {

    const postId = post.id;
    var voteType = 0;

    function callUpvotePost() {
        voteType = 1;
        const voteDto = { postId, voteType };

        votePost(voteDto).then((response) => {
            setPosts(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    function callDownvotePost() {
        voteType = -1;
        const voteDto = { postId, voteType };

        votePost(voteDto).then((response) => {
            setPosts(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    return (
        <div>
            <div className="col-md-1">
                <div className="d-flex flex-column votebox">
                    <div className="p-2">
                        <span onClick={callUpvotePost} className="upvote">
                            <FontAwesomeIcon icon={faArrowUp} />
                        </span>
                    </div>
                    <div className="p-2 votecount"> {post.voteCount} </div>
                    <div className="p-2">
                        <span onClick={callDownvotePost} className="downvote">
                            <FontAwesomeIcon icon={faArrowDown} />
                        </span>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default VoteComponent