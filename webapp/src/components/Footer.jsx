import React from "react";
import { Link } from "react-router-dom";

function Footer() {
  return (
    <footer class="footer">
      <div class="first__footer">
        <div class="first__footer__logo--wrapper">
          <h4 class="logo logo--footer">XXS -</h4>
          <p class="logo__slogan">Because the size doesn't matter</p>
        </div>
        <ul class="footer__socials">
          <li class="footer__socials__item">
            <a href="#" class="footer__socials__link">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                <path d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z" />
              </svg>
            </a>
          </li>
          <li class="footer__socials__item">
            <a href="#" class="footer__socials__link">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                <path d="M549.655 124.083c-6.281-23.65-24.787-42.276-48.284-48.597C458.781 64 288 64 288 64S117.22 64 74.629 75.486c-23.497 6.322-42.003 24.947-48.284 48.597-11.412 42.867-11.412 132.305-11.412 132.305s0 89.438 11.412 132.305c6.281 23.65 24.787 41.5 48.284 47.821C117.22 448 288 448 288 448s170.78 0 213.371-11.486c23.497-6.321 42.003-24.171 48.284-47.821 11.412-42.867 11.412-132.305 11.412-132.305s0-89.438-11.412-132.305zm-317.51 213.508V175.185l142.739 81.205-142.739 81.201z" />
              </svg>
            </a>
          </li>
          <li class="footer__socials__item">
            <a href="#" class="footer__socials__link">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path d="M459.37 151.716c.325 4.548.325 9.097.325 13.645 0 138.72-105.583 298.558-298.558 298.558-59.452 0-114.68-17.219-161.137-47.106 8.447.974 16.568 1.299 25.34 1.299 49.055 0 94.213-16.568 130.274-44.832-46.132-.975-84.792-31.188-98.112-72.772 6.498.974 12.995 1.624 19.818 1.624 9.421 0 18.843-1.3 27.614-3.573-48.081-9.747-84.143-51.98-84.143-102.985v-1.299c13.969 7.797 30.214 12.67 47.431 13.319-28.264-18.843-46.781-51.005-46.781-87.391 0-19.492 5.197-37.36 14.294-52.954 51.655 63.675 129.3 105.258 216.365 109.807-1.624-7.797-2.599-15.918-2.599-24.04 0-57.828 46.782-104.934 104.934-104.934 30.213 0 57.502 12.67 76.67 33.137 23.715-4.548 46.456-13.32 66.599-25.34-7.798 24.366-24.366 44.833-46.132 57.827 21.117-2.273 41.584-8.122 60.426-16.243-14.292 20.791-32.161 39.308-52.628 54.253z" />
              </svg>
            </a>
          </li>
          <li class="footer__socials__item">
            <a href="#" class="footer__socials__link">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path d="M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z" />
              </svg>
            </a>
          </li>
        </ul>
        <ul class="footer__list footer__link">
          <li>
            <h5 class="footer__list__title">Links</h5>
          </li>
          <li class="footer__list__item">
            <a href="#" class="footer__list__link">
              Go to shop
            </a>
          </li>
          <li class="footer__list__item">
            <a href="#" class="footer__list__link">
              Campaigns
            </a>
          </li>
          <li class="footer__list__item">
            <a href="#" class="footer__list__link">
              Reviews
            </a>
          </li>
          <li class="footer__list__item">
            <a href="#" class="footer__list__link">
              About us
            </a>
          </li>
          <li class="footer__list__item">
            <a href="#" class="footer__list__link">
              Our products & services
            </a>
          </li>
        </ul>
        <ul class="footer__list footer__business-hours">
          <li>
            <h5 class="footer__list__title">Opening Hours</h5>
          </li>
          <li class="footer__list__item">
            <span class="footer__list__item--darker">Mon - Thurs:</span>09.00 -
            22.00
          </li>
          <li class="footer__list__item">
            <span class="footer__list__item--darker">Friday:</span>09.00 - 20.00
          </li>
          <li class="footer__list__item">
            <span class="footer__list__item--darker">Saturday:</span>10.00 -
            20.0
          </li>
          <li class="footer__list__item">
            <span class="footer__list__item--darker">Sunday:</span>13.00 - 19.00
          </li>
        </ul>
        <ul class="footer__list footer__contact-info">
          <li>
            <h5 class="footer__list__title">Contact Information</h5>
          </li>
          <li class="footer__list__item">
            <span class="footer__list__item--darker">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512">
                <path d="M168.3 499.2C116.1 435 0 279.4 0 192C0 85.96 85.96 0 192 0C298 0 384 85.96 384 192C384 279.4 267 435 215.7 499.2C203.4 514.5 180.6 514.5 168.3 499.2H168.3zM192 256C227.3 256 256 227.3 256 192C256 156.7 227.3 128 192 128C156.7 128 128 156.7 128 192C128 227.3 156.7 256 192 256z" />
              </svg>
              XXS AS, Haugavegen 69, 6008 Ålesund, Norge
            </span>
          </li>
          <li class="footer__list__item">
            <span class="footer__list__item--darker">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path d="M511.2 387l-23.25 100.8c-3.266 14.25-15.79 24.22-30.46 24.22C205.2 512 0 306.8 0 54.5c0-14.66 9.969-27.2 24.22-30.45l100.8-23.25C139.7-2.602 154.7 5.018 160.8 18.92l46.52 108.5c5.438 12.78 1.77 27.67-8.98 36.45L144.5 207.1c33.98 69.22 90.26 125.5 159.5 159.5l44.08-53.8c8.688-10.78 23.69-14.51 36.47-8.975l108.5 46.51C506.1 357.2 514.6 372.4 511.2 387z" />
              </svg>
              Call us now:{" "}
            </span>
            <a href="tel:463-87-526" class="footer__list__link">
              (+47) 463 87 526
            </a>
          </li>
          <li class="footer__list__item">
            <span class="footer__list__item--darker">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path d="M256 352c-16.53 0-33.06-5.422-47.16-16.41L0 173.2V400C0 426.5 21.49 448 48 448h416c26.51 0 48-21.49 48-48V173.2l-208.8 162.5C289.1 346.6 272.5 352 256 352zM16.29 145.3l212.2 165.1c16.19 12.6 38.87 12.6 55.06 0l212.2-165.1C505.1 137.3 512 125 512 112C512 85.49 490.5 64 464 64h-416C21.49 64 0 85.49 0 112C0 125 6.01 137.3 16.29 145.3z" />
              </svg>
              mail:{" "}
            </span>
            <a href="mailto:xxs@gmail.com" class="footer__list__link">
              xxs@gmail.com
            </a>
          </li>
        </ul>
      </div>
      <div class="second__footer">
        <div class="second__footer--wrapper">
          <p class="second__footer__copyright">
            &copy; 2022 NTNU WebTek/AppDev Group 2 - All rights reserved
          </p>
          <p class="second__footer__legal">
            <a href="#">Sources & Inspiration</a> -
            <a href="#">Terms & Condition</a>
          </p>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
