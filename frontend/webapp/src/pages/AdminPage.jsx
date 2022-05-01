import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

import PictureForm from "../components/PictureForm";
import Footer from "../components/Footer";

import "../styles/form.css";
import "../styles/admin.css";

export default function AdminPage({ user }) {
  const navigate = useNavigate();

  // Redirects none admins back to main page
  useEffect(() => {
    if (!user || !user.roles.includes("ROLE_ADMIN")) {
      navigate("/");
    }
  }, []);

  return (
    <>
      <div className="admin-page">
        <PictureForm />
      </div>
      <Footer />
    </>
  );
}
