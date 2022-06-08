import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import ShowCaseImg from "../components/ShowCaseImg";
import ShowCaseBody from "../components/ShowCaseBody";
import DescriptionBox from "../components/DescriptionBox";
import Footer from "../components/Footer";

// Import header styles
import "../styles/productPage.css";
import { displayFeedback } from "../tools/feedback";

/**
 * Returns a product page containing a product with details and images
 * @param {*} user, the user signed in on the app
 * @returns a product page
 */
function ProductPage({ user }) {
  // The id of the product
  const { id } = useParams();
  // The product
  const [product, setProduct] = useState({});
  // The images for the product
  const [images, setImages] = useState([]);

  // Retrieves the product and all its images when page loads
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
    sendApiRequest(
      "GET",
      "/images/" + id,
      (response) => {
        setImages(response);
      },
      null,
      (error) => console.error(error)
    );
  }, []);

  /**
   * Adds the product with the color and size selected to the cart
   * @param {*} color, the color of the product the user chose
   * @param {*} size, the size of the product the user chose
   */
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
        displayFeedback(
          "success",
          "Added to cart",
          document.querySelector("[data-submit]"),
          document.querySelector("[data-feedback]")
        );
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
          <ShowCaseImg images={images} />
        </div>
        <ShowCaseBody
          user={user}
          title={product.productName}
          price={product.price}
          discount={product.discount}
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
