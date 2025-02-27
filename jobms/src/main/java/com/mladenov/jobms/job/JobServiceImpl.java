package com.mladenov.jobms.job;

import com.mladenov.jobms.job.clients.CompanyClient;
import com.mladenov.jobms.job.clients.ReviewClient;
import com.mladenov.jobms.job.dto.JobDTO;
import com.mladenov.jobms.job.external.Company;
import com.mladenov.jobms.job.external.Review;
import com.mladenov.jobms.job.mapper.JobMapper;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final RestTemplate restTemplate;
    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository, RestTemplate restTemplate, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.restTemplate = restTemplate;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
//    @CircuitBreaker(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
//    @Retry(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
//    @RateLimiter(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
    public List<JobDTO> findAll() {
        List<JobDTO> result = new ArrayList<>();

        List<Job> jobs = jobRepository.findAll();
        for (Job job : jobs) {
            Company company = getCompany(job);
            List<Review> review = getReviews(company);
            result.add(JobMapper.mapJobToDTO(job, company, review));
        }

        return result;
    }

    public List<String> companyBreakerFallback(Exception ex) {
        List<String> result = new ArrayList<>();
        result.add("Dummy");
        return result;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO findById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null){
            Company company = getCompany(job);
            List<Review> review = getReviews(company);

            return JobMapper.mapJobToDTO(job, company, review);
        }

        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        JobDTO job = findById(id);
        if (job == null) {
            return false;
        }
        jobRepository.deleteById(id);
        return true;
    }

    @Override
    public JobDTO updateJob(Long id, Job job) {
        Job job1 = jobRepository.findById(id).orElse(null);
        if (job1 == null) {
            return null;
        }

        job1    .setDescription(job.getDescription())
                .setLocation(job.getLocation())
                .setTitle(job.getTitle())
                .setMaxSalary(job.getMaxSalary())
                .setMinSalary(job.getMinSalary())
                .setCompanyId(job.getCompanyId());

        Job saved = jobRepository.save(job1);
        Company company = getCompany(saved);
        List<Review> review = getReviews(company);

        return JobMapper.mapJobToDTO(saved, company, review);
    }

    private Company getCompany(Job job) {
        return companyClient.getCompany(job.getCompanyId());
    }

    private List<Review> getReviews(Company company) {
        return reviewClient.getReviews(company.getId());
    }

    /**
     * OLD Rest Template way of communication to other services
     */
//    private Company getCompany(Job job) {
//        return restTemplate.getForObject("http://COMPANY-SERVICE:8081/companies/" + job.getCompanyId(), Company.class);
//    }
//
//
//    private List<Review> getReview(Company company) {
//        //exchange is used when we return List<?>
//        ResponseEntity<List<Review>> reviews = restTemplate.exchange(
//                "http://REVIEW-SERVICE:8083/reviews?companyId=" + company.getId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Review>>() {
//                });
//
//        return reviews.getBody();
//    }
}
