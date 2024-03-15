import React from 'react'
import { NavLink } from 'react-router-dom'
import { getLoggedInUser, isUserLoggedIn } from '../service/AuthService';

const HeaderComponent = () => {

    const isAuth = isUserLoggedIn();
    const loggedInUserName = getLoggedInUser();

    function callLogout() {
        // logout();
    }

    return (
        <div>
            <header>
                <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                    <div className='simple-margin'>
                        <a className='navbar-brand'>
                            Todo Management Application
                        </a>
                    </div>

                    <div className='collapse navbar-collapse'>
                        <ul className='navbar-nav'>
                            {
                                !isAuth &&
                                <li className='nav-item'>
                                    <NavLink to="/sign-up" className="nav-link">Sign up</NavLink>
                                </li>
                            }
                        </ul>
                    </div>
                    <div className='collapse navbar-collapse'>
                        <ul className='navbar-nav'>
                            {
                                isAuth &&
                                <li className='nav-item'>
                                    <NavLink to="/userprofile" className="nav-link">{loggedInUserName}</NavLink>
                                </li>
                            }
                        </ul>
                    </div>
                    <div className='collapse navbar-collapse'>
                        <ul className='navbar-nav'>
                            {!isAuth &&
                                <li className='nav-item'>
                                    <NavLink to="/login" className="nav-link">Login</NavLink>
                                </li>
                            }
                        </ul>
                    </div>

                    <div className='collapse navbar-collapse'>
                        <ul className='navbar-nav'>
                            {
                                <li className='nav-item'>
                                    <NavLink to="/login" className="nav-link" onClick={callLogout}>Logout</NavLink>
                                </li>
                            }
                        </ul>
                    </div>

                </nav>
            </header>

        </div>
    )
}

export default HeaderComponent