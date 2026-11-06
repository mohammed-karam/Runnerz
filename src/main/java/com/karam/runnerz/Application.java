package com.karam.runnerz;

import com.karam.runnerz.user.User;
import com.karam.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("App Started");

	}

	@Bean
    CommandLineRunner runner(UserRestClient restClient) {
		return args -> {
			try {
				System.out.println(restClient.findAll());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

}
