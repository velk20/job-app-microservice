package com.mladenov.jobms.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job findById(Long id);

    boolean deleteJob(Long id);

    Job updateJob(Long id, Job job);
}
