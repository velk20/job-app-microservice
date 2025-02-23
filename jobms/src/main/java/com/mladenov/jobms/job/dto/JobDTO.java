package com.mladenov.jobms.job.dto;

import java.util.List;

import com.mladenov.jobms.job.external.Company;
import com.mladenov.jobms.job.external.Review;

public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> review;

    public List<Review> getReview() {
        return review;
    }

    public JobDTO setReview(List<Review> review) {
        this.review = review;
        return this;
    }

    public Long getId() {
        return id;
    }

    public JobDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public JobDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public JobDTO setMinSalary(String minSalary) {
        this.minSalary = minSalary;
        return this;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public JobDTO setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public JobDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public JobDTO setCompany(Company company) {
        this.company = company;
        return this;
    }
}
