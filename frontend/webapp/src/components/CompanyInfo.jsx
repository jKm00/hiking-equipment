import React from "react";

import "../styles/companyInfo.css";

/**
 * Creates a component that includes all information about the company
 * @returns returns a component that includes information about the company 
 */
function CompanyInfo() {
  return (
    <div className="company-info">
      <article className="company-article" id="about-us">
        <div className="company-article--wrapper">
          <h2 className="company-article__title">About XXS</h2>
          <p className="company-article__desc">
            Young or old, we help you reach the peaks of your lifetime. With XXS
            your weekend is a success. Our team consists of professional
            climbers as well as weekend hikers.
          </p>
        </div>
        <img
          src="img/ice-climber-compressed.jpg"
          alt="Employee ice climbing"
          className="company-article__img"
        />
      </article>
      <article
        className="company-article company-article--mirrored"
        id="products-and-services"
      >
        <div className="company-article--wrapper">
          <h2 className="company-article__title">Our products & services</h2>
          <p className="company-article__desc">
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
          src="img/our-products-shoes-compressed.jpg"
          alt="Nice hiking shoes"
          className="company-article__img"
        />
      </article>
    </div>
  );
}

export default CompanyInfo;
