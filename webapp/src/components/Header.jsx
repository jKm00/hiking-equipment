import React from "react";
import { Link } from "react-router-dom";

function Header() {
  return (
    <header className="header">
      <div className="header--wrapper">
        <h1 className="header__title shadow--text">All-Weather Jacket</h1>
        <p className="header__desc shadow--text">Perfect for tough weather</p>
        <Link to="shop" className="cta cta--big">
          Go to shop
        </Link>
      </div>
    </header>
  );
}

export default Header;
