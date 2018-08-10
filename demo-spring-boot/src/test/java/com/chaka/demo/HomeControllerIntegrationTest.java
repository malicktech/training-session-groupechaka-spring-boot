package com.chaka.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerIntegrationTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void testHome() throws Exception {
		String url = "http://localhost:" + port + "/";
		String body = this.restTemplate.getForObject(url, String.class);
		String expectedResult = "Hello, World!";
		assertThat(body).isEqualTo(expectedResult);
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
		assertThat(response.getBody()).isEqualTo("Hello, World!");
	}

}
