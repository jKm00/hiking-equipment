import { Link } from "react-router-dom";

import "../styles/cartItem.css";

export default function CartItem({ product, handleRemove }) {
  function onSubmit() {
    handleRemove(product.id);
  }

  return (
    <Link to={"/product/" + product.id} className="cart__item__link">
      <div className="cart__item" key={product.id}>
        <img
          className="cart__item__img"
          src={"https://picsum.photos/200/300?random=" + product.id}
          alt=""
        />
        <div className="cart__item__details">
          <h3 className="cart__item__title">{product.title}</h3>
          <p className="cart__item__detail">Color: {product.color}</p>
          <p className="cart__item__detail">Size: {product.size}</p>
          <p className="cart__item__detail">Quantity: {product.quantity}</p>
        </div>
        <div className="cart__item__addons">
          <div className="cart__item__price--wrapper">
            <p className="cart__item__price">
              {parseFloat(
                (product.price - product.discount) * product.quantity
              ).toFixed(2)}
              ,-
            </p>
            <p className="cart__item__price--small">
              {parseFloat(product.price - product.discount).toFixed(2)},-
            </p>
          </div>
          <button className="cart__item__remove" onClick={onSubmit}>
            Remove
          </button>
        </div>
      </div>
    </Link>
  );
}
