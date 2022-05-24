package com.SpringProjectMavenJan.SpringProjectMavenJan.repository;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByName(String name);

    void deleteByName(String name);
}
