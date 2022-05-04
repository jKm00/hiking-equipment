import { useState } from "react";
import { sendApiRequest } from "../../tools/request";
import { displayFeedback } from "../../tools/feedback";
import { validEmail } from "../../tools/validators";

import "../../styles/form.css";

export default function CreateAdminUserForm() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [country, setCountry] = useState("");
  const [zipCode, setZipCode] = useState("");
  const [city, setCity] = useState("");
  const [address, setAddress] = useState("");

  /**
   * Handles action for when the submit button for the create admin user form
   * is pressed
   * @param {*} event the event that is triggered when submit is pressed
   */
  function handleSubmit(event) {
    event.preventDefault();
    if (
      firstName === "" ||
      lastName === "" ||
      email === "" ||
      password === "" ||
      country === "" ||
      zipCode === "" ||
      city === "" ||
      address === ""
    ) {
      displayFeedback(
        "error",
        "Make sure there are no empty fields",
        document.querySelector("[data-submit-user]"),
        document.querySelector("[data-feedback-user]")
      );
    } else if (!validEmail(email)) {
      displayFeedback(
        "error",
        "Email is not valid",
        document.querySelector("[data-submit-user]"),
        document.querySelector("[data-feedback-user]")
      );
    } else {
      sendApiRequest(
        "POST",
        "/users/admin",
        function () {
          displayFeedback(
            "success",
            "Admin user created",
            document.querySelector("[data-submit-user]"),
            document.querySelector("[data-feedback-user]")
          );
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
            "Something went wrong, try again",
            document.querySelector("[data-submit-user]"),
            document.querySelector("[data-feedback-user]")
          );
        }
      );
    }
  }

  return (
    <form action="" className="form form--stretch box create-admin-form">
      <fieldset className="form__section form__section--no-space form__section--horizontal form__section--four-column">
        <legend className="form__title form__title--small">
          Create admin user
        </legend>
        <div className="form__input--wrapper">
          <label htmlFor="firstName" className="form__label">
            First name
          </label>
          <input
            id="firstName"
            type="text"
            name="firstName"
            className="form__input"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="lastName" className="form__label">
            Last name
          </label>
          <input
            id="lastName"
            type="text"
            name="lastName"
            className="form__input"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="email" className="form__label">
            Email
          </label>
          <input
            id="email"
            type="email"
            name="email"
            className="form__input"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="password" className="form__label">
            Password
          </label>
          <input
            id="password"
            type="password"
            name="password"
            className="form__input"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
      </fieldset>
      <fieldset className="form__section form__section--no-space form__section--horizontal form__section--four-column">
        <div className="form__input--wrapper">
          <label htmlFor="country" className="form__label">
            Country
          </label>
          <input
            id="country"
            type="text"
            name="country"
            className="form__input"
            value={country}
            onChange={(e) => setCountry(e.target.value)}
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="zipCode" className="form__label">
            Zip Code
          </label>
          <input
            id="zipCode"
            type="text"
            name="zipCode"
            className="form__input"
            value={zipCode}
            onChange={(e) => setZipCode(e.target.value)}
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="city" className="form__label">
            City
          </label>
          <input
            id="city"
            type="text"
            name="city"
            className="form__input"
            value={city}
            onChange={(e) => setCity(e.target.value)}
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="address" className="form__label">
            Address
          </label>
          <input
            id="address"
            type="text"
            name="address"
            className="form__input"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
        </div>
      </fieldset>
      <button className="cta" onClick={handleSubmit} data-submit-user>
        Create user
      </button>
      <p className="form__feedback form__feedback--inline" data-feedback-user>
        Failed to create admin
      </p>
    </form>
  );
}
