package com.comit.screen_squad_syndicate.service;




import java.util.List;

import org.springframework.stereotype.Service;

import com.comit.screen_squad_syndicate.dao.MovieDao;

import Beam.MovieBeam;

@Service
public class MovieService {

    MovieDao movieDao = new MovieDao();

    public List<MovieBeam> getAllMovies() {
        return movieDao.getAllMovies();
    }

    public MovieBeam getMovieById(int id) {
        return movieDao.getMovieById(id);
    }

    public boolean addMovie(MovieBeam movie) {
        return movieDao.addMovie(movie);
    }

    public boolean updateMovie(MovieBeam movie) {
        return movieDao.updateMovie(movie);
    }

    public boolean deleteMovie(int id) {
        return movieDao.deleteMovie(id);
    }

}
