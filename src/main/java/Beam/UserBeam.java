package Beam;

import java.util.List;

public class UserBeam {
	
	int idUser;
	String username;
	String password;
	String email;
	List<Review> reviews;
	List<BlogPost> blogpost;
	
	
	public UserBeam() {
	}


	public UserBeam(int idUser, String username, String password, String email, List<Review> reviews,
			List<BlogPost> blogpost) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.email = email;
		this.reviews = reviews;
		this.blogpost = blogpost;
	}
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<BlogPost> getBlogpost() {
		return blogpost;
	}
	public void setBlogpost(List<BlogPost> blogpost) {
		this.blogpost = blogpost;
	}
	@Override
	public String toString() {
		return "UserBeam [idUser=" + idUser + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", reviews=" + reviews + ", blogpost=" + blogpost + "]";
	}
	
	
	

}
