package com.mladenov.jobapp.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mladenov.jobapp.job.Job;
import com.mladenov.jobapp.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public Company setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public Company setJobs(List<Job> jobs) {
        this.jobs = jobs;
        return this;
    }
}
