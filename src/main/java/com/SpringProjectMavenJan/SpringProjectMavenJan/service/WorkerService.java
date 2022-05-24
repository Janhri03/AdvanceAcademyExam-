package com.SpringProjectMavenJan.SpringProjectMavenJan.service;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Worker;

import java.util.List;

public interface WorkerService {

    Worker save(Worker worker);

    List<Worker> findAll();

    Worker update(Worker updatedWorker, Long id);

    Worker findById(Long id);

    Worker findByName(String name);

    void deleteById(Long id);

    void deleteByName(String name);
}
