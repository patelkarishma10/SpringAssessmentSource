package com.bae.service;

import org.springframework.http.ResponseEntity;

public interface UserService {
	ResponseEntity<Object> findBySearchTerm(String searchTerm);

}
