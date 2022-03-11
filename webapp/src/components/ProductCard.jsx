import React from "react";
import { Link } from "react-router-dom";

function ProductCard({ img, imgAlt, title, desc, price, id }) {
  return (
    <Link to={"product?id=" + id} class="card-link--wrapper">
      <article class="card">
        <img src={img} alt={imgAlt} class="card__img" />
        <div class="card__body">
          <h3 class="card__body__title">{title}</h3>
          <p class="card__body__desc">{desc}</p>
          <p class="card__body__price">{price}</p>
          <p class="cta cta--small">View item</p>
        </div>
      </article>
    </Link>
  );
}

export default ProductCard;
