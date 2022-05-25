import { useState } from "react";
import { useParams } from "react-router-dom";

// components
import ProfileDetail from "../components/ProfileDetail";
import Footer from "../components/Footer";

// styles
import "../styles/profilePage.css";

export default function ProfilePage() {
  const { id } = useParams();

  const [firstName, setFirstName] = useState("Joakim");
  const [lastName, setLastName] = useState("Edvardsen");
  const [email, setEmail] = useState("joakimedvardsen2000@gmail.com");
  const [password, setPassword] = useState("********");
  const [country, setCountry] = useState("Norway");
  const [city, setCity] = useState("Ålesund");
  const [address, setAddress] = useState("Øvre Strandgate 2");
  const [zipCode, setZipCode] = useState("6004");

  return (
    <>
      <div className="profile-page">
        <h2>Profile Settings</h2>
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
        <button className="cta">Save changes</button>
      </div>
      <Footer />
    </>
  );
}
