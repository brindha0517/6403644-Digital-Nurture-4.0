package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		// ⬅️  this boots Spring‑Boot and loads application.properties
		SpringApplication.run(SpringLearnApplication.class, args);
	}

	// Spring Boot calls this after the context is ready
	@Override
	public void run(String... args) {
		displayCountry();
	}

	private void displayCountry() {
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("country.xml");
		Country country = ctx.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country);
	}
}


