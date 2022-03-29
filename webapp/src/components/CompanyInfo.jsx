import React from "react";

import "../styles/companyInfo.css";

function CompanyInfo() {
  return (
    <div className="company-info">
      <article className="company__article">
        <div className="company__article--wrapper">
          <h2 className="company__article__title">About XXS</h2>
          <p className="company__article__desc">
            Young or old, we help you reach the peaks of your lifetime. With XXS
            your weekend is a success. Our team consists of professional
            climbers as well as weekend hikers.
          </p>
        </div>
        <img
          src="img/02-people-outdoors-iceman.jpg"
          alt="Employee ice climbing"
          className="company__article__img"
        />
      </article>
      <article className="company__article company__article--mirrored">
        <div className="company__article--wrapper">
          <h2 className="company__article__title">Our products & services</h2>
          <p className="company__article__desc">
            We sell only premium equipment from brands such as Bergans, North
            Face, Devold and Mammut. All our employees are hiking enthusiast and
            we have tested all we sell in the shop. P.S. we have warm clothes
            for dogs. Check out our products.
          </p>
          <a href="#" className="cta">
            Go to shop
          </a>
        </div>
        <img
          src="img/01-robust-clothing-waterproofjacket.jpg"
          alt="Employee ice climbing"
          className="company__article__img"
        />
      </article>
    </div>
  );
}

export default CompanyInfo;
