import React from "react";
import { Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

import Homepage from "./pages/Homepage";

import "./style.css";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route exact path="/" element={<Homepage />} />
        <Route path="/shop" element={<h1>Shop page</h1>} />
      </Routes>
      <Footer />
    </>
  );
}

export default App;
