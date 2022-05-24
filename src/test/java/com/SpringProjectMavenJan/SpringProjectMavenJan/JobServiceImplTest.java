package com.SpringProjectMavenJan.SpringProjectMavenJan;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;
import com.SpringProjectMavenJan.SpringProjectMavenJan.exception.RecordNotFoundException;
import com.SpringProjectMavenJan.SpringProjectMavenJan.repository.JobRepository;
import com.SpringProjectMavenJan.SpringProjectMavenJan.service.JobServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobServiceImplTest {

    @Mock
    private JobRepository jobRepository;
    private JobServiceImpl jobService;

    @BeforeEach
    public void setUp() {
        jobService = new JobServiceImpl(jobRepository);
    }

    @Test
    public void verifyFindAll() {
        when(jobRepository.findAll()).thenReturn(List.of(Job.builder().build()));
        jobService.findAll();
        verify(jobRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Job job = Job.builder().build();
        jobService.save(job);
        verify(jobRepository, times(1)).save(job);
    }

    @Test
    public void verifyFindByName() {
        String name = "Programmer";
        when(jobRepository.findByName(name)).thenReturn(Optional.of(Job.builder().build()));
        jobService.findByName(name);
        verify(jobRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(jobRepository.findById(id)).thenReturn(Optional.of(Job.builder().build()));
        jobService.findById(id);
        verify(jobRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Работа с име: Programmer не е намерена!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            jobService.findByName("Programmer");
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Работа с ID: 1 не е намерен!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            jobService.findById(1L);
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyDeleteByName() {
        String name = "Programmer";
        jobService.deleteByName(name);
        verify(jobRepository, times(1)).deleteByName(name);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        jobService.deleteById(id);
        verify(jobRepository, times(1)).deleteById(id);
    }
}
