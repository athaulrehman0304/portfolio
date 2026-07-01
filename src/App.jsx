import { Routes, Route, Outlet } from "react-router-dom";

import Navbar from "./components/Navbar/Navbar";
import Footer from "./components/Footer/Footer";

import ProtectedRoute from "./components/ProtectedRoute";

import Home from "./pages/Home/Home";
import About from "./pages/About/About";
import Skills from "./pages/Skills/Skills";
import Education from "./pages/Education/Education";
import Projects from "./pages/Projects/Projects";
import Contact from "./pages/Contact/Contact";

import Login from "./pages/Admin/Login/Login";
import Dashboard from "./pages/Admin/Dashboard/Dashboard";
import Profile from "./pages/Admin/Profile/Profile";
import SkillsAdmin from "./pages/Admin/Skills/Skills";
import EducationAdmin from "./pages/Admin/Education/Education";
import ProjectsAdmin from "./pages/Admin/Projects/Projects";
import ContactAdmin from "./pages/Admin/Contact/Contact";

import "./App.css";

function PublicLayout() {
  return (
    <>
      <Navbar />
      <div className="app-container">
        <Outlet />
      </div>
      <Footer />
    </>
  );
}

function App() {
  return (
    <Routes>

      {/* Public Website */}

      <Route element={<PublicLayout />}>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/skills" element={<Skills />} />
        <Route path="/education" element={<Education />} />
        <Route path="/projects" element={<Projects />} />
        <Route path="/contact" element={<Contact />} />
      </Route>

      {/* Admin Login */}

      <Route
        path="/admin/login"
        element={<Login />}
      />

      {/* Admin CMS */}

      <Route
        path="/admin"
        element={
          <ProtectedRoute>
            <Dashboard />
          </ProtectedRoute>
        }
      >
        <Route
          index
          element={
            <>
              <h1>Welcome Admin 👋</h1>
              <p>Select a section from the sidebar.</p>
            </>
          }
        />

        <Route
          path="profile"
          element={<Profile />}
        />

        <Route
          path="skills"
          element={<SkillsAdmin />}
        />

        <Route
          path="education"
          element={<EducationAdmin />}
        />

        <Route
          path="projects"
          element={<ProjectsAdmin />}
        />

        <Route
          path="contact"
          element={<ContactAdmin />}
        />

      </Route>

    </Routes>
  );
}

export default App;