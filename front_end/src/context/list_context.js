import React from "react";
import TaskReducer from "../reducers/taskReducer";

const initState = {
    tasks: [
        {
            id: 1,
            task: "learn spring",
            completed: false
        },
        {
            id: 2,
            task: "learn nextJS",
            completed: false
        },
        {
            id: 3,
            task: "learn ReactJS and express js",
            completed: true
        }
    ]
}

export const Taskscontext = React.createContext();

export default function TaskProvider({ children }) {
    const [state, dispatch] = React.useReducer(TaskReducer, initState);
    const tasks = React.useMemo(() => [state, dispatch], [state]);

    return (
        <Taskscontext.Provider value={tasks}>
            {children}
        </Taskscontext.Provider>
    );
}

export function useTaskst() {
    const context = React.useContext(Taskscontext)
    if (!context) {
        throw new Error(`useTask must be used within a TaskProvider`)
    }
    const [state, dispatch] = context

    const addTask = (task) => dispatch({ type: "ADD_TASK", payload: task });

    return {
        state,
        dispatch,
        addTask,
    }
}