package com.SpringProjectMavenJan.SpringProjectMavenJan.service;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Worker;
import com.SpringProjectMavenJan.SpringProjectMavenJan.exception.RecordNotFoundException;
import com.SpringProjectMavenJan.SpringProjectMavenJan.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
@Transactional
public class WorkerServiceImpl implements WorkerService{

    private final WorkerRepository workerRepository;

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker update(Worker updatedWorker, Long id) {
        Worker worker = findById(id);
        worker.setName(updatedWorker.getName());
        worker.setAge(updatedWorker.getAge());
        worker.setJob(updatedWorker.getJob());
        worker.setSalary(updatedWorker.getSalary());
        return worker;
    }

    @Override
    public Worker findById(Long id) {
        return workerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Работник с ID: %s не е намерен!", id)));
    }

    @Override
    public Worker findByName(String name) {
        return workerRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(String.format("Работник с име: %s не е намерен!", name)));
    }

    @Override
    public void deleteById(Long id) {
        workerRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        workerRepository.deleteByName(name);
    }
}
