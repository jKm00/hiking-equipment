import { Link } from "react-router-dom";

import "../styles/order.css";

export default function Order({ order }) {
  return (
    <div className="order">
      <div className="order__detail">
        <h3 className="order__detail__title">Products</h3>
        <ul className="order__detail__list">
          {order.products.map((product) => (
            <li key={product.id} className="order__detail__item">
              {product.title}
            </li>
          ))}
        </ul>
      </div>
      <div className="order__detail">
        <h3 className="order__detail__title">Order date</h3>
        <p className="order__detail__body">{order.date}</p>
      </div>
      <div className="order__detail">
        <h3 className="order__detail__title">Total sum</h3>
        <p className="order__detail__body">
          {order.products
            .map((product) => product.price)
            .reduce(
              (previousValue, currentValue) => previousValue + currentValue,
              0
            )}
          ,-
        </p>
      </div>
      <div className="order__detail">
        <h3 className="order__detail__title">Payment status</h3>
        <p className="order__detail__body">
          {order.paymentStatus ? "Payed" : "Not payed"}
        </p>
      </div>
      <Link to={"/order/" + order.id} className="order__link">
        Go to order
      </Link>
    </div>
  );
}
