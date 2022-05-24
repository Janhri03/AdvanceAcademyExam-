package com.SpringProjectMavenJan.SpringProjectMavenJan.service;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);

    List<Company> findAll();

    Company update(Company updatedCompany, Long id);

    Company findById(Long id);

    Company findByName(String name);

    void deleteById(Long id);

    void deleteByName(String name);
}
