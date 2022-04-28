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
        <Route path="/shop" element={<ShopPage />} />
        <Route path="/shop/men" element={<ShopPageMen />} />
        <Route path="/shop/women" element={<ShopPageWomen />} />
        <Route path="/shop/animals" element={<ShopPageAnimal />} />
        <Route path="/product/:id" element={<ProductPage />} />
        <Route path="/search/:keyword" element={<SearchResultPage />} />
        <Route path="/login" element={<LoginPage setUser={setUser} />} />
      </Routes>
    </>
  );
}

export default App;
