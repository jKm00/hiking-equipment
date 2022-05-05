import React, { useEffect, useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { getCookie } from "./tools/cookies";
import { parseJwtUser } from "./tools/authentication";

import Navbar from "./components/Navbar";
import HomePage from "./pages/HomePage";
import ShopPage from "./pages/ShopPage";
import ProductPage from "./pages/ProductPage";
import SearchResultPage from "./pages/SearchResultPage";
import LoginPage from "./pages/LoginPage";
import AdminPage from "./pages/AdminPage";
import CartPage from "./pages/CartPage";

import "./styles/global.css";
import "./styles/mediaQueries.css";
import SignUpPage from "./pages/SignUpPage";

function App() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const jwt = getCookie("jwt");
    if (jwt !== "") {
      const userData = parseJwtUser(jwt);
      setUser(userData);
    }
  }, []);

  return (
    <>
      <Navbar user={user} setUser={setUser} />
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/shop/:sex" element={<ShopPage />} />
        <Route path="/shop/:sex/:category" element={<ShopPage />} />
        <Route path="/product/:id" element={<ProductPage />} />
        <Route path="/search/:keyword" element={<SearchResultPage />} />
        <Route path="/login" element={<LoginPage setUser={setUser} />} />
        <Route path="/signup" element={<SignUpPage />} />
        <Route
          path="/cart"
          element={
            user === null ? (
              <Navigate to="/login" replace />
            ) : (
              <CartPage user={user} />
            )
          }
        />
        <Route
          path="/admin"
          element={
            !user || !user.roles.includes("ROLE_ADMIN") ? (
              <Navigate to="/" replace />
            ) : (
              <AdminPage user={user} />
            )
          }
        />
      </Routes>
    </>
  );
}

export default App;
