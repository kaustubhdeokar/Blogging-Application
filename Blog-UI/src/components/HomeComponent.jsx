import React, { useEffect, useState } from 'react'
import { getAllPosts } from '../service/PostsService'
import PostComponent from './PostComponent'
import SideBarComponent from './AppSideBar/SideBarComponent'
import ViewTopicSidebarComponent from './TopicSideBar/ViewTopicSidebarComponent'
import './HomeComponent.css'
import { text } from '@fortawesome/fontawesome-svg-core'

function HomeComponent() {


    return (
        <div className='reddit-body'>
            <div>
                <h2 className='text-align-center'>Homepage </h2>
            </div>
            <div className="container">
                <div className='row'>
                    <hr />
                    <div className="col-md-9">
                        <PostComponent />
                    </div>
                    <div className="col-md-3">
                        <SideBarComponent />
                        <ViewTopicSidebarComponent />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default HomeComponent