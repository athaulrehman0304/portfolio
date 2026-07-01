import { useEffect, useState } from "react";
import api from "../../../api/api";
import "./Profile.css";

function Profile() {
  const [profile, setProfile] = useState({
    name: "",
    headline: "",
    bio: "",
    location: "",
    email: "",
    githubUrl: "",
    linkedinUrl: "",
    resumeUrl: "",
    profileImage: "",
  });

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    api
      .get("/profile")
      .then((res) => {
        setProfile(res.data);
        setLoading(false);
      })
      .catch((err) => {
        console.error(err);
        setLoading(false);
      });
  }, []);

  function handleChange(e) {
    setProfile({
      ...profile,
      [e.target.name]: e.target.value,
    });
  }

  function handleSubmit(e) {
    e.preventDefault();

    api
      .put("/profile", profile)
      .then(() => {
        alert("Profile updated successfully.");
      })
      .catch((err) => {
        console.error(err);
        alert("Update failed.");
      });
  }

  if (loading) return <h2>Loading...</h2>;

  return (
    <div className="profile-page">

      <h1>Edit Profile</h1>

      <form onSubmit={handleSubmit}>

        <input
          name="name"
          placeholder="Name"
          value={profile.name}
          onChange={handleChange}
        />

        <input
          name="headline"
          placeholder="Headline"
          value={profile.headline}
          onChange={handleChange}
        />

        <textarea
          name="bio"
          placeholder="Bio"
          value={profile.bio}
          onChange={handleChange}
        />

        <input
          name="location"
          placeholder="Location"
          value={profile.location}
          onChange={handleChange}
        />

        <input
          name="email"
          placeholder="Email"
          value={profile.email}
          onChange={handleChange}
        />

        <input
          name="githubUrl"
          placeholder="Github URL"
          value={profile.githubUrl}
          onChange={handleChange}
        />

        <input
          name="linkedinUrl"
          placeholder="LinkedIn URL"
          value={profile.linkedinUrl}
          onChange={handleChange}
        />

        <input
          name="resumeUrl"
          placeholder="Resume URL"
          value={profile.resumeUrl}
          onChange={handleChange}
        />

        <input
          name="profileImage"
          placeholder="Profile Image URL"
          value={profile.profileImage}
          onChange={handleChange}
        />

        <button type="submit">
          Save Changes
        </button>

      </form>

    </div>
  );
}

export default Profile;