import React from "react";

import Footer from "../components/Footer";
import Header from "../components/Header";
import Campaigns from "../components/Campaigns";
import ReviewSection from "../components/ReviewSection";
import CompanyInfo from "../components/CompanyInfo";
import Newsletter from "../components/Newsletter";

/**
 * Returns a home page containing all the section in the home page
 * @returns the home page of the app
 */
function HomePage() {
  return (
    <>
      <Header />
      <Campaigns />
      <ReviewSection />
      <CompanyInfo />
      <Newsletter />
      <Footer />
    </>
  );
}

export default HomePage;
