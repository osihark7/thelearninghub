package com.dreamsathis.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class SpringBootConfig extends SpringBootServletInitializer{
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringBootConfig.class);
	    }
	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
	    }
	    
}
