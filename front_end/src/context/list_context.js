import React from "react";
import TaskReducer from "../reducers/taskReducer";

const initState = {
    task: {
        id: 0,
        task: "",
        completed: false
    },
    tasks: []
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

    return {
        state,
        dispatch,
    }
}