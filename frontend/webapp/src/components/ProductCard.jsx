import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import "../styles/productCard.css";

function ProductCard({ title, desc, price, id }) {
  const [image, setImage] = useState(null);

  useEffect(() => {
    sendApiRequest(
      "GET",
      "/images/thumbnail/" + id,
      (respone) => {
        setImage(respone);
      },
      null,
      (error) => console.error(error)
    );
  }, []);

  return (
    <Link to={"/product/" + id} className="product-card-link--wrapper">
      <article className="product-card">
        <img
          src={
            image !== null
              ? "data:image/" + image.extension + ";base64," + image.data
              : ""
          }
          alt={"Thumbnail for " + title}
          className="product-card__img"
        />
        <div className="product-card__body">
          <h3 className="product-card__body__title">{title}</h3>
          <p className="product-card__body__desc">{desc}</p>
          <p className="product-card__body__price">{price},-</p>
          <p className="cta cta--small">View item</p>
        </div>
      </article>
    </Link>
  );
}

export default ProductCard;
