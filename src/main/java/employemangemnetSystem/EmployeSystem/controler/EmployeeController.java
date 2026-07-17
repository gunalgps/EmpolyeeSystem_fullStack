package employemangemnetSystem.EmployeSystem.controler;

import employemangemnetSystem.EmployeSystem.dto.Employeedto;
import employemangemnetSystem.EmployeSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<Employeedto> createEmployee (@RequestBody Employeedto employeedto){
        Employeedto savedEmployee =employeeService.createEmployee(employeedto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
