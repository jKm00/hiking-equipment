import React, { useRef, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/free-mode";
import "swiper/css/navigation";
import "swiper/css/thumbs";

import "../styles/showCaseImg.css";

// import required modules
import { FreeMode, Navigation, Thumbs } from "swiper";

// pass inn en liste med bilder istedenfor. se på thumbs.
export default function ShowCaseImg({bigImg, bigImgAlt, bigImg2, bigImgAlt2, bigImg3, bigImgAlt3,
   navImg, navImgAlt, navImg2, navImgAlt2, navImg3, navImgAlt3}) {
  const [thumbsSwiper, setThumbsSwiper] = useState(null);

  return (
    <>
      <Swiper
        style={{
          "--swiper-navigation-color": "#fff",
          "--swiper-pagination-color": "#fff",
        }}
        loop={true}
        spaceBetween={10}
        slidesPerView="auto"
        navigation={true}
        thumbs={{ swiper: thumbsSwiper }}
        modules={[FreeMode, Navigation, Thumbs]}
        className="big__images"
      >
        <SwiperSlide>
          <img src= {bigImg} alt={bigImgAlt} className="swiper-slide-pic"/>
        </SwiperSlide>
        <SwiperSlide>
          <img src= {bigImg2} alt={bigImgAlt2} className="swiper-slide-pic"/>
        </SwiperSlide>
        <SwiperSlide>
          <img src= {bigImg3} alt={bigImgAlt3} className="swiper-slide-pic"/>
        </SwiperSlide>
      </Swiper>
      <Swiper
        onSwiper={setThumbsSwiper}
        spaceBetween={10}
        slidesPerView="3.5"
        direction="vertical"
        navigation={true}
        freeMode={true}
        watchSlidesProgress={true}
        modules={[FreeMode, Navigation, Thumbs]}
        className="small__images"
      >
        <SwiperSlide>
          <img src= {navImg} alt={navImgAlt}  className="swiper-slide-pic" />
        </SwiperSlide>
        <SwiperSlide >
          <img src= {navImg2} alt={navImgAlt2}  className="swiper-slide-pic" />
        </SwiperSlide>
        <SwiperSlide>
          <img src= {navImg3} alt={navImgAlt3}  className="swiper-slide-pic"/>
        </SwiperSlide>
      </Swiper>
    </>
  );
}
