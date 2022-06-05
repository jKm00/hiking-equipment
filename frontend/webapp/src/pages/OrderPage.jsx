import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import Order from "../components/Order";
import Footer from "../components/Footer";

import "../styles/orderPage.css";

export default function OrderPage({ user }) {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    updateOrders();
  }, []);

  /**
   * Sends a new request to API and updates the orders
   * based on the response from the API
   */
  function updateOrders() {
    if (user !== null) {
      sendApiRequest(
        "GET",
        "/orders/",
        function (respone) {
          setOrders(respone);
        },
        null,
        function (error) {
          console.error("Could not load orders: " + error);
        }
      );
    }
  }

  return (
    <>
      <div className="order-page">
        {user === null ? (
          <p>
            You need to be logged in to see your orders.{" "}
            <Link to="/login">Log in here</Link>
          </p>
        ) : (
          <>
            <h2>Your orders</h2>¨
            <div className="orders">
              {orders.length === 0 ? (
                <p>
                  You do not have any orders.{" "}
                  <Link to="/shop/all">Go to shop</Link> to discover our
                  products
                </p>
              ) : (
                orders.map((order) => <Order key={order.id} order={order} />)
              )}
            </div>
          </>
        )}
      </div>
      <Footer />
    </>
  );
}
