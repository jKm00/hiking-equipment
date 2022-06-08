
/**
 * Returns a table row component that is to be used in the admin page
 * @param product, the product that the table rows are for
 * @returns a table row component that is to be used in the admin page
 */
export default function AdminTableRow({ product, deleteProduct }) {
  /**
   * Handling when delete button is pressed
   */
  function handleDeletion() {
    deleteProduct(product.id);
  }

  return (
    <tr>
      <td>{product.id}</td>
      <td>{product.productName}</td>
      <td>{product.description}</td>
      <td>{product.price}</td>
      <td>{product.category}</td>
      <td>{product.sex}</td>
      <td>{product.featured ? "Yes" : "No"}</td>
      <td className="table__row--delete">
        <button onClick={handleDeletion}>x</button>
      </td>
    </tr>
  );
}
