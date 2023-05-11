package com.comit.screen_squad_syndicate.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.screen_squad_syndicate.dao.MovieDao;

import Beam.MovieBeam;

@Service
public class MovieService {
	
	@Autowired
	MovieDao movieDao;
		
	public List<MovieBeam> listMovie(){
    	List<MovieBeam> movies = this.movieDao.listMovie();
    	return movies;
    	
    }
	
	public void createMovie(MovieBeam movie) {
		
		this.validateMovie(movie);
		
		this.movieDao.createMovie(movie);
		
	}
	
	public MovieBeam findMovies(int idMovie) {
		return this.movieDao.findMovie(idMovie);
	}
	
	public void updateMovie(MovieBeam movie) {
		this.validateMovie(movie);
		this.movieDao.updateMovie(movie);
		
	}
	
	public void deleteMovie(int idUser) {
		this.movieDao.deleteMovie(idUser);
	}
	
	private void validateMovie (MovieBeam movie) {
		
		if(movie.getTitle().isEmpty()||
			movie.getDescription().isEmpty()) {
			throw new RuntimeException("Invalid Movie Data: " + movie);
		}
	}

	
}

    