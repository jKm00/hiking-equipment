import { setCookie } from "./cookies";
import { sendApiRequest } from "./request";

/**
 * Send an authentication request to the API
 * @param {*} username username
 * @param {*} password password
 * @param {*} successCallback function to be called on success
 * @param {*} errorCallback function to be called on error
 */
export function sendAuthenticationRequest(
  username,
  password,
  successCallback,
  errorCallback
) {
  const postData = {
    username: username,
    password: password,
  };
  sendApiRequest(
    "POST",
    "/authenticate",
    function (jwtResponse) {
      setCookie("jwt", jwtResponse.jwt);
      const userData = parseJwtUser(jwtResponse.jwt);
      if (userData) {
        setCookie("current_username", userData.username);
        setCookie("current_user_roles", userData.roles.join(","));
        successCallback(userData);
      }
    },
    postData,
    function (responseStatus, responseText) {
      console.error(
        "Authentication failed: " + responseStatus + ", " + responseText
      );
      errorCallback();
    }
  );
}

/**
 * Parse JWT string, extract information from it
 * Code copied from https://stackoverflow.com/questions/38552003/how-to-decode-jwt-token-in-javascript-without-using-a-library
 * @param token JWT token string
 * @returns {any} Decoded JWT object
 */
function parseJwt(token) {
  const base64Url = token.split(".")[1];
  const base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
  const jsonPayload = decodeURIComponent(
    atob(base64)
      .split("")
      .map(function (c) {
        return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
      })
      .join("")
  );

  return JSON.parse(jsonPayload);
}

/**
 * Parse JWT string, extract a User object
 * @param jwtString
 * @return User object
 */
function parseJwtUser(jwtString) {
  let user = null;
  const jwtObject = parseJwt(jwtString);
  if (jwtObject) {
    user = {
      username: jwtObject.sub,
      roles: jwtObject.roles.map((r) => r.authority),
    };
  }
  return user;
}
