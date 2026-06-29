import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import ProjectCard from "../../components/ProjectCard/ProjectCard";
import api from "../../api/api";
import "./Projects.css";

function Projects() {
  const [projects, setProjects] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchProjects();
  }, []);

  async function fetchProjects() {
    try {
      const response = await api.get("/projects");

      setProjects(response.data.content);
    } catch (error) {
      console.error("Failed to fetch projects:", error);
    } finally {
      setLoading(false);
    }
  }

  const containerVariants = {
    hidden: { opacity: 0 },
    visible: {
      opacity: 1,
      transition: {
        staggerChildren: 0.1,
      },
    },
  };

  if (loading) {
    return (
      <section className="projects-container">
        <h2>Loading Projects...</h2>
      </section>
    );
  }

  return (
    <section className="projects-container">
      <motion.div
        className="projects-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
      >
        <h1>
          My <span className="accent">Projects</span>
        </h1>

        <div className="underline"></div>
      </motion.div>

      <motion.div
        className="projects-grid"
        variants={containerVariants}
        initial="hidden"
        animate="visible"
      >
        {projects.map((project) => (
          <ProjectCard
            key={project.id}
            title={project.title}
            description={project.description}
            tags={project.tags}
            githubLink={project.repositoryUrl}
            demoLink={project.liveUrl}
            image={project.imageUrl}
          />
        ))}
      </motion.div>
    </section>
  );
}

export default Projects;