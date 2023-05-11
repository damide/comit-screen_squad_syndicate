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
	
	public synchronized void createUser(UserBeam user) {
		int max = this.users.stream()
				   .mapToInt(u->u.getIdUser())
		           .max().orElse(0);
		user.setIdUser(++max);
		this.users.add(user);
	}
	
	public UserBeam findUser (int idUser) {
		
		return this.users.stream()
		          .filter(u->u.getIdUser()== idUser)
		             .findAny().orElse(null);
		
	}
	
	public void modifyUser(UserBeam user) {
		
		UserBeam currentUser = this.findUser(user.getIdUser());
		
		if (currentUser != null) {
			currentUser.setUsername(user.getUsername());
			currentUser.setEmail(user.getEmail());
			
		}
	}
	
	public void deleteUser(int idUser) {
		this.users.removeIf(u->u.getIdUser()== idUser);
		
	}


}
