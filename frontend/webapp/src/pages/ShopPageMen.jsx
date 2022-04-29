import React, { useState } from "react";
import { useParams } from "react-router-dom";

import Footer from "../components/Footer";
import ProductCard from "../components/ProductCard";
import ShopCategories from "../components/ShopCategories";

import "../styles/shop.css";

function ShopPageMen() {
  const { category } = useParams();

  const [products, setProducts] = useState([]);

  return (
    <>
      <header className="shop-header shop-header--men">
        <h1 className="shop-header__title">Men</h1>
      </header>
      <section className="shop">
        <ShopCategories
          selected={category}
          sex="men"
          updateProducts={setProducts}
        />
        <div className="shop-items">
          {products.length === 0 ? (
            <p>Loading...</p>
          ) : (
            products.map((product) => (
              <ProductCard
                key={product.id}
                img="/img/articles/winter-sweater-green.jpg"
                imgAlt={product.productName}
                title={product.productName}
                desc={product.description}
                price={product.price}
                id={product.id}
              />
            ))
          )}
        </div>
      </section>
      <Footer />
    </>
  );
}

export default ShopPageMen;
