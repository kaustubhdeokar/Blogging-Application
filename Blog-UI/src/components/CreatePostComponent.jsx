import React from 'react'
import { createPost } from '../service/PostsService'
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';

function CreatePostComponent() {


    const [postName, setPostName] = useState('')
    const [topicName, setTopicName] = useState('')
    const [url, setUrl] = useState('')
    const [description, setDescription] = useState('')
    const navigator = useNavigate();


    function handleRegistrationForm(e) {

        e.preventDefault();

        const post = { postName, topicName, url, description }

        console.log(post);

        createPost(post).then((response) => {
            console.log(response.data);
            navigator("/home");

        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='col-md-6 offset-md-3'>
                    <div className='card'>
                        <div className='card-header'>
                            <h2 className='text-center'> User Registration Form </h2>
                        </div>

                        <div className='card-body'>
                            <form>
                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'> postName </label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='postname'
                                            className='form-control'
                                            placeholder='Enter postName'
                                            value={postName}
                                            onChange={(e) => setPostName(e.target.value)}
                                        >
                                        </input>
                                    </div>
                                </div>

                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'> topicName </label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='topicname'
                                            className='form-control'
                                            placeholder='Enter topicName'
                                            value={topicName}
                                            onChange={(e) => setTopicName(e.target.value)}
                                        >
                                        </input>
                                    </div>
                                </div>


                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'> Url </label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='url'
                                            className='form-control'
                                            placeholder='Enter Url'
                                            value={url}
                                            onChange={(e) => setUrl(e.target.value)}
                                        >
                                        </input>
                                    </div>
                                </div>

                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'> Description </label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='description'
                                            className='form-control'
                                            placeholder='Enter Description'
                                            value={description}
                                            onChange={(e) => setDescription(e.target.value)}
                                        >
                                        </input>
                                    </div>
                                </div>

                                <div className='form-group mb-3'>
                                    <button className='btn btn-primary' onClick={(e) => handleRegistrationForm(e)}>Submit</button>

                                </div>
                            </form>

                        </div>

                    </div>
                </div>
            </div>


        </div>
    )
}

export default CreatePostComponent