import React from 'react';
import { FaGithub, FaLinkedin, FaTwitter, FaEnvelope } from 'react-icons/fa';
import './Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-logo">Athaul.</div>
        <div className="footer-links">
          <a href="https://github.com/athaulrehman0304" target="_blank" rel="noopener noreferrer"><FaGithub /></a>
          <a href="https://www.linkedin.com/in/athaul-rehman/" target="_blank" rel="noopener noreferrer"><FaLinkedin /></a>
          <a href="mailto:ataul0917@example.com"><FaEnvelope /></a>
        </div>
        <p className="copyright">© {new Date().getFullYear()} Md Athaul Rehman. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;
