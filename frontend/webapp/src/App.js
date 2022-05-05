import React, { useEffect, useState } from "react";
import { Routes, Route } from "react-router-dom";
import { getCookie } from "./tools/cookies";

import Navbar from "./components/Navbar";
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
import SignUpPage from "./pages/SignUpPage";

function App() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const username = getCookie("current_username");
    const roles = getCookie("current_user_roles");
    if (username !== "" && roles !== "") {
      setUser({
        username: username,
        roles: roles,
      });
    }
  }, []);

  return (
    <>
      <Navbar user={user} setUser={setUser} />
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/shop/all" element={<ShopPage />} />
        <Route path="/shop/all/:category" element={<ShopPage />} />
        <Route path="/shop/men" element={<ShopPageMen />} />
        <Route path="/shop/men/:category" element={<ShopPageMen />} />
        <Route path="/shop/women" element={<ShopPageWomen />} />
        <Route path="/shop/women/:category" element={<ShopPageWomen />} />
        <Route path="/shop/animals" element={<ShopPageAnimal />} />
        <Route path="/shop/animals/:category" element={<ShopPageAnimal />} />
        <Route path="/product/:id" element={<ProductPage />} />
        <Route path="/search/:keyword" element={<SearchResultPage />} />
        <Route path="/login" element={<LoginPage setUser={setUser} />} />
        <Route path="signup" element={<SignUpPage />} />
      </Routes>
    </>
  );
}

export default App;
