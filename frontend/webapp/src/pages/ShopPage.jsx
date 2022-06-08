import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import ShopHeader from "../components/ShopHeader";
import Footer from "../components/Footer";
import ShopCategories from "../components/ShopCategories";
import ProductCard from "../components/ProductCard";

import "../styles/shop.css";

/**
 * Returns a shop page, containing all the products matching the filter
 * @returns
 */
function ShopPage() {
  // A filter for sex
  const { sex } = useParams();
  // A filter for category
  const { category } = useParams();
  // List of all products matching the filters
  const [products, setProducts] = useState([]);
  // The title to be displayed at the top of the page
  const [title, setTitle] = useState("");
  // The style classes the header should have
  const [headerStyle, setHeaderStyle] = useState("");

  // Update shop header based on gender
  useEffect(() => {
    if (sex === "all") {
      setTitle("Shop");
      setHeaderStyle("shop-header");
    } else if (sex === "men") {
      setTitle("Men");
      setHeaderStyle("shop-header shop-header--men");
    } else if (sex === "women") {
      setTitle("Women");
      setHeaderStyle("shop-header shop-header--women");
    } else if (sex === "animals") {
      setTitle("Animals");
      setHeaderStyle("shop-header shop-header--animals");
    }
  }, [sex]);

  // Updates the products whenever a filter is changed
  useEffect(() => {
    updateProducts(sex, category);
  }, [sex, category]);

  /**
   * Updates the product to be displayed in the shop. The
   * update is triggered by the ShopCategories component, when
   * the category value changes.
   * @param {*} sex if provided products are filtered to only
   * the sex specified
   * @param {*} category if provided products are filtered
   * to only the category specified
   */
  function updateProducts(sex, category) {
    let url = "/products";
    if (sex === "all" && category === undefined) {
      url += "?sex=undefined&category=undefined";
    } else if (sex === "all") {
      url += "?sex=undefined&category=" + category;
    } else if (category === undefined) {
      url += "?sex=" + sex + "&category=undefined";
    } else {
      url += "?sex=" + sex + "&category=" + category;
    }
    sendApiRequest(
      "GET",
      url,
      function (response) {
        setProducts(response);
      },
      null,
      function (error) {
        console.error("Could not load products: " + error);
      }
    );
  }

  return (
    <>
      <ShopHeader headerStyle={headerStyle} title={title} />
      <section className="shop">
        <ShopCategories
          sex={sex}
          category={category}
          updateProducts={updateProducts}
        />
        <div className="shop-items">
          {products.length === 0 ? (
            <p>No products :(</p>
          ) : (
            products.map((product) => (
              <ProductCard
                key={product.id}
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

export default ShopPage;
