import { Link, useNavigate } from "react-router-dom";
import { sendApiRequest } from "../tools/request";

import "../styles/login.css";
import "../styles/form.css";

export default function LoginPage() {
  const LOGIN_URL = "http://localhost:8080/api/authenticate";
  const navigate = useNavigate();
  /**
   * Sends a login request to the API
   * @param {*} userDetails the username and password of the user to login
   */
  async function sendLoginRequest(userDetails) {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", LOGIN_URL);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
      if (this.readyState === XMLHttpRequest.DONE) {
        if (this.status === 200) {
          // Save jwt to browser
          const result = JSON.parse(this.response);
          localStorage.setItem("jwt", result.jwt);
          navigate("/");
        } else {
          // Display error message
          const errorMsg = document.querySelector("[data-error]");
          errorMsg.style.opacity = 1;
        }
      }
    };

    xhr.send(JSON.stringify(userDetails));
  }

  /**
   * Handles the event when the login button is presses
   * @param {*} event
   */
  function handleSubmit(event) {
    // Prevent form from defaul behavior
    event.preventDefault();
    // Create authentication request from input values
    const requestData = {
      username: event.target.username.value,
      password: event.target.password.value,
    };
    // Send login request to API
    sendLoginRequest(requestData);
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
            />
          </div>
          <p className="form__error-msg" data-error>
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
