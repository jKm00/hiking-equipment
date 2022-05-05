import React from "react";
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
            bigImg="https://picsum.photos/200/300" 
            bigImgAlt="lorem picsum placeholder"
            bigImg2="https://picsum.photos/200" 
            bigImgAlt2="lorem picsum placeholder"
            smallImg="https://picsum.photos/200/300" 
            smallImgAlt="lorem picsum placeholder"
            smallImg2="https://picsum.photos/200" 
            smallImg2Alt="lorem picsum placeholder"
      />

      <ShowCaseBody 
      title="Lorem ipsum dolor."
      price="800,-"
      colorTitle="Color:"
      colorBtn
      colorBtn2
      sizeLabel="Size:"
      sizeSelector={ 
      <>
      <option value="" disabled selected hidden>Pick size...</option>
      <option value="small">Small</option>
      <option value="medium">Medium</option>
      <option value="large">Large</option>
      </>
    }
      addToCart="add to cart"
       />
      <DescriptionBox 
      title="Lorem ipsum dolor."
      desc="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer aliquet."
      />
    </div>
    <Footer />
    </>
  );
}

export default ProductPage;
