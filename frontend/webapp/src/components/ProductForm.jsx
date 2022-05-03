import { useState } from "react";

import "../styles/productForm.css";
import "../styles/table.css";

export default function ProductForm({ products }) {
  const [name, setName] = useState("");
  const [desc, setDesc] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [sex, setSex] = useState("");
  const [colors, setColors] = useState("");
  const [sizes, setSize] = useState("");
  const [images, setImages] = useState([]);

  /**
   * TODO: Handles adding products
   */
  function handleSubmit(event) {
    event.preventDefault();
    console.log(images);
  }

  /**
   * TODO: Handles deleting products
   */
  function handleDeletion(event) {
    const productId = event.target.value;
    console.log(productId);
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
            <label htmlFor="product-name" className="form__label">
              Desc
            </label>
            <input
              id="product-name"
              type="text"
              className="form__input"
              value={desc}
              onChange={(e) => setDesc(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Price
            </label>
            <input
              id="product-name"
              type="number"
              className="form__input"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Category
            </label>
            <input
              id="product-name"
              type="text"
              className="form__input"
              value={category}
              onChange={(e) => setCategory(e.target.value)}
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Sex
            </label>
            <input
              id="product-name"
              type="text"
              className="form__input"
              value={sex}
              onChange={(e) => setSex(e.target.value)}
            />
          </div>
        </fieldset>
        <fieldset className="form__section form__section--no-space form__section--horizontal">
          <div className="form__input--wrapper">
            <label htmlFor="product-color" className="form__label">
              Colors (separeted by ", ")
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
              Sizes (separeted by ", ")
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
            <label htmlFor="product-images" className="form__label">
              Images
            </label>
            <input
              id="product-images"
              type="file"
              className="form__input form__input--file"
              accept="image/png, image/jpeg"
              multiple
              onChange={(e) => setImages(e.target.files)}
            />
          </div>
        </fieldset>
        <button className="cta cta--tiny" onClick={handleSubmit}>
          Add product
        </button>
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
