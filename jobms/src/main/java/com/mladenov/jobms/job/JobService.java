package com.mladenov.jobms.job;

import com.mladenov.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO findById(Long id);

    boolean deleteJob(Long id);

    JobDTO updateJob(Long id, Job job);
}
