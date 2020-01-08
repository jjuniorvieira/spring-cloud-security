package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//entity post
@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description;

	//many post (class where we are) to one user (the attribute)
	@ManyToOne(fetch= FetchType.LAZY) //this way not be retrieved the post details when user be called
	@JsonIgnore //it is important to do not have a cyclic dependency
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format("Post [id=%s, description=%s]", id, description);
	}
	
}
