import React from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";
// import required modules
import { Autoplay, Pagination, Navigation, Keyboard } from "swiper";

// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

// Import header styles
import "../styles/showCaseImg.css";



function ShowCaseImg({ bigImg, bigImgAlt, smallImg, smallImgAlt, smallImg2, smallImg2Alt }) {
  return (
      <><div className="small__images">
      <img src={smallImg} alt={smallImgAlt} />
      <img src={smallImg2} alt={smallImg2Alt} />
    </div><div className="big__images">
        <img src={bigImg} alt={bigImgAlt} />
      </div></>
// fikk opp quick fix wrap in jsx fragment og da funket griden
  );
}

export default ShowCaseImg;

