import axios from "axios";
import React from "react";
import { getToken } from "./AuthService";

const baseURL = 'http://localhost:8080/api/votes'

export const votePost = (voteObj) => {
    return axios.post(baseURL, voteObj);
}
