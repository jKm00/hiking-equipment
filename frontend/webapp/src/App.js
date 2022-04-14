import React from "react";
import { Routes, Route } from "react-router-dom";

import HomePage from "./pages/HomePage";
import ShopPage from "./pages/ShopPage";
import ShopPageMen from "./pages/ShopPageMen";
import ShopPageWomen from "./pages/ShopPageWomen";
import ShopPageAnimal from "./pages/ShopPageAnimal";
import ProductPage from "./pages/ProductPage";
import SearchResultPage from "./pages/SearchResultPage";
import LoginPage from "./pages/LoginPage";

import "./styles/global.css";
import "./styles/mediaQueries.css";

function App() {
  return (
    <>
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/shop" element={<ShopPage />} />
        <Route path="/shop/men" element={<ShopPageMen />} />
        <Route path="/shop/women" element={<ShopPageWomen />} />
        <Route path="/shop/animals" element={<ShopPageAnimal />} />
        <Route path="/product/:id" element={<ProductPage />} />
        <Route path="/search/:keyword" element={<SearchResultPage />} />
        <Route path="/login" element={<LoginPage />} />
      </Routes>
    </>
  );
}

export default App;
