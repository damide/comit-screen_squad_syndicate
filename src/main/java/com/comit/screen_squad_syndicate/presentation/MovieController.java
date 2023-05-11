
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

import com.comit.screen_squad_syndicate.service.MovieService;

import Beam.MovieBeam;
import Beam.Review;
import jakarta.servlet.http.HttpServletRequest;
import util.Util;

@Controller
public class MovieController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	public ModelAndView movie() {
		logger.debug("Movie List");
		List<MovieBeam> movies = this.movieService.listMovie();
		return new ModelAndView("movielist","movies", movies);
		
	}
	
	@GetMapping ("/moviecreate")
	public String newMovie() {
		logger.debug("Show new Movie");
		return "moviecreate";
	}
	
	@PostMapping("/moviecreate")
	public String createMovie(HttpServletRequest req) {
		logger.debug("Create new Movie");
		
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String release = req.getParameter("release");
		
		MovieBeam movie = this.createMovieBeam(null,title, description, release);
		this.movieService.createMovie(movie);
		
		return "redirect:/movies";
	}
	
	@GetMapping("/updatemovie/{id}")
	public ModelAndView showUpdateMovie(@PathVariable int id) {
		logger.debug("Show UpdateMovie");
		MovieBeam movie = this.movieService.findMovies(id);
		return new ModelAndView("updatemovie", "movie", movie);
		
	}
	
	@PostMapping("/updatemovie")
	public String updateMovie(HttpServletRequest req) {
		logger.debug("Update Movie");
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String release = req.getParameter("release");
		
		MovieBeam movie = this.createMovieBeam(id, title, description, release);
		this.movieService.updateMovie(movie);
		
		return "redirect:/movies";
	}
	
	@GetMapping("/deletemovie/{id}")
	public String deleteMovie(@PathVariable int id) {
		this.movieService.deleteMovie(id);
		return "redirect:/movies";
		
	}
	private MovieBeam createMovieBeam(String id, String title,String description,String release) {
		MovieBeam movie = new MovieBeam(Util.parseId(id),title,description,Util.parseDate(release),new ArrayList<Review>());
		return movie;
	}
	
	
}

