package hello.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

        Job updatedEmployee = jobRepository.save(job.merge(jobDetails));
        return ResponseEntity.ok(updatedEmployee);
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
