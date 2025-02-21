package com.mladenov.jobms.job;

import com.mladenov.jobms.job.dto.JobWithCompanyDTO;
import com.mladenov.jobms.job.external.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<JobWithCompanyDTO> result = new ArrayList<>();

        List<Job> jobs = jobRepository.findAll();
        for (Job job : jobs) {
            Company company = getCompany(job);
            result.add(new JobWithCompanyDTO(job, company));
        }

        return result;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobWithCompanyDTO findById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null){
            Company company = getCompany(job);
            return new JobWithCompanyDTO(job, company);
        }

        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        JobWithCompanyDTO job = findById(id);
        if (job == null) {
            return false;
        }
        jobRepository.deleteById(id);
        return true;
    }

    @Override
    public JobWithCompanyDTO updateJob(Long id, Job job) {
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
        return new JobWithCompanyDTO(saved, company);
    }

    private static Company getCompany(Job job) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8081/companies/" + job.getCompanyId(), Company.class);
    }
}
