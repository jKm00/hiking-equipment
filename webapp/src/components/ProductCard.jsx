import React from "react";
import { Link } from "react-router-dom";

function ProductCard({ img, imgAlt, title, desc, price, id }) {
  return (
    <Link to={"product/" + id} className="card-link--wrapper">
      <article className="card">
        <img src={img} alt={imgAlt} className="card__img" />
        <div className="card__body">
          <h3 className="card__body__title">{title}</h3>
          <p className="card__body__desc">{desc}</p>
          <p className="card__body__price">{price}</p>
          <p className="cta cta--small">View item</p>
        </div>
      </article>
    </Link>
  );
}

export default ProductCard;
