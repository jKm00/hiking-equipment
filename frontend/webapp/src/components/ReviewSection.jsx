import React from "react";
import Review from "./Review";

import "../styles/reviewSection.css";

function ReviewSection() {
  return (
    <section className="reviews" id="reviews">
      <div className="reviews--wrapper">
        <h2 className="reviews__title">Reviews</h2>
        <Review
          img="img/profile-pictures/anton-berg-hansen-cropped.jpg"
          name="Anton Berg-Hansen"
          desc="Hiking is a good way to use weekends together with your family. XXS
          is our go-to place for the latest hiking gear."
        />
        <Review
          img="img/profile-pictures/chuck-venster-cropped.jpg"
          name="Chuck Venster"
          desc="We are a small IT company, full of geeks. I had difficulty getting
          the geeks out of their chairs. XXS suggested the latest water
          bottles as a Christmas gift for all employees. I was skeptical at
          first, but now I have difficulty getting them back indoors."
        />
        <Review
          img="img/profile-pictures/pitbuill-cropped.jpg"
          name="Pitbull"
          desc="Got a matching sweater for my dog and myself. We are out in the
          mountains every Sunday since."
        />
      </div>
    </section>
  );
}

export default ReviewSection;
