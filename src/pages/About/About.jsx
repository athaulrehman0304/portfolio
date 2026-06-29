import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import api from "../../api/api";
import "./About.css";

function About() {
  const [profile, setProfile] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchProfile = async () => {
      try {
        const response = await api.get("/profile");
        setProfile(response.data);
      } catch (err) {
        console.error(err);
        setError("Failed to load profile.");
      } finally {
        setLoading(false);
      }
    };

    fetchProfile();
  }, []);

  if (loading) {
    return (
      <section className="about-container">
        <h2>Loading...</h2>
      </section>
    );
  }

  if (error) {
    return (
      <section className="about-container">
        <h2>{error}</h2>
      </section>
    );
  }

  return (
    <section className="about-container">
      <motion.div
        className="about-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
      >
        <h1>
          About <span className="accent">Me</span>
        </h1>
        <div className="underline"></div>
      </motion.div>

      <div className="about-content">
        <motion.div
          className="about-text"
          initial={{ opacity: 0, x: -30 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ delay: 0.3, duration: 0.8 }}
        >
          <h3>{profile.name}</h3>

          <h4
            style={{
              color: "#00df82",
              marginBottom: "15px",
              fontWeight: "500",
            }}
          >
            {profile.headline}
          </h4>

          <p>{profile.bio}</p>

          <div className="personal-info">
            <div className="info-item">
              <span className="label">Location:</span>
              <span className="value">{profile.location}</span>
            </div>

            <div className="info-item">
              <span className="label">Email:</span>
              <span className="value">{profile.email}</span>
            </div>

            <div className="info-item">
              <span className="label">Degree:</span>
              <span className="value">{profile.degree}</span>
            </div>

            <div className="info-item">
              <span className="label">Availability:</span>
              <span className="value accent">{profile.availability}</span>
            </div>
          </div>

          <div
            style={{
              display: "flex",
              gap: "15px",
              marginTop: "25px",
            }}
          >
            <a
              href={profile.githubUrl}
              target="_blank"
              rel="noopener noreferrer"
            >
              GitHub
            </a>

            <a
              href={profile.linkedinUrl}
              target="_blank"
              rel="noopener noreferrer"
            >
              LinkedIn
            </a>
          </div>
        </motion.div>

        <motion.div
          className="about-visual"
          initial={{ opacity: 0, x: 30 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ delay: 0.5, duration: 0.8 }}
        >
          <div className="visual-card">
            <div className="card-inner">
              <span>Code.</span>
              <span>Build.</span>
              <span>Learn.</span>
            </div>
          </div>
        </motion.div>
      </div>
    </section>
  );
}

export default About;