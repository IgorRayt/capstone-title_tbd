package hello.controller;

import javax.validation.Valid;

import hello.EmptyJsonResponse;
import hello.model.Customer;
import hello.model.Employee;
import hello.repository.CustomerRepository;
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

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("")
    public @ResponseBody
    Job createJob(@Valid @RequestBody Job job) {
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
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(job);
    }

    @PutMapping("{id}")
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") Long jobId,
                                         @Valid @RequestBody Job jobDetails) {
        Job job = jobRepository.findOne(jobId);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }

        Job updatedJob = jobRepository.save(job.merge(jobDetails));
        return ResponseEntity.ok(updatedJob);
    }

    // set a job as available
    @PutMapping("{id}/available")
    public ResponseEntity<Job> setJobAvailability(
            @PathVariable(value = "id") Long jobId
    ) {
        Job job = jobRepository.findOne(jobId);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        job.setAvailable(true);

        Job updatedJob = jobRepository.save(job);

        return ResponseEntity.ok(updatedJob);
    }

    // add an employee to a job
    @PutMapping("{id}/employee/{employeeId}")
    public ResponseEntity<Job> addEmployeeToJob(
            @PathVariable(value = "id") Long jobId,
            @PathVariable(value = "employeeId") Long employeeId
    ) {
        Job job = jobRepository.findOne(jobId);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        Employee employee = employeeRepository.findOne(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        job.getEmployees().add(employee);

        Job updatedJob = jobRepository.save(job);

        return ResponseEntity.ok(updatedJob);
    }

    // add an employee to a job
    @PutMapping("{id}/customer/{customerId}")
    public ResponseEntity<Job> addCustomerToJob(
            @PathVariable(value = "id") Long jobId,
            @PathVariable(value = "customerId") Long customerId
    ) {
        Job job = jobRepository.findOne(jobId);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        Customer customer = customerRepository.findOne(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        job.setCustomer(customer);

        Job updatedJob = jobRepository.save(job);

        return ResponseEntity.ok(updatedJob);
    }

    // remove an employee from a job TODO
    @DeleteMapping("{id}/employee/{employeeId}")
    public ResponseEntity<Job> deleteEmployeeFromJob(
            @PathVariable(value = "id") Long jobId,
            @PathVariable(value = "employeeId") Long employeeId
    ) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteJob(@PathVariable(value = "id") Long jobId) {
        Job job = jobRepository.findOne(jobId);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }

        jobRepository.delete(job);
        return new ResponseEntity<>(new EmptyJsonResponse(), HttpStatus.OK);
    }
}
