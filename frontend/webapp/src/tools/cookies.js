/**
 * Get calue of a specific cookie
 * @param {*} cookieName Key of the cookie to get
 * @return {string} Value of cookie or "" if cookie is not found
 */
export function getCookie(cookieName) {
  let name = cookieName + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(";");
  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) === " ") {
      c = c.substring(1);
    }
    if (c.indexOf(name) === 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

/**
 * Store a cookie to the browser
 * @param {*} cookieName name/key of the cookie
 * @param {*} cookieValue value of the cookie
 * @param {*} exdays expiry time in days
 */
export function setCookie(cookieName, cookieValue, exdays) {
  const d = new Date();
  d.setTime(d.getTime() + exdays * 24 * 60 * 60 * 1000);
  let expires = "expires=" + d.toUTCString();
  document.cookie = cookieName + "=" + cookieValue + ";" + expires + ";path=/";
}

/**
 * Delete a cookie
 * @param cookieName Name of the cookie to delete
 */
export function deleteCookie(cookieName) {
  setCookie(cookieName, "", -1);
}
