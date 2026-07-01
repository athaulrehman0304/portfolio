import { Outlet } from "react-router-dom";
import Sidebar from "../../../components/Admin/Sidebar";
import Topbar from "../../../components/Admin/Topbar";
import "./Dashboard.css";

function Dashboard() {
  return (
    <div className="dashboard">

      <Sidebar />

      <div className="dashboard-content">

        <Topbar />

        <div className="dashboard-body">
          <Outlet />
        </div>

      </div>

    </div>
  );
}

export default Dashboard;