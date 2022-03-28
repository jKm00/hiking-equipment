import React, { useRef, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";


export default function Header() {
  return (
    <>

      <Swiper className="header">
      

        <SwiperSlide className="header-carousel__item">
        <img className="header-carousel-item-wrapper" src="https://picsum.photos/1920/1080" alt="img" />
        <div
        className="header--wrapper"
        data-swiper-parallax="-300"
        data-swiper-parallax-duration="600"
      >
       <button className="cta">Go to shop</button>
        <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
      </div>

        //TO DO: ADD CLASSES TO FOLLOWING SWIPER TAGS
        </SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080?random=1" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080?random=2" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080?random=3" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080?random=4" alt="img" /></SwiperSlide>
        <SwiperSlide><img src="https://picsum.photos/1920/1080?random=5" alt="img" /></SwiperSlide>
      </Swiper>
    </>
  );
}