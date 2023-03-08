package com.ecturing.Gp.Cron;

import com.ecturing.Gp.Plugins.handle.RegisterCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class CronHandle {
    @Autowired
    RegisterCenter registerCenter;
    @Scheduled(cron = "0 0 8 * * ?")
    public void CronRun() throws ExecutionException, InterruptedException {
        registerCenter.pluginRun("News");
    }
}
