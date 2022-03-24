import React from "react";

function SearchResultPage()
{
    function getSearchWord()
    {
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);
        let searchWord = urlParams.get("keyword")
        
        return searchWord;
    }

    const searchWord = getSearchWord();

    const mystyle = {
        gridColumn: "2 / -2",
        margin: "12.8em 0",
    };

    return (
        <div style={mystyle}>
            <h1>Results for {searchWord}</h1>
            <p>
                Tried to display search results for {searchWord}
            </p>
        </div>
    );
}

export default SearchResultPage;