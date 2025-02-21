package com.mladenov.jobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean deleteReview(Long companyId, Long reviewId);

    Review updateReview(Long companyId, Long reviewId, Review review);
}
