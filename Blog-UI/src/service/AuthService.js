import axios from "axios";

const baseURL = "http://localhost:8080/api/auth";

export const registerAPICall = (registerObj) => axios.post(baseURL + '/signup', registerObj);

export const loginAPICall = (loginObj) => axios.post(baseURL + '/login', loginObj);

export const storeToken = (token) => {
    console.log('storing token' + token);
    localStorage.setItem("token", token);
}

export const getToken = () => localStorage.getItem("token");

export const saveLoggedInUser = (username, role) => {
    localStorage.setItem("authenticatedUser", username);
    localStorage.setItem("role", role);
}

export const getAllSubscribedTopicsByUser = () => {
    if (isUserLoggedIn()) {
        const username = getLoggedInUser();
        console.log('sending request to ' + baseURL + '/topics/' + username);
        return axios.get(baseURL + '/topics/' + username);
    }
    else {
        console.log('bad request');
    }
}

export const getAllSubscribedTopicNamesByUser = () => {
    if (isUserLoggedIn) {
        const username = getLoggedInUser();
        return axios.get(baseURL + '/user-info/' + username);
    }
    else {
        console.log('bad request');
    }
}

export const addTopicForUser = (topicName) => {
    if (isUserLoggedIn) {
        const userName = getLoggedInUser();
        const userTopic = { userName, topicName }
        return axios.post(baseURL + '/add-topic', userTopic);
    }
}

export const removeTopicForUser = (topicName) => {
    if (isUserLoggedIn) {
        const userName = getLoggedInUser();
        const userTopic = { userName, topicName }
        return axios.post(baseURL + '/remove-topic', userTopic);
    }
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
    return localStorage.getItem("authenticatedUser");
}

export const logout = () => {
    localStorage.clear();
}