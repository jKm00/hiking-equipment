import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import Order from "../components/Order";
import Footer from "../components/Footer";

import "../styles/orderPage.css";

export default function OrderPage({ user }) {
  const [orders, setOrders] = useState([
    {
      id: 1,
      products: [
        {
          id: 3,
          title: "Winter Sweater",
          desc: "Holds you warm",
          price: 399.0,
          size: "L",
          color: "green",
          sex: "unisex",
        },
        {
          id: 5,
          title: "Hiking Boots",
          desc: "Comfy for your feet",
          price: 700.49,
          size: "44",
          color: "black",
          sex: "male",
        },
      ],
      date: "07.05.2022",
      paymentStatus: false,
    },
    {
      id: 2,
      products: [
        {
          id: 1,
          title: "Winter Hat",
          desc: "Keeps your ears warm",
          price: 299.0,
          size: "L",
          color: "green",
          sex: "unisex",
        },
      ],
      date: "29.04.2022",
      paymentStatus: true,
    },
    {
      id: 3,
      products: [
        {
          id: 1,
          title: "Winter Hat",
          desc: "Keeps your ears warm",
          price: 299.0,
          size: "L",
          color: "green",
          sex: "unisex",
        },
        {
          id: 3,
          title: "Winter Sweater",
          desc: "Holds you warm",
          price: 399.0,
          size: "L",
          color: "green",
          sex: "unisex",
        },
        {
          id: 5,
          title: "Hiking Boots",
          desc: "Comfy for your feet",
          price: 700.49,
          size: "44",
          color: "black",
          sex: "male",
        },
      ],
      date: "01.02.2022",
      paymentStatus: true,
    },
  ]);

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
        "/orders/" + user.id,
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
