package com.SpringProjectMavenJan.SpringProjectMavenJan.converter;

import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.JobResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerResponse;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerSaveRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.dto.WorkerUpdateRequest;
import com.SpringProjectMavenJan.SpringProjectMavenJan.entity.Worker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WorkerConverter {

    public Worker convert(WorkerSaveRequest workerSaveRequest) {
        return Worker.builder()
                .name(workerSaveRequest.getName())
                .age(workerSaveRequest.getAge())
                .EGN(workerSaveRequest.getEGN())
                .salary(workerSaveRequest.getSalary())
                .job(workerSaveRequest.getJob())
                .build();
    }

    public WorkerResponse convert(Worker worker) {
        return WorkerResponse.builder()
                .name(worker.getName())
                .age(worker.getAge())
                .job(JobResponse.builder()
                        .name(worker.getJob().getName())
                        .build())
                .build();
    }

    public Worker convert(WorkerUpdateRequest workerUpdateRequest) {
        return Worker.builder()
                .id(workerUpdateRequest.getId())
                .name(workerUpdateRequest.getName())
                .age(workerUpdateRequest.getAge())
                .salary(workerUpdateRequest.getSalary())
                .job(workerUpdateRequest.getJob())
                .build();
    }
}
