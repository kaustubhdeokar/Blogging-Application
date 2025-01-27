import React from 'react'
import { useState } from 'react';
import { loginAPICall, saveLoggedInUser, storeToken } from '../service/AuthService';
import { useNavigate } from 'react-router-dom';


function LoginComponent() {

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')

    const navigate = useNavigate();

    async function handleLoginForm(e) {

        e.preventDefault();

        const loginDto = { username, password };
        storeToken(null);

        await loginAPICall(loginDto).then((response) => {
            console.log(response.data);

            const token = 'Bearer ' + response.data.authenticationToken;

            storeToken(token);
            console.log('token is:' + token);

            saveLoggedInUser(username);
            navigate("/home");
            window.location.reload(false);

        }).catch(error => {
            console.error(error);
        })

    }

    return (
        <div className='container'>
            <br /> <br />

            {/* <ToastContainer
                position="top-left"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
                theme="light"
                transition:Flip
            /> */}

            <div className='row'>
                <div className='col-md-6 offset-md-3'>
                    <div className='card'>
                        <div className='card-header'>
                            <h2 className='text-center'> Login Form </h2>
                        </div>

                        <div className='card-body'>
                            <form>

                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'> Username or Email</label>
                                    <div className='col-md-9'>
                                        <input
                                            type='text'
                                            name='username'
                                            className='form-control'
                                            placeholder='Enter username'
                                            value={username}
                                            onChange={(e) => setUsername(e.target.value)}
                                        >
                                        </input>
                                    </div>
                                </div>

                                <div className='row mb-3'>
                                    <label className='col-md-3 control-label'> Password </label>
                                    <div className='col-md-9'>
                                        <input
                                            type='password'
                                            name='password'
                                            className='form-control'
                                            placeholder='Enter password'
                                            value={password}
                                            onChange={(e) => setPassword(e.target.value)}
                                        >
                                        </input>
                                    </div>
                                </div>

                                <div className='form-group mb-3'>
                                    <button className='btn btn-primary' onClick={(e) => handleLoginForm(e)}>Submit</button>

                                </div>
                            </form>

                        </div>

                    </div>
                </div>
            </div>


        </div>
    )
}

export default LoginComponent