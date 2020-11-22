
const TaskReducer = (state  , action) => {
    switch (action.type) {
        case "GET_ALL_TASKS":
            return {
                ...state,
                tasks: action.payload
            };
        case "ADD_TASK":
            return {
                ...state,
                tasks: state.tasks.concat(action.payload)
            };
        case "DELETE_TASK":
            return {
                ...state,
                tasks: state.tasks.filter(task => task.id !== action.payload)
            };
        case "UPDATE_TASK":
            return {
                tasks: state.tasks.map(
                    task =>
                        task.id === action.payload.id ?
                            task = action.payload :
                            task
                )
            };
        default:
            return {
                ...state
            }
    }
}
export default TaskReducer;