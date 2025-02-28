package com.mladenov.reviewms.review.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.mladenov.reviewms.review.Review;
import com.mladenov.reviewms.review.dto.ReviewMessage;

@Service
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review) {
        ReviewMessage reviewMessage = new ReviewMessage()
                .setCompanyId(review.getCompanyId())
                .setRating(review.getRating())
                .setDescription(review.getDescription())
                .setTitle(review.getTitle())
                .setId(review.getId());

        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);
    }
}
