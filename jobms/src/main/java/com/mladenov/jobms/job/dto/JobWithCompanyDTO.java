package com.mladenov.jobms.job.dto;

import com.mladenov.jobms.job.Job;
import com.mladenov.jobms.job.external.Company;

public class JobWithCompanyDTO {
    private Job job;
    private Company company;

    public JobWithCompanyDTO(Job job, Company company) {
        this.job = job;
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public JobWithCompanyDTO setJob(Job job) {
        this.job = job;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public JobWithCompanyDTO setCompany(Company company) {
        this.company = company;
        return this;
    }
}
