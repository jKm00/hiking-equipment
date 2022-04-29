import { sendApiRequest } from "../tools/request";

export function fetchProducts(category, sex, callbackFunction, errorFunction) {
  let url = "/products";
  if (category && sex !== "all") {
    url += "?category=" + category + "&sex=" + sex;
  } else if (category) {
    url += "?category=" + category;
  } else if (sex !== "all") {
    url += "?sex=" + sex;
  }
  sendApiRequest("GET", url, callbackFunction, null, errorFunction);
}
