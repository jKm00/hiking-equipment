import React, { useEffect, useState } from "react";

// Import header styles
import "../styles/showCaseBody.css";

function ShowCaseBody({ title, price, colors, sizes }) {
  const [loading, setLoading] = useState(true);
  const [productColors, setProductColors] = useState([]);
  const [productSizes, setProductSizes] = useState([]);

  useEffect(() => {
    setProductColors(colors);
    setProductSizes(sizes);
    setLoading(false);
  }, [colors, sizes]);

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
            {loading || !productColors ? (
              <p>No colors</p>
            ) : (
              productColors.map((color) => (
                <div key={color.id}>
                  <input
                    className="body__form__checkbox"
                    type="radio"
                    name="color"
                    value={color}
                    id={color.id}
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
          <select name="size" id="sizes" className="size-selector">
            {loading || !productSizes ? (
              <option value="undefined">No sizes</option>
            ) : (
              productSizes.map((size, index) => (
                <option key={index} value={size.size}>
                  {size.size}
                </option>
              ))
            )}
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
