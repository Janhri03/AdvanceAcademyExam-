package com.SpringProjectMavenJan.SpringProjectMavenJan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobSaveRequest {

    @NotNull
    private String name;
}
