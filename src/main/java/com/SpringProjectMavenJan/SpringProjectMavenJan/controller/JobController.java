package com.SpringProjectMavenJan.SpringProjectMavenJan.controller;

import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.JobResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.JobSaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobController {

    ResponseEntity<JobResponse> save(JobSaveRequest jobSaveRequest);

    ResponseEntity<List<JobResponse>> findAll();

    ResponseEntity<JobResponse> findByName(String name);

    ResponseEntity<JobResponse> findById(Long id);

    ResponseEntity<HttpStatus> deleteByName(String name);

    ResponseEntity<HttpStatus> deleteById(Long id);
}
