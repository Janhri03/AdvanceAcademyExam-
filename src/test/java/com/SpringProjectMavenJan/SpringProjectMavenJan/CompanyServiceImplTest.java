package com.SpringProjectMavenJan.SpringProjectMavenJan;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Company;
import com.SpringProjectMavenJan.SpringProjectMavenJan.exception.RecordNotFoundException;
import com.SpringProjectMavenJan.SpringProjectMavenJan.repository.CompanyRepository;
import com.SpringProjectMavenJan.SpringProjectMavenJan.service.CompanyServiceImpl;
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
public class CompanyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;
    private CompanyServiceImpl companyService;

    @BeforeEach
    public void setUp() {
        companyService = new CompanyServiceImpl(companyRepository);
    }


    @Test
    public void verifyFindAll() {
        when(companyRepository.findAll()).thenReturn(List.of(Company.builder().build()));
        companyService.findAll();
        verify(companyRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Company company = Company.builder().build();
        companyService.save(company);
        verify(companyRepository, times(1)).save(company);
    }

    @Test
    public void verifyFindByName() {
        String name = "Advance Academy";
        when(companyRepository.findByName(name)).thenReturn(Optional.of(Company.builder().build()));
        companyService.findByName(name);
        verify(companyRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(companyRepository.findById(id)).thenReturn(Optional.of(Company.builder().build()));
        companyService.findById(id);
        verify(companyRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByNameThrowsException() {
        String message = "Фирма с име Advance Academy не е намерена!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            companyService.findByName("Advance Academy");
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Фирма с ID: 1 не е намерена!";
        RecordNotFoundException recordNotFoundException = assertThrows(RecordNotFoundException.class, () -> {
            companyService.findById(1L);
        });
        assertEquals(message, recordNotFoundException.getMessage());
    }

    @Test
    public void verifyDeleteByName() {
        String name = "Advance Academy";
        companyService.deleteByName(name);
        verify(companyRepository, times(1)).deleteByName(name);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        companyService.deleteById(id);
        verify(companyRepository, times(1)).deleteById(id);
    }
}
