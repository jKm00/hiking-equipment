
/**
 * Creates a form input component
 * @param value, the value of the input
 * @param updateValue, method that updates values
 * @param label, what the label of the form is going to say
 * @param type, the type of input the form will accept
 * @returns an input form component
 */
export default function FormInput({ value, updateValue, label, type }) {
  function handleChange(e) {
    if (type !== null && type === "checkbox") {
      updateValue(!value);
    } else {
      updateValue(e.target.value);
    }
  }

  return (
    <div className="form__input--wrapper">
      <label htmlFor={label} className="form__label">
        {label}
      </label>
      <input
        id={label}
        type={type === null ? "text" : type}
        className="form__input"
        value={value}
        onChange={handleChange}
      />
    </div>
  );
}
