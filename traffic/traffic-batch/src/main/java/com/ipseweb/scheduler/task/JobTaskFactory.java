package com.ipseweb.scheduler.task;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JobTaskFactory {

    private final List<JobTask> jobTasks;

    public JobTask find(String jobName) {
        for (JobTask jobTask : jobTasks) {
            if (jobTask.supports(jobName)) {
                return jobTask;
            }
        }
        return null;
    }


}
