import { deleteCookie, setCookie } from "./cookies";
import { sendApiRequest } from "./request";

/**
 * Send an authentication request to the API
 * @param {*} email email
 * @param {*} password password
 * @param {*} successCallback function to be called on success
 * @param {*} errorCallback function to be called on error
 */
export function sendAuthenticationRequest(
  email,
  password,
  successCallback,
  errorCallback
) {
  const postData = {
    email: email,
    password: password,
  };
  sendApiRequest(
    "POST",
    "/authenticate",
    function (jwtResponse) {
      setCookie("jwt", jwtResponse.jwt);
      const userData = parseJwtUser(jwtResponse.jwt);
      if (userData) {
        setCookie("current_email", userData.email);
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

export function deleteAuthorizationCookies() {
  deleteCookie("jwt");
  deleteCookie("current_email");
  deleteCookie("current_user_roles");
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
export function parseJwtUser(jwtString) {
  let user = null;
  const jwtObject = parseJwt(jwtString);
  if (jwtObject) {
    user = {
      id: jwtObject.uid,
      email: jwtObject.sub,
      roles: jwtObject.roles.map((r) => r.authority),
    };
  }
  return user;
}

/**
 * Checks if a jwt token is expired or not
 * @param {*} jwt the jwt to check
 * @returns true if it has expired, false otherwise
 */
export function isExpired(jwt) {
  const jwtObject = parseJwt(jwt);
  const expiration = jwtObject.exp;
  const current = parseInt(Date.now().toString().slice(0, -3));

  if (expiration < current) {
    return true;
  }
  return false;
}
