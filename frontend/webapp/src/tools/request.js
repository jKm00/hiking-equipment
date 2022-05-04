import { getCookie } from "./cookies";

const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

/**
 * Send an api request to the backend
 * @param {*} method the method to use when sending the request
 * @param {*} url the relative URL to the API endpoint
 * @param {*} callback function to be called when request is successfull,
 * with (JSON-decoded) as parameter
 * @param {*} requestBody body of the request. Does not need to be applied,
 * for example when sending a GET request
 * @param {*} errorCallback function to be called when request was unsuccessfull,
 * with HTTP response code and response body as parameter
 */
export function sendApiRequest(
  method,
  url,
  callback,
  requestBody,
  errorCallback
) {
  const request = new XMLHttpRequest();
  request.onreadystatechange = function () {
    if (request.readyState === XMLHttpRequest.DONE) {
      if (request.status === 200) {
        let responseJson = "";
        if (request.responseText) {
          responseJson = JSON.parse(request.responseText);
        }
        callback(responseJson);
      } else if (errorCallback) {
        errorCallback(request.status, request.responseText);
      } else {
        console.error("Error in API request");
      }
    }
  };

  const fullUrl = API_BASE_URL + url;
  request.open(method, fullUrl);

  const jwtToken = getCookie("jwt");
  if (jwtToken) {
    request.setRequestHeader("Authorization", "Bearer " + jwtToken);
  }

  if (requestBody) {
    if (method.toLowerCase() !== "get") {
      request.setRequestHeader("Content-Type", "application/json");
      request.send(JSON.stringify(requestBody));
    } else {
      console.error("Sending HTTP GET with request body not allowed!");
      request.send();
    }
  } else {
    request.send();
  }
}
