package com.mladenov.jobms.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface JobRepository extends JpaRepository<Job, Long> {

}
