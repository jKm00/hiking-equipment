import React from "react";

function ShopCategories() {
  return (
    <nav className="shop-categories">
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
    </nav>
  );
}

export default ShopCategories;
