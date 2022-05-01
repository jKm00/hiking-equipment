import React from "react";


// Import header styles
import "../styles/showCaseBody.css";

function ShowCaseBody({ title, price, colorTitle, sizeLabel, sizeSelector, addToCart }) {
  return (
  <div className="showcase__body">
    <h1 className="card__body__title">{title}</h1>
    <h2 className="card__body__price">{price}</h2>
    <h3 className="card__body__color">{colorTitle}</h3>
    <button className="color_button">
    <span></span>
    </button>
    <button className="color_button2">
    <span></span>
    </button>
    <label className="size_selector_text">{sizeLabel}</label>

    <select name="Size" className="size_selector">
    {sizeSelector}</select>

    <p className="cta cta--small" id="cta--add--to--cart">{addToCart}</p>

  </div>
  );
}

export default ShowCaseBody;


