import { Link } from "react-router-dom";

export default function SignUpPage() {
  return (
    <div className="login--background">
      <form action="" method="POST" className="form form--grid">
        <Link to="/" className="form__logo logo">
          XXS
        </Link>
        <h2 className="form__title">Sign up</h2>
        <fieldset className="form__section">
          <div className="form__input--wrapper">
            <label htmlFor="firstName" className="form__label">
              First name
            </label>
            <input
              type="text"
              id="firstName"
              name="firstName"
              className="form__input"
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="lastName" className="form__label">
              Last name
            </label>
            <input
              type="text"
              id="lastName"
              name="lastName"
              className="form__input"
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="email" className="form__label">
              Email
            </label>
            <input
              type="text"
              id="email"
              name="email"
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
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="passwordConfirm" className="form__label">
              Confirm password
            </label>
            <input
              type="password"
              id="passwordConfirm"
              name="password"
              Confirm
              className="form__input"
              required
            />
          </div>
        </fieldset>
        <fieldset className="form__section">
          <div className="form__input--wrapper">
            <label htmlFor="country" className="form__label">
              Country
            </label>
            <input
              type="text"
              id="country"
              name="country"
              className="form__input"
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="zipCode" className="form__label">
              Zip code
            </label>
            <input
              type="text"
              id="zipCode"
              name="zipCode"
              className="form__input"
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="city" className="form__label">
              City
            </label>
            <input
              type="text"
              id="city"
              name="city"
              className="form__input"
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="address" className="form__label">
              Address
            </label>
            <input
              type="text"
              id="address"
              name="address"
              className="form__input"
              required
            />
          </div>
          <div>
            <button className="cta cta--max-width">Login</button>
            <p className="login__redirect">
              Already have an account? <Link to="/login">Log in here</Link>
            </p>
          </div>
        </fieldset>
      </form>
    </div>
  );
}
