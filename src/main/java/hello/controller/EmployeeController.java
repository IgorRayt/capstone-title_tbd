package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import hello.model.Employee;
import hello.model.EmergencyContact;
import hello.repository.EmployeeRepository;
import hello.repository.EmergencyContactRepository;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    @PostMapping("")
    public @ResponseBody Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping(path = {"", "/all"})
    public @ResponseBody
    Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeRepository.findOne(employeeId);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findOne(employeeId);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }

        Employee updatedEmployee = employeeRepository.save(employee.merge(employeeDetails));
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeRepository.findOne(employeeId);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
