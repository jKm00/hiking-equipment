import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import ProductForm from "../components/ProductForm";
import PictureForm from "../components/PictureForm";
import Footer from "../components/Footer";

import "../styles/form.css";
import "../styles/admin.css";

export default function AdminPage({ user }) {
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);

  // Load products
  useEffect(() => {
    sendApiRequest(
      "GET",
      "/products",
      function (response) {
        setProducts(response);
      },
      null,
      function (error) {
        console.error("Could not load products: " + error);
      }
    );
  }, []);

  return (
    <>
      <div className="admin-page">
        <ProductForm products={products} />
        <PictureForm />
      </div>
      <Footer />
    </>
  );
}
