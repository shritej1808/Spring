package com.shritej.springsec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories("com.shritej.springsec.repository")
@EntityScan("com.shritej.springsec.model")
class EasyBankBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
