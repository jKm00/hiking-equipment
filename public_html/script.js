const API_URL = "http://localhost:8080";

const toggleSearchBtn = document.querySelector("[data-search-toggle]");
const searchForm = document.querySelector("[data-search-form]");

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
    alert("Error: " + err);
  });
