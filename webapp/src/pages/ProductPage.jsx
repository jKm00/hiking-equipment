import React from "react";
import { useParams } from "react-router-dom";

function ProductPage() {
  const { id } = useParams();

  return (
    <div style={{ gridColumn: "1 / -1" }}>
      <h1>Product page</h1>
      <p>
        Tried to display item with id {id}, but failed because this page is not
        fully implemented
      </p>
    </div>
  );
}

export default ProductPage;
