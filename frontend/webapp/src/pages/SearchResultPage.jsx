// Tools
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

// Components
import Footer from "../components/Footer";
import ProductCard from "../components/ProductCard";

// Styling
import "../styles/searchResultPage.css";

/**
 * Returns a page containing products the match the search keywod
 */
function SearchResultPage() {
  // The search keyword
  const { keyword } = useParams();
  // Set of products that match the keyword
  const [products, setProduct] = useState([]);

  // Retrieves all products that match the keyword when page loads
  useEffect(() => {
    sendApiRequest(
      "GET",
      "/products/search/" + keyword,
      (response) => {
        console.log(response);
        setProduct(response);
      },
      null,
      (error) => console.error(error)
    );
  }, []);

  return (
    <>
      <div className="search-page">
        <h1 className="search-page__title">Results for {keyword}</h1>

        {products.length === 0 ? (
          <p>No products named {keyword} found.</p>
        ) : (
          products.map((product) => (
            <ProductCard
              key={product.id}
              img="/img/articles/hiking-shoes-transparent-black-02.png"
              imgAlt={product.productName}
              title={product.productName}
              desc={product.description}
              price={product.price}
              id={product.id}
            />
          ))
        )}
      </div>
      <Footer />
    </>
  );
}

export default SearchResultPage;
