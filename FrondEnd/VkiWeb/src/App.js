import "./App.css";
import Header from "./components/Header.jsx";
import Main from "./components/Main.jsx";
import Footer from "./components/Footer.jsx";
import UserFindByUname from "./components/userProcess/UserFindByUname.jsx";
// Router
import { Navigate, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="App">
      {/* HEADER */}
      <div>
        <Header />
      </div>
      <div className="row app" >
      <div className="col col-6">
        {/* MAIN */}
        <Main />
        </div>
        {/* ROUTE */}
        <div className=" col  col-6" id="tables">
          <Routes>
            <Route path="/"></Route>
            <Route path={"/findbyuname/:uname"} element={<UserFindByUname />} />
            <Route path={"*"} element={<Navigate to={"/"} />} />
          </Routes>
        </div>
     </div>
        {/* FOOTER */}
        <Footer></Footer>
 
    </div>
  );
}

export default App;
