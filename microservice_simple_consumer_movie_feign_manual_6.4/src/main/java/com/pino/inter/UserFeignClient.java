package com.pino.inter;

import com.pino.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yin on 2019/1/14.
 * Description:
 */
public interface UserFeignClient {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
