package com.bae.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bae.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	UserController controller;

	@Mock
	UserService service;

	@Mock
	RestTemplate restTemplate;

	public static final ResponseEntity<Object> MOCK_USER_OBJECT4 = new ResponseEntity<Object>("search", HttpStatus.OK);

	@Test
	public void findBySearchTermTest() {
		String searchTerm = "search";
		Mockito.when(service.findBySearchTerm(searchTerm)).thenReturn(MOCK_USER_OBJECT4);
		assertEquals(MOCK_USER_OBJECT4, controller.findBySearchTerm(searchTerm));
		Mockito.verify(service).findBySearchTerm(searchTerm);
	}

	@Test
	public void getAUserTest() {

	}

}
