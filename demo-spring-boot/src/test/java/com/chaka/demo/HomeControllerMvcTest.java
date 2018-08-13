package com.chaka.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.chaka.demo.web.rest.HomeController;

/**
 * not start the server at all, but test only the layer below that, where Spring
 * handles the incoming HTTP request and hands it off to your controller. Mock
 * the Service/Repository layer
 * 
 * In this test, the full Spring application context is started, but without the
 * server.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerMvcTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private HelloProperties helloProperties;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
        when(helloProperties.getPrefix()).thenReturn("Hello");
        when(helloProperties.getTarget()).thenReturn("Test");

		String expectedResult = String.format("%s, %s!", helloProperties.getPrefix(), helloProperties.getTarget());
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(expectedResult)));
	}

}
