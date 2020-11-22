import React from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import { addTask } from '../actions/taskActions';
import { useTaskst } from '../context/list_context';

const AddTodo = () => {
    const { dispatch } = useTaskst();

    const validate = Yup.object({
        task: Yup.string()
            .min(3, 'Must be 3 characters or more')
            .max(15, 'Must be 15 characters or less')
            .required('Required'),
    });


    const formik = useFormik({
        initialValues: {
            task: '',
        },
        validationSchema: validate,
        onSubmit: (values, actions) => {
            const task = {
                id: Math.random(),
                task: values.task,
                completed: false
            }
            // addTask(dispatch, task);
            console.log(task);
        },
    });
    return (
        <div className="col-12 col-sm-12 col-lg-12 col-xl-12">
            <form onSubmit={formik.handleSubmit}>
                <input type="text" className="form-control mb-3" name="task"
                    onChange={formik.handleChange}
                    value={formik.values.task} />
                {formik.touched.task && formik.errors.task ? (
                    <div className="alert alert-danger" role="alert">
                        <strong>
                            <div>{formik.errors.task}</div>
                        </strong>
                    </div>
                ) : null}
                <button type="submit" className="btn btn-primary btn-block">Ajouter</button>
            </form>
        </div>
    );
}

export default AddTodo;
