import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

import "../styles/categories.css";

function ShopCategories({ selected, sex }) {
  return (
    <aside className="categories">
      <h2 className="categories__title">Categories</h2>
      <Link
        to={"/shop/" + sex}
        className={
          selected == undefined
            ? "categories__item categories__item--selected"
            : "categories__item"
        }
      >
        All items
      </Link>
      <Link
        to={"/shop/" + sex + "/boots"}
        className={
          selected === "boots"
            ? "categories__item categories__item--selected"
            : "categories__item"
        }
      >
        Boots
      </Link>
      <Link
        to={"/shop/" + sex + "/sweater"}
        className={
          selected === "sweater"
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
          selected === "hats"
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
