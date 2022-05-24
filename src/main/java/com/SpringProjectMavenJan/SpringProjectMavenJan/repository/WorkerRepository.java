package com.SpringProjectMavenJan.SpringProjectMavenJan.repository;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Optional<Worker> findByName(String name);

    void deleteByName(String name);
}
