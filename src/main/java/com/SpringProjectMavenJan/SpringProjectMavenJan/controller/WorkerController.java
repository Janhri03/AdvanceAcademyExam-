package com.SpringProjectMavenJan.SpringProjectMavenJan.controller;

import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerSaveRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkerController {

    ResponseEntity<WorkerResponse> save(WorkerSaveRequest workerSaveRequest);

    ResponseEntity<List<WorkerResponse>> findAll();

    ResponseEntity<WorkerResponse> update(WorkerUpdateRequest workerUpdateRequest);

    ResponseEntity<WorkerResponse> findById(Long id);

    ResponseEntity<WorkerResponse> findByName(String name);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<HttpStatus> deleteByName(String name);
}
