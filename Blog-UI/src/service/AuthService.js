import axios from "axios";
import React from "react";

const baseURL = "http://localhost:8080/api/auth";

export const registerAPICall = (registerObj) => axios.post(baseURL + '/signup', registerObj);

export const loginAPICall = (loginObj) => axios.post(baseURL + '/login', loginObj);

export const storeToken = (token) => {
    console.log('storing token' + token);
    localStorage.setItem("token", token);
}

export const getToken = () => localStorage.getItem("token");

export const saveLoggedInUser = (username, role) => {
    sessionStorage.setItem("authenticatedUser", username);
    sessionStorage.setItem("role", role);
}


export const isUserLoggedIn = () => {

    const username = getLoggedInUser();

    if (username == null) {
        return false;
    }
    else {
        return true;
    }
}

export const getLoggedInUser = () => {
    return sessionStorage.getItem("authenticatedUser");
}

export const logout = () => {
    localStorage.clear();
    sessionStorage.clear();
}