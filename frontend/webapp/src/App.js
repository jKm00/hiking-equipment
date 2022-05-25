import React, { useEffect, useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { getCookie } from "./tools/cookies";
import {
  isExpired,
  parseJwtUser,
  deleteAuthorizationCookies,
} from "./tools/authentication";

import Navbar from "./components/Navbar";
import HomePage from "./pages/HomePage";
import ShopPage from "./pages/ShopPage";
import ProductPage from "./pages/ProductPage";
import SearchResultPage from "./pages/SearchResultPage";
import LoginPage from "./pages/LoginPage";
import AdminPage from "./pages/AdminPage";
import CartPage from "./pages/CartPage";
import SignUpPage from "./pages/SignUpPage";
import OrderPage from "./pages/OrderPage";
import ProfilePage from "./pages/ProfilePage";

import "./styles/global.css";
import "./styles/mediaQueries.css";

function App() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const jwt = getCookie("jwt");
    if (jwt !== "") {
      if (isExpired(jwt)) {
        deleteAuthorizationCookies();
        setUser(null);
      } else {
        const userData = parseJwtUser(jwt);
        setUser(userData);
        console.log(userData);
      }
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
        <Route path="/cart" element={<CartPage user={user} />} />
        <Route path="/profile/:id" element={<ProfilePage user={user} />} />
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
        <Route path="/orders" element={<OrderPage user={user} />} />
      </Routes>
    </>
  );
}

export default App;
