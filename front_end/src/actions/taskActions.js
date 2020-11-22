
export const addTask = (dispatch, task) => {
    dispatch({ type: "ADD_TASK", payload: task });
}