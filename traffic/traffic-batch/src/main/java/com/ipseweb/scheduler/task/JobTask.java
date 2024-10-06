package com.ipseweb.scheduler.task;

import com.ipseweb.scheduler.trigger.TriggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.Trigger;

public abstract class JobTask implements Runnable {

    protected JobLauncher jobLauncher;
    protected Job job;


    public abstract JobType getJobType();

    public abstract boolean supports(String jobName);



}
