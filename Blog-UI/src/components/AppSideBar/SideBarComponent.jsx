import React from 'react'
import { useNavigate } from 'react-router-dom';
import './SideBarComponent.css'

const SideBarComponent = () => {

    const navigator = useNavigate();

    function goToCreatePost() {
        console.log('create post');
        navigator('/create-post');
    }

    function goToCreateSubreddit() {
        console.log('create subreddit');
        navigator('/create-topic');
    }

    return (
        <div>

            <div className="sidebar">

                <div className='center-div title'>Shortcuts.
                </div>

                <div className=''>
                    <button className="btn btn-link" onClick={goToCreatePost}>Create Post</button>
                </div>

                <div className=''>
                    <button className="btn btn-link" onClick={goToCreateSubreddit}>Create Topic</button>
                </div>
            </div>

        </div>
    )
}

export default SideBarComponent