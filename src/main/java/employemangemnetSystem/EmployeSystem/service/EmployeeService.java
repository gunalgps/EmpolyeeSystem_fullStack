package employemangemnetSystem.EmployeSystem.service;

import employemangemnetSystem.EmployeSystem.dto.Employeedto;

import java.util.List;

public interface EmployeeService {
    Employeedto createEmployee(Employeedto employeedto);
    Employeedto FindEmployee( Long Employeeid);
    List<Employeedto> GetAllEmployee ();
    Employeedto UpdateEmployee(Long Employeeid);
}
