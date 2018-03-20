package hello.controller;

import hello.EmptyJsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import hello.model.*;
import hello.repository.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(path = "jobhours")
public class JobHoursController {
    @Autowired
    private JobHoursRepository jobHoursRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("")
    public @ResponseBody
    JobHours createJobHours(@Valid @RequestBody JobHours jobHours) {
        return jobHoursRepository.save(jobHours);
    }

    @GetMapping(path = {"", "/all"})
    public @ResponseBody
    Iterable<JobHours> getAllJobHours() {
        return jobHoursRepository.findAll();
    }
}
