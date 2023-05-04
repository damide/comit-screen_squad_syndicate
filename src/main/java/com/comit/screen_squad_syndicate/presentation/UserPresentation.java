package com.comit.screen_squad_syndicate.presentation;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.comit.screen_squad_syndicate.service.UserService;

import Beam.UserBeam;

@Controller
public class UserPresentation {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String getAllMovies() {
		logger.debug("Landing Page");
		return "index";
		
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		logger.debug("List Page");
		List<UserBeam> users = this.userService.listUsers();
		return new ModelAndView("list","users",users);
	}
	
	@GetMapping("/user/{id}")
	public ModelAndView getUserById(@PathVariable("id") int id) {
		logger.debug("User Details Page for user with id {}", id);
		UserBeam user = this.userService.getUserById(id);
		return new ModelAndView("user", "user", user);
	}

}
