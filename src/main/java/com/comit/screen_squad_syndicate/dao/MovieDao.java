package com.comit.screen_squad_syndicate.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Beam.MovieBeam;
import Beam.Review;
import util.Util;

@Repository
public class MovieDao {

    List<MovieBeam> movies;

    public MovieDao() {
    	
    	this.movies= new ArrayList<MovieBeam>();
    	
        movies.add(new MovieBeam(1, "The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",Util.parseDate("1994-09-23"), new ArrayList<Review>()));
        movies.add(new MovieBeam(2, "The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", Util.parseDate("1972-03-14"), new ArrayList<Review>()));
        movies.add(new MovieBeam(3, "The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", Util.parseDate("2008-07-18"), new ArrayList<Review>()));
    }
    
    public List<MovieBeam> listMovie() {
    	return this.movies;
    	
    }
    
    public synchronized void createMovie(MovieBeam movie) {
    	
    	int max = this.movies.stream()
    	           .mapToInt(mo->mo.getIdMovie())
    	           .max().orElse(0);
    	movie.setIdMovie(++max);
    	
    	this.movies.add(movie);
    	
    }
    
    public MovieBeam findMovie(int idMovie) {
    	return this.movies.stream()
    	           .filter(u->u.getIdMovie()==idMovie)
    	           .findAny().orElse(null);
    }
    
    public void updateMovie(MovieBeam movie) {
    	
    	MovieBeam currentMovie = this.findMovie(movie.getIdMovie());
    	if (currentMovie != null) {
    		currentMovie.setTitle(movie.getTitle());
			currentMovie.setDescription(movie.getDescription());
    		currentMovie.setReleaseDate(movie.getReleaseDate());
    	}
    	
    }
    
    public void deleteMovie(int idMovie) {
    	
    	this.movies.removeIf(u->u.getIdMovie()==idMovie);
    }
}
