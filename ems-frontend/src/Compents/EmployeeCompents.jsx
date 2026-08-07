import React,{useState,useEffect} from 'react'
import { addEmployee, getEmployeeById, updateEmployee,  } from '../service/employeservice'
import { useNavigate, useParams } from 'react-router-dom';

export const EmployeeCompents = () => {
    const { id } = useParams();
    const [FristName, setFristName] = useState('')
    const [LastName, setLastName] = useState('')
    const [email, setEmail] = useState('') 

    const [error, setError] = useState({
        FristName: '', LastName: '', email: ''
    }
    );
    const navigate = useNavigate();
    function deleteEmployee(id) {
        window.confirm("Are you sure you want to delete this employee?") && fetch(`http://localhost:8080/api/employees/${id}`, {
            method: 'DELETE',
        })
    }
   
    useEffect(() => {
        if(id) {
            getEmployeeById(id).then((response) => {
                setFristName(response.data.FristName);
                setLastName(response.data.LastName);
                setEmail(response.data.email);
            }).catch((error) => {
                console.error(error);
            });
        }
    }, [id]);

    function saveemployee(e){
        e.preventDefault();
        if(validateForm()) {
            const employee = {FristName, LastName, email}
            console.log(employee)
            const request = id ? updateEmployee(id, employee) : addEmployee(employee);
            request.then((response) => {
                console.log(response.data)
                navigate('/employees')
            }).catch((error) => {
                console.error(error)
            })
        }
    }
    function pagetite(){
        if(id){
            return <h2 className='text-center'>Update Employee</h2>
        }else{
            return <h2 className='text-center'>Add Employee</h2>
        }
    }

    function validateForm() {
        let isValid = true;
        const copyerror = { ...error };
        if(FristName.trim()) {
            copyerror.FristName = '';
        } else {
            copyerror.FristName = 'first name is required';
            isValid = false;
        }
        if(LastName.trim()) {
            copyerror.LastName = '';
        } else {
            copyerror.LastName = 'last name is required';
            isValid = false;
        }
        if(email.trim()) {
            copyerror.email = '';
        } else {
            copyerror.email = 'email is required';
            isValid = false;
        }
        setError(copyerror);
        return isValid;
    }
//
    

  return (
    <div>
        <div className='container'>
            <br />
            <div className='Row'><div className='card col-md-6 offset-md-3 offset-md-3'>
            {pagetite()}
            <div className='card-body'>
                <form>
                    <div className='form-group mb-2'>   
                        <label className='form-label'>First Name :</label>
                        <input type='text' placeholder='Enter First Name' name='firstName' className={`form-control ${error.FristName ? 'is-invalid' : ''}`}
                        value={FristName} onChange={(e) => setFristName(e.target.value)}></input>
                        {error.FristName && <div className='invalid-feedback'>{error.FristName}</div>}
                    </div>
                    <div className='form-group mb-2'>   
                        <label className='form-label'>Last Name :</label>
                        <input type='text' placeholder='Enter Last Name' name='lastName' className={`form-control ${error.LastName ? 'is-invalid' : ''}`}
                        value={LastName} onChange={(e) => setLastName(e.target.value)}></input>
                        {error.LastName && <div className='invalid-feedback'>{error.LastName}</div>}
                    </div>
                    <div className='form-group mb-2'>
                        <label className='form-label'>Email :</label>
                        <input type='text' placeholder='Enter Email' name='email' className={`form-control ${error.email ? 'is-invalid' : ''}`}
                        value={email} onChange={(e) => setEmail(e.target.value)}></input>
                        {error.email && <div className='invalid-feedback'>{error.email}</div>}
                    </div>
                    <button className='btn btn-success' type='submit' onClick={saveemployee}>Submit</button>
                </form>

            </div>
            
        </div></div></div>
    </div>
  )
}
