package com.loogodamner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
	@Autowired
	private UserFeignClient userFeignCliet;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return this.userFeignCliet.findById(id);
	}
}
