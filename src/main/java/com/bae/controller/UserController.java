package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.UserService;

@RestController
@RequestMapping("/search")
public class UserController {

	public UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/find/{searchTerm}")
	public ResponseEntity<Object> findBySearchTerm(@PathVariable("searchTerm") String searchTerm) {
		return service.findBySearchTerm(searchTerm);

	}

}
