const API_URL = "/api";

const page = document.querySelector("body");
const toggleSearchBtn = document.querySelector("[data-search-toggle]");
const searchForm = document.querySelector("[data-search-form]");

page.addEventListener("click", (e) => {
  const result = e.target;
  if (!result.hasAttribute("data-search")) {
    searchForm.classList.add("hidden");
  }
});

toggleSearchBtn.addEventListener("click", (e) => {
  searchForm.classList.toggle("hidden");
});

fetch(API_URL + "/products", {
  method: "Get",
})
  .then(function (response) {
    return response.json();
  })
  .then(function (json) {
    console.log(json);
  })
  .catch(function (err) {
    console.log("Error: " + err);
  });
