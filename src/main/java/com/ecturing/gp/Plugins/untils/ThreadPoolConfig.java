package com.ecturing.gp.Plugins.untils;

import org.ecturing.Decorator.ContextTaskDecorator;
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

    @Bean("pluginTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadName);
        executor.setTaskDecorator(new ContextTaskDecorator());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
