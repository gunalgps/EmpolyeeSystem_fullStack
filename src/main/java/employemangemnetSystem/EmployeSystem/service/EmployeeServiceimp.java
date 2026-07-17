package employemangemnetSystem.EmployeSystem.service;

import employemangemnetSystem.EmployeSystem.dto.Employeedto;
import employemangemnetSystem.EmployeSystem.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import employemangemnetSystem.EmployeSystem.Wapper.EmployeeWrapper;
import employemangemnetSystem.EmployeSystem.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceimp implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public Employeedto createEmployee(Employeedto employeedto) {
        Employee employee= EmployeeWrapper.mapToEmployee(employeedto);

        Employee createEmployee=employeeRepository.save(employee);
        return  EmployeeWrapper.mapToEmployeeDto(createEmployee);

    }
}
