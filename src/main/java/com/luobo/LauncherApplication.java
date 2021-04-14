package com.luobo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * LauncherApplication class
 * @author chenlingyu
 *  @date 2020/4/26 9:57
 */
@Slf4j
@SpringBootApplication
@EnableAsync
public class LauncherApplication  {

    public static void main(String[] args) {
        SpringApplication.run(LauncherApplication.class, args);
    }
}
