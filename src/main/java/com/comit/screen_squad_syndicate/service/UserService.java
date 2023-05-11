package com.comit.screen_squad_syndicate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.screen_squad_syndicate.dao.UserDao;

import Beam.UserBeam;



@Service
public class UserService {
	
	    @Autowired
	    UserDao userDao;

	    public List<UserBeam> listUsers() {
	        return userDao.listUsers();
	    }
	    
	    public void createUser(UserBeam user) {
	    	this.validateUser(user);
	    	this.userDao.createUser(user);
	    }
	    
	    public UserBeam findUser(int idUser) {
	    	return this.userDao.findUser(idUser);
	    }
	    
	    public void modifyUser(UserBeam user) {
	    	this.validateUser(user);
	    	this.userDao.modifyUser(user);
	    	
	    }
	    
	    public void deleteUser(int idUser) {
	    	this.userDao.deleteUser(idUser);
	    }
	    
	    private void validateUser(UserBeam user) {
			
			if (user.getUsername().isEmpty() ||
				user.getEmail().isEmpty()) {
				throw new RuntimeException("Invalid User Data: " + user);
			}		
		}

	    


}
