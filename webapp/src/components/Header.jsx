import React, { useRef, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";


export default function Header() {
  return (
    <>

      <Swiper className="mySwiper header">
      

        <SwiperSlide className="header-carousel">
        <img className="retard" src="https://picsum.photos/1920/1080" alt="img" />
        <div
        class="text"
        data-swiper-parallax="-300"
        data-swiper-parallax-duration="600"
      >
       <button className="cta">Go to shop</button>
        <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
      </div>

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