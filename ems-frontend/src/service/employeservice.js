import axios from 'axios'

const rest_api_url = "http://localhost:8080/api/employees/GetAll"

const listEmployees = () => axios.get(rest_api_url);

export default listEmployees;

export const addEmployee = (employee) => {
    return axios.post("http://localhost:8080/api/employees", employee);
}

export const getEmployeeById = (id) => {
    return axios.get(`http://localhost:8080/api/employees/${id}`);
}

export const updateEmployee = (id, employee) => {
    return axios.put(`http://localhost:8080/api/employees/${id}`, employee);
}

export const deleteEmployee = (id) => {
    return axios.delete(`http://localhost:8080/api/employees/${id}`);
}