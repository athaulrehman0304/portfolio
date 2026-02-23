import React from 'react';
import { FaGithub, FaExternalLinkAlt } from 'react-icons/fa';
import { motion } from 'framer-motion';
import './ProjectCard.css';

const ProjectCard = ({ title, description, tags, githubLink, demoLink, image }) => {
    return (
        <motion.div
            className="project-card"
            whileHover={{ y: -10 }}
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5 }}
            viewport={{ once: true }}
        >
            <div className="project-image">
                {image ? <img src={image} alt={title} /> : <div className="placeholder-image"></div>}
                <div className="project-links">
                    {githubLink && (
                        <a href={githubLink} target="_blank" rel="noopener noreferrer" title="View Code">
                            <FaGithub />
                        </a>
                    )}
                    {demoLink && (
                        <a href={demoLink} target="_blank" rel="noopener noreferrer" title="Live Demo">
                            <FaExternalLinkAlt />
                        </a>
                    )}
                </div>
            </div>
            <div className="project-content">
                <h3>{title}</h3>
                <p>{description}</p>
                <div className="project-tags">
                    {tags.map((tag, index) => (
                        <span key={index} className="tag">{tag}</span>
                    ))}
                </div>
            </div>
        </motion.div>
    );
};

export default ProjectCard;
