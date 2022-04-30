import React, { useEffect } from "react";
import { Link } from "react-router-dom";

import "../styles/categories.css";

function ShopCategories({ sex, category, updateProducts }) {
  useEffect(() => {
    updateProducts(sex, category);
  }, [category]);

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
