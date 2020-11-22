import React from "react";
import TaskReducer from "../reducers/taskReducer";
import { addTask } from "../actions/taskActions"

const initState = [
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

export const Taskscontext = React.createContext();

export default function TaskProvider({ children }) {
    const [state, dispatch] = React.useReducer(TaskReducer, initState);
    const tasks = React.useMemo(() => [state, dispatch], [state]);

    return (
        <Taskscontext.Provider
            value={tasks}
        >
            {children}
        </Taskscontext.Provider>
    );
}

export function useTaskst() {
    const context = React.useContext(Taskscontext)
    if (!context) {
        throw new Error(`useCount must be used within a CountProvider`)
    }
    const [state, dispatch] = context

    return {
        state,
        dispatch,
        addTask,
    }
}