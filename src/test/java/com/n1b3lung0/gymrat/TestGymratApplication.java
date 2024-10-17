package com.n1b3lung0.gymrat;

import org.springframework.boot.SpringApplication;

public class TestGymratApplication {

	public static void main(String[] args) {
		SpringApplication.from(GymratApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
