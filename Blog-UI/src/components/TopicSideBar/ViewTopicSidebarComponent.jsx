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
        <div className='container'>
            <div className="sidebar-view-subreddit">
                <div style={{ color: "black", fontweight: "bold" }}>Browse Subreddits</div>
                <div>
                    {
                        topics.map(topic =>
                            <div className='subreddit-text' key={topic.topicid}>
                                <Link to={`/view-topic/${topic.topicid}`}>{topic.name}</Link>
                            </div>
                        )
                    }
                </div >
            </div >
        </div>
    )
}

export default ViewTopicSidebarComponent