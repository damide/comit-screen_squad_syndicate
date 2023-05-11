package com.comit.screen_squad_syndicate.dao;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.comit.screen_squad_syndicate.dao.mapper.MovieMapper;

import Beam.MovieBeam;

@Repository
public class MovieDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    List<MovieBeam> movies;

	@Autowired
	JdbcTemplate jdbcTemplate;

    
    public List<MovieBeam> listMovie() {
    	
    	String sql = "SELECT * FROM MOVIE";
		return jdbcTemplate.query(sql, new MovieMapper());
    	
    }
    
    public void createMovie(MovieBeam movie) {
    	
    	String sql = "INSERT INTO MOVIE(TITLE, DESCRIPTION, RELEASE_DATE) "
			     + "VALUES(?,?,?)";
    	
    	this.jdbcTemplate.update(sql, movie.getTitle(), movie.getDescription(),movie.getReleaseDate());
    	
    	
    }
    
    public MovieBeam findMovie(int idMovie) {
    	String sql = "SELECT * FROM MOVIE WHERE ID_MOVIE = ?";
		return this.jdbcTemplate.queryForObject(sql, new MovieMapper(), idMovie);
    }
    
    public void updateMovie(MovieBeam movie) {
    	
    	String sql = "UPDATE MOVIE SET TITLE = ?, DESCRIPTION = ?,RELEASE_DATE = ?, WHERE ID_MOVIE = ?";
    	int status = this.jdbcTemplate.update(sql, movie.getTitle(), movie.getDescription(),movie.getReleaseDate(), movie.getIdMovie());
    	
    	if (status == 0) {
			logger.error("Error while updating movie", movie);
    	}
    	
    }
    
    public void deleteMovie(int idMovie) {
    	
    	String sql = "DELETE FROM MOVIE WHERE ID_MOVIE = ?";
    	int status = this.jdbcTemplate.update(sql, idMovie);
    	
    	if (status == 0) {
			logger.error("Error while updating movie, idMovie:", idMovie);
			
    	}
    }
}
