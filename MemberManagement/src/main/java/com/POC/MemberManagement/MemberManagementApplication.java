package com.POC.MemberManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class MemberManagementApplication {

	@Bean
	public OpenAPI openApiInformation() {

		  Info info = new Info()
		              .description("POC for member management")
		              .summary("POC Member management project")
		              .title("Member Management")
		              .version("V1.0.0")
		              .license(new License().name("Apache 2.0").url("http://springdoc.org"));

		  return new OpenAPI().info(info);
		 }
	
	
	public static void main(String[] args) {
		SpringApplication.run(MemberManagementApplication.class, args);
	}

}
