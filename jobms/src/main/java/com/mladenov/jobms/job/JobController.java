package com.mladenov.jobms.job;

import com.mladenov.jobms.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id) {
        JobDTO job = jobService.findById(id);
        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @RequestBody Job job) {
        JobDTO job1 = jobService.updateJob(id, job);
        if (job1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJob(id);
        if (deleted) {
            return new ResponseEntity<>("Job deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}
