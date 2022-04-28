import React from "react";


function DescriptionBox({ title, desc }) {
  return (
    <div class="description-box">
    <h4 class="product__description__title">{title}</h4>
    <p class="product__description">{desc}</p>
    </div>
  );
}

export default DescriptionBox;

