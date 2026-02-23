import { motion } from "framer-motion";
import "./About.css";

function About() {
  return (
    <section className="about-container">
      <motion.div
        className="about-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
      >
        <h1>About <span className="accent">Me</span></h1>
        <div className="underline"></div>
      </motion.div>

      <div className="about-content">
        <motion.div
          className="about-text"
          initial={{ opacity: 0, x: -30 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ delay: 0.3, duration: 0.8 }}
        >
          <h3>I'm Athaul Rehman, a passionate developer.</h3>
          <p>
            I am a fresher software developer with a strong foundation in modern web technologies.
            I love building responsive, user-friendly applications and solving complex problems with clean code.
            My journey in tech is driven by curiosity and a desire to constantly learn and improve.
          </p>
          <p>
            I specialize in React ecosystem and have experience with backend technologies.
            I'm always looking for opportunities to work on challenging projects and collaborate with talented teams.
          </p>

          <div className="personal-info">
            <div className="info-item">
              <span className="label">Location:</span>
              <span className="value">India</span>
            </div>
            <div className="info-item">
              <span className="label">Email:</span>
              <span className="value">ataul0917@example.com</span>
            </div>
            <div className="info-item">
              <span className="label">Degree:</span>
              <span className="value">B.Tech in Computer Science</span>
            </div>
            <div className="info-item">
              <span className="label">Availability:</span>
              <span className="value accent">Open to Work</span>
            </div>
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
              <span>Create.</span>
              <span>Innovate.</span>
            </div>
          </div>
        </motion.div>
      </div>
    </section>
  );
}

export default About;
