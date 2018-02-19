package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hello.model.Employee;
import hello.repository.EmployeeRepository;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("")
    public @ResponseBody Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping(path = {"", "/all"})
    public @ResponseBody
    Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
