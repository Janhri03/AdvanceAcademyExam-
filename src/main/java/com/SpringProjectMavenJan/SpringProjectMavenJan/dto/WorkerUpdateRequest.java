package com.SpringProjectMavenJan.SpringProjectMavenJan.dto;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class WorkerUpdateRequest {

    private Long id;

    private String name;

    private Integer age;

    private Double salary;

    private Job job;
}
