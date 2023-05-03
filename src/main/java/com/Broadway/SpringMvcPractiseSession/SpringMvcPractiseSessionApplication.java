package com.Broadway.SpringMvcPractiseSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "EmployeeMs", description="EmployeeApis",version="2.8"))  //http://localhost:9090/swagger-ui/index.html#/
public class SpringMvcPractiseSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcPractiseSessionApplication.class, args);
	}

}
