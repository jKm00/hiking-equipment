import React from "react";

import Footer from "../components/Footer";
import Header from "../components/Header";
import Campaigns from "../components/Campaigns";
import ReviewSection from "../components/ReviewSection";
import CompanyInfo from "../components/CompanyInfo";
import Newsletter from "../components/Newsletter";

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
