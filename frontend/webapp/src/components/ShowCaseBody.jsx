import React from "react";


// Import header styles
import "../styles/showCaseBody.css";

function ShowCaseBody({ title, price, colorTitle, colorBtn, colorBtn2, sizeLabel, sizeSelector, addToCart }) {
  return (
      <section>
    <h1 className="card__body__title">{title}</h1>
    <h2 className="card__body__price">{price}</h2>
    <h3 className="card__body__color">{colorTitle}</h3>
    <button className="color_button">{colorBtn}</button>
    <button className="color_button2">{colorBtn2}</button>
    <label className="size_selector_text">{sizeLabel}</label>

    <select name="Size"className="size_selector">
              <div className="option_text">
                <option value="" disabled selected hidden>Pick size...</option>
                <option value="small">Small</option>
                <option value="medium">Medium</option>
                <option value="large">Large</option>
              </div>
    {sizeSelector}</select>

    <p className="cta cta--small" id="cta--add--to--cart">{addToCart}</p>

      </section>
  );
}

export default ShowCaseBody;



