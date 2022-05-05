import { useState, useEffect } from "react";
import { sendApiRequest } from "../tools/request";
import { Link } from "react-router-dom";

import Footer from "../components/Footer";

import "../styles/cart.css";

export default function CartPage({ user }) {
  const [cart, setCart] = useState([]);

  useEffect(() => {
    loadCart();
  });

  useEffect(() => {
    calculatePrice();
  }, [cart]);

  /**
   * Sends a request to API to get cart for current logged in user.
   * If request is successfull, cart is populated with producs. Otherwise
   * an error message is printed to console.
   */
  function loadCart() {
    if (user !== null && cart.length === 0) {
      sendApiRequest(
        "GET",
        "/carts/" + user.email,
        function (response) {
          setCart(response);
        },
        null,
        function (error) {
          console.error("Could not load cart: " + error);
        }
      );
    }
  }

  /**
   * Sums the prices for each item in the cart and stores
   * it to the price useState variable
   */
  function calculatePrice() {}

  return (
    <>
      <section className="cart-page">
        {user === null ? (
          <p>
            You need to be logged in to view cart.{" "}
            <Link to="/login">Log in here</Link>
          </p>
        ) : (
          <>
            <h2 className="cart-page__title">Your cart</h2>
            <div className="cart">
              <div className="cart__item">
                <img
                  className="cart__item__img"
                  src="https://picsum.photos/200/300"
                  alt=""
                />
                <div className="cart__item__details">
                  <h3 className="cart__item__title">Winter Sweater</h3>
                  <p className="cart__item__detail">Color: green</p>
                  <p className="cart__item__detail">Size: L</p>
                  <p className="cart__item__detail">Quantity: 1</p>
                </div>
                <div className="cart__item__addons">
                  <p className="cart__item__price">463.00,-</p>
                  <button className="cart__item__remove">Remove</button>
                </div>
              </div>
            </div>
            <div>
              <div className="total">
                <p className="total__item">
                  Total price: <span>1156.00,-</span>
                </p>
                <p className="total__item">
                  Discount: <span>0,-</span>
                </p>
                <p className="total__item">
                  Total: <span>1156.00,-</span>
                </p>
              </div>
              <button className="cart__submit cta">Make purchase</button>
            </div>
          </>
        )}
      </section>
      <Footer />
    </>
  );
}
