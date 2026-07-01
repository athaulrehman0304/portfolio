import { motion } from "framer-motion";
import { useEffect, useState } from "react";
import api from "../../api/api";
import "./About.css";

function About() {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    api.get("/profile")
      .then((res) => setProfile(res.data))
      .catch((err) => console.error(err));
  }, []);

  if (!profile) {
    return (
      <section className="about-container">
        <h2 style={{ color: "white", textAlign: "center" }}>
          Loading...
        </h2>
      </section>
    );
  }

  return (
    <section className="about-container">
      <motion.div
        className="about-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
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
        >

          <h3>{profile.name}</h3>

          <h4 className="accent">
            {profile.headline}
          </h4>

          <p>{profile.bio}</p>

          <div className="personal-info">

            <div className="info-item">
              <span className="label">Location:</span>
              <span className="value">
                {profile.location}
              </span>
            </div>

            <div className="info-item">
              <span className="label">Email:</span>
              <span className="value">
                {profile.email}
              </span>
            </div>

            <div className="info-item">
              <span className="label">Degree:</span>
              <span className="value">
                {profile.degree}
              </span>
            </div>

            <div className="info-item">
              <span className="label">Availability:</span>
              <span className="value accent">
                {profile.availability}
              </span>
            </div>

          </div>

          <div
            style={{
              marginTop: "30px",
              display: "flex",
              gap: "20px",
            }}
          >
            <a
              href={profile.githubUrl}
              target="_blank"
              rel="noreferrer"
            >
              GitHub
            </a>

            <a
              href={profile.linkedinUrl}
              target="_blank"
              rel="noreferrer"
            >
              LinkedIn
            </a>

            {profile.resumeUrl && (
              <a
                href={profile.resumeUrl}
                target="_blank"
                rel="noreferrer"
              >
                Resume
              </a>
            )}
          </div>

        </motion.div>

        <motion.div
          className="about-visual"
          initial={{ opacity: 0, x: 30 }}
          animate={{ opacity: 1, x: 0 }}
        >

          <div className="visual-card">

            <div className="card-inner">

              <span>CODE.</span>

              <span>BUILD.</span>

              <span>LEARN.</span>

            </div>

          </div>

        </motion.div>

      </div>
    </section>
  );
}

export default About;