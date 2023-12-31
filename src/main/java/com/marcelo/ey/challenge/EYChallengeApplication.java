package com.marcelo.ey.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EYChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EYChallengeApplication.class, args);
	}

}
