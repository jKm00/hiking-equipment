import {sendApiRequest} from "./request";

export const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

export function sendApiFileUploadRequest(url, callback, errorCallback) {
  sendApiRequest("post", url, callback, null, errorCallback)
}

export function sendApiDeleteRequest(url, callback, errorCallback) {
    sendApiRequest("delete", url, callback, null, errorCallback)
}