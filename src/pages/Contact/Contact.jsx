import { motion } from "framer-motion";
import { FaPaperPlane, FaGithub, FaLinkedin, FaTwitter, FaEnvelope, FaMapMarkerAlt } from "react-icons/fa";
import "./Contact.css";

function Contact() {
  const handleSubmit = (e) => {
    e.preventDefault();
    // Add form submission logic here
    alert("Message sent!");
  };

  return (
    <section className="contact-container">
      <motion.div
        className="contact-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
      >
        <h1>Get In <span className="accent">Touch</span></h1>
        <div className="underline"></div>
      </motion.div>

      <div className="contact-content">
        <motion.div
          className="contact-info"
          initial={{ opacity: 0, x: -30 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ delay: 0.3, duration: 0.8 }}
        >
          <h3>Let's Talk</h3>
          <p>
            I'm currently open to new opportunities and collaborations.
            Whether you have a question or just want to say hi, I'll try my best to get back to you!
          </p>

          <div className="contact-details">
            <div className="contact-item">
              <FaEnvelope className="icon" />
              <span>ataul0917@example.com</span>
            </div>
            <div className="contact-item">
              <FaMapMarkerAlt className="icon" />
              <span>India</span>
            </div>
          </div>

          <div className="social-links-large">
            <a href="https://github.com/athaulrehman0304" target="_blank" rel="noopener noreferrer"><FaGithub /></a>
            <a href="https://www.linkedin.com/in/athaul-rehman/" target="_blank" rel="noopener noreferrer"><FaLinkedin /></a>

          </div>
        </motion.div>

        <motion.form
          className="contact-form"
          onSubmit={handleSubmit}
          initial={{ opacity: 0, x: 30 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ delay: 0.5, duration: 0.8 }}
        >
          <div className="form-group">
            <input type="text" placeholder="Your Name" required />
          </div>
          <div className="form-group">
            <input type="email" placeholder="Your Email" required />
          </div>
          <div className="form-group">
            <textarea placeholder="Your Message" rows="5" required></textarea>
          </div>
          <button type="submit" className="btn btn-primary submit-btn">
            Send Message <FaPaperPlane />
          </button>
        </motion.form>
      </div>
    </section>
  );
}

export default Contact;
