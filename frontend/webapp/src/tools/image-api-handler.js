export const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

export function sendApiFileUploadRequest(url, fileContent, callback, errorCallback) {
  sendApiRequest("post", url, callback, null, errorCallback, fileContent)
}

export function sendApiDeleteRequest(url, callback, errorCallback) {
    sendApiRequest("delete", url, callback, null, errorCallback)
}

/**
 * sends a REST-API request to the backend
 * @param {*} method 
 * @param {*} url 
 * @param {*} callback 
 * @param {*} requestBody 
 * @param {*} errorCallback 
 * @param {*} fileContent 
 * @returns 
 */
function sendApiRequest(method, url, callback, requestBody, errorCallback, fileContent) {
  const request = new XMLHttpRequest();
  request.onreadystatechange = function () {
      if (request.readyState === XMLHttpRequest.DONE) {
          if (request.status === 200) {
              let responseJson = "";
              if (request.responseText) {
                  try {
                      responseJson = JSON.parse(request.responseText);
                  } catch (e) {
                      responseJson = "";
                      console.log("error parsing json response")
                  }
              }
              callback(responseJson);
          } else if (errorCallback) {
              errorCallback(request.status, request.responseText);
          } else {
              console.error("Error in API request");
          }
      }
  };