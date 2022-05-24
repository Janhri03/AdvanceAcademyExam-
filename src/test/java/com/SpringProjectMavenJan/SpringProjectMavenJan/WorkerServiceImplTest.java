package com.SpringProjectMavenJan.SpringProjectMavenJan;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Worker;
import com.SpringProjectMavenJan.SpringProjectMavenJan.exception.RecordNotFoundException;
import com.SpringProjectMavenJan.SpringProjectMavenJan.repository.WorkerRepository;
import com.SpringProjectMavenJan.SpringProjectMavenJan.service.WorkerServiceImpl;
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
public class WorkerServiceImplTest {

    @Mock
    private WorkerRepository workerRepository;
    private WorkerServiceImpl workerService;

    @BeforeEach
    public void setUp() {
        workerService = new WorkerServiceImpl(workerRepository);
    }

    @Test
    public void verifyFindAll() {
        when(workerRepository.findAll()).thenReturn(List.of(Worker.builder().build()));
        workerService.findAll();
        verify(workerRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Worker worker = Worker.builder().build();
        workerService.save(worker);
        verify(workerRepository, times(1)).save(worker);
    }

    @Test
    public void verifyFindByName() {
        String name = "Jan Hristov";
        when(workerRepository.findByName(name)).thenReturn(Optional.of(Worker.builder().build()));
        workerService.findByName(name);
        verify(workerRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(workerRepository.findById(id)).thenReturn(Optional.of(Worker.builder().build()));
        workerService.findById(id);
        verify(workerRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Работник с име: Jan Hristov не е намерен!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            workerService.findByName("Jan Hristov");
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Работник с ID: 1 не е намерен!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            workerService.findById(1L);
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyDeleteByName() {
        String name = "Jan Hristov";
        workerService.deleteByName(name);
        verify(workerRepository, times(1)).deleteByName(name);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        workerService.deleteById(id);
        verify(workerRepository, times(1)).deleteById(id);
    }
}
