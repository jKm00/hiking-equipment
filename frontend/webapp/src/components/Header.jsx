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
          <picture>
            <source
              media="(max-width: 650px)"
              srcSet="./img/header/header-1-cropped-small-compressed.jpg 650w"
              sizes="100vw"
            />
            <source
              type="image/webp"
              sizes="100vw"
              srcSet="./img/header/header-1-cropped-compressed.webp 2400w"
            />
            <source
              type="image/jpeg"
              sizes="100vw"
              srcSet="./img/header/header-1-cropped-compressed.jpg 2400w"
            />
            <img
              className="header-carousel__img"
              src="./img/header/header-1-original.jpg"
              alt="Guy sitting on a cliff"
            />
          </picture>
          <div className="header-carousel__img--overlay"></div>
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">Winter Sweater</h1>
            <p className="header-carousel__body__desc">
              Makes sure you are warm and comfy with our premium winter sweaters
            </p>
            <Link to={"/shop/all/sweater"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>

        <SwiperSlide>
          <picture>
            <source
              media="(max-width: 650px)"
              srcSet="./img/header/header-2-640.jpg 640w"
              sizes="100vw"
            />
            <source
              type="image/webp"
              sizes="100vw"
              srcSet="./img/header/header-2-2400.webp 2400w"
            />
            <source
              type="image/jpeg"
              sizes="100vw"
              srcSet="./img/header/header-2-2400.jpg 2400w"
            />
            <img
              className="header-carousel__img"
              src="./img/header/header-2-original.jpg"
              alt="Closeup of boots walking over rivers"
            />
          </picture>
          <div className="header-carousel__img--overlay"></div>
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">Hiking Boots</h1>
            <p className="header-carousel__body__desc">
              Keep your feet warm and dry with our premium hiking boots
            </p>
            <Link to={"/shop/all/boots"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>
        <SwiperSlide>
          <picture>
            <source
              type="image/webp"
              sizes="100vw"
              srcSet="./img/header/header-3-2400.webp 2400w"
            />
            <source
              type="image/jpeg"
              sizes="100vw"
              srcSet="./img/header/header-3-2400.jpg 2400w"
            />
            <img
              className="header-carousel__img"
              src="./img/header/header-3-original.jpg"
              alt="Dog with west"
            />
          </picture>
          <div className="header-carousel__img--overlay"></div>
          <div
            className="header-carousel__body"
            data-swiper-parallax="-300"
            data-swiper-parallax-duration="600"
          >
            <h1 className="header-carousel__body__title">Dog Set</h1>
            <p className="header-carousel__body__desc">
              Make your best friend match you and your outfit. With our premium
              dog set your best friend will both look good and feel good
            </p>
            <Link to={"/shop/animals"} className="cta">
              Go to shop
            </Link>
          </div>
        </SwiperSlide>
      </Swiper>
    </>
  );
}
