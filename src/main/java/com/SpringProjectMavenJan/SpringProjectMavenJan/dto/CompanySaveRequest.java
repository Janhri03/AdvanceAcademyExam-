package com.SpringProjectMavenJan.SpringProjectMavenJan.dto;

import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanySaveRequest {

   private String name;

   private List<Worker> workers;
}
