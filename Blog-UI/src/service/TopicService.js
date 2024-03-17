import axios from "axios";
import React from "react";
import { getToken } from "./AuthService";

const baseURL = 'http://localhost:8080/api/topic'


export const createTopic = (topicObj) => {
    return axios.post(baseURL, topicObj)
}

export const getTopics = () => {
    return axios.get(baseURL + '/all');
}

export const getTopicIdByTopicName = (topicName) => {

    return axios.get(baseURL + '/get-id/' + topicName);
}




export const getAllSubscribedTopics = (username) => {
    console.log('sending request to ' + baseURL + '/topics/' + username);
    return axios.get(baseURL + '/topics/' + username);
}
