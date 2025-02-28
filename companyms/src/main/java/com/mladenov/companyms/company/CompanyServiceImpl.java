package com.mladenov.companyms.company;

import org.springframework.stereotype.Service;

import java.util.List;

import com.mladenov.companyms.company.dto.ReviewMessage;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);

    }

    @Override
    public Company updateCompany(Company company, Long id) {
        Company company1 = getCompanyById(id);
        if (company1 == null) {
            return null;
        }
        company1.setName(company.getName());
        company1.setDescription(company.getDescription());
        return companyRepository.save(company1);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        System.out.println(reviewMessage.getDescription());
    }

}
