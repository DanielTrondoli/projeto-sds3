import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/Navbar";

function App() {
  return (
    <>
      <NavBar />
      <div >
        <h1 className="container">Ola Arrombados !! </h1>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
