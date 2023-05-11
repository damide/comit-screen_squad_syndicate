package com.comit.screen_squad_syndicate.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.comit.screen_squad_syndicate.dao.mapper.UserMapper;

import Beam.UserBeam;

@Repository
public class UserDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	List<UserBeam> users;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<UserBeam> listUsers() {
		
		String sql = "SELECT * FROM USER";
		return jdbcTemplate.query(sql, new UserMapper());
	}
	
	public void createUser(UserBeam user) {
		String sql = "INSERT INTO USER(USERNAME, PASSWORD, EMAIL) "
			     + "VALUES(?,?,?,?)";
		
		this.jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
		
	}
	
	public UserBeam findUser (int idUser) {
		
		String sql = "SELECT * FROM USER WHERE ID_USER = ?";
		return this.jdbcTemplate.queryForObject(sql, new UserMapper(), idUser);
		
	}
	
	public void modifyUser(UserBeam user) {
		
		String sql = "UPDATE USER SET USERNAME = ?,EMAIL = ?, WHERE ID_USER = ?";
		int status = this.jdbcTemplate.update(sql,user.getUsername(), user.getEmail(), user.getIdUser());
		
		if (status == 0) {
			logger.error("Error while updating user", user);
		}
	}
	
	public void deleteUser(int idUser) {
		
		String sql = "DELETE FROM USER WHERE ID_USER = ?";
		int status = this.jdbcTemplate.update(sql,idUser);
		
		if (status == 0) {
			logger.error("Error while updating user, idUser:", idUser);

		}
	}


}
