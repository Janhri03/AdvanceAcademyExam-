package com.SpringProjectMavenJan.SpringProjectMavenJan.service;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Company;
import com.SpringProjectMavenJan.SpringProjectMavenJan.exception.RecordNotFoundException;
import com.SpringProjectMavenJan.SpringProjectMavenJan.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Primary
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company update(Company updatedCompany, Long id) {
        Company company = findById(id);
        company.setName(updatedCompany.getName());
        company.setWorkers(updatedCompany.getWorkers());
        return null;
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Фирма с ID: %s не е намерена!", id)));
    }

    @Override
    public Company findByName(String name) {
        return companyRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(String.format("Фирма с име %s не е намерена!", name)));
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        companyRepository.deleteByName(name);
    }
}
