import React from 'react'
import { useState } from 'react';
import { useEffect } from 'react';
import { getTopics } from '../service/TopicService';
import { Link } from 'react-router-dom';
import SideBarComponent from './AppSideBar/SideBarComponent';
import { getAllSubscribedTopicsByUser } from '../service/AuthService';
import { addTopicForUser, removeTopicForUser } from '../service/AuthService';


function ListTopics() {

    const [topics, setTopics] = useState([])
    const [subscribedTopics, setSubscribedTopics] = useState([])
    const [stateChanged, setStateChanged] = useState(false);

    useEffect(() => {
        listAllTopics();
        listSubscribedTopics();
    }, [stateChanged])

    function listAllTopics() {
        getTopics().then((response) => {
            setTopics(response.data);
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

    function handleSubscription(topicName) {
        var isSubscribed = false;
        subscribedTopics.forEach(t => {
            if (topicName == t.name) {
                isSubscribed = true;
            }
        })

        if (!isSubscribed) {
            return <span>&nbsp;&nbsp;&nbsp;<a href=''>
                <span onClick={() => handleSubscriptionChange(true, topicName)}>&nbsp;&nbsp;
                    Subscribe
                </span></a>
            </span>
        }
        else {
            return <span>&nbsp;&nbsp;&nbsp;<a href=''>
                <span onClick={() => handleSubscriptionChange(false, topicName)}>&nbsp;&nbsp;Unsubscribe</span>
            </a></span>
        }
    }

    function handleSubscriptionChange(toAdd, topicName) {
        console.log('handle subscription change');
        if (toAdd) {
            console.log('add');
            addTopicForUser(topicName);
            setStateChanged(true);
        }
        else {
            console.log('remove');
            removeTopicForUser(topicName);
            setStateChanged(true);
        }
    }


    return (
        <div className='container'>
            <div className="row">
                <hr />
                <div className="col-md-9">
                    <h2>List of Topics</h2>
                    <ul>
                        {
                            topics.map(topic =>
                                <li key={topic.topicid}>
                                    <Link to={`/view-topic/${topic.name}`}>{topic.name}</Link>
                                    <span>
                                        {handleSubscription(topic.name)}
                                    </span>
                                </li>
                            )
                        }
                    </ul>
                </div>
                <div className="col-md-3">
                    <SideBarComponent />
                </div>
            </div>
        </div >
    )
}

export default ListTopics