package employemangemnetSystem.EmployeSystem.service;

import employemangemnetSystem.EmployeSystem.dto.Employeedto;
import employemangemnetSystem.EmployeSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employeedto createEmployee(Employeedto employeedto);
    Employeedto FindEmployee( Long Employeeid);
    List<Employeedto> GetAllEmployee ();
    Employeedto UpdateEmployee(Long Employeeid, Employeedto update);
    void DeletedEmployee(Long id);
}
