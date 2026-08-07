import React,{useState,useEffect} from 'react'
import listEmployees, { deleteEmployee } from '../service/employeservice'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {
    const[employees,setEmployees] = useState([])
    const navigate = useNavigate()

        const fetchEmployees = () => {
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch((error) => {
            console.error(error);
        });
    }

    useEffect(() => {
        fetchEmployees();
    }, [])
   
    function addnewEmployee(){
        navigate('/add-employee')
    }

    function updateemployee(id){
        navigate(`/update-employee/${id}`)
    }

    function deleteEmployeeById(id) {
        if (!window.confirm('Are you sure you want to delete this employee?')) {
            return;
        }

        deleteEmployee(id)
            .then(() => {
                setEmployees((prev) => prev.filter((employee) => employee.id !== id));
            })
            .catch((error) => {
                console.error(error);
            });
    }

   
    return (
        <div> 
            <h2> List Employee</h2>
            <button className='btn btn-primary' onClick={addnewEmployee}>
                Add Employee
            </button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email Id</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>{
                    employees.map((employee) => (
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.FristName}</td>
                            <td>{employee.LastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className='btn btn-info' onClick={() => updateemployee(employee.id)}>Update</button>
                            
                            
                                <button className='btn btn-danger' onClick={() => deleteEmployeeById(employee.id)} style={{ marginLeft: '10px' }}>Delete</button>
                            </td>
                        </tr>
                    ))
                }</tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent