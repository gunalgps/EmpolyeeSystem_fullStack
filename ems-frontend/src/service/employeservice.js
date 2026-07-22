import axios from 'axios'

const rest_api_url = "http://localhost:8080/api/employees/GetAll"

const listEmployees = () => axios.get(rest_api_url);

export default listEmployees;