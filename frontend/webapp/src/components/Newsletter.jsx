import React from "react";

import "../styles/newsletter.css";

/**
 * Creates the newsletter component that is displayed on the main page of the website
 * @returns returns a component that contains the newsletter information of the main page
 */
function Newsletter() {
  return (
    <section className="newsletter">
      <div className="newsletter--wrapper">
        <h2 className="newsletter__title">Subscribe to our newsletter</h2>
        <p className="newsletter__desc">
          Want to get notified about new articles and campaigns?
        </p>
        <form action="" className="newsletter__form">
          <input
            type="text"
            placeholder="Enter email..."
            className="newsletter__input"
          />
          <button className="cta cta--newsletter">Subscribe</button>
        </form>
      </div>
    </section>
  );
}

export default Newsletter;
