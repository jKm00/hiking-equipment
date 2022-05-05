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

export default function App() {
  const [thumbsSwiper, setThumbsSwiper] = useState(null);

  return (
    <>
      <Swiper
        style={{
          "--swiper-navigation-color": "#fff",
          "--swiper-pagination-color": "#fff",
        }}
        spaceBetween={10}
        direction="vertical"
        slidesPerView="auto"
        navigation={true}
        thumbs={{ swiper: thumbsSwiper }}
        modules={[FreeMode, Navigation, Thumbs]}
        className="small__images"
      >
        <SwiperSlide>
          <img src="https://picsum.photos/200/300" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="https://picsum.photos/200" />
        </SwiperSlide>
      </Swiper>
      <Swiper
        onSwiper={setThumbsSwiper}
        spaceBetween={10}
        slidesPerView="auto"
        freeMode={true}
        watchSlidesProgress={true}
        modules={[FreeMode, Navigation, Thumbs]}
        className="big__images"
      >
        <SwiperSlide>
          <img src="https://picsum.photos/200/300" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="https://picsum.photos/200" />
        </SwiperSlide>
      </Swiper>
    </>
  );
}


















function ShowCaseImg({ bigImg, bigImgAlt, bigImg2, bigImgAlt2, smallImg, smallImgAlt, smallImg2, smallImg2Alt }) {
  return (
      <><div className="small__images">
      <img src={smallImg} alt={smallImgAlt} onClick={() => Swiper.mySwiper.slideTo(0)} />
      <img src={smallImg2} alt={smallImg2Alt} onClick={() => Swiper.mySwiper.slideTo(1)} />
    </div><div className="big__images">
      <img src={bigImg} alt={bigImgAlt} />
      <img src={bigImg2} alt={bigImgAlt2} />

      </div></>
// fikk opp quick fix wrap in jsx fragment og da funket griden
  );
}

// export default ShowCaseImg;

