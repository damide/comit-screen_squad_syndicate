package com.comit.screen_squad_syndicate.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Beam.UserBeam;

public class UserMapper implements RowMapper<UserBeam> {

	@Override
	public UserBeam mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBeam user = new UserBeam();
		
		user.setIdUser(rs.getInt("ID_USER"));
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setEmail(rs.getString("EMAIL"));
		
		return null;
	}

}
