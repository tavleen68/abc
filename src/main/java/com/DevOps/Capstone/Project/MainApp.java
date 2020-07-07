package com.DevOps.Capstone.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MainApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApp.class);
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MainApp.class, args);
	
		BankApp b = null;
		try {
				b = new BankApp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			b.bank();
		
	}


}
