import { motion } from "framer-motion";
import { useEffect, useState } from "react";
import api from "../../api/api";

import {
  FaHtml5,
  FaCss3Alt,
  FaJs,
  FaReact,
  FaNodeJs,
  FaGitAlt,
  FaJava
} from "react-icons/fa";

import {
  SiMongodb,
  SiNextdotjs,
  SiPostman,
  SiMysql,
  SiSpringboot,
  SiVercel
} from "react-icons/si";

import "./Skills.css";

const iconMap = {
  HTML5: <FaHtml5 />,
  CSS3: <FaCss3Alt />,
  JavaScript: <FaJs />,
  React: <FaReact />,
  "Node.js": <FaNodeJs />,
  Git: <FaGitAlt />,
  Java: <FaJava />,
  MongoDB: <SiMongodb />,
  "Next.js": <SiNextdotjs />,
  Postman: <SiPostman />,
  MySQL: <SiMysql />,
  "Spring Boot": <SiSpringboot />,
  Vercel: <SiVercel />,
};

function Skills() {
  const [skillsData, setSkillsData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    api
      .get("/skills")
      .then((res) => {
        const grouped = {};

        res.data.forEach((skill) => {
          if (!grouped[skill.category]) {
            grouped[skill.category] = [];
          }

          grouped[skill.category].push(skill);
        });

        const finalData = Object.keys(grouped).map((category) => ({
          category,
          skills: grouped[category],
        }));

        setSkillsData(finalData);
      })
      .catch((err) => console.error(err))
      .finally(() => setLoading(false));
  }, []);

  const containerVariants = {
    hidden: { opacity: 0 },
    visible: {
      opacity: 1,
      transition: {
        staggerChildren: 0.15,
      },
    },
  };

  const itemVariants = {
    hidden: { y: 20, opacity: 0 },
    visible: {
      y: 0,
      opacity: 1,
    },
  };

  if (loading) {
    return (
      <section className="skills-container">
        <h2 style={{ color: "white", textAlign: "center" }}>
          Loading Skills...
        </h2>
      </section>
    );
  }

  return (
    <section className="skills-container">
      <motion.div
        className="skills-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
      >
        <h1>
          My <span className="accent">Skills</span>
        </h1>

        <div className="underline"></div>
      </motion.div>

      <motion.div
        className="skills-grid"
        variants={containerVariants}
        initial="hidden"
        animate="visible"
      >
        {skillsData.map((category) => (
          <motion.div
            key={category.category}
            className="skill-category"
            variants={itemVariants}
          >
            <h3>{category.category}</h3>

            <div className="skills-list">
              {category.skills.map((skill) => (
                <div key={skill.id} className="skill-item">
                  <div className="icon">
                    {iconMap[skill.name] ?? "💻"}
                  </div>

                  <span className="tooltip">
                    {skill.name}
                  </span>
                </div>
              ))}
            </div>
          </motion.div>
        ))}
      </motion.div>
    </section>
  );
}

export default Skills;