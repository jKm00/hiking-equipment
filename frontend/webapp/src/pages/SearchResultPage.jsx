import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

import Footer from "../components/Footer";
import ProductCard from "../components/ProductCard";

import { sendApiRequest } from "../tools/request";

function SearchResultPage() {
  const { keyword } = useParams();
  const [products, setProduct] = useState([]);

  useEffect(() => {
    sendApiRequest(
      "GET",
      "/products/search/" + keyword,
      (response) => {
        setProduct(response);
      },
      null,
      (error) => console.error(error)
    );
  }, []);

  const mystyle = {
    gridColumn: "2 / -2",
    margin: "12.8em 0",
  };

  return (
    <>
      <div style={mystyle}>
        <h1>Results for {keyword}</h1>

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
