package com.mladenov.jobms.job.mapper;

import com.mladenov.jobms.job.Job;
import com.mladenov.jobms.job.dto.JobWithCompanyDTO;
import com.mladenov.jobms.job.external.Company;

public class JobMapper {
    public static JobWithCompanyDTO getJobWithCompanyDTO(Job job, Company company) {
        return new JobWithCompanyDTO()
                .setId(job.getId())
                .setTitle(job.getTitle())
                .setCompany(company)
                .setLocation(job.getLocation())
                .setDescription(job.getDescription())
                .setMaxSalary(job.getMaxSalary())
                .setMinSalary(job.getMinSalary());
    }
}
