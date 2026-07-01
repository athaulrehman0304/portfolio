import { motion } from "framer-motion";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import { FaGithub, FaLinkedin } from "react-icons/fa";
import api from "../../api/api";
import "./Home.css";

function Home() {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    api
      .get("/profile")
      .then((res) => setProfile(res.data))
      .catch((err) => console.error(err));
  }, []);

  if (!profile) {
    return (
      <section className="home-container">
        <h2 style={{ color: "white", textAlign: "center" }}>
          Loading...
        </h2>
      </section>
    );
  }

  return (
    <section className="home-container">
      <div className="home-content">

        <motion.h1
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.8 }}
        >
          Hello, I'm <span className="accent">{profile.name}</span>
        </motion.h1>

        <motion.h2
          style={{
            color: "#22c55e",
            marginBottom: "20px",
            fontWeight: "600",
          }}
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ delay: 0.2 }}
        >
          {profile.headline}
        </motion.h2>

        <motion.p
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ delay: 0.3, duration: 0.8 }}
        >
          {profile.bio}
        </motion.p>

        <motion.div
          className="cta-buttons"
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.6, duration: 0.8 }}
        >
          <Link to="/projects" className="btn btn-primary">
            View Work
          </Link>

          <Link to="/contact" className="btn btn-outline">
            Contact Me
          </Link>
        </motion.div>

        <motion.div
          className="social-links"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ delay: 0.9, duration: 0.8 }}
        >
          <a
            href={profile.githubUrl}
            target="_blank"
            rel="noopener noreferrer"
          >
            <FaGithub />
          </a>

          <a
            href={profile.linkedinUrl}
            target="_blank"
            rel="noopener noreferrer"
          >
            <FaLinkedin />
          </a>
        </motion.div>
      </div>

      <motion.div
        className="home-avatar"
        initial={{ opacity: 0, scale: 0.8 }}
        animate={{ opacity: 1, scale: 1 }}
        transition={{ delay: 0.3, duration: 0.8 }}
      >
        <motion.div
          className="avatar-container"
          animate={{ y: [0, -20, 0] }}
          transition={{
            repeat: Infinity,
            duration: 4,
            ease: "easeInOut",
          }}
        >
          <div className="avatar-placeholder">
            <img
              src={
                profile.profileImage ||
                "https://i.pinimg.com/736x/c3/87/16/c38716858b10e01056f11bee531b07db.jpg"
              }
              alt={profile.name}
            />
          </div>
        </motion.div>
      </motion.div>
    </section>
  );
}

export default Home;