package com.comit.screen_squad_syndicate.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Beam.MovieBeam;

public class MovieMapper implements RowMapper<MovieBeam> {

	@Override
	public MovieBeam mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MovieBeam movie = new MovieBeam();
		
		movie.setIdMovie(rs.getInt("ID_MOVIE"));
		movie.setTitle(rs.getString("TITLE"));
		movie.setDescription(rs.getString("DESCRIPTION"));
		movie.setReleaseDate(rs.getDate("RELEASE_DATE"));
		
		return null;
	}

}
