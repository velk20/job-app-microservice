package com.mladenov.jobms.job.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mladenov.jobms.job.external.Review;

@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<Review> getReviews(@RequestParam Long companyId);
}
