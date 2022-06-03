import { API_BASE_URL, sendApiRequest } from "./image-api-handler";

const IMAGE_URL = "/images";


/**
 * Sends a request to server to delete an image
 * @param {*} imageId ID of the image to be deleted
 * @param {*} callback Callback function to call when the operation is successfull
 * @param {*} errorCallback Callback function to call when the operation failed
 */
export function deleteImageOnServer(imageId, callback, errorCallback){
    sendApiRequest("delete", IMAGE_URL, callback, null, errorCallback);
}

/**
 * Upload an image to the server
 * @param {*} image Image date
 * @param {*} callback Callback function to call when the operation is successfull
 * @param {*} errorCallback Callback function to call when the operation failed
 */
export function uploadImageToServer(image, callback, errorCallback){
    sendApiRequest("POST", IMAGE_URL, callback, null, errorCallback, image);
}

/**
 * Get URL for fetching image with given ID
 * @param imageId ID of the image to fetch
 * @return {string} full image URL or null when image ID is invalid
 */
 export function generateImageUrl(imageId) {
    if (imageId > 0) {
        return API_BASE_URL + IMAGE_URL + "/" + imageId;
    } else {
        return null;
    }
}