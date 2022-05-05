import React from "react";

import ProductCard from "./ProductCard";

import "../styles/campaigns.css";

function Campaigns() {
  return (
    <section className="campaigns">
      <h2 className="campaigns__title">Campaigns</h2>
      <ProductCard
        img="/img/articles/01-dog-boots-green.jpg"
        imgAlt="Military green dog boots"
        title="Dog set"
        desc="For small dogs. Includes boots, pants and sweater"
        price="700"
        id="1"
      />
      <ProductCard
        img="/img/articles/water-bottle-blue.jpeg"
        imgAlt="Blue water bottle"
        title="Water bottle"
        desc="0.7 Liters, with hook for easy attachment."
        price="120"
        id="2"
      />
      <ProductCard
        img="/img/articles/winter-sweater-green.jpg"
        imgAlt="Military green sweater"
        title="Winter Sweater"
        desc="Holds the heat effectively."
        price="800"
        id="3"
      />
    </section>
  );
}

export default Campaigns;
