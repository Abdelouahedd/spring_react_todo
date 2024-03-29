import React, { useCallback, useEffect } from 'react'
import { deleteTask, getAllTask, getTask, updateTask } from '../actions/taskActions';
import { useTaskst } from '../context/list_context'

export default function ListTodos(props) {

    const { state, dispatch } = useTaskst();

    const selectTask = (task) => {
        dispatch(getTask(task));
        props.onUpdate()
    }


    const getDate = useCallback(
        async () => {
            const res = await fetch(`${process.env.REACT_APP_PROD_API}/listTodos`);
            const tasks = await res.json();
            console.log("tasks --> ",tasks);
            dispatch(getAllTask(tasks));
        },
        [dispatch],
    )


    useEffect(() => {
        console.log(`${process.env.REACT_APP_PROD_API}/listTodos`);
        getDate();
    }, [getDate]);


    const onCompleteTask = async (task) => {
        const newTask = { ...task, completed: !task.completed }
        await dispatch(updateTask(newTask));
        await fetch(`${process.env.REACT_APP_PROD_API}/updateTodo/${task.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(newTask)
        });
    }

    const removeTask = async (task) => {
        await dispatch(deleteTask(task));
        await fetch(`${process.env.REACT_APP_PROD_API}/deleteTodo/${task.id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
        });
    }

    return (
        <div className=" justify-content-md-center">
            <ul className="list-group list-group-flush">
                {
                    state?.tasks.map(el =>
                        <li key={el.id} className="list-group-item">
                            <div className="form-row ml-4">
                                <div className="col-10 form-check">
                                    <input className="form-check-input" type="checkbox"
                                        value={el.completed}
                                        defaultChecked={el.completed}
                                        id="defaultCheck1"
                                        onChange={() => onCompleteTask(el)}

                                    />
                                    <label className="form-check-label" htmlFor="defaultCheck1">
                                        {el.task}
                                    </label>
                                </div>

                                <div className="col-1">
                                    <button className="btn btn-success" onClick={() => selectTask(el)}>
                                        <i className="fa fa-pen" aria-hidden="true"></i>
                                    </button>
                                </div>
                                <div className="col-1">
                                    <button className="btn btn-danger" onClick={() => removeTask(el)}>
                                        <i className="fa fa-trash" aria-hidden="true"></i>
                                    </button>
                                </div>
                            </div>
                        </li>
                    )
                }
            </ul>
        </div >
    )
}
