package com.mladenov.jobapp.job;

import com.mladenov.jobapp.company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    private Company company;

    public Job() {
    }

    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public Job setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Job setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Job setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public Job setMinSalary(String minSalary) {
        this.minSalary = minSalary;
        return this;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public Job setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Job setLocation(String location) {
        this.location = location;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Job setCompany(Company company) {
        this.company = company;
        return this;
    }
}
