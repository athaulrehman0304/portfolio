import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import api from "../../api/api";
import "./Education.css";

function Education() {

  const [education, setEducation] = useState([]);

  useEffect(() => {
    api
      .get("/education")
      .then((res) => setEducation(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <section className="education-container">

      <motion.div
        className="education-header"
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6 }}
      >
        <h1>
          My <span className="accent">Education</span>
        </h1>

        <div className="underline"></div>
      </motion.div>

      <div className="timeline">

        {education.map((item, index) => (

          <motion.div
            key={item.id}
            className="timeline-item"
            initial={{
              opacity: 0,
              x: index % 2 === 0 ? -50 : 50,
            }}
            whileInView={{
              opacity: 1,
              x: 0,
            }}
            transition={{
              duration: 0.6,
              delay: index * 0.2,
            }}
            viewport={{ once: true }}
          >

            <div className="timeline-content">

              <span className="year">{item.year}</span>

              <h3>{item.degree}</h3>

              <h4>{item.institution}</h4>

              <p>{item.description}</p>

            </div>

          </motion.div>

        ))}

      </div>

    </section>
  );
}

export default Education;