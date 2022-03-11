import React from "react";
import { Link } from "react-router-dom";

import ProductCard from "../components/ProductCard";

function ShopPage() {
  return (
    <>
      <header className="shop-header">
        <h1 className="shop-header__title">Shop</h1>
      </header>
      <section className="shop">
        <nav className="shop-categories">
          <h2 className="shop-categories__title">Categories</h2>
          <a className="categories__item" href="#">
            All items
          </a>
          <a className="categories__item" href="#">
            Boots
          </a>
          <a className="categories__item" href="#">
            Sweaters
          </a>
          <a className="categories__item" href="#">
            Hats
          </a>
        </nav>
        <div className="shop-items">
          <ProductCard
            img="img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="1"
          />
          <ProductCard
            img="img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="1"
          />
          <ProductCard
            img="img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="1"
          />
          <ProductCard
            img="img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="1"
          />
          <ProductCard
            img="img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="1"
          />
          <ProductCard
            img="img/articles/winter-sweater-green.jpg"
            imgAlt="Military green sweater"
            title="Winter Sweater"
            desc="Holds the heat effectively."
            price="800,-"
            id="1"
          />
        </div>
      </section>
    </>
  );
}

export default ShopPage;
