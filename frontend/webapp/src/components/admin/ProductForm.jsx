import { useState, useEffect } from "react";
import { sendApiRequest } from "../../tools/request";
import { displayFeedback } from "../../tools/feedback";
import { isImages } from "../../tools/validators";

import FormInput from "./FormInput";
import AdminTableRow from "./AdminTableRow";

import "../../styles/productForm.css";
import "../../styles/table.css";

export default function ProductForm({ products, updateProducts }) {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [sex, setSex] = useState("");
  const [discount, setDiscount] = useState("");
  const [colors, setColors] = useState("");
  const [sizes, setSizes] = useState("");
  const [images, setImages] = useState([]);
  const [featured, setFeatured] = useState(false);
  const [details, setDetails] = useState("");

  function handleSubmit(event) {
    event.preventDefault();
    console.log(
      title,
      description,
      price,
      category,
      sex,
      discount,
      colors,
      sizes,
      images.length,
      details
    );
    if (
      title === "" ||
      description === "" ||
      price === "" ||
      category === "" ||
      sex === "" ||
      discount === "" ||
      colors === "" ||
      sizes === "" ||
      images.length === 0 ||
      details === ""
    ) {
      displayFeedback(
        "error",
        "Make sure there are no empty fields",
        document.querySelector("[data-submit-product]"),
        document.querySelector("[data-feedback-product]")
      );
    } else if (!isImages(images)) {
      displayFeedback(
        "error",
        "Only jpg/jpeg and png accepted",
        document.querySelector("[data-submit-product]"),
        document.querySelector("[data-feedback-product]")
      );
    } else {
      const newProduct = {
        productName: title,
        description: description,
        price: parseFloat(price),
        category: category,
        sex: sex,
        featured: featured,
        discount: parseFloat(discount),
        colors: colors.split(", "),
        sizes: sizes.split(", "),
        details: details.split("\n"),
      };
      sendApiRequest(
        "POST",
        "/products/add",
        (response) => {
          displayFeedback(
            "success",
            "Product was added",
            document.querySelector("[data-submit-product]"),
            document.querySelector("[data-feedback-product]")
          );
          updateProducts();
          resetInputs();
        },
        newProduct,
        (error) => {
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
   * Resets all inputs in the form
   */
  function resetInputs() {
    setTitle("");
    setDescription("");
    setPrice("");
    setCategory("");
    setSex("");
    setDiscount("");
    setColors("");
    setSizes("");
    setImages([]);
    setFeatured(false);
    setDetails("");
  }

  /**
   * Sends a delete request trying to delete product with the id of
   * the product to delete to the API.
   * If unsuccessfull an error message is printed to console
   * @param {*} id the id of the product to delete
   */
  function deleteProduct(id) {
    const relativeUrl = "/products/" + id;
    sendApiRequest("DELETE", relativeUrl, updateProducts, null, () => {
      console.error("Could not delete product with id: " + id);
    });
  }

  return (
    <section className="product-form box">
      <form onSubmit={handleSubmit}>
        <h3 className="form__title form__title--small">Add product</h3>
        <fieldset className="form__section form__section--no-space form__section--horizontal">
          <FormInput
            value={title}
            updateValue={setTitle}
            label="Product title"
          />
          <FormInput
            value={description}
            updateValue={setDescription}
            label="Description"
          />
          <FormInput
            value={price}
            updateValue={setPrice}
            label="Price"
            type="number"
          />
          <FormInput
            value={category}
            updateValue={setCategory}
            label="Category"
          />
          <FormInput value={sex} updateValue={setSex} label="Sex" />
          <FormInput
            value={discount}
            updateValue={setDiscount}
            label="Discount"
            type="number"
          />
          <FormInput
            value={colors}
            updateValue={setColors}
            label="Colors (Separated by ', ')"
          />
          <FormInput
            value={sizes}
            updateValue={setSizes}
            label="Sizes (Separated by ', ')"
          />
          <div className="form__input--wrapper">
            <label htmlFor="images" className="form__label">
              Images
            </label>
            <input
              id="images"
              className="form__input"
              type="file"
              accept="image/png, image/jpeg"
              multiple
              onChange={(e) => setImages(e.target.files)}
            />
          </div>
          <FormInput
            value={featured}
            updateValue={setFeatured}
            label="Featured"
            type="checkbox"
          />
          <div className="form__input--wrapper form__input--wrapper--full-width">
            <label htmlFor="details" className="form__label">
              Product details (Separated with new line)
            </label>
            <textarea
              className="form__input form__input--textarea"
              id="details"
              cols="30"
              rows="5"
              value={details}
              onChange={(e) => setDetails(e.target.value)}
            ></textarea>
          </div>
        </fieldset>
        <button className="cta cta--small" type="submit" data-submit-product>
          Add product
        </button>
        <p
          className="form__feedback form__feedback--inline"
          data-feedback-product
        >
          Product added
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
            <th className="table__heading">Featured</th>
          </tr>
        </thead>
        <tbody>
          {products.length === 0 ? (
            <tr>
              <td>Loading...</td>
            </tr>
          ) : (
            products.map((product) => (
              <AdminTableRow
                key={product.id}
                product={product}
                deleteProduct={deleteProduct}
              />
            ))
          )}
        </tbody>
      </table>
    </section>
  );
}
