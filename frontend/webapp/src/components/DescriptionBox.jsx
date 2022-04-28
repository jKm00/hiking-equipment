import React from "react";


// Import header styles
import "../styles/descriptionBox.css";

function DescriptionBox({ title, desc }) {
  return (
    <div className="description-box">
    <h4 className="product__description__title">{title}</h4>
    <p className="product__description">{desc}</p>
    </div>
  );
}

export default DescriptionBox;

