import { useState, useEffect } from "react";
import { sendApiRequest } from "../tools/request";

import Footer from "../components/Footer";

import "../styles/cart.css";

export default function CartPage({ user }) {
  const [cart, setCart] = useState();

  useEffect(() => {
    sendApiRequest(
      "GET",
      "/cart/" + user.email,
      function (response) {
        setCart(response);
      },
      null,
      function (error) {
        console.log("Could not load cart: " + error);
      }
    );
  }, []);

  return (
    <>
      <section className="cart-page">
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
      </section>
      <Footer />
    </>
  );
}
