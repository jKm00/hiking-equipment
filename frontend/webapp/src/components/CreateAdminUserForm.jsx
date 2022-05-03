import "../styles/form.css";

export default function CreateAdminUserForm() {
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
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="email" className="form__label">
            Email
          </label>
          <input id="email" type="email" name="email" className="form__input" />
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
          />
        </div>
        <div className="form__input--wrapper">
          <label htmlFor="city" className="form__label">
            City
          </label>
          <input id="city" type="text" name="city" className="form__input" />
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
          />
        </div>
      </fieldset>
      <button className="cta">Create user</button>
    </form>
  );
}
