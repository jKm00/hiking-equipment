export default function PictureForm() {
  /**
   * Handles adding pictures to product
   */
  function handleSubmit() {
    console.log("Tried to add picture");
  }

  return (
    <form action="" className="form form--box">
      <fieldset className="form__section form__section--no-space">
        <legend className="form__title form__title--small">
          Add picture to product
        </legend>
        <div className="form__input--wrapper">
          <label htmlFor="product" className="form__label">
            Product to add image to
          </label>
          <select name="product" id="product" className="form__input">
            <option value="1">Winter Sweater</option>
            <option value="2">Hiking Boots</option>
          </select>
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="product-image" className="form__label">
            Product image:
          </label>
          <input
            type="file"
            id="product-image"
            name="product-image"
            accept="image/png, image/jpeg"
            multiple
            className="form__input"
          />
        </div>
        <button onClick={handleSubmit} className="cta">
          Add picture
        </button>
      </fieldset>
    </form>
  );
}
