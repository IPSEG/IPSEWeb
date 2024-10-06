package com.ipseweb.scheduler.task;

import com.ipseweb.scheduler.trigger.CronTriggerFactory;
import com.ipseweb.scheduler.trigger.TriggerFactory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class CronJobTask extends JobTask{
    @Override
    public void run() {

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("jobName", job.getName())
                .addLocalDateTime("startDate", LocalDateTime.now())
                .toJobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            throw new RuntimeException(e);
        } catch (JobRestartException e) {
            throw new RuntimeException(e);
        } catch (JobInstanceAlreadyCompleteException e) {
            throw new RuntimeException(e);
        } catch (JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public JobType getJobType() {
        return JobType.CRON_JOB;
    }

    @Override
    public boolean supports(String jobName) {
        return jobName.contains("CronJob")  ? true : false;
    }

}
