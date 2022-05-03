import { useEffect, useState } from "react";
import { sendApiRequest } from "../tools/request";

import ProductForm from "../components/ProductForm";
import PictureForm from "../components/PictureForm";
import Footer from "../components/Footer";

import "../styles/form.css";
import "../styles/admin.css";

export default function AdminPage({ user }) {
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
