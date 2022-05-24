package com.SpringProjectMavenJan.SpringProjectMavenJan.service;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;

import java.util.List;

public interface JobService {

    Job save(Job job);

    List<Job> findAll();

    Job findById(Long id);

    Job findByName(String name);

    void deleteById(Long id);

    void deleteByName(String name);
}
