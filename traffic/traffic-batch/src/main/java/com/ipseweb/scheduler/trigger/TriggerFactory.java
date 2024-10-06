package com.ipseweb.scheduler.trigger;

import com.ipseweb.scheduler.task.JobType;
import org.springframework.scheduling.Trigger;

public interface TriggerFactory {
    Trigger createTrigger(String args);

    boolean supports(JobType jobType);
}
