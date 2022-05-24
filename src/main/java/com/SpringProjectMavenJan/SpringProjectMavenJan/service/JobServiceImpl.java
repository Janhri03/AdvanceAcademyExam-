package com.SpringProjectMavenJan.SpringProjectMavenJan.service;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;
import com.SpringProjectMavenJan.SpringProjectMavenJan.exception.RecordNotFoundException;
import com.SpringProjectMavenJan.SpringProjectMavenJan.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Primary
public class JobServiceImpl implements JobService{

    private final JobRepository jobRepository;

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Работа с ID: %s не е намерен!", id)));
    }

    @Override
    public Job findByName(String name) {
        return jobRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(String.format("Работа с име: %s не е намерена!", name)));
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        jobRepository.deleteByName(name);
    }
}
