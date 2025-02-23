package com.mladenov.jobms.job.mapper;

import java.util.List;

import com.mladenov.jobms.job.Job;
import com.mladenov.jobms.job.dto.JobDTO;
import com.mladenov.jobms.job.external.Company;
import com.mladenov.jobms.job.external.Review;

public class JobMapper {
    public static JobDTO mapJobToDTO(Job job, Company company, List<Review> review) {
        return new JobDTO()
                .setId(job.getId())
                .setTitle(job.getTitle())
                .setCompany(company)
                .setLocation(job.getLocation())
                .setDescription(job.getDescription())
                .setMaxSalary(job.getMaxSalary())
                .setMinSalary(job.getMinSalary())
                .setReview(review);
    }
}
