
export const addTask = (task) => {
    return {
        type: "ADD_TASK",
        payload: task
    };
}

export const updateTask = (task) => {
    return {
        type: "UPDATE_TASK",
        payload: task
    };
}

export const deleteTask = (task) => {
    return {
        type: "DELETE_TASK",
        payload: task
    };
}

export const getAllTask = (tasks) => {
    return {
        type: "GET_ALL_TASKS",
        payload: tasks
    }
}

export const getTask = (task) => {
    return {
        type: "GET_TASK",
        payload: task
    }
}