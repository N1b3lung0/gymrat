package com.n1b3lung0.gymrat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class GymratApplicationTests {

	@Test
	void contextLoads() {
	}

}
