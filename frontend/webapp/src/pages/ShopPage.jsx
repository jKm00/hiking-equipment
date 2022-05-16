import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import ShopHeader from "../components/ShopHeader";
import Footer from "../components/Footer";
import ShopCategories from "../components/ShopCategories";
import ProductCard from "../components/ProductCard";

import "../styles/shop.css";

function ShopPage() {
  const { sex } = useParams();
  const { category } = useParams();
  const [products, setProducts] = useState([]);
  const [title, setTitle] = useState("");
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
    if (sex !== "all" && category) {
      url += "?sex=" + sex + "&category=" + category;
    } else if (category) {
      url += "?category=" + category;
    } else if (sex !== "all") {
      url += "?sex=" + sex;
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
            <p>Loading...</p>
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
      </section>
      <Footer />
    </>
  );
}

export default ShopPage;
