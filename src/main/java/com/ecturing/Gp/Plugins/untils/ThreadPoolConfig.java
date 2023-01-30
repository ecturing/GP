package com.ecturing.Gp.Plugins.untils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/***
 * 线程池配置
 */

@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Value("${corePoolSize}")
    private int corePoolSize;
    @Value("${maxPoolSize}")
    private int maxPoolSize;

    @Value("${keepAliveTime}")
    private int keepAliveTime;

    @Value("${queueCapacity}")
    private int queueCapacity;

    @Value("${threadName}")
    private String threadName;

    @Bean("taskExecutor") // bean的名称，默认为首字母小写的方法名
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadName);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}