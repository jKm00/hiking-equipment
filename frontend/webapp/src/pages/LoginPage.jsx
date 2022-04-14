import { Link } from "react-router-dom";

import "../styles/login.css";

export default function LoginPage() {
  return (
    <div className="login--background">
      <form action="" className="form">
        <h2 className="form__logo logo">XXS</h2>
        <fieldset className="form__section">
          <legend className="form__title">Login</legend>
          <div className="form__input--wrapper">
            <label htmlFor="username" className="form__label">
              Username / email
            </label>
            <input type="text" id="username" className="form__input" required />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="password" className="form__label">
              Password
            </label>
            <input type="password" id="password" className="form__input" />
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
