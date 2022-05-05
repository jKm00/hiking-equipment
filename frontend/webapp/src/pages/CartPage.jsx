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
        <table className="cart">
          <thead>
            <tr>
              <th className="cart__title">Product</th>
              <th className="cart__title">Quantity</th>
              <th className="cart__title">Price</th>
            </tr>
          </thead>
          <tbody className="cart__body">
            <tr className="cart__item">
              <td>
                <div className="cart__item__content">
                  <img
                    src="https://picsum.photos/200/300"
                    alt=""
                    className="cart__item__content__img"
                  />
                  <h3 className="cart__item__content__title">Winter sweater</h3>
                  <p className="cart__item__content__details">Size: L</p>
                  <p className="cart__item__content__details">Color: Green</p>
                </div>
              </td>
              <td>
                <input type="number" className="cart__item__input" />
              </td>
              <td>
                <div>
                  <p className="cart__item__price cart__item__price--total">
                    1156.00,-
                  </p>
                  <p className="cart__item__price">315.20,- each</p>
                </div>
              </td>
              <td>
                <button className="cart__item__remove">Remove</button>
              </td>
            </tr>
          </tbody>
        </table>
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
