/**
 * Displays a feedback message for 7 seconds when a form is submitted
 * @param {*} type the type of the feedback, "success" or "error"
 * @param {*} msg the message to be displayed
 * @param {*} submit the submit button of the form
 * @param {*} element the text element that displays the feedback
 */
export function displayFeedback(type, msg, submit, element) {
  // Change style of feedback depending on type
  if (type === "success") {
    element.classList.remove("form__feedback--error");
    element.classList.add("form__feedback--success");
  } else {
    element.classList.remove("form__feedback--success");
    element.classList.add("form__feedback--error");
  }
  // Set feedback text
  element.innerHTML = msg;
  // Display element and fade it out
  element.classList.add("form__feedback__animation");
  setTimeout(() => {
    // Reset button and feedback message after 2250ms
    element.classList.remove("form__feedback__animation");
  }, 7250);
}
