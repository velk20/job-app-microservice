package com.mladenov.jobms.job;

import com.mladenov.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDTO> findAll();
    void createJob(Job job);
    JobWithCompanyDTO findById(Long id);

    boolean deleteJob(Long id);

    JobWithCompanyDTO updateJob(Long id, Job job);
}
