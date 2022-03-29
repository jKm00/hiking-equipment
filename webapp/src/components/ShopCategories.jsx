import React from "react";

import "../styles/categories.css";

function ShopCategories() {
  return (
    <aside className="shop-categories">
      <h2 className="shop-categories__title">Categories</h2>
      <a className="categories__item" href="#">
        All items
      </a>
      <a className="categories__item" href="#">
        Boots
      </a>
      <a className="categories__item" href="#">
        Sweaters
      </a>
      <a className="categories__item" href="#">
        Hats
      </a>
    </aside>
  );
}

export default ShopCategories;
