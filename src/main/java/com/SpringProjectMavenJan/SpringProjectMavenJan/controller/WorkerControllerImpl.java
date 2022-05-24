package com.SpringProjectMavenJan.SpringProjectMavenJan.controller;

import com.SpringProjectMavenJan.SpringProjectMavenJan.converter.WorkerConverter;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerSaveRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerUpdateRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Worker;
import com.SpringProjectMavenJan.SpringProjectMavenJan.service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/workers")
public class WorkerControllerImpl implements WorkerController{

    private final WorkerService workerService;
    private final WorkerConverter workerConverter;

    @Override
    @PostMapping
    public ResponseEntity<WorkerResponse> save(@RequestBody @Valid WorkerSaveRequest workerSaveRequest) {
        Worker worker = workerConverter.convert(workerSaveRequest);
        Worker savedWorker = workerService.save(worker);
        WorkerResponse workerResponse = workerConverter.convert(savedWorker);
        return ResponseEntity.ok().body(workerResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<WorkerResponse>> findAll() {
        return ResponseEntity.ok(workerService.findAll().stream().map(workerConverter::convert).collect(Collectors.toList()));
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<WorkerResponse> update(@RequestBody WorkerUpdateRequest workerUpdateRequest) {
        Worker worker = workerConverter.convert(workerUpdateRequest);
        Worker updatedWorker = workerService.update(worker, worker.getId());
        WorkerResponse workerResponse = workerConverter.convert(updatedWorker);
        return ResponseEntity.ok().body(workerResponse);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<WorkerResponse> findById(@PathVariable Long id) {
        Worker worker = workerService.findById(id);
        WorkerResponse workerResponse = workerConverter.convert(worker);
        return ResponseEntity.ok().body(workerResponse);
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<WorkerResponse> findByName(@PathVariable String name) {
        Worker worker = workerService.findByName(name);
        WorkerResponse workerResponse = workerConverter.convert(worker);
        return ResponseEntity.ok().body(workerResponse);
    }

    @Override
    @DeleteMapping(value = "/id/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        workerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/name/delete/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        workerService.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}
