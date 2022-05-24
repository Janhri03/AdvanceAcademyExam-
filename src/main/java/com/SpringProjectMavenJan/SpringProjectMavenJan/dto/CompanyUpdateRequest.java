package com.SpringProjectMavenJan.SpringProjectMavenJan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class CompanyUpdateRequest {

    private Long id;

    private String name;

    private List<WorkerUpdateRequest> workers;
}
