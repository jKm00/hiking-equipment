import { Link } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import "../styles/cartItem.css";

/**
 * Creates a cart item component that represents a item in a cart
 * @param product, the product that the component represents
 * @param handleRemove, method that handles the event when removing a product form the cart
 * @returns returns a component with information about a product
 */
export default function CartItem({ product, handleRemove }) {
  function onSubmit() {
    handleRemove(product.id);
  }

  return (
    <div className="cart__item">
      <Link to={"/product/" + product.productId} className="cart__item__link">
        <div className="cart__item__details">
          <h3 className="cart__item__title">{product.productName}</h3>
          <p className="cart__item__detail">Color: {product.color}</p>
          <p className="cart__item__detail">Size: {product.size}</p>
          <p className="cart__item__detail">Quantity: {product.quantity}</p>
        </div>
      </Link>
      <div className="cart__item__addons">
        <div className="cart__item__price--wrapper">
          <p className="cart__item__price">
            {parseFloat(
              (product.productPrice -
                (product.productPrice * product.discount) / 100) *
                product.quantity
            ).toFixed(2)}
            ,-
          </p>
          <p className="cart__item__price--small">
            {parseFloat(
              product.productPrice -
                (product.productPrice * product.discount) / 100
            ).toFixed(2)}
            ,-
          </p>
        </div>
        <button className="cart__item__remove" onClick={onSubmit}>
          Remove
        </button>
      </div>
    </div>
  );
}
