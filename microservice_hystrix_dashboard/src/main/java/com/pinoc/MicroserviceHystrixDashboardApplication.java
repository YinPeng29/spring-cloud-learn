package com.pinoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 使用dashboard 并没有将hystrix dashboard 注册到 eureka server 实际生产可以注册到里面 更方便的管理
 */
@SpringBootApplication
@EnableHystrixDashboard
public class MicroserviceHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceHystrixDashboardApplication.class, args);
	}

}

