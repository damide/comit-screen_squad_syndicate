package Beam;

import java.util.Date;
import java.util.List;

public class MovieBeam {
	
	int id;
    String title;
    String description;
    Date releaseDate;
    List<Review> reviews;
	
    
    public MovieBeam(int id, String title, String description, Date releaseDate, List<Review> reviews) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.reviews = reviews;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	@Override
	public String toString() {
		return "MovieBeam [id=" + id + ", title=" + title + ", description=" + description + ", releaseDate="
				+ releaseDate + ", reviews=" + reviews + "]";
	}
    
    
    
    
}    