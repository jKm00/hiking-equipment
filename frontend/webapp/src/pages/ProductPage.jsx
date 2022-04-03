import React from "react";
import { useParams } from "react-router-dom";

function ProductPage() {
  const { id } = useParams();

  const mystyle = {
    gridColumn: "2 / -2",
    margin: "12.8em 0",
  };

  return (
    <div style={mystyle}>
      <h1>Product page</h1>
      <p>
        Tried to display item with id {id}, but failed because this page is not
        fully implemented
      </p>
    </div>
  );
}

export default ProductPage;
