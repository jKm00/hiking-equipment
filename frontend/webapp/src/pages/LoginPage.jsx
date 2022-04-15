import { Link } from "react-router-dom";

import "../styles/login.css";
import "../styles/form.css";

export default function LoginPage() {
  const LOGIN_URL = "http://localhost:8080/api/authenticate";

  /**
   * Sends a login request to the API
   * @param {*} userDetails the username and password of the user to login
   */
  async function loginUser(userDetails) {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", LOGIN_URL);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
      if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        console.log(this.response);
        return this.response;
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
    // TODO: fix response being undefined
    const response = loginUser(requestData);
    console.log(response);
    // Check if response contains a JWT token
    if ("jwt" in response) {
      // TODO: Store JWT token in browser
      console.log("Logged in");
    } else {
      // TODO: Display error msg
      console.log("Login failed!");
    }
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
        </fieldset>
        <button className="cta cta--max-width">Login</button>
        <p className="login__redirect">
          Don't have an account? <Link to="/signup">Sign up</Link> for free
        </p>
      </form>
    </div>
  );
}
