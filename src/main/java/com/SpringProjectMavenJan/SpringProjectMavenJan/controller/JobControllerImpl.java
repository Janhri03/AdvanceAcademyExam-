package com.SpringProjectMavenJan.SpringProjectMavenJan.controller;

import com.SpringProjectMavenJan.SpringProjectMavenJan.converter.JobConverter;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.JobResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.JobSaveRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;
import com.SpringProjectMavenJan.SpringProjectMavenJan.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/jobs")
public class JobControllerImpl implements JobController{

    private final JobService jobService;
    private final JobConverter jobConverter;

    @Override
    @PostMapping
    public ResponseEntity<JobResponse> save(@RequestBody @Valid JobSaveRequest jobSaveRequest) {
        Job job = jobConverter.convert(jobSaveRequest);
        Job savedJob = jobService.save(job);
        JobResponse jobResponse = jobConverter.convert(savedJob);
        return ResponseEntity.ok().body(jobResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<JobResponse>> findAll() {
        return ResponseEntity.ok(jobService.findAll().stream().map(jobConverter::convert).collect(Collectors.toList()));
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<JobResponse> findByName(@PathVariable String name) {
        Job job = jobService.findByName(name);
        JobResponse jobResponse = jobConverter.convert(job);
        return ResponseEntity.ok().body(jobResponse);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<JobResponse> findById(@PathVariable Long id) {
        Job job = jobService.findById(id);
        JobResponse jobResponse = jobConverter.convert(job);
        return ResponseEntity.ok().body(jobResponse);
    }

    @Override
    @DeleteMapping(value = "/delete/name/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        jobService.deleteByName(name);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/delete/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        jobService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
