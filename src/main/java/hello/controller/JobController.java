package hello.controller;

import javax.validation.Valid;

import hello.model.Employee;
import hello.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import hello.model.Job;
import hello.repository.JobRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "job")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("")
    public @ResponseBody Job createJob(@Valid @RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping(path = {"", "/all"})
    public @ResponseBody
    Iterable<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Job> getJobById(@PathVariable(value = "id") Long jobId) {
        Job job = jobRepository.findOne(jobId);
        if(job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(job);
    }

    @PutMapping("{id}")
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") Long jobId,
                                                   @Valid @RequestBody Job jobDetails) {
        Job job = jobRepository.findOne(jobId);
        if(job == null) {
            return ResponseEntity.notFound().build();
        }

        Job updatedJob = jobRepository.save(job.merge(jobDetails));
        return ResponseEntity.ok(updatedJob);
    }

    @PutMapping("{id}/{employeeId}")
    public ResponseEntity<Job> addEmployeeToJob(
            @PathVariable(value = "id") Long jobId,
            @PathVariable(value = "employeeId") Long employeeId)
    {
        System.out.println("PUT {id}/{employeeId}");
        Job job = jobRepository.findOne(jobId);
        if(job == null) {
            System.out.println("job is null");
            return ResponseEntity.notFound().build();
        }
        Employee employee = employeeRepository.findOne(employeeId);
        if(employee == null) {
            System.out.println("employee is null");
            return ResponseEntity.notFound().build();
        }

        job.getEmployees().add(employee);

        Job updatedJob = jobRepository.save(job);

        return ResponseEntity.ok(updatedJob);

        // return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Job> deleteJob(@PathVariable(value = "id") Long jobId) {
        Job job = jobRepository.findOne(jobId);
        if(job == null) {
            return ResponseEntity.notFound().build();
        }

        jobRepository.delete(job);
        return ResponseEntity.ok().build();
    }
}
