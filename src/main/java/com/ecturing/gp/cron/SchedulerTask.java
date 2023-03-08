package com.ecturing.gp.cron;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerTask {

    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        return new ThreadPoolTaskScheduler();
    }
}
