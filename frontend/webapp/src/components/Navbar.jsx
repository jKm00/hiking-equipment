import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { deleteAuthorizationCookies } from "../tools/authentication";

import "../styles/nav.css";

function Navbar({ user, setUser }) {
  const navigate = useNavigate();
  const searchElements = [
    "data-search-form",
    "data-search-input",
    "data-search-btn",
    "data-search-svg",
    "data-search-path",
  ];

  document.addEventListener("click", (e) => {
    const targetedElement = e.target;
    if (
      !targetedElement.hasAttribute(searchElements[0]) &&
      !targetedElement.hasAttribute(searchElements[1]) &&
      !targetedElement.hasAttribute(searchElements[2]) &&
      !targetedElement.hasAttribute(searchElements[3]) &&
      !targetedElement.hasAttribute(searchElements[4])
    ) {
      const searchBar = document.querySelector("[data-search-form");
      searchBar.classList.add("search-bar--hidden");
    }
  });

  document.addEventListener("click", (e) => {
    const targetedElement = e.target;
    if (!targetedElement.hasAttribute("data-user-details-element")) {
      const userDetails = document.querySelector(
        "[data-user-details-container]"
      );
      userDetails.classList.add("user-details--hidden");
    }
  });

  function doToggleSearch() {
    const searchBar = document.querySelector("[data-search-form]");
    searchBar.classList.toggle("search-bar--hidden");
  }

  function doSearch() {
    const inputValue = document.querySelector("[data-search-input]").value;
    const path = "/search/" + inputValue;
    const searchBar = document.querySelector("[data-search-form]");
    searchBar.classList.add("search-bar--hidden");
    navigate(path);
  }

  function toggleUserDetails() {
    const userDetails = document.querySelector("[data-user-details-container]");
    userDetails.classList.toggle("user-details--hidden");
  }

  function redirectLogin() {
    navigate("/login");
    toggleUserDetails();
  }

  function redirectSignup() {
    navigate("/signup");
    toggleUserDetails();
  }

  function handleLogout() {
    deleteAuthorizationCookies();
    setUser(null);
    toggleUserDetails();
    navigate("/");
  }

  return (
    <nav className="nav">
      <div className="first-nav">
        <Link to="/" className="logo">
          XXS
        </Link>
        <ul className="first-nav__icons">
          <li className="first-nav__item">
            <button
              aria-label="search-bar toggle"
              className="btn"
              onClick={doToggleSearch}
              data-search-btn
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 512 512"
                data-search-svg
              >
                <path
                  data-search-path
                  d="M500.3 443.7l-119.7-119.7c27.22-40.41 40.65-90.9 33.46-144.7C401.8 87.79 326.8 13.32 235.2 1.723C99.01-15.51-15.51 99.01 1.724 235.2c11.6 91.64 86.08 166.7 177.6 178.9c53.8 7.189 104.3-6.236 144.7-33.46l119.7 119.7c15.62 15.62 40.95 15.62 56.57 0C515.9 484.7 515.9 459.3 500.3 443.7zM79.1 208c0-70.58 57.42-128 128-128s128 57.42 128 128c0 70.58-57.42 128-128 128S79.1 278.6 79.1 208z"
                />
              </svg>
            </button>
          </li>
          <li className="first-nav__item">
            <button aria-label="customer service" className="first-nav__btn">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path d="M191.1 224c0-17.72-14.34-32.04-32-32.04L144 192c-35.34 0-64 28.66-64 64.08v47.79C80 339.3 108.7 368 144 368H160c17.66 0 32-14.36 32-32.06L191.1 224zM256 0C112.9 0 4.583 119.1 .0208 256L0 296C0 309.3 10.75 320 23.1 320S48 309.3 48 296V256c0-114.7 93.34-207.8 208-207.8C370.7 48.2 464 141.3 464 256v144c0 22.09-17.91 40-40 40h-110.7C305 425.7 289.7 416 272 416H241.8c-23.21 0-44.5 15.69-48.87 38.49C187 485.2 210.4 512 239.1 512H272c17.72 0 33.03-9.711 41.34-24H424c48.6 0 88-39.4 88-88V256C507.4 119.1 399.1 0 256 0zM368 368c35.34 0 64-28.7 64-64.13V256.1C432 220.7 403.3 192 368 192l-16 0c-17.66 0-32 14.34-32 32.04L320 335.9C320 353.7 334.3 368 352 368H368z" />
              </svg>
            </button>
          </li>
          <li className="first-nav__item">
            <Link
              to={user === null ? "/login" : "/cart"}
              className="first-nav__btn"
              aria-label="shopping cart"
            >
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                <path d="M96 0C107.5 0 117.4 8.19 119.6 19.51L121.1 32H541.8C562.1 32 578.3 52.25 572.6 72.66L518.6 264.7C514.7 278.5 502.1 288 487.8 288H170.7L179.9 336H488C501.3 336 512 346.7 512 360C512 373.3 501.3 384 488 384H159.1C148.5 384 138.6 375.8 136.4 364.5L76.14 48H24C10.75 48 0 37.25 0 24C0 10.75 10.75 0 24 0H96zM128 464C128 437.5 149.5 416 176 416C202.5 416 224 437.5 224 464C224 490.5 202.5 512 176 512C149.5 512 128 490.5 128 464zM512 464C512 490.5 490.5 512 464 512C437.5 512 416 490.5 416 464C416 437.5 437.5 416 464 416C490.5 416 512 437.5 512 464z" />
              </svg>
            </Link>
          </li>
          <li className="first-nav__item">
            <button
              aria-label="user-details"
              className="first-nav__btn"
              onClick={toggleUserDetails}
              data-user-details-element
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 448 512"
                data-user-details-element
              >
                <path
                  data-user-details-element
                  d="M224 256c70.7 0 128-57.31 128-128s-57.3-128-128-128C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3c0 19.14 15.52 34.67 34.66 34.67h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304z"
                />
              </svg>
            </button>
            <div
              className="user-details user-details--hidden"
              data-user-details-container
              data-user-details-element
            >
              {user == null ? (
                <ul className="user-details__list">
                  <li
                    className="cta cta--small"
                    onClick={redirectLogin}
                    data-user-details-element
                  >
                    Log in
                  </li>
                  <li
                    className="user-details__item--underline user-details__item--small"
                    onClick={redirectSignup}
                    data-user-details-element
                  >
                    Sign up
                  </li>
                </ul>
              ) : (
                <ul
                  className="user-details__list user-details__list--left"
                  data-user-details-element
                >
                  <li className="user-details__item" data-user-details-element>
                    {user.email}
                  </li>
                  <li data-user-details-element>
                    <Link to="/orders" className="user-details__link">
                      Orders
                    </Link>
                  </li>
                  {user.roles.includes("ROLE_ADMIN") ? (
                    <li>
                      <Link to="/admin" className="user-details__link">
                        Admin page
                      </Link>
                    </li>
                  ) : (
                    <></>
                  )}
                  <li
                    className="user-details__item user-details__item--small user-details__item--underline"
                    onClick={handleLogout}
                    data-user-details-element
                  >
                    Log out
                  </li>
                </ul>
              )}
            </div>
          </li>
        </ul>
      </div>
      <div className="search-bar search-bar--hidden" data-search-form>
        <form className="search-bar--wrapper">
          <input
            type="text"
            name="keyword"
            placeholder="Search..."
            className="search-bar__input"
            data-search-input
          />
          <button
            aria-label="search"
            className="search-bar__btn"
            onClick={doSearch}
            data-search-btn
          >
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
              <path d="M500.3 443.7l-119.7-119.7c27.22-40.41 40.65-90.9 33.46-144.7C401.8 87.79 326.8 13.32 235.2 1.723C99.01-15.51-15.51 99.01 1.724 235.2c11.6 91.64 86.08 166.7 177.6 178.9c53.8 7.189 104.3-6.236 144.7-33.46l119.7 119.7c15.62 15.62 40.95 15.62 56.57 0C515.9 484.7 515.9 459.3 500.3 443.7zM79.1 208c0-70.58 57.42-128 128-128s128 57.42 128 128c0 70.58-57.42 128-128 128S79.1 278.6 79.1 208z" />
            </svg>
          </button>
        </form>
      </div>
      <div className="second-nav">
        <ul className="second-nav__links">
          <li className="second-nav__item">
            <Link to="/shop/men" className="second-nav__link">
              Men
            </Link>
          </li>
          <li className="second-nav__item">
            <Link to="/shop/women" className="second-nav__link">
              Women
            </Link>
          </li>
          <li className="second-nav__item">
            <Link to="/shop/animals" className="second-nav__link">
              Animal
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;
