import React from 'react'
import { useState } from 'react';
import { useEffect } from 'react';

import { getTopics } from '../../service/TopicService';
import './ViewTopicSidebarComponent.css'
import { Link } from 'react-router-dom';

function ViewTopicSidebarComponent() {

    const [topics, setTopics] = useState([])

    useEffect(() => {
        listAllTopics();
    }, [])

    function listAllTopics() {
        getTopics().then((response) => {
            setTopics(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    return (
        <div className="sidebar-view-subreddit">
            <div className='title'>Topics</div>
            <hr />
            <div>
                <Link to={`/list-topics`}>View All</Link>
            </div>
            <hr />
            <div>
                {
                    topics.map(topic =>
                        <span className='subreddit-text' key={topic.topicid}>
                            <Link to={`/view-topic/${topic.topicid}`}>{topic.name}</Link>
                            <hr />
                        </span>
                    )
                }
            </div >


        </div >
    )
}

export default ViewTopicSidebarComponent