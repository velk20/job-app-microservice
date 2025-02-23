package com.mladenov.jobms.job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /**
     * Load Balanced is needed for Eureka Service Regestry
     * In order to use the rest template with the name of the service
     * @example: http://COMPANY-SERVICE:8081/companies/"
     */

    //Example:
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
