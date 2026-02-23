import { motion } from "framer-motion";
import ProjectCard from "../../components/ProjectCard/ProjectCard";
import "./Projects.css";

const projectsData = [
  {
    title: "Clinical Trial Management System",
    description: "A full-stack clinical trial management system with secure admin login, participant CRUD operations, search, sorting, pagination, and CSV export.",
    tags: ["React", "Node.js", "MongoDB", "JWT"],
    githubLink: "https://github.com/athaulrehman0304/clinical-trial-app",
    demoLink: "https://clinical-trial-app-1.onrender.com",
    image: "/projects/clinical-trial-dashboard.png" // Placeholder will be used
  },
  {
    title: "LoMar – Data Poisoning Detection System",
    description: "A full-stack Django web application that detects malicious data poisoning patterns in text datasets. Features role-based access for users and administrators, ML model training, performance comparison, and prediction logging.",
    tags: ["Python", "Django", "Machine Learning", "Scikit-learn", "SQLite"],
    githubLink: "https://github.com/athaulrehman0304/lomar",
    demoLink: "https://lomar-production.up.railway.app",
    image: "/projects/lomar-dashboard.png"
  },
];

/* 
  {
    title: "Task Management Tool",
    description: "A productivity tool for organizing tasks with features like drag-and-drop, priority setting, and deadlines.",
    tags: ["React", "Firebase", "Beautiful DnD"],
    githubLink: "https://github.com/athaul",
    demoLink: "https://demo.com",
    image: ""
  },
  {
    title: "Portfolio Website",
    description: "My personal portfolio website showcasing my skills, projects, and professional journey.",
    tags: ["React", "Framer Motion", "CSS3"],
    githubLink: "https://github.com/athaul/portfolio",
    demoLink: "https://athaul.com",
    image: ""
  },
  {
    title: "Chat Application",
    description: "Real-time chat application with features like private messaging, group chats, and file sharing.",
    tags: ["React", "Socket.io", "Express"],
    githubLink: "https://github.com/athaul",
    demoLink: "https://demo.com",
    image: ""
  },
  {
    title: "Blog Platform",
    description: "A content management system for creating and publishing blog posts with rich text editing.",
    tags: ["Next.js", "Markdown", "Tailwind CSS"],
    githubLink: "https://github.com/athaul",
    demoLink: "https://demo.com",
    image: ""
  }


*/

function Projects() {
  const containerVariants = {
    hidden: { opacity: 0 },
    visible: {
      opacity: 1,
      transition: {
        staggerChildren: 0.1
      }
    }
  };

  return (
    <section className="projects-container">
      <motion.div
        className="projects-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
      >
        <h1>My <span className="accent">Projects</span></h1>
        <div className="underline"></div>
      </motion.div>

      <motion.div
        className="projects-grid"
        variants={containerVariants}
        initial="hidden"
        animate="visible"
      >
        {projectsData.map((project, index) => (
          <ProjectCard key={index} {...project} />
        ))}
      </motion.div>
    </section>
  );
}

export default Projects;
