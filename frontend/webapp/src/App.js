import React from "react";
import { Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

import HomePage from "./pages/HomePage";
import ShopPage from "./pages/ShopPage";
import ShopPageMen from "./pages/ShopPageMen";
import ShopPageWomen from "./pages/ShopPageWomen";
import ShopPageAnimal from "./pages/ShopPageAnimal";
import ProductPage from "./pages/ProductPage";
import SearchResultPage from "./pages/SearchResultPage";

import "./styles/global.css";
import "./styles/mediaQueries.css";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/shop" element={<ShopPage />} />
        <Route path="/shop/men" element={<ShopPageMen />} />
        <Route path="/shop/women" element={<ShopPageWomen />} />
        <Route path="/shop/animals" element={<ShopPageAnimal />} />
        <Route path="/product/:id" element={<ProductPage />} />
        <Route path="/search/:keyword" element={<SearchResultPage />} />
      </Routes>
      <Footer />
    </>
  );
}

export default App;
