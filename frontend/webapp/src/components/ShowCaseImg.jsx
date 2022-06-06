import React, { useEffect, useRef, useState } from "react";
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

  return images.length === 0 ? (
    <p>No images available</p>
  ) : (
    <>
      <Swiper
        loop={true}
        spaceBetween={0}
        slidesPerView="auto"
        navigation={true}
        thumbs={{ swiper: thumbsSwiper }}
        modules={[FreeMode, Navigation, Thumbs]}
        className="mySwiper2 big-images"
      >
        {images.map((image, index) => {
          return (
            <SwiperSlide key={index}>
              <img
                src={"data:image/" + image.extension + ";base64," + image.data}
                alt=""
                className="image--big"
              />
            </SwiperSlide>
          );
        })}
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
        {images.map((image, index) => {
          return (
            <SwiperSlide key={index}>
              <img
                src={"data:image/" + image.extension + ";base64," + image.data}
                alt=""
              />
            </SwiperSlide>
          );
        })}
      </Swiper>
    </>
  );
}
