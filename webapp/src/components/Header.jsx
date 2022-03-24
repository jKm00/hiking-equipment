import React, { useRef, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";


export default function App() {
  return (
    <>

      <Swiper className="mySwiper header">
      

        <SwiperSlide> Test
        <img className="retard" src="https://picsum.photos/1920/1080" alt="img" />
        </SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080" alt="img" /></SwiperSlide>
      </Swiper>
    </>
  );
}