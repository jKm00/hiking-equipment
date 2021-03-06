import React from "react";

// Import header styles
import "../styles/descriptionBox.css";

/**
 * Creates a description box which holds descriptions about an item
 * @param details, the details of a specific item 
 * @returns returns a component that contains the description of an item
 */
function DescriptionBox({ details }) {
  return (
    <div className="description-box">
      <h4 className="product__description__title">Details</h4>
      <ul className="product__description__list">
        {!details || details.length === 0 ? (
          <li className="product__description__item">
            No details for this items
          </li>
        ) : (
          details.map((detail) => (
            <li key={detail.id} className="product__description__item">
              {detail.detail}
            </li>
          ))
        )}
      </ul>
    </div>
  );
}

export default DescriptionBox;
