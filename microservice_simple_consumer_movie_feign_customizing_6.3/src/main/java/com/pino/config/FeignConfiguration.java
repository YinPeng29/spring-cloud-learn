package com.pino.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yin on 2019/1/15.
 * Description: feign 配置类
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
