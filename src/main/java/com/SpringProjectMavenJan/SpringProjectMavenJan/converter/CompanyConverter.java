package com.SpringProjectMavenJan.SpringProjectMavenJan.converter;

import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.CompanyResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.CompanySaveRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.CompanyUpdateRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CompanyConverter {

    private WorkerConverter workerConverter;

    public Company convert(CompanySaveRequest companySaveRequest) {
        return Company.builder()
                .name(companySaveRequest.getName())
                .workers(companySaveRequest.getWorkers())
                .build();
    }

    public CompanyResponse convert(Company company) {
        return CompanyResponse.builder()
                .name(company.getName())
                .workers(company.getWorkers().stream().map(worker -> workerConverter.convert(worker)).collect(Collectors.toList()))
                .build();
    }

    public Company convert(CompanyUpdateRequest companyUpdateRequest) {
        return Company.builder()
                .id(companyUpdateRequest.getId())
                .name(companyUpdateRequest.getName())
                .workers(companyUpdateRequest.getWorkers().stream().map(worker -> workerConverter.convert(worker)).collect(Collectors.toList()))
                .build();
    }
}
