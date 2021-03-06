import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { sendAuthenticationRequest } from "../tools/authentication";
import { displayFeedback } from "../tools/feedback";
import { validEmail } from "../tools/validators";

import "../styles/login.css";
import "../styles/form.css";

/**
 * Returns a login page
 * @param {*} setUser, a function to be called whenever the login is successful
 * @returns a login page
 */
export default function LoginPage({ setUser }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  /**
   * Handles the event when the login form is submitted
   * @param {*} event, the event that is triggered when
   * the login form is submitted
   */
  function handleSubmit(event) {
    event.preventDefault();
    if (!validEmail(email)) {
      displayFeedback(
        "error",
        "Invalid email, please try again...",
        document.querySelector("[data-submit-login]"),
        document.querySelector("[data-feedback-login]")
      );
    } else {
      sendAuthenticationRequest(email, password, onLoginSuccess, onError);
    }
  }

  /**
   * Called whenever the login is successful. Sets the user state to the user
   * logged in and redirects to home page
   * @param {*} userData
   */
  function onLoginSuccess(userData) {
    setUser(userData);
    navigate("/");
  }

  /**
   * Called whenever login is unsuccessful. Displayes a feedback message
   * to the user
   */
  function onError() {
    displayFeedback(
      "error",
      "Something went wrong, please try again...",
      document.querySelector("[data-submit-login]"),
      document.querySelector("[data-feedback-login]")
    );
  }

  return (
    <div className="login--background">
      <form
        action=""
        method="POST"
        className="form form--padding"
        onSubmit={handleSubmit}
      >
        <Link to="/" className="form__logo logo">
          XXS
        </Link>
        <h2 className="form__title">Sign in</h2>
        <fieldset className="form__section">
          <div className="form__input--wrapper">
            <label htmlFor="username" className="form__label">
              Email
            </label>
            <input
              type="text"
              id="username"
              name="username"
              className="form__input"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
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
              value={password}
              onChange={(event) => setPassword(event.target.value)}
              required
            />
          </div>
          <p className="form__feedback" data-feedback-login>
            Something went wrong, please try again...
          </p>
        </fieldset>
        <button className="cta cta--max-width" data-submit-login>
          Login
        </button>
        <p className="login__redirect">
          Don't have an account? <Link to="/signup">Sign up</Link> for free
        </p>
      </form>
    </div>
  );
}
