import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { displayFeedback } from "../tools/feedback";
import { sendApiRequest } from "../tools/request";
import { validEmail, validPassword } from "../tools/validators";

export default function SignUpPage() {
  const navigate = useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordConfirm, setPasswordConfirm] = useState("");
  const [country, setCountry] = useState("");
  const [zipCode, setZipCode] = useState("");
  const [city, setCity] = useState("");
  const [address, setAddress] = useState("");

  function handleSubmit(event) {
    event.preventDefault();
    if (
      firstName === "" ||
      lastName === "" ||
      email === "" ||
      password === "" ||
      passwordConfirm === "" ||
      country === "" ||
      zipCode === "" ||
      city === "" ||
      address === ""
    ) {
      displayFeedback(
        "error",
        "Make sure there are no empty fields",
        document.querySelector("[data-submit-signup]"),
        document.querySelector("[data-feedback-signup]")
      );
    } else if (!validEmail(email)) {
      displayFeedback(
        "error",
        "Invalid email, please try again",
        document.querySelector("[data-submit-signup]"),
        document.querySelector("[data-feedback-signup]")
      );
    } else if (!validPassword(password)) {
      displayFeedback(
        "error",
        "Password is not valid",
        document.querySelector("[data-submit-signup]"),
        document.querySelector("[data-feedback-signup]")
      );
    } else if (password !== passwordConfirm) {
      displayFeedback(
        "error",
        "Passwords does not match, please try again",
        document.querySelector("[data-submit-signup]"),
        document.querySelector("[data-feedback-signup]")
      );
    } else {
      sendApiRequest(
        "POST",
        "/auth/signup",
        function (response) {
          navigate("/login");
        },
        {
          firstName: firstName,
          lastName: lastName,
          email: email,
          password: password,
          country: country,
          zipCode: zipCode,
          city: city,
          address: address,
        },
        function () {
          displayFeedback(
            "error",
            "Something went wrong, please try again",
            document.querySelector("[data-submit-signup]"),
            document.querySelector("[data-feedback-signup]")
          );
        }
      );
    }
  }

  return (
    <div className="login--background">
      <form
        action=""
        method="POST"
        className="form form--grid form--padding"
        onSubmit={handleSubmit}
      >
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
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
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
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
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
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="form__input--wrapper">
            <label htmlFor="password" className="form__label">
              Password{" "}
              <span className="tooltip">
                ?{" "}
                <span className="tooltip__content">
                  Password must contain atleast one lower and upper case letter,
                  one digit and a total of atleast 8 characters
                </span>
              </span>
            </label>
            <input
              type="password"
              id="password"
              name="password"
              className="form__input"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
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
              name="passwordConfirm"
              className="form__input"
              value={passwordConfirm}
              onChange={(e) => setPasswordConfirm(e.target.value)}
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
              value={country}
              onChange={(e) => setCountry(e.target.value)}
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
              value={zipCode}
              onChange={(e) => setZipCode(e.target.value)}
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
              value={city}
              onChange={(e) => setCity(e.target.value)}
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
              value={address}
              onChange={(e) => setAddress(e.target.value)}
              required
            />
          </div>
          <p className="form__feedback" data-feedback-signup>
            Something went wrong, please try again...
          </p>
        </fieldset>
        <div className="form-submit-wrapper form-submit-wrapper--stretch">
          <button className="cta cta--max-width" data-submit-signup>
            Sign up
          </button>
          <p className="login__redirect">
            Already have an account? <Link to="/login">Log in here</Link>
          </p>
        </div>
      </form>
    </div>
  );
}
