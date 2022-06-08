import React, { useEffect } from "react";
import { Link } from "react-router-dom";

import "../styles/categories.css";

/**
 * Returns a list of all categories
 * @param {*} sex, the current sex selected
 * @param {*} category, the current category selected
 * @param {*} updateProducts, a function that updates the products on the product page
 * @returns
 */
function ShopCategories({ sex, category, updateProducts }) {
  // Updated the products whenever the sex or category is changes
  useEffect(() => {
    updateProducts(sex, category);
  }, [sex, category]);

  return (
    <aside className="categories">
      <h2 className="categories__title">Categories</h2>
      <Link
        to={"/shop/" + sex}
        className={
          category == undefined
            ? "categories__item categories__item--selected"
            : "categories__item"
        }
      >
        All items
      </Link>
      <Link
        to={"/shop/" + sex + "/boots"}
        className={
          category === "boots"
            ? "categories__item categories__item--selected"
            : "categories__item"
        }
      >
        Boots
      </Link>
      <Link
        to={"/shop/" + sex + "/sweater"}
        className={
          category === "sweater"
            ? "categories__item categories__item--selected"
            : "categories__item"
        }
        href="#"
      >
        Sweaters
      </Link>
      <Link
        to={"/shop/" + sex + "/hats"}
        className={
          category === "hats"
            ? "categories__item categories__item--selected"
            : "categories__item"
        }
      >
        Hats
      </Link>
    </aside>
  );
}

export default ShopCategories;
