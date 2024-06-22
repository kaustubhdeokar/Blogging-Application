import React from 'react'
import { createTopic } from '../service/TopicService';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function CreateTopicComponent() {
  

    const [name, setName] = useState('')
    const [description, setDescription] = useState('')
    const navigator = useNavigate();


    function handleRegistrationForm(e) {

        e.preventDefault();

        const topic = { name, description}

        console.log(topic);

        createTopic(topic).then((response) => {
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
                                    <label className='col-md-3 control-label'> Topic Name </label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='name'
                                            className='form-control'
                                            placeholder='Enter topic name'
                                            value={name}
                                            onChange={(e) => setName(e.target.value)}
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

export default CreateTopicComponent