package hello.controller;

import hello.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import hello.model.Employee;
import hello.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // post an employee
    @PostMapping("")
    public @ResponseBody
    Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // get all employees which "/employee" or "/employee/all"
    @GetMapping(path = {"", "/all"})
    public @ResponseBody
    Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // get a specific employee
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeRepository.findOne(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    // get all the jobs for a specific employee
    @GetMapping("{id}/jobs")
    public ResponseEntity<Set<Job>> getEmployeesJobs(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeRepository.findOne(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        // return ResponseEntity.ok().body(employee.getJobs());
        return new ResponseEntity<>(employee.getJobs(), HttpStatus.OK);
    }

    // put (edit) an employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findOne(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        Employee updatedEmployee = employeeRepository.save(employee.merge(employeeDetails));
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete an employee
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeRepository.findOne(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
