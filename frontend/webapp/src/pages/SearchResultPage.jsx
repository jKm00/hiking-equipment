import React from "react";
import { useParams } from "react-router-dom";

import Footer from "../components/Footer";

function SearchResultPage() {
  const { keyword } = useParams();

  const mystyle = {
    gridColumn: "2 / -2",
    margin: "12.8em 0",
  };

  return (
    <>
      <div style={mystyle}>
        <h1>Results for {keyword}</h1>
        <p>Tried to display search results for {keyword}</p>
      </div>
      <Footer />
    </>
  );
}

export default SearchResultPage;
