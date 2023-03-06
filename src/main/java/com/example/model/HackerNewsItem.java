package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class HackerNewsItem {
//    @Id
    private int hacker_id;
    private String 		hacker_type;
    private long 		hacker_time;
    private String 		hacker_title;
    private String 		hacker_url;
    private int 		hacker_score;
    private String 		hacker_by;
//    @OneToMany(cascade = CascadeType.ALL)
    private List<Comments> comments = new ArrayList<>();
    // getters and setters
	public int getId() {
		return hacker_id;
	}
	public void setId(int id) {
		this.hacker_id = id;
	}
	public String getType() {
		return hacker_type;
	}
	public void setType(String type) {
		this.hacker_type = type;
	}
	public long getTime() {
		return hacker_time;
	}
	public void setTime(long time) {
		this.hacker_time = time;
	}
	public String getTitle() {
		return hacker_title;
	}
	public void setTitle(String title) {
		this.hacker_title = title;
	}
	public String getUrl() {
		return hacker_url;
	}
	public void setUrl(String url) {
		this.hacker_url = url;
	}
	public int getScore() {
		return hacker_score;
	}
	public void setScore(int score) {
		this.hacker_score = score;
	}
	public String getBy() {
		return hacker_by;
	}
	public void setBy(String by) {
		this.hacker_by = by;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
    
    
}
