package com.comit.screen_squad_syndicate.presentation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comit.screen_squad_syndicate.service.MovieService;

import Beam.MovieBeam;

@Controller
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movie";
    }

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable int id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie";
    }

    @GetMapping("/add")
    public String showAddMovieForm() {
        return "add-movie";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute MovieBeam movie) {
        movieService.addMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/edit")
    public String showEditMovieForm(@PathVariable int id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "edit-movie";
    }

    @PostMapping("/{id}/edit")
    public String editMovie(@ModelAttribute MovieBeam movie) {
        movieService.updateMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/delete")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }

}
