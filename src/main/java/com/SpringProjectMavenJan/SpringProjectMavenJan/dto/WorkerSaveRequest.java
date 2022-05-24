package com.SpringProjectMavenJan.SpringProjectMavenJan.dto;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerSaveRequest {

    private String name;

    private Integer age;

    private Double salary;

    private String EGN;

    private Job job;
}
