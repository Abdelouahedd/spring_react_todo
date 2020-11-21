import "bootstrap/dist/css/bootstrap.min.css";
import AddTodo from "./add_todo/addTodo";

function App() {
  return (
    <div className="container">
      <div className="row d-flex flex-column justify-content-center align-items-center">
        {/* <div className="row justify-content-md-center"> */}
        <div className="col-lg-4 my-2 justify-content-md-center">
          <h1>Todo list</h1>
        </div>
        <hr />
        <AddTodo />
      </div>
    </div >
  );
}

export default App;
