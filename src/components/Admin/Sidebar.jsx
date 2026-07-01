import { NavLink } from "react-router-dom";
import {
  FaHome,
  FaUser,
  FaCode,
  FaGraduationCap,
  FaProjectDiagram,
  FaEnvelope,
} from "react-icons/fa";
import "./Sidebar.css";

function Sidebar() {
  return (
    <aside className="sidebar">

      <div className="sidebar-logo">
        <h2>Athaul Admin</h2>
      </div>

      <nav>

        <NavLink to="/admin" end>
          <FaHome />
          <span>Dashboard</span>
        </NavLink>

        <NavLink to="/admin/profile">
          <FaUser />
          <span>Profile</span>
        </NavLink>

        <NavLink to="/admin/skills">
          <FaCode />
          <span>Skills</span>
        </NavLink>

        <NavLink to="/admin/education">
          <FaGraduationCap />
          <span>Education</span>
        </NavLink>

        <NavLink to="/admin/projects">
          <FaProjectDiagram />
          <span>Projects</span>
        </NavLink>

        <NavLink to="/admin/contact">
          <FaEnvelope />
          <span>Messages</span>
        </NavLink>

      </nav>

    </aside>
  );
}

export default Sidebar;