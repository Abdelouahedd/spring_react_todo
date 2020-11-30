import React, { useState, useEffect } from 'react';
import { useTaskst } from '../context/list_context';
import { addTask, updateTask } from '../actions/taskActions';

const AddTodo = ({ isUpdate, setChangeToUpdate }) => {

    const { dispatch, state } = useTaskst();
    const [taskState, setTask] = useState("");

    useEffect(() => {
        setTask(state.task.task);
    }, [state.task.task]);

    const modifierTask = async (e) => {
        e.preventDefault();
        const task = {
            id: state.task?.id,
            task: taskState,
            completed: state.task?.completed
        }
        await dispatch(updateTask(task));
        await fetch(`http://localhost:8080/updateTodo/${task.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(task)
        });
        setChangeToUpdate(false);
        setTask('');
    }

    const onAddTask = async (e) => {
        e.preventDefault();
        const task = {
            id: Math.random(),
            task: taskState,
            completed: false
        }
        await dispatch(addTask(task));
        await fetch(`http://localhost:8080/addTodo`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(task)
        });
        setTask('');
    }

    return (
        <div className="col-12 col-sm-12 col-lg-12 col-xl-12">
            <form>
                <input type="text"
                    className="form-control mb-3"
                    name="task"
                    required
                    onChange={(e) => setTask(e.target.value)}
                    value={taskState}
                />
                {
                    isUpdate ?
                        <button type="submit" className="btn btn-success btn-block" onClick={(e) => modifierTask(e)}>Modifier</button>
                        :
                        <button type="submit" className="btn btn-primary btn-block" onClick={(e) => onAddTask(e)}>Ajouter</button>
                }
            </form>
        </div>
    );
}

export default AddTodo;
