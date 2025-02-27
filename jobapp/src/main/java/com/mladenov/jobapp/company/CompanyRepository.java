package com.mladenov.jobapp.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
