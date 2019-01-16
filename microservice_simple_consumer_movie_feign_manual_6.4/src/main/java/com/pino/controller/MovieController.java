package com.pino.controller;

import com.pino.inter.UserFeignClient;
import com.pino.pojo.User;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yin on 2018/12/21.
 * Description: 手动创建feign
 */
@RestController
@Import(FeignClientsConfiguration.class)
public class MovieController {
    private UserFeignClient userUserFeignClient;
    private UserFeignClient adminUserFeignClient;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user","pwd1"))
                .target(UserFeignClient.class,"http://microservice-provider-user/");

        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin","pwd2"))
                .target(UserFeignClient.class,"http://microservice-provider-user/");

    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable("id") Long id){
        return this.userUserFeignClient.findById(id);
    }

    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable("id") Long id){
        return this.adminUserFeignClient.findById(id);
    }


}
