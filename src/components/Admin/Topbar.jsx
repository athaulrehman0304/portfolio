import { useNavigate } from "react-router-dom";
import { clearToken } from "../../utils/auth";
import "./Topbar.css";

function Topbar() {

  const navigate = useNavigate();

  function logout() {
    clearToken();
    navigate("/admin/login");
  }

  return (
    <header className="topbar">

      <div>
        <h2>Portfolio CMS</h2>
        <p>Manage your portfolio</p>
      </div>

      <button onClick={logout}>
        Logout
      </button>

    </header>
  );
}

export default Topbar;