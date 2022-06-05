import { useState, useEffect } from "react";
import { sendApiRequest } from "../tools/request";
import { Link } from "react-router-dom";

import CartItem from "../components/CartItem";
import Footer from "../components/Footer";

import "../styles/cart.css";

export default function CartPage({ user }) {
  const [cart, setCart] = useState([]);
  const [total, setTotal] = useState(0);
  const [discount, setDiscount] = useState(0);
  const [finalSum, setFinalSum] = useState(0);

  useEffect(() => {
    sendApiRequest(
      "GET",
      "/carts",
      (response) => {
        setCart(response.cartItems);
      },
      null,
      (error) => {
        console.error(error);
      }
    );
  }, []);

  useEffect(() => {
    calculateBill();
  }, [cart]);

  /**
   * Sends a request to API to get cart for current logged in user.
   * If request is successfull, cart is populated with producs. Otherwise
   * an error message is printed to console.
   */
  function updateCart() {
    if (user !== null) {
      sendApiRequest(
        "GET",
        "/carts",
        function (response) {
          setCart(response.cartItems);
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
  function calculateBill() {
    let total = 0;
    let discount = 0;
    cart.forEach((product) => {
      total += product.productPrice * product.quantity;
      discount += product.discount * product.quantity;
    });
    setTotal(total);
    setDiscount(discount);
    setFinalSum(total - discount);
  }

  /**
   * Removes an item from the shopping cart
   * @param {*} id the id of the item to remove
   */
  function removeItem(id) {
    const deleteBody = {
      cartItemId: id,
    };
    sendApiRequest(
      "DELETE",
      "/carts",
      () => {
        updateCart();
      },
      deleteBody,
      (error) => {
        console.error(error);
      }
    );
  }

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
              {cart.length === 0 ? (
                <p>
                  You have 0 items in your cart.{" "}
                  <Link to="/shop/all">Go to shop</Link> to discover our
                  products
                </p>
              ) : (
                cart.map((product) => (
                  <CartItem
                    key={product.id}
                    product={product}
                    handleRemove={removeItem}
                  />
                ))
              )}
            </div>
            <div>
              <div className="total">
                <p className="total__item">
                  Total price: <span>{parseFloat(total).toFixed(2)},-</span>
                </p>
                <p className="total__item">
                  Discount: <span>{parseFloat(discount).toFixed(2)},-</span>
                </p>
                <p className="total__item">
                  Total: <span>{parseFloat(finalSum).toFixed(2)},-</span>
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
