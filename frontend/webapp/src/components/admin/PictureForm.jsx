import { useState } from "react";
import { sendApiRequest } from "../../tools/request";
import { displayFeedback } from "../../tools/feedback";


export default function PictureForm({ products }) {
  const [images, setImages] = useState([]);
  const [productId, setProductId] = useState("");

  /**
   * Handles adding pictures to product
   */
  function handleSubmit(e) {
    e.preventDefault();
    if(productId === "" || productId === "undefined") {
      displayFeedback(
        "error",
        "Please select a product",
        document.querySelector("[data-submit]"),
        document.querySelector("[data-feedback]")
      )
    } else if (images.length === 0) {
      displayFeedback(
        "error",
        "Please select an image",
        document.querySelector("[data-submit]"),
        document.querySelector("[data-feedback]")
      )
    } else {
      sendApiRequest(
      "POST",
      "/images/add/" + productId,
      (response) => {
        displayFeedback(
          "success",
          "successfully uploaded",
          document.querySelector("[data-submit]"),
          document.querySelector("[data-feedback]")
        )
      },
      null,
      (error) => console.error(error),
      images
    );}
    
  }

  return (
    <form action="" className="form form--stretch box">
      <fieldset className="form__section form__section--no-space">
        <legend className="form__title form__title--small">
          Add picture to product
        </legend>
        <div className="form__input--wrapper">
          <label htmlFor="product" className="form__label">
            Product to add image to
          </label>
          <select onChange={(e) => setProductId(e.target.value)} name="product" id="product" className="form__input">
            <option value="undefined" >Select a product</option>
            {!products || products.length === 0 ? (
              <option value="undefined">No products</option>
            ) : (
              products.map((product) => (
                <option key={product.id} value={product.id}>{product.productName}</option>
              ))
            )}
          </select>
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="product-image" className="form__label">
            Product image:
          </label>
          <input onChange={(e) => setImages(e.target.files)}
            type="file"
            id="product-image"
            name="product-image"
            accept="image/png, image/jpeg"
            multiple
            className="form__input"
          />
        </div>
        <p className="form__feedback" data-feedback></p>
        <button onClick={handleSubmit} data-submit className="cta">
          Add picture
        </button>
      </fieldset>
    </form>
  );
}
