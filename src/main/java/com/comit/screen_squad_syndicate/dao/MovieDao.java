package com.comit.screen_squad_syndicate.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Beam.MovieBeam;
import Beam.Review;
import util.Util;

@Repository
public class MovieDao {

    List<MovieBeam> movies = new ArrayList<MovieBeam>();

    public MovieDao() {
        movies.add(new MovieBeam(1, "The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",Util.parseDate("1994-09-23"), new ArrayList<Review>()));
        movies.add(new MovieBeam(2, "The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", Util.parseDate("1972-03-14"), new ArrayList<Review>()));
        movies.add(new MovieBeam(3, "The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", Util.parseDate("2008-07-18"), new ArrayList<Review>()));
    }

    public List<MovieBeam> getAllMovies() {
        return movies;
    }

    public MovieBeam getMovieById(int id) {
        for (MovieBeam movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public boolean addMovie(MovieBeam movie) {
        return movies.add(movie);
    }

    public boolean updateMovie(MovieBeam movie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == movie.getId()) {
                movies.set(i, movie);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMovie(int id) {
        return movies.removeIf(movie -> movie.getId() == id);
    }

}
