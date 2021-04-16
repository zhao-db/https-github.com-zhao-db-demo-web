package com.example.rabbitmq.demorabbitmq;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@EnableApolloConfig
@RestController
public class DemoRabbitmqApplication {


    public static void main(String[] args) {
        ConfigurableEnvironment env = SpringApplication.run(DemoRabbitmqApplication.class, args).getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "服务端 '{}' 启动完成! \n\t" +
                        "环境(s): {}\n\t" +
                        "日志级别: {}" +
                        "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getActiveProfiles(),
                env.getProperty("logging.level.ROOT"));
    }



}
