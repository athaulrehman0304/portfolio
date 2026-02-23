import { motion } from "framer-motion";
import { Link } from "react-router-dom";
import { FaGithub, FaLinkedin, FaTwitter } from "react-icons/fa";
import "./Home.css";

function Home() {
  return (
    <section className="home-container">
      <div className="home-content">
        <motion.h1
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.8 }}
        >
          Hello, I’m <span className="accent">Athaul Rehman</span>
        </motion.h1>

        <motion.p
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ delay: 0.3, duration: 0.8 }}
        >
          Fresher software developer passionate about building modern web
          applications and improving continuously.
        </motion.p>

        <motion.div
          className="cta-buttons"
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.6, duration: 0.8 }}
        >
          <Link to="/projects" className="btn btn-primary">View Work</Link>
          <Link to="/contact" className="btn btn-outline">Contact Me</Link>
        </motion.div>

        <motion.div
          className="social-links"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ delay: 0.9, duration: 0.8 }}
        >
          <a href="https://github.com/athaulrehman0304" target="_blank" rel="noopener noreferrer"><FaGithub /></a>
          <a href="https://www.linkedin.com/in/athaul-rehman/" target="_blank" rel="noopener noreferrer"><FaLinkedin /></a>

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
          transition={{ repeat: Infinity, duration: 4, ease: "easeInOut" }}
        >
          {/* Placeholder for animated student cartoon - using a simple SVG representation or image */}
          <div className="avatar-placeholder">
            <img src="https://i.pinimg.com/736x/c3/87/16/c38716858b10e01056f11bee531b07db.jpg" alt="Athaul's Avatar" />
          </div>
        </motion.div>
      </motion.div>
    </section>
  );
}

export default Home;
