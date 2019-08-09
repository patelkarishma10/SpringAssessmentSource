package com.bae.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl service;

	@Mock
	RestTemplate restTemplate;

	@Test
	public void findBySearchTermTest() {
		String searchTerm = "search";
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<Object> obj = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + searchTerm,
				HttpMethod.GET, entity, Object.class);
		Mockito.when(restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + searchTerm, HttpMethod.GET, entity,
				Object.class)).thenReturn(obj);

		assertEquals(obj, service.findBySearchTerm(searchTerm));
		// Mockito.verify(service).findBySearchTerm(searchTerm);
	}
}
