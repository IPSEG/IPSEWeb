package com.ipseweb.batch.job.busstop;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BusStopOpenApiJobConfiguration {

    @Bean
    public Job busStopOpenApiCronJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("BusStopOpenApiCronJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(busStopOpenApiStep(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step busStopOpenApiStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("BusStopOpenApiStep", jobRepository)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                        TODO : 모듈 분리 후 openAPI 처리 예정



                        return RepeatStatus.FINISHED;
                    }
                }, transactionManager).build();
    }


}
