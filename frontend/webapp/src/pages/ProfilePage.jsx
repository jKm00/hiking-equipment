import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

// tools
import { sendApiRequest } from "../tools/request";
import { displayFeedback } from "../tools/feedback";
import { getCookie } from "../tools/cookies";
import { parseJwtUser } from "../tools/authentication";

// components
import ProfileDetail from "../components/ProfileDetail";
import Footer from "../components/Footer";

// styles
import "../styles/profilePage.css";

export default function ProfilePage({ user }) {
  const { id } = useParams();

  const [validUser, setValidUser] = useState(false);
  const [uid, setUid] = useState("");

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("********");
  const [country, setCountry] = useState("");
  const [city, setCity] = useState("");
  const [address, setAddress] = useState("");
  const [zipCode, setZipCode] = useState("");

  useEffect(() => {
    // TODO: Use user instead of getting the jwt
    const jwt = getCookie("jwt");
    if (jwt !== "") {
      const userData = parseJwtUser(jwt);
      if (userData.id == id) {
        setValidUser(true);
        sendApiRequest(
          "GET",
          "/users/" + id,
          (response) => {
            setFirstName(response.firstName);
            setLastName(response.lastName);
            setEmail(response.email);
            setCountry(response.country);
            setCity(response.city);
            setAddress(response.address);
            setZipCode(response.zipCode);
          },
          null,
          (error) => {
            console.log(error);
          }
        );
      }
    }
  }, []);

  /**
   * Handles the event when submit if pressed. If all guard conditions is
   * true, a request to update the user is send to the API.
   */
  function handleSubmit() {
    if (
      firstName === "" ||
      lastName === "" ||
      email === "" ||
      password === "" ||
      country === "" ||
      city === "" ||
      address === "" ||
      zipCode === ""
    ) {
      displayFeedback(
        "error",
        "Cant change any fields to empty",
        document.querySelector("[data-profile-submit]"),
        document.querySelector("[data-profile-feedback]")
      );
    } else {
      let newDetails;
      if (password === "********") {
        newDetails = {
          firstName: firstName,
          lastName: lastName,
          email: email,
          password: null,
          country: country,
          city: city,
          address: address,
          zipCode: zipCode,
        };
      } else {
        newDetails = {
          firstName: firstName,
          lastName: lastName,
          email: email,
          password: password,
          country: country,
          city: city,
          address: address,
          zipCode: zipCode,
        };
      }
      sendApiRequest(
        "PUT",
        "/users/" + id,
        (response) => {
          displayFeedback(
            "success",
            "Changes saved",
            document.querySelector("[data-profile-submit]"),
            document.querySelector("[data-profile-feedback]")
          );
        },
        newDetails,
        (error) => {
          console.error(error);
        }
      );
    }
  }

  return (
    <>
      <div className="profile-page">
        <h2>Profile Settings</h2>
        {!validUser ? (
          <p>
            You do not have access to this user.{" "}
            <Link to="/">Back to home page</Link>
          </p>
        ) : (
          <>
            <ProfileDetail
              label="First name"
              value={firstName}
              updateValue={setFirstName}
            />
            <ProfileDetail
              label="Last name"
              value={lastName}
              updateValue={setLastName}
            />
            <ProfileDetail label="Email" value={email} updateValue={setEmail} />
            <ProfileDetail
              label="Password"
              value={password}
              type="password"
              updateValue={setPassword}
            />
            <ProfileDetail
              label="Country"
              value={country}
              updateValue={setCountry}
            />
            <ProfileDetail label="City" value={city} updateValue={setCity} />
            <ProfileDetail
              label="Address"
              value={address}
              updateValue={setAddress}
            />
            <ProfileDetail
              label="Zip code"
              value={zipCode}
              updateValue={setZipCode}
            />
            <div className="profile-page__submit-wrapper">
              <button
                onClick={handleSubmit}
                className="cta"
                data-profile-submit
              >
                Save changes
              </button>
              <p
                className="profile-page__feedback form__feedback form__feedback--inline"
                data-profile-feedback
              >
                Changes saved
              </p>
            </div>
          </>
        )}
      </div>
      <Footer />
    </>
  );
}
