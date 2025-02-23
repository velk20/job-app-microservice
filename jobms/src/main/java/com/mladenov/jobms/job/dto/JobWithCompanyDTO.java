package com.mladenov.jobms.job.dto;

import com.mladenov.jobms.job.Job;
import com.mladenov.jobms.job.external.Company;

public class JobWithCompanyDTO {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;

    public Long getId() {
        return id;
    }

    public JobWithCompanyDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public JobWithCompanyDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobWithCompanyDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public JobWithCompanyDTO setMinSalary(String minSalary) {
        this.minSalary = minSalary;
        return this;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public JobWithCompanyDTO setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public JobWithCompanyDTO setLocation(String location) {
        this.location = location;
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
