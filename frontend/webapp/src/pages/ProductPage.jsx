import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import ShowCaseImg from "../components/ShowCaseImg";
import ShowCaseBody from "../components/ShowCaseBody";
import DescriptionBox from "../components/DescriptionBox";
import Footer from "../components/Footer";

// Import header styles
import "../styles/productPage.css";

function ProductPage() {
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

  return (
    <>
      <div className="layout">
        <div className="images--wrapper">
          <ShowCaseImg images={product.images} />
        </div>
        <ShowCaseBody
          title={product.productName}
          price={product.price}
          colors={product.colors}
          sizes={product.sizes}
        />
        <DescriptionBox details={product.productDetails} />
      </div>
      <Footer />
    </>
  );
}

export default ProductPage;
