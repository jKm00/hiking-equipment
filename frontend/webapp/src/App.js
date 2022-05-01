import React, { useEffect, useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { getCookie } from "./tools/cookies";

import Navbar from "./components/Navbar";
import HomePage from "./pages/HomePage";
import ShopPage from "./pages/ShopPage";
import ProductPage from "./pages/ProductPage";
import SearchResultPage from "./pages/SearchResultPage";
import LoginPage from "./pages/LoginPage";
import AdminPage from "./pages/AdminPage";

import "./styles/global.css";
import "./styles/mediaQueries.css";

function App() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const username = getCookie("current_email");
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
        <Route path="/shop/:sex" element={<ShopPage />} />
        <Route path="/shop/:sex/:category" element={<ShopPage />} />
        <Route path="/product/:id" element={<ProductPage />} />
        <Route path="/search/:keyword" element={<SearchResultPage />} />
        <Route path="/login" element={<LoginPage setUser={setUser} />} />
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
