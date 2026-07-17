package employemangemnetSystem.EmployeSystem.service;

import employemangemnetSystem.EmployeSystem.dto.Employeedto;
import employemangemnetSystem.EmployeSystem.entity.Employee;
import employemangemnetSystem.EmployeSystem.execpection.ResourceNotFoundExpection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import employemangemnetSystem.EmployeSystem.Wapper.EmployeeWrapper;
import employemangemnetSystem.EmployeSystem.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Employeedto FindEmployee(Long Employeeeid) {
        Employee employee =employeeRepository.findById(Employeeeid).orElseThrow(
                () -> new ResourceNotFoundExpection("Employee is nt able exist with given Id"+ Employeeeid)

        );
        return  EmployeeWrapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<Employeedto> GetAllEmployee() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeWrapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public Employeedto UpdateEmployee(Long Employeeid) {
        Employee employee = employeeRepository.findById().orElseThrow(
                () -> new ResourceNotFoundExpection("Employe not foundd"));
        employee.setFristName(UpdateEmployee.getFristName());
        employee.getLastName(UpdateEmployee.getLastName());
        employee.getEmail(UpdateEmployee.getEmail());

        Employee UpdatedEmployee =employeeRepository.save(employee);
        return EmployeeWrapper.mapToEmployeeDto(UpdatedEmployee);


    }

}
