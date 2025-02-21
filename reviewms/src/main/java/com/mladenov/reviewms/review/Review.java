package com.mladenov.reviewms.review;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;
    private Long companyId;


    public Long getId() {
        return id;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Review setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Review setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Review setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Review setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }
}
