package com.ipseweb.scheduler.trigger;

import com.ipseweb.scheduler.task.JobType;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class CronTriggerFactory implements TriggerFactory{

    @Override
    public Trigger createTrigger(String args) {
        return new CronTrigger(args);
    }

    @Override
    public boolean supports(JobType jobType) {
        return jobType == JobType.CRON_JOB ? true : false;

    }
}
