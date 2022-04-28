import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { sendAuthenticationRequest } from "../tools/authentication";

import "../styles/login.css";
import "../styles/form.css";

export default function LoginPage({ setUser }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  function handleSubmit(event) {
    event.preventDefault();
    sendAuthenticationRequest(username, password, onLoginSuccess, onError);
  }

  function onLoginSuccess(userData) {
    setUser(userData);
    navigate("/");
  }

  function onError() {
    const errorMsg = document.querySelector("[data-error]");
    errorMsg.classList.remove("form__error-msg--hidden");
  }

  return (
    <div className="login--background">
      <form action="" method="POST" className="form" onSubmit={handleSubmit}>
        <Link to="/" className="form__logo logo">
          XXS
        </Link>
        <h2 className="form__title">Sign in</h2>
        <fieldset className="form__section">
          <div className="form__input--wrapper">
            <label htmlFor="username" className="form__label">
              Username / email
            </label>
            <input
              type="text"
              id="username"
              name="username"
              className="form__input"
              onChange={(event) => setUsername(event.target.value)}
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="password" className="form__label">
              Password
            </label>
            <input
              type="password"
              id="password"
              name="password"
              className="form__input"
              onChange={(event) => setPassword(event.target.value)}
              required
            />
          </div>
          <p className="form__error-msg form__error-msg--hidden" data-error>
            Something went wrong, please try again...
          </p>
        </fieldset>
        <button className="cta cta--max-width">Login</button>
        <p className="login__redirect">
          Don't have an account? <Link to="/signup">Sign up</Link> for free
        </p>
      </form>
    </div>
  );
}
