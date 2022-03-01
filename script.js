const toggleSearchBtn = document.querySelector("[data-search-toggle]")
const searchForm = document.querySelector("[data-search-form]")

toggleSearchBtn.addEventListener("click", e => {
    searchForm.classList.toggle("hidden")
})