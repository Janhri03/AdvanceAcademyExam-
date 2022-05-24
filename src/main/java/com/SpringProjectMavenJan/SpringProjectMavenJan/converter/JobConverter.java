package com.SpringProjectMavenJan.SpringProjectMavenJan.converter;

import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.JobResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.JobSaveRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Job;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JobConverter {

    public Job convert(JobSaveRequest jobSaveRequest) {
        return Job.builder()
                .name(jobSaveRequest.getName())
                .build();
    }

    public JobResponse convert(Job job) {
        return JobResponse.builder()
                .name(job.getName())
                .build();
    }
}
