import React from "react";

import Header from "../components/Header";
import Campaigns from "../components/Campaigns";
import ReviewSection from "../components/ReviewSection";
import CompanyInfo from "../components/CompanyInfo";
import Newsletter from "../components/Newsletter";

function Homepage() {
  return (
    <>
      <Header />
      <Campaigns />
      <ReviewSection />
      <CompanyInfo />
      <Newsletter />
    </>
  );
}

export default Homepage;
