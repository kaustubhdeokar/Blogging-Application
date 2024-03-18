import React, { useEffect } from 'react'
import { NavLink } from 'react-router-dom'
import { getLoggedInUser, isUserLoggedIn } from '../service/AuthService';
import { logout } from '../service/AuthService';
import { useState } from 'react';

const HeaderComponent = () => {

    const loggedInUserName = getLoggedInUser();
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    function callLogout() {
        logout();
    }

    useEffect(() => {
        var isAuth = isUserLoggedIn();
        setIsLoggedIn(isAuth);
    }, [isLoggedIn])

    return (
        <div>
            <header>
                <nav className='navbar navbar-expand-lg navbar-light bg-light'>

                    <div className="container">
                        <a className="navbar-brand" href="/home">Blog-it</a>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarResponsive">
                            <ul className="navbar-nav ms-auto">
                                <li className="nav-item active">
                                    {
                                        !isLoggedIn &&
                                        <NavLink to="/sign-up" className="nav-link">Sign up</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {
                                        isLoggedIn &&
                                        <NavLink to="/home" className="nav-link">Home</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {!isLoggedIn &&
                                        <NavLink to="/login" className="nav-link">Login</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {
                                        isLoggedIn &&
                                        <NavLink to="/login" className="nav-link" onClick={callLogout}>Logout</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {
                                        isLoggedIn &&
                                        <NavLink to="/userprofile" className="nav-link">{loggedInUserName}</NavLink>
                                    }
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
        </div >
    )
}

export default HeaderComponent