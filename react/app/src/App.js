import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

// Styles
import "./style.css";

// Pages
import HomePage from "./pages/HomePage";
import ShopMen from "./pages/ShopMen";
import ShopWomen from "./pages/ShopWomen";

// Components
import Nav from "./components/Nav";

function App() {
  return (
    <Router>
      <Nav />
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/shop-men" element={<ShopMen />} />
        <Route path="/shop-women" element={<ShopWomen />} />
      </Routes>
    </Router>
  );
}

export default App;
