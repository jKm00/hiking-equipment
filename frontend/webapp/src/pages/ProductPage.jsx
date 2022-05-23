import React, { useState } from "react";
import ShowCaseImg from "../components/ShowCaseImg";
import ShowCaseBody from "../components/ShowCaseBody";
import DescriptionBox from "../components/DescriptionBox";
import Footer from "../components/Footer";
// Import header styles
import "../styles/productPage.css";

function ProductPage() {
  const [product, setProduct] = useState({});

  return (
    <>
      <div className="layout">
        <div className="images--wrapper">
          <ShowCaseImg images={product.images} />
        </div>
        <ShowCaseBody product={product} />
        <DescriptionBox details={product.detail} />
      </div>
      <Footer />
    </>
  );
}

export default ProductPage;
