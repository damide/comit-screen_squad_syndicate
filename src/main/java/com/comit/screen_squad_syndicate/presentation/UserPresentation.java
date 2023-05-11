package com.comit.screen_squad_syndicate.presentation;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comit.screen_squad_syndicate.service.UserService;

import Beam.BlogPost;
import Beam.Review;
import Beam.UserBeam;
import jakarta.servlet.http.HttpServletRequest;
import util.Util;



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
	
	
	@GetMapping("/usercreate")
	public String newUser() {
		logger.debug("Show new update");
		return "usercreate";
		
	}
	
	@PostMapping("/usercreate")
	public String createUser(HttpServletRequest req) {
		logger.debug("Create update");
		
		String username = req.getParameter("username");
		String password =req.getParameter("password");
		String email =req.getParameter("email");
		
		UserBeam user = this.createUserBeam(null,username,password,email);
		this.userService.createUser(user);
		return "redirect:/list";
		
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView showUpdate(@PathVariable int id) {
		logger.debug("Show Update");
		UserBeam user = this.userService.findUser(id);
		
		return new ModelAndView("update", "user", user);
	}
	@PostMapping("/update")
	public String modifyUser(HttpServletRequest req) {
		logger.debug("Modify User");
		
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String email =req.getParameter("email");
		
		UserBeam user = this.createUserBeam(id, username, null, email);
		this.userService.modifyUser(user);
		return "redirect:/list";
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		this.userService.deleteUser(id);
		return "redirect:/list";
	}
	
	
	private UserBeam createUserBeam(String id, String username,String password, String email) {
		UserBeam user = new UserBeam(Util.parseId(id),username,password,email,new ArrayList<Review>(), new ArrayList<BlogPost>());
		return user;
	}

}
