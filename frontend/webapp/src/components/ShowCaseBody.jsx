import React, { useState } from "react";
import { Link } from "react-router-dom";
import { displayFeedback } from "../tools/feedback";

// Import header styles
import "../styles/showCaseBody.css";

function ShowCaseBody({ user, title, price, colors, sizes, addToCart }) {
  const [color, setColor] = useState("");
  const [size, setSize] = useState("");

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
        <p className="body__price">{price},-</p>
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
                    style={{ backgroundColor: color.color.toLowerCase() }}
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
          <p className="form__feedback" data-feedback>
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
