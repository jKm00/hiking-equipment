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
          bigImgAlt="demo placeholder from swiper"
          bigImg2="https://picsum.photos/200/300"
          bigImgAlt2="demo placeholder from swiper"
          bigImg3="https://picsum.photos/200/300"
          bigImgAlt3="demo placeholder from swiper"
          navImg="https://picsum.photos/200/300"
          navImgAlt="demo placeholder from swiper"
          navImg2="https://picsum.photos/200/300"
          navImgAlt2="demo placeholder from swiper"
          navImg3="https://picsum.photos/200/300"
          navImgAlt3="demo placeholder from swiper"
        />

        <ShowCaseBody
          title="Lorem ipsum dolor."
          price="800,-"
          colorTitle
          colorBtn
          colorBtn2
          sizeLabel
          sizeSelector={
            <>
              <option value="" disabled selected hidden>
                Pick size...
              </option>
              <option value="small">Small</option>
              <option value="medium">Medium</option>
              <option value="large">Large</option>
            </>
          }
          addToCart
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
