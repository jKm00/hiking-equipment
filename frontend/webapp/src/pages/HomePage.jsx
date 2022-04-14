import React from "react";

import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import Header from "../components/Header";
import Campaigns from "../components/Campaigns";
import ReviewSection from "../components/ReviewSection";
import CompanyInfo from "../components/CompanyInfo";
import Newsletter from "../components/Newsletter";

function HomePage() {
  return (
    <>
      <Navbar />
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
