import React, { useRef, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/free-mode";
import "swiper/css/navigation";
import "swiper/css/thumbs";

// import required modules
import { FreeMode, Navigation, Thumbs } from "swiper";

// import custom styles
import "../styles/showCaseImg.css";

// pass inn en liste med bilder istedenfor. se på thumbs.
export default function ShowCaseImg({ images }) {
  const [thumbsSwiper, setThumbsSwiper] = useState(null);

  return (
    <>
      <Swiper
        style={{
          "--swiper-navigation-color": "#fff",
          "--swiper-pagination-color": "#fff",
        }}
        loop={true}
        spaceBetween={0}
        slidesPerView="auto"
        navigation={true}
        thumbs={{ swiper: thumbsSwiper }}
        modules={[FreeMode, Navigation, Thumbs]}
        className="mySwiper2 big-images"
      >
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-black-01.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-black-02.png"
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-black-03.png"
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-blue-01.png"
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-blue-02.png"
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-blue-03.png"
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-red-01.png"
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-red-02.png"
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="image--big"
            src="/img/articles/hiking-shoes-transparent-red-03.png"
          />
        </SwiperSlide>
      </Swiper>
      <Swiper
        onSwiper={setThumbsSwiper}
        spaceBetween={10}
        slidesPerView={5.5}
        navigation={true}
        freeMode={true}
        watchSlidesProgress={true}
        modules={[FreeMode, Navigation, Thumbs]}
        className="mySwiper small-images"
      >
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-black-01.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-black-02.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-black-03.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-blue-01.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-blue-02.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-blue-03.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-red-01.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-red-02.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-red-03.png" />
        </SwiperSlide>
        <SwiperSlide>
          <img src="/img/articles/hiking-shoes-transparent-black-01.png" />
        </SwiperSlide>
      </Swiper>
    </>
  );
}
