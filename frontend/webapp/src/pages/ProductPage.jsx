import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import ShowCaseImg from "../components/ShowCaseImg";
import ShowCaseBody from "../components/ShowCaseBody";
import DescriptionBox from "../components/DescriptionBox";
import Footer from "../components/Footer";

// Import header styles
import "../styles/productPage.css";

function ProductPage({ user }) {
  const { id } = useParams();
  const [product, setProduct] = useState({});

  useEffect(() => {
    sendApiRequest(
      "GET",
      "/products/" + id,
      (response) => {
        setProduct(response);
      },
      null,
      (error) => console.error(error)
    );
  }, []);

  function addToCart(color, size) {
    const cartItem = {
      productId: product.id,
      productName: product.productName,
      productPrice: product.price,
      productCategory: product.category,
      productSex: product.sex,
      discount: product.discount,
      color: color,
      size: size,
      quantity: 1,
    };
    sendApiRequest(
      "POST",
      "/carts",
      (response) => {
        console.log("Product added to cart");
      },
      cartItem,
      (error) => {
        console.error(error);
      }
    );
  }

  return (
    <>
      <div className="layout">
        <div className="images--wrapper">
          <ShowCaseImg images={product.images} />
        </div>
        <ShowCaseBody
          user={user}
          title={product.productName}
          price={product.price}
          colors={product.colors}
          sizes={product.sizes}
          addToCart={addToCart}
        />
        <DescriptionBox details={product.productDetails} />
      </div>
      <Footer />
    </>
  );
}

export default ProductPage;
