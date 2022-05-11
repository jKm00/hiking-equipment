import { useState, useEffect } from "react";
import { sendApiRequest } from "../../tools/request";
import { displayFeedback } from "../../tools/feedback";
import { isImages } from "../../tools/validators";

import "../../styles/productForm.css";
import "../../styles/table.css";

export default function ProductForm({ products, updateProducts }) {
  const [name, setName] = useState("");
  const [desc, setDesc] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [sex, setSex] = useState("");
  const [colors, setColors] = useState("");
  const [sizes, setSize] = useState("");
  const [quantity, setQuantity] = useState("");
  const [images, setImages] = useState([]);

  const [discounts, setDiscounts] = useState([]);

  // Retrieve all the discount stored in the backend
  useEffect(() => {
    sendApiRequest(
      "GET",
      "/discounts",
      function (respone) {
        setDiscounts(respone);
      },
      null,
      function (error) {
        console.error("Could not retrieve discounts: " + error);
      }
    );
  }, []);

  /**
   * Tries to add product to API. If unsuccessfull an error message is
   * display to the UI, if successfull a success message is display
   * to the UI
   */
  function handleSubmit(event) {
    event.preventDefault();
    // Check valid fields
    if (
      name === "" ||
      desc === "" ||
      price === "" ||
      category === "" ||
      sex === "" ||
      sizes === "" ||
      images.length === 0
    ) {
      displayFeedback(
        "error",
        "Make sure there are no empty fields",
        document.querySelector("[data-submit-product]"),
        document.querySelector("[data-feedback-product]")
      );
      // Make sure only images are uploaded
    } else if (!isImages(images)) {
      displayFeedback(
        "error",
        "Only jpg/jpeg and png accepted",
        document.querySelector("[data-submit-product]"),
        document.querySelector("[data-feedback-product]")
      );
    } else {
      // TODO: transform images into binary
      const newProduct = {
        productName: name,
        description: desc,
        price: parseFloat(price),
        category: category,
        sex: sex,
        colors: colors,
        sizes: sizes,
      };
      sendApiRequest(
        "POST",
        "/products",
        function (response) {
          displayFeedback(
            "success",
            "Product was added",
            document.querySelector("[data-submit-product]"),
            document.querySelector("[data-feedback-product]")
          );
          updateProducts();
        },
        newProduct,
        function (error) {
          displayFeedback(
            "error",
            "Something went wrong. Product was not added",
            document.querySelector("[data-submit-product]"),
            document.querySelector("[data-feedback-product]")
          );
        }
      );
    }
  }

  /**
   * Sends a delete request trying to delete product with the id of
   * the product to delete to the API.
   * If unsuccessfull an error message is printed to console
   */
  function handleDeletion(event) {
    const productId = event.target.value;
    const relativeUrl = "/products/" + productId;
    sendApiRequest("DELETE", relativeUrl, updateProducts, null, function () {
      console.error("Could not delete product with id: " + productId);
    });
  }

  return (
    <section className="product-form box">
      <form action="" className="form form--stretch">
        <fieldset className="form__section form__section--no-space form__section--horizontal">
          <legend className="form__title form__title--small">
            Add product
          </legend>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Name
            </label>
            <input
              id="product-name"
              type="text"
              className="form__input"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-desc" className="form__label">
              Desc
            </label>
            <input
              id="product-desc"
              type="text"
              className="form__input"
              value={desc}
              onChange={(e) => setDesc(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-price" className="form__label">
              Price
            </label>
            <input
              id="product-price"
              type="number"
              className="form__input"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-category" className="form__label">
              Category
            </label>
            <input
              id="product-category"
              type="text"
              className="form__input"
              value={category}
              onChange={(e) => setCategory(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-sex" className="form__label">
              Sex
            </label>
            <input
              id="product-sex"
              type="text"
              className="form__input"
              value={sex}
              onChange={(e) => setSex(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-color" className="form__label">
              Colors (separated by ", ")
            </label>
            <input
              id="product-color"
              type="text"
              className="form__input"
              value={colors}
              onChange={(e) => setColors(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-sizes" className="form__label">
              Sizes (separated by ", ")
            </label>
            <input
              id="product-sizes"
              type="text"
              className="form__input"
              value={sizes}
              onChange={(e) => setSize(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-sizes" className="form__label">
              Quantity
            </label>
            <input
              id="product-sizes"
              type="number"
              className="form__input"
              value={quantity}
              onChange={(e) => setQuantity(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-sizes" className="form__label">
              Discount
            </label>
            <select
              id="product-sizes"
              type="number"
              className="form__input"
              value={quantity}
              onChange={(e) => setQuantity(e.target.value)}
            >
              <option value="null">None</option>
              {discounts.forEach((discount) => (
                <option value={discount}>{discount}</option>
              ))}
            </select>
          </div>
          <div className="form__input--wrapper">
            <label
              htmlFor="product-images"
              className="form__label custom-file-upload"
            >
              Upload images
            </label>
            <input
              id="product-images"
              type="file"
              className="form__input"
              accept="image/png, image/jpeg"
              multiple
              onChange={(e) => setImages(e.target.files)}
            />
          </div>
        </fieldset>
        <button
          className="cta cta--tiny"
          onClick={handleSubmit}
          data-submit-product
        >
          Add product
        </button>
        <p
          className="form__feedback form__feedback--inline"
          data-feedback-product
        >
          Failed to add product
        </p>
      </form>
      <table className="table">
        <caption className="table__title">Products</caption>
        <thead>
          <tr>
            <th className="table__heading">Id</th>
            <th className="table__heading">Name</th>
            <th className="table__heading">Description</th>
            <th className="table__heading">Price</th>
            <th className="table__heading">Category</th>
            <th className="table__heading">Sex</th>
          </tr>
        </thead>
        <tbody>
          {products.length === 0 ? (
            <tr>
              <td>Loading...</td>
            </tr>
          ) : (
            products.map((product) => (
              <tr key={product.id}>
                <td>{product.id}</td>
                <td>{product.productName}</td>
                <td>{product.description}</td>
                <td>{product.price}</td>
                <td>{product.category}</td>
                <td>{product.sex}</td>
                <td className="table__row--delete">
                  <button onClick={handleDeletion} value={product.id}>
                    X
                  </button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </section>
  );
}
