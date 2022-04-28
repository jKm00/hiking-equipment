import React from "react";


function DescriptionBox({ title, price, colorTitle, colorBtn, colorBtn2, sizeLabel, sizeSelector, addToCart }) {
  return (
      <section>
    <h1 class="card__body__title">{title}</h1>
    <h2 class="card__body__price">{price}</h2>
    <h3 class="card__body__color">{colorTitle}</h3>
    <button class="color_button">{colorBtn}</button>
    <button class="color_button2">{colorBtn2}</button>
    <label class="size_selector_text">{sizeLabel}</label>

    <select name="Size" id="size_selector" class="size_selector">
              <div class="option_text">
                <option value="" disabled selected hidden>Pick size...</option>
                <option value="small">Small</option>
                <option value="medium">Medium</option>
                <option value="large">Large</option>
              </div>
    {sizeSelector}</select>

    <p class="cta cta--small" id="cta--add--to--cart">{addToCart}</p>

      </section>
  );
}

export default DescriptionBox;
