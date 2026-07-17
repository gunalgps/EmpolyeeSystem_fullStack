package employemangemnetSystem.EmployeSystem.controler;

import employemangemnetSystem.EmployeSystem.dto.Employeedto;
import employemangemnetSystem.EmployeSystem.entity.Employee;
import employemangemnetSystem.EmployeSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    
    // build get employee
    @GetMapping("/{Employeeid}")
    public ResponseEntity<Employeedto> getEmployeId(@PathVariable Long Employeeid){
        Employeedto employeedto=employeeService.FindEmployee( Employeeid);
        return new ResponseEntity<>(employeedto ,HttpStatus.OK);
    }
    // Build get All Employuee
    
    @GetMapping("/GetAll")
    public ResponseEntity<List<Employeedto>> getAllEmployee(){
        List<Employeedto> employees =employeeService.GetAllEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
                
    }

}
