package Beam;

import java.time.LocalDateTime;

public class BlogPost {
	
	int id;
	String title;
	String content;
	LocalDateTime timestamp;
    UserBeam user;
    
    
	public BlogPost(int id, String title, String content, LocalDateTime timestamp, UserBeam user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.timestamp = timestamp;
		this.user = user;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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
    
    

}
