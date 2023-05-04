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

	    public UserBeam getUserById(int id) {
	        return userDao.getUserById(id);
	    }


}
