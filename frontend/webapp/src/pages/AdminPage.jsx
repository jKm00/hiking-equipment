import { useEffect, useState } from "react";
import { sendApiRequest } from "../tools/request";

import ProductForm from "../components/ProductForm";
import PictureForm from "../components/PictureForm";
import CreateAdminUserForm from "../components/CreateAdminUserForm";
import Footer from "../components/Footer";

import "../styles/admin.css";

export default function AdminPage({ user }) {
  const [products, setProducts] = useState([]);

  // Load products
  useEffect(() => {
    updateProducts();
  }, []);

  function updateProducts() {
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
  }

  return (
    <>
      <div className="admin-page--wrapper">
        <div className="admin-page">
          <PictureForm />
          <CreateAdminUserForm />
          <ProductForm products={products} updateProducts={updateProducts} />
        </div>
      </div>
      <Footer />
    </>
  );
}
