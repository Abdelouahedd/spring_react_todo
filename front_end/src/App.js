import "bootstrap/dist/css/bootstrap.min.css";
import "@fortawesome/fontawesome-free/css/all.css"
import AddTodo from "./add_todo/addTodo";
import ListTodos from "./list_todos/listTodos";
import TasksProvider from "./context/list_context"
import { useState } from "react";

function App() {
  const [isUpdate, setIsUpdate] = useState(false);

  const onUpdate = () => setIsUpdate(true)
  const setChangeToUpdate = () => setIsUpdate(false);

  return (
    <div className="container">
      <div className="row d-flex flex-column justify-content-center ">
        <div className="col-lg-6 my-2 justify-content-md-center">
          <h1>Todo list</h1>
        </div>
        <hr />
        <TasksProvider>
          <AddTodo isUpdate={isUpdate} setChangeToUpdate={setChangeToUpdate} />
          <ListTodos onUpdate={onUpdate} />
        </TasksProvider>
      </div>
    </div >
  );
}

export default App;
