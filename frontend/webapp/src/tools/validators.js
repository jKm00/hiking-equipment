/**
 * Checks if a list of files only contains images
 * @param {*} files the list of files to check
 * @returns true if all files are images, false otherwise
 */
export function isImages(files) {
  let i = 0;
  let allImages = true;
  while (allImages && i < files.length) {
    const extension = getExtension(files[i].name).toLowerCase();
    if (extension !== "jpg" && extension !== "jpeg" && extension !== "png") {
      allImages = false;
    }
    i++;
  }
  return allImages;
}

/**
 * Returns the extension of a file
 * @param {*} filename the file to get the extension of
 * @returns extension of file
 */
function getExtension(filename) {
  const parts = filename.split(".");
  return parts[parts.length - 1];
}

/**
 * Checks if a string is a valid email
 * @param {*} email the string to check
 * @returns true if string is a valid email, false otherwise
 */
export function validEmail(email) {
  return email
    .toLowerCase()
    .match(
      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    );
}

/**
 * Checks if a password is valid. Its valid if its 8 or more characters,
 * has atleast one upper and lower case letter as well as atleast one digit
 * @param {*} password the password to validate
 * @returns true if password is valid, false otherwise
 */
export function validPassword(password) {
  return password.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/);
}
