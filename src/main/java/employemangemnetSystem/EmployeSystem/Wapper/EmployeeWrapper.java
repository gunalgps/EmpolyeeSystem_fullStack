package employemangemnetSystem.EmployeSystem.Wapper;

import employemangemnetSystem.EmployeSystem.dto.Employeedto;
import employemangemnetSystem.EmployeSystem.entity.Employee;

public class EmployeeWrapper {
    public static Employeedto mapToEmployeeDto(Employee employee){
        return new Employeedto(
                employee.getId(),
                employee.getFristName(),
                employee.getLastName(),
                employee.getEmail()

        );
    }
    public static Employee mapToEmployee(Employeedto employeedto ){

        return new Employee(
                employeedto.getId(),
                employeedto.getFristName(),
                employeedto.getLastName(),
                employeedto.getEmail()
        );
    }
}
