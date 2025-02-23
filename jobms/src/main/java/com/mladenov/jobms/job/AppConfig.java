package com.mladenov.jobms.job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /**
     * Load Balanced is needed for Eureka Service Registry
     * In order to use the rest template with the name of the service
     * @example: http://COMPANY-SERVICE:8081/companies/
     * @otherwise we need to use this: http://localhost:8081/companies/
     */

    /**
     * That's why OpenFeign is better
     * , we are not needed to create this @LoadBalanced Bean
     * we only create an interface with @FeignClient
     * and define the endpoints
     * check:
     * {@link com.mladenov.jobms.job.clients.CompanyClient}
     * and
     * {@link com.mladenov.jobms.job.clients.ReviewClient}
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
