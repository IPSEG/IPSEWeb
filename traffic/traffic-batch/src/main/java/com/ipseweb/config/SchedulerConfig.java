package com.ipseweb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableScheduling
@Configuration
@Slf4j
public class SchedulerConfig {

    @Value("${spring.batch.scheduler.max_thread_count}")
    private Integer maxThreadCount;

    @Bean
    @Primary
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        int availableProcessor = Runtime.getRuntime().availableProcessors() / 2;
        int threadCount = maxThreadCount;

        if (availableProcessor > maxThreadCount) {
            log.info("Half of available Processor Counts are : " + availableProcessor / 2);
            log.info("The Final numbers of threads used is : " + maxThreadCount);
            availableProcessor = maxThreadCount;
        }

        threadCount = availableProcessor;

        threadPoolTaskScheduler.setPoolSize(threadCount);
        threadPoolTaskScheduler.initialize();

        return threadPoolTaskScheduler;
    }

    @Bean
    public TaskExecutor taskExecutor() {

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        int availableProcessor = Runtime.getRuntime().availableProcessors() / 2;
        int threadCount = maxThreadCount;

        if (availableProcessor > maxThreadCount) {
            log.info("Half of available Processor Counts are : " + availableProcessor / 2);
            log.info("The Final numbers of threads used is : " + maxThreadCount);
            availableProcessor = maxThreadCount;
        }

        threadCount = availableProcessor;

        threadPoolTaskExecutor.setCorePoolSize(threadCount);
        threadPoolTaskExecutor.setMaxPoolSize(threadCount);

        return threadPoolTaskExecutor;
    }


}
