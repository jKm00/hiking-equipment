import { useEffect, useState } from "react";
import { sendApiRequest } from "../tools/request";

import ProductForm from "../components/admin/ProductForm";
import PictureForm from "../components/admin/PictureForm";
import CreateAdminUserForm from "../components/admin/CreateAdminUserForm";
import Footer from "../components/Footer";

import "../styles/admin.css";

/**
 * Returns an admin page with forms allowing admins with more functionality
 * @param {*} user, the user that is signed in on the app
 */
export default function AdminPage({ user }) {
  const [products, setProducts] = useState([]);

  // Load products
  useEffect(() => {
    updateProducts();
  }, []);

  /**
   * Updates the products from the backend
   */
  function updateProducts() {
    sendApiRequest(
      "GET",
      "/products?sex=undefined&category=undefined",
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
          <PictureForm products={products} />
          <CreateAdminUserForm />
          <ProductForm products={products} updateProducts={updateProducts} />
        </div>
      </div>
      <Footer />
    </>
  );
}
