import React from "react";
import { Link } from "react-router-dom";

import "../styles/productCard.css";

function ProductCard({ img, imgAlt, title, desc, price, id }) {
  return (
    <Link to={"/product/" + id} className="product-card-link--wrapper">
      <article className="product-card">
        <img src={img} alt={imgAlt} className="product-card__img" />
        <div className="product-card__body">
          <h3 className="product-card__body__title">{title}</h3>
          <p className="product-card__body__desc">{desc}</p>
          <p className="product-card__body__price">{price} ,-</p>
          <p className="cta cta--small">View item</p>
        </div>
      </article>
    </Link>
  );
}

export default ProductCard;
