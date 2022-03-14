import React from "react";

import ProductCard from "../components/ProductCard";
import ShopCategories from "../components/ShopCategories";

function ShopPageMen() {
  return (
    <>
      <header className="shop-header shop-header--men">
        <h1 className="shop-header__title">Men</h1>
      </header>
      <section className="shop">
        <ShopCategories />
        <div className="shop-items">
          <ProductCard
            img="/img/articles/01-dog-boots-green.jpg"
            imgAlt="Military green dog boots"
            title="Dog set"
            desc="For small dogs. Includes boots, pants and sweater"
            price="700,-"
            id="1"
          />
          <ProductCard
            img="/img/articles/water-bottle-blue.jpeg"
            imgAlt="Blue water bottle"
            title="Water bottle"
            desc="0.7 Liters, with hook for easy attachment."
            price="120,-"
            id="2"
          />
          <ProductCard
            img="/img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="3"
          />
          <ProductCard
            img="/img/articles/01-dog-boots-green.jpg"
            imgAlt="Military green dog boots"
            title="Dog set"
            desc="For small dogs. Includes boots, pants and sweater"
            price="700,-"
            id="1"
          />
          <ProductCard
            img="/img/articles/water-bottle-blue.jpeg"
            imgAlt="Blue water bottle"
            title="Water bottle"
            desc="0.7 Liters, with hook for easy attachment."
            price="120,-"
            id="2"
          />
          <ProductCard
            img="/img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="3"
          />
        </div>
      </section>
    </>
  );
}

export default ShopPageMen;
