package com.luobo.config;

import lombok.Data;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * EnableAsyncConfig class
 *
 * @author chenlingyu
 * @date 2020/6/8 19:55
 */
@Configuration
@EnableAsync
@Data
public class EnableAsyncConfig {
    @Value("${spring.async.core-pool-size}")
    private  int corePoolSize;
    @Value("${spring.async.max-pool-size}")
    private  int maxPoolSize;
    @Value("${spring.async.queue-capacity}")
    private  int queueCapacity;
    @Value("${spring.async.keep-alive-seconds}")
    private  int keepAliveSeconds;
    @Value("${spring.async.thread-name-prefix}")
    private  String threadNamePrefix;

    private static final int CORE_POOL_SIZE = 20;

    @Bean
    public TaskExecutor taskExecutor() {
        //TODO上线前具体思考下异步现成池容量问题
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置队列容量
        executor.setQueueCapacity(queueCapacity);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 设置默认线程名称
        executor.setThreadNamePrefix(threadNamePrefix);
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
