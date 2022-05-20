import React from "react";

// Import header styles
import "../styles/descriptionBox.css";

function DescriptionBox({ details }) {
  return (
    <div className="description-box">
      <h4 className="product__description__title">Details</h4>
      <ul className="product__description__list">
        <li className="product__description__item">Holds heat effectivly</li>
        <li className="product__description__item">Very warm</li>
        <li className="product__description__item">Much wow</li>
        <li className="product__description__item">Such cool</li>
      </ul>
    </div>
  );
}

export default DescriptionBox;
