import axios from "axios";
import React from "react";
import { getToken } from "./AuthService";

const baseURL = 'http://localhost:8080/api/posts'

const commentBaseUrl = 'http://localhost:8080/api/comments'

export const getAllPosts = () => {
    console.log('sending request to ' + baseURL + '/all');
    return axios.get(baseURL + '/all');
}

export const getPost = (id) => {
    console.log('getting post'+id);
    return axios.get(baseURL+'/'+id);
}

axios.interceptors.request.use(function (config) {
    config.headers['Authorization'] = getToken();
    return config;
}, function (error) {
    return Promise.reject(error);
});

export const createPost = (postObj) => {
    return axios.post(baseURL, postObj)
}

export const createComment = (commentObj) => {
    return axios.post(commentBaseUrl, commentObj);
}

export const getAllCommentsByPost = (postid) => {
    return axios.get(commentBaseUrl + '/by-post/' + postid);
}