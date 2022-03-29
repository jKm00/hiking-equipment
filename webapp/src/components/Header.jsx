import React, { useRef, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";
// import required modules
import { Autoplay, Pagination, Navigation, Keyboard } from "swiper";

// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

export default function Header() {
  return (
    <>
      <Swiper
        className="header"
        autoplay={{
          delay: 5000,
          disableOnInteraction: false,
        }}
        pagination={{
          clickable: true,
        }}
        navigation={true}
        keyboard={{
          enabled: true,
          onlyInViewport: false,
        }}
        loop={true}
        slidesPerView={1}
        spaceBetween={0}
        modules={[Autoplay, Pagination, Navigation, Keyboard]}
      >
        <SwiperSlide className="header-carousel__item">
          <img
            className="header-carousel-item-wrapper"
            src="https://picsum.photos/1920/1080"
            alt="img"
          />
          <div
            className="header--wrapper"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
            <button className="cta">Go to shop</button>
          </div>
        </SwiperSlide>

        <SwiperSlide className="header-carousel__item">
          <img
            className="header-carousel-item-wrapper"
            src="https://picsum.photos/1920/1080?random=1"
            alt="img"
          />
          <div
            className="header--wrapper"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
            <button className="cta">Go to shop</button>
          </div>
        </SwiperSlide>
        <SwiperSlide className="header-carousel__item">
          <img
            className="header-carousel-item-wrapper"
            src="https://picsum.photos/1920/1080?random=2"
            alt="img"
          />
          <div
            className="header--wrapper"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
            <button className="cta">Go to shop</button>
          </div>
        </SwiperSlide>

        <SwiperSlide className="header-carousel__item">
          <img
            className="header-carousel-item-wrapper"
            src="https://picsum.photos/1920/1080?random=3"
            alt="img"
          />
          <div
            className="header--wrapper"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
            <button className="cta">Go to shop</button>
          </div>
        </SwiperSlide>

        <SwiperSlide className="header-carousel__item">
          <img
            className="header-carousel-item-wrapper"
            src="https://picsum.photos/1920/1080?random=4"
            alt="img"
          />
          <div
            className="header--wrapper"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
            <button className="cta">Go to shop</button>
          </div>
        </SwiperSlide>

        <SwiperSlide className="header-carousel__item">
          <img
            className="header-carousel-item-wrapper"
            src="https://picsum.photos/1920/1080?random=5"
            alt="img"
          />
          <div
            className="header--wrapper"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
            <button className="cta">Go to shop</button>
          </div>
        </SwiperSlide>

        <SwiperSlide className="header-carousel__item">
          <img
            className="header-carousel-item-wrapper"
            src="https://picsum.photos/1920/1080?random=6"
            alt="img"
          />
          <div
            className="header--wrapper"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-title">Lorem ipsum dolor sit amet, ...</h1>
            <button className="cta">Go to shop</button>
          </div>
        </SwiperSlide>
      </Swiper>
    </>
  );
}
