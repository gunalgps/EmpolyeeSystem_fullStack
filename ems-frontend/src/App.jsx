import './App.css'
import ListEmployeeComponent from './Compents/listemployeecompent.jsx'
import HeaderComponent from './Compents/HeaderComponents.jsx'
import FotterComponent from './Compents/FotterComponent.jsx'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { EmployeeCompents } from './Compents/EmployeeCompents.jsx'

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<ListEmployeeComponent />} />
          <Route path="/employees" element={<ListEmployeeComponent />} />
          <Route path="/add-employee" element={<EmployeeCompents />} />/

          <Route path="/update-employee/:id" element={<EmployeeCompents />} />
        </Routes>
        <FotterComponent />
      </BrowserRouter>
    </>
  )
}

export default App

