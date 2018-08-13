package com.chaka.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerIntegrationTest {

	@LocalServerPort
	private int port;
	
	@LocalManagementPort
    int randomManagementPort;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private HelloProperties helloProperties;

	private URL base;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void testHome() throws Exception {
		String body = this.restTemplate.getForObject(base.toString(), String.class);
		String expectedResult = String.format("%s, %s!", helloProperties.getPrefix(), helloProperties.getTarget());
		;
		assertThat(body).isEqualTo(expectedResult);
	}

}
