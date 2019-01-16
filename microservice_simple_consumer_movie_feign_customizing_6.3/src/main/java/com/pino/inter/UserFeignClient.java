package com.pino.inter;

import com.pino.config.FeignConfiguration;
import com.pino.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yin on 2019/1/14.
 * Description: 使用自定义的feign 配置
 */
@FeignClient(name="microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
