package com.comit.screen_squad_syndicate.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Beam.BlogPost;
import Beam.Review;
import Beam.UserBeam;

@Repository
public class UserDao {
	List<UserBeam> users;
	
	public UserDao( ) {
		this.users = new ArrayList<UserBeam>();
		users.add(new UserBeam(1, "jdoe", "password", "jdoe@example.com", new ArrayList<Review>(), new ArrayList<BlogPost>()));
		users.add(new UserBeam(2, "jsmith", "password", "jsmith@example.com", new ArrayList<Review>(), new ArrayList<BlogPost>()));
		users.add(new UserBeam(3, "proberts", "password", "proberts@example.com", new ArrayList<Review>(), new ArrayList<BlogPost>()));
		
	}
	
	public List<UserBeam> listUsers() {
		return this.users;
	}
	
	public UserBeam getUserById(int id) {
		for (UserBeam user : users) {
			if (user.getIdUser() == id) {
				return user;
			}
		}
		return null;
	}


}
