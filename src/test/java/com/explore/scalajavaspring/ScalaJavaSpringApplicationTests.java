package com.explore.scalajavaspring;

import com.explore.scalajavaspring.controller.JavaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ScalaJavaSpringApplicationTests {

	@Autowired
	private JavaController javaController;

	@Test
	void contextLoads() {
		assertThat(javaController).isNotNull();
	}

}
