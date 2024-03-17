import React, { useEffect } from 'react'
import { NavLink } from 'react-router-dom'
import { getLoggedInUser, isUserLoggedIn } from '../service/AuthService';
import { logout } from '../service/AuthService';
const HeaderComponent = () => {

    const isAuth = isUserLoggedIn();
    const loggedInUserName = getLoggedInUser();

    function callLogout() {
        logout();
    }

    useEffect(() => {
        
        
        
      }, [isAuth])

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
                                        !isAuth &&
                                        <NavLink to="/sign-up" className="nav-link">Sign up</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {
                                        isAuth &&
                                        <NavLink to="/home" className="nav-link">Home</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {!isAuth &&
                                        <NavLink to="/login" className="nav-link">Login</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {
                                        isAuth &&
                                        <NavLink to="/login" className="nav-link" onClick={callLogout}>Logout</NavLink>
                                    }
                                </li>
                                <li className="nav-item">
                                    {
                                        isAuth &&
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