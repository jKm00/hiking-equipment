import React from "react";
import { useParams } from "react-router-dom";
import ShowCaseImg from "../components/ShowCaseImg";
import ShowCaseBody from "../components/ShowCaseBody";
import DescriptionBox from "../components/DescriptionBox";
import Footer from "../components/Footer";
// Import header styles
import "../styles/productPage.css";


function ProductPage() {
  return (
    <>
    <div className="layout">
    <ShowCaseImg 
            bigImg="./img/lorem-picsum.jpg"
            bigImgAlt="lorem picsum placeholder"
            smallImg="./img/lorem-picsum.jpg"
            smallImgAlt="lorem picsum placeholder"
            smallImg2="./img/lorem-picsum-2.jpg"
            smallImg2Alt="lorem picsum placeholder"
      />

      <ShowCaseBody 
      title="Lorem ipsum dolor."
      price="800"
      colorTitle="Color:"
      colorBtn="color_button"
      colorBtn2="color_button2"
      sizeLabel="Size:"
      sizeSelector={ 
      <div className="option_text">
      <option value="" disabled selected hidden>Pick size...</option>
      <option value="small">Small</option>
      <option value="medium">Medium</option>
      <option value="large">Large</option>
    </div>}
      addToCart
       />
      <DescriptionBox 
      title="Lorem ipsum dolor."
      desc="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer aliquet."
      />
      <Footer />
    </div>
    </>
  );
}

export default ProductPage;
