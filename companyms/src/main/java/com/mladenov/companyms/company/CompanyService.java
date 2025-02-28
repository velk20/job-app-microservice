package com.mladenov.companyms.company;

import java.util.List;

import com.mladenov.companyms.company.dto.ReviewMessage;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    Company updateCompany(Company company, Long id);
    void createCompany(Company company);
    boolean deleteCompany(Long id);

    void updateCompanyRating(ReviewMessage reviewMessage);
}
