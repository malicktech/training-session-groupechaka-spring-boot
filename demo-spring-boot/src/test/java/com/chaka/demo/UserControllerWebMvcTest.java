package com.chaka.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.chaka.demo.domain.User;
import com.chaka.demo.repository.UserRepository;
import com.chaka.demo.web.rest.UserController;

/**
 * Only focused on the Controller code
 * 
 * Mock the Service/Repository layer
 * 
 * narrow down the tests to just the web layer by using @WebMvcTest
 * 
 * @WebMvcTest. It will auto-configure the Spring MVC infrastructure for our
 * unit tests.
 * 
 * @author dell
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerWebMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRepository userRepository;

	private User savedUser;

	@Test
	public void givenUsers_whenGetAllUsers_thenReturnJsonArray() throws Exception {

		savedUser = new User("Stephan", "Nicolle", LocalDate.of(2000, Month.JANUARY, 1));
		List<User> allUsers = Arrays.asList(savedUser);

		Mockito.when(userRepository.findAll()).thenReturn(allUsers);

		this.mockMvc.perform(get("/all-users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].lastName", is(savedUser.getLastName())));
	}

}
