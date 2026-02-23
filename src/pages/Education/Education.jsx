import { motion } from "framer-motion";
import "./Education.css";

const educationData = [
  {
    institution: "St Martin's Engineering College",
    degree: "B.Tech in Computer Science",
    year: "2021 - 2025",
    description: [
      "Computer Science Engineering gave me a strong foundation in programming, data structures, databases, operating systems, and computer networks, along with hands-on experience in software development.",
      "Served as a CoHo Club member, gaining experience in teamwork, coordination, and campus activities."
    ]
  },
  {
    institution: "Narayana junior college",
    degree: "Intermediate (MPC)",
    year: "2018 - 2020",
    description: ["Completed PUC with Mathematics, Physics, and Chemistry (MPC) at Narayana Junior College, securing 90%.",
      "This phase strengthened my analytical thinking and problem-solving skills through a strong focus on mathematics and core sciences.",
      "It built a solid academic foundation that supported my interest in engineering and technology."]
  },
  {
    institution: "Martin's Grammar High School",
    degree: "SSC",
    year: "2018",
    description: [
      "Secured a 9.0 CGPA with consistent academic performance",
      "Built strong fundamentals across core subjects",
      "Developed disciplined study habits and structured learning skills",
      "Laid a solid foundation for higher secondary and engineering studies"
    ]
  }
];

function Education() {
  return (
    <section className="education-container">
      <motion.div
        className="education-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
      >
        <h1>My <span className="accent">Education</span></h1>
        <div className="underline"></div>
      </motion.div>

      <div className="timeline">
        {educationData.map((item, index) => (
          <motion.div
            key={index}
            className="timeline-item"
            initial={{ opacity: 0, x: index % 2 === 0 ? -50 : 50 }}
            whileInView={{ opacity: 1, x: 0 }}
            transition={{ duration: 0.6, delay: index * 0.2 }}
            viewport={{ once: true }}
          >
            <div className="timeline-content">
              <span className="year">{item.year}</span>
              <h3>{item.degree}</h3>
              <h4>{item.institution}</h4>
              {Array.isArray(item.description) ? (
                <ul className="description-list">
                  {item.description.map((point, i) => (
                    <li key={i}>{point}</li>
                  ))}
                </ul>
              ) : (
                <p>{item.description}</p>
              )}
            </div>
          </motion.div>
        ))}
      </div>
    </section>
  );
}

export default Education;
