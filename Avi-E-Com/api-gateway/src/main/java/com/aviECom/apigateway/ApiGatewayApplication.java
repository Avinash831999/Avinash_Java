package com.aviECom.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
    public RouteLocator getRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/users/**").filters(f -> f.stripPrefix(1)).uri("lb://USER-MANAGEMENT"))
				.route(p -> p.path("/orders/**").filters(f -> f.stripPrefix(1)).uri("lb://ORDER-MANAGEMENT"))
				.route(p -> p.path("/users/**").filters(f -> f.stripPrefix(1)).uri("lb://USER-MANAGEMENT"))
				.route(p -> p.path("/products/**").filters(f -> f.stripPrefix(1)).uri("lb://PRODUCT-MANAGEMENT"))
				.build() ;
	}

}
