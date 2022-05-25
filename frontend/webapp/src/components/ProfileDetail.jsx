// styles
import "../styles/profileInfo.css";

export default function ProfileDetail({ label, value, type, updateValue }) {
  /**
   * Toggles the input field so the user can edit their details
   */
  function toggleInput() {
    const input = document.querySelector(
      "[data-input=" + label.replace(" ", "-") + "]"
    );
    const value = document.querySelector(
      "[data-value=" + label.replace(" ", "-") + "]"
    );
    input.classList.toggle("profile-info__input--hidden");
    value.classList.toggle("profile-info__value--hidden");
  }

  /**
   * Handles the event that is triggered when a user types in the input field
   * @param {*} event the event that is triggered by typing in the input field
   */
  function handleChange(event) {
    updateValue(event.target.value);
  }

  return (
    <div className="profile-info">
      <p className="profile-info__label">{label}:</p>
      <p className="profile-info__value" data-value={label.replace(" ", "-")}>
        {value}
      </p>
      <input
        className="profile-info__input profile-info__input--hidden"
        type={type ? type : "text"}
        value={value}
        onChange={handleChange}
        data-input={label.replace(" ", "-")}
      />
      <button className="profile-info__btn" onClick={toggleInput}>
        Change
      </button>
    </div>
  );
}
