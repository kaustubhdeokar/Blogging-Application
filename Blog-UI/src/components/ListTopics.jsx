import React from 'react'
import { useState } from 'react';
import { useEffect } from 'react';
import { getTopics } from '../service/TopicService';
import { Link } from 'react-router-dom';
import SideBarComponent from './AppSideBar/SideBarComponent';

function ListTopics() {

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
            <div className="row">
                <hr />
                <div className="col-md-9">
                    <h2>List of Topics</h2>
                    <ul>
                        {
                            topics.map(topic =>
                                <li key={topic.topicid}>
                                    <Link to={`/view-topic/${topic.name}`}>{topic.name}</Link>
                                </li>
                            )
                        }
                    </ul>
                </div>
                <div className="col-md-3">
                    <SideBarComponent/>
                </div>
            </div>
        </div >
    )
}

export default ListTopics