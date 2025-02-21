package com.mladenov.jobapp.job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        Job job = findById(id);
        if (job == null) {
            return false;
        }
        jobRepository.delete(job);
        return true;
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Job job1 = findById(id);
        if (job1 == null) {
            return null;
        }

        job1.setDescription(job.getDescription());
        job1.setLocation(job.getLocation());
        job1.setTitle(job.getTitle());
        job1.setMaxSalary(job.getMaxSalary());
        job1.setMinSalary(job.getMinSalary());


        return jobRepository.save(job1);
    }
}
