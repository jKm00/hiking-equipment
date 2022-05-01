import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

import Footer from "../components/Footer";

import "../styles/form.css";
import "../styles/admin.css";

export default function AdminPage({ user }) {
  const navigate = useNavigate();

  useEffect(() => {
    if (!user || !user.roles.includes("ROLE_ADMIN")) {
      navigate("/");
    }
  }, []);

  return (
    <>
      <div className="admin-page">
        <form action="" className="form">
          <fieldset className="form__section">
            <legend className="form__title form__title--small">
              Add picture to product
            </legend>
            <div className="form__input--wrapper">
              <label htmlFor="product" className="form__label">
                Product to add image to
              </label>
              <select name="product" id="product" className="form__input">
                <option value="1">Winter Sweater</option>
                <option value="2">Hiking Boots</option>
              </select>
            </div>
            <div className="form__input--wrapper">
              <label htmlFor="product-image" className="form__label">
                Product image:
              </label>
              <input
                type="file"
                id="product-image"
                name="product-image"
                accept="image/png, image/jpeg"
                className="form__input"
              />
            </div>
          </fieldset>
        </form>
      </div>
      <Footer />
    </>
  );
}
