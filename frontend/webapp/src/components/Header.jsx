import React, { useRef, useState } from "react";
import { Link } from "react-router-dom";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";
// import required modules
import { Autoplay, Pagination, Navigation, Keyboard } from "swiper";

// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

// Import header styles
import "../styles/header.css";

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
        <SwiperSlide>
          <img
            className="header-carousel__img"
            src="https://picsum.photos/1920/1080"
            alt="img"
          />
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">
              Lorem ipsum dolor sit amet, ...
            </h1>
            <p className="header-carousel__body__desc">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Perspiciatis minus nulla quae reprehenderit laborum
            </p>
            <Link to={"/shop"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>

        <SwiperSlide>
          <img
            className="header-carousel__img"
            src="https://picsum.photos/1920/1080?random=1"
            alt="img"
          />
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">
              Lorem ipsum dolor sit amet, ...
            </h1>
            <p className="header-carousel__body__desc">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Perspiciatis minus nulla quae reprehenderit laborum
            </p>
            <Link to={"/shop"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>
        <SwiperSlide>
          <img
            className="header-carousel__img"
            src="https://picsum.photos/1920/1080?random=2"
            alt="img"
          />
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">
              Lorem ipsum dolor sit amet, ...
            </h1>
            <p className="header-carousel__body__desc">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Perspiciatis minus nulla quae reprehenderit laborum
            </p>
            <Link to={"/shop"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>

        <SwiperSlide>
          <img
            className="header-carousel__img"
            src="https://picsum.photos/1920/1080?random=3"
            alt="img"
          />
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">
              Lorem ipsum dolor sit amet, ...
            </h1>
            <p className="header-carousel__body__desc">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Perspiciatis minus nulla quae reprehenderit laborum
            </p>
            <Link to={"/shop"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>

        <SwiperSlide>
          <img
            className="header-carousel__img"
            src="https://picsum.photos/1920/1080?random=4"
            alt="img"
          />
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">
              Lorem ipsum dolor sit amet, ...
            </h1>
            <p className="header-carousel__body__desc">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Perspiciatis minus nulla quae reprehenderit laborum
            </p>
            <Link to={"/shop"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>

        <SwiperSlide>
          <img
            className="header-carousel__img"
            src="https://picsum.photos/1920/1080?random=5"
            alt="img"
          />
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">
              Lorem ipsum dolor sit amet, ...
            </h1>
            <p className="header-carousel__body__desc">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Perspiciatis minus nulla quae reprehenderit laborum
            </p>
            <Link to={"/shop"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>

        <SwiperSlide>
          <img
            className="header-carousel__img"
            src="https://picsum.photos/1920/1080?random=6"
            alt="img"
          />
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">
              Lorem ipsum dolor sit amet, ...
            </h1>
            <p className="header-carousel__body__desc">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.
              Perspiciatis minus nulla quae reprehenderit laborum Lorem ipsum
              dolor sit amet consectetur adipisicing elit. Perspiciatis minus
              nulla quae reprehenderit laborum
            </p>
            <Link to={"/shop"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>
      </Swiper>
    </>
  );
}
