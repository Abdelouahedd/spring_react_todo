import React from 'react'
import { useTaskst } from '../context/list_context'

export default function ListTodos() {
    const { state } = useTaskst();

    return (
        <div className=" justify-content-md-center">
            <ul className="list-group list-group-flush">
                {
                    state?.map(el => <li key={el.id} className="list-group-item">
                        <div className="form-row ml-4">
                            <div className="col-10 form-check">
                                <input className="form-check-input" type="checkbox" value={el.completed} defaultChecked={el.completed} id="defaultCheck1" />
                                <label className="form-check-label" htmlFor="defaultCheck1">
                                    {el.task}
                                </label>
                            </div>

                            <div className="col-1">
                                <button className="btn btn-success">
                                    <i className="fa fa-pen" aria-hidden="true"></i>
                                </button>
                            </div>
                            <div className="col-1">
                                <button className="btn btn-danger">
                                    <i className="fa fa-trash" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>
                    </li>)
                }
            </ul>
        </div >
    )
}
