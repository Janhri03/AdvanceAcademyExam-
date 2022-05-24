package com.SpringProjectMavenJan.SpringProjectMavenJan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerResponse {

    private String name;

    private Integer age;

    private JobResponse job;
}
