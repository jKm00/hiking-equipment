import { useState, useEffect } from "react";
import { sendApiRequest } from "../../tools/request";
import { displayFeedback } from "../../tools/feedback";
import { isImages } from "../../tools/validators";

import FormInput from "../FormInput";

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
  const [images, setImages] = useState("");
  const [featured, setFeatured] = useState(false);
  const [details, setDetails] = useState("");

  function handleSubmit(event) {
    event.preventDefault();
    console.log(title, colors, featured);
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
          <FormInput
            value={images}
            updateValue={setImages}
            label="Images"
            type="file"
          />
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
            ></textarea>
          </div>
        </fieldset>
        <button className="cta cta--small" type="submit">
          Add product
        </button>
      </form>
    </section>
  );
}
