package hello.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
