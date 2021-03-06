import React, { useState } from "react";
import { Link } from "react-router-dom";
import { displayFeedback } from "../tools/feedback";

// Import header styles
import "../styles/showCaseBody.css";

/**
 * Returns a show case body that contains details about a product
 * @param {*} user, the current user logged in
 * @param {*} title, title of the product
 * @param {*} price, the price of the product
 * @param {*} discount, the discount of the product
 * @param {*} colors, the colors the product is available in
 * @param {*} size, the sizes the product is available in
 * @param {*} addToCart, a function to be called whenere the add to cart button is pressed
 * @returns
 */
function ShowCaseBody({
  user,
  title,
  price,
  discount,
  colors,
  sizes,
  addToCart,
}) {
  // The color the user has selected
  const [color, setColor] = useState("");
  // The size the user has selected
  const [size, setSize] = useState("");

  /**
   * Handles the event when a user clicks on "Add to cart"
   * If no color or size is selected an error message is displayed,
   * otherwise the "addToCart" is called
   */
  function handleSubmit() {
    if (color === "" || size === "" || size === "undefined") {
      displayFeedback(
        "error",
        "Need to specify color and size before adding to cart",
        document.querySelector("[data-submit]"),
        document.querySelector("[data-feedback]")
      );
    } else {
      addToCart(color, size);
    }
  }

  return (
    <div className="showcase__body">
      <div>
        <h1 className="body__title">{title}</h1>
        <div className="body__price--wrapper">
          <p
            className={
              discount > 0 ? "body__price body__price--discount" : "body__price"
            }
          >
            {price},-
          </p>
          <p className="body__price">
            {discount > 0
              ? (price * (1 - discount / 100)).toFixed(2) + ",-"
              : ""}
          </p>
        </div>
      </div>
      <form className="body__form">
        <div className="body__form__wrapper">
          <p className="body__form__color">Color:</p>
          <div className="color__button--wrapper">
            {!colors ? (
              <p>No colors</p>
            ) : (
              colors.map((color) => (
                <div key={color.id}>
                  <input
                    className="body__form__checkbox"
                    type="radio"
                    name="color"
                    value={color.color}
                    id={color.id}
                    onChange={(e) => setColor(e.target.value)}
                  ></input>
                  <label
                    htmlFor={color.id}
                    className={"color__button"}
                    style={{
                      backgroundColor:
                        color.color.toLowerCase() === "transparent"
                          ? "lightgrey"
                          : color.color.toLowerCase(),
                    }}
                  ></label>
                </div>
              ))
            )}
          </div>
        </div>
        <div className="body__form__wrapper">
          <label className="size-selector-text" htmlFor="sizes">
            Size:
          </label>
          <select
            name="size"
            id="sizes"
            className="size-selector"
            onChange={(e) => setSize(e.target.value)}
          >
            <option value="undefined">No sizes selected</option>
            {!sizes ? (
              <option value="undefined">No sizes found</option>
            ) : (
              sizes
                .sort(function (a, b) {
                  return a - b;
                })
                .map((size, index) => (
                  <option key={index} value={size.size}>
                    {size.size}
                  </option>
                ))
            )}
          </select>
        </div>
      </form>
      {!user ? (
        <Link to="/login" className="cta cta--small" id="cta--add--to--cart">
          Log in to add to cart
        </Link>
      ) : (
        <div className="body__btn--wrapper">
          <p
            className="form__feedback form__feedback--align-center"
            data-feedback
          >
            Feedback
          </p>
          <button
            className="cta cta--small"
            id="cta--add--to--cart"
            onClick={handleSubmit}
            data-submit
          >
            Add to cart
          </button>
        </div>
      )}
    </div>
  );
}

export default ShowCaseBody;
