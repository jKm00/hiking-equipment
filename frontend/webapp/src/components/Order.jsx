import { useEffect } from "react";
import { Link } from "react-router-dom";

import "../styles/order.css";
import { sendApiRequest } from "../tools/request";

/**
 * Returns an order component that is to be used in the orderPage
 * @param order, the order that the component will be connected to
 * @param updateOrders, the method that updates orders 
 * @returns returns an order component that is to be used in the orderPage
 */
export default function Order({ order, updateOrders }) {

  /**
   * Sends a request to the backend to delete a users order
   */
  function deleteOrder() {
    const relativeUrl = "/orders/delete/" + order.id;
    sendApiRequest("DELETE", relativeUrl, updateOrders, null, () => {
      console.error("Could not cancel order with id: " + order.id);
    });
  }

  return (
    <div className="order">
      <div className="order__detail">
        <h3 className="order__detail__title">Products</h3>
        <ul className="order__detail__list">
          {
            order.orderItems.map(product => (
              <li key={product.id} className="order__detail__item">
              {product.productName}
              </li>
            ))
          }
        </ul>
      </div>
      <div className="order__detail">
        <h3 className="order__detail__title">Order date</h3>
        <p className="order__detail__body">{order.orderDate}</p>
      </div>
      <div className="order__detail">
        <h3 className="order__detail__title">Total sum</h3>
        <p className="order__detail__body">
          {order.totalPrice},-
        </p>
      </div>
      <div className="order__detail">
        <h3 className="order__detail__title">Order status</h3>
        <p className="order__detail__body">
          {order.status}
        </p>
      </div>
      <button onClick={deleteOrder} className="order__link">
        Cancel order
      </button>
    </div>
  );
}
