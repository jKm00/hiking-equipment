import {sendApiRequest} from "./request";

export const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

export function sendApiFileUploadRequest(url, fileContent, callback, errorCallback) {
  sendApiRequest("post", url, callback, null, errorCallback, fileContent)
}

export function sendApiDeleteRequest(url, callback, errorCallback) {
    sendApiRequest("delete", url, callback, null, errorCallback)
}