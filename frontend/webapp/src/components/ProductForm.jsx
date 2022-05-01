import "../styles/productForm.css";
import "../styles/table.css";

export default function ProductForm({ products }) {
  /**
   * TODO: Handles adding products
   */
  function handleSubmit(event) {
    event.preventDefault();
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
            <input id="product-name" type="text" className="form__input" />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Desc
            </label>
            <input id="product-name" type="text" className="form__input" />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Price
            </label>
            <input id="product-name" type="number" className="form__input" />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Category
            </label>
            <input id="product-name" type="text" className="form__input" />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="product-name" className="form__label">
              Sex
            </label>
            <input id="product-name" type="text" className="form__input" />
          </div>
          <button className="cta cta--tiny" onClick={handleSubmit}>
            Add product
          </button>
        </fieldset>
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
