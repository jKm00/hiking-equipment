import React, { useEffect, useState } from "react";
import { sendApiRequest } from "../tools/request";

import ProductCard from "./ProductCard";

import "../styles/campaigns.css";

/**
 * Sends a request to the backend to find the featured products to display in campaigns
 * @returns returns a component with all featured products
 */
function Campaigns() {
  const [featured, setFeatured] = useState([]);

  useEffect(() => {
    sendApiRequest(
      "GET",
      "/products/features",
      (response) => {
        setFeatured(response);
      },
      null,
      (error) => {
        console.error(error);
      }
    );
  }, []);

  return (
    <section className="campaigns" id="campaigns">
      <h2 className="campaigns__title">Campaigns</h2>
      {!featured || featured.length === 0 ? (
        <p>Loading featured products...</p>
      ) : (
        featured.map((product) => (
          <ProductCard
            key={product.id}
            title={product.productName}
            desc={product.description}
            price={product.price}
            id={product.id}
          />
        ))
      )}
    </section>
  );
}

export default Campaigns;
