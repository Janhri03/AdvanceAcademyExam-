package com.SpringProjectMavenJan.SpringProjectMavenJan.repository;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

    void deleteByName(String name);
}
