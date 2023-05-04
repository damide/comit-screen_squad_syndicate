package Beam;

import java.time.LocalDateTime;

public class Review {
	
	int id;
	int rating;
	String comment;
	LocalDateTime timestamp;
	UserBeam user;
	MovieBeam movie;
	
	public Review(int id, int rating, String comment, LocalDateTime timestamp, UserBeam user, MovieBeam movie) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.timestamp = timestamp;
		this.user = user;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public UserBeam getUser() {
		return user;
	}

	public void setUser(UserBeam user) {
		this.user = user;
	}

	public MovieBeam getMovie() {
		return movie;
	}

	public void setMovie(MovieBeam movie) {
		this.movie = movie;
	}

	
}
