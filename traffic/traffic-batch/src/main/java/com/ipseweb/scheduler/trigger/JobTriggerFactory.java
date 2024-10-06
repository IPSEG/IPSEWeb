package com.ipseweb.scheduler.trigger;

import com.ipseweb.scheduler.task.JobTask;
import com.ipseweb.scheduler.task.JobType;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class JobTriggerFactory {

    private final List<TriggerFactory> triggerFactories;


    public TriggerFactory find(JobType jobType) {
        for (TriggerFactory triggerFactory : triggerFactories) {
            if (triggerFactory.supports(jobType)) {
                return triggerFactory;
            }
        }

        return null;
    }
}
