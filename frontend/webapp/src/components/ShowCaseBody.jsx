import React from "react";

// Import header styles
import "../styles/showCaseBody.css";

function ShowCaseBody({ title, price, sizeSelector }) {
  return (
    <div className="showcase__body">
      <div>
        <h1 className="body__title">Winter Sweater</h1>
        <p className="body__price">800,-</p>
      </div>
      <form className="body__form">
        <div className="body__form__wrapper">
          <p className="body__form__color">Color:</p>
          <div className="color__button--wrapper">
            <input
              className="body__form__checkbox"
              type="radio"
              name="color"
              value="green"
              id="green"
            ></input>
            <label
              htmlFor="green"
              className="color__button color__button--green"
            ></label>
            <input
              className="body__form__checkbox"
              type="radio"
              name="color"
              value="orange"
              id="orange"
            ></input>
            <label
              htmlFor="orange"
              className="color__button color__button--orange"
            ></label>
          </div>
        </div>
        <div className="body__form__wrapper">
          <label className="size-selector-text" for="sizes">
            Size:
          </label>
          <select name="size" id="sizes" className="size-selector">
            <option value="XS">XS</option>
            <option value="XS">S</option>
            <option value="XS">M</option>
            <option value="XS">L</option>
          </select>
        </div>
      </form>
      <button className="cta cta--small" id="cta--add--to--cart">
        Add to cart
      </button>
    </div>
  );
}

export default ShowCaseBody;
