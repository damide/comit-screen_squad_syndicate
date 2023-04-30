package com.comit.screen_squad_syndicate.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPresentation {
	
	@GetMapping("/")
	public String getAllMovies() {
		
		return "index";
		
	}

}
