package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Story {

	@Id
    private int story_id;
    private String story_title;
    private String story_url;
    private int story_score;
    private LocalDateTime story_time;
    private String story_by;
	private List<Integer> kids;
	public Story(int id, String story_title, String story_url, int score, LocalDateTime submissionTime,
			String story_by, List<Integer> kids2) {
		super();
		this.story_id = id;
		this.story_title = story_title;
		this.story_url = story_url;
		this.story_score = score;
		this.story_time = submissionTime;
		this.story_by = story_by;
		this.kids = kids2;
	}

	public List<Integer> getKids() {
		return kids;
	}

	public void setKids(List<Integer> kids) {
		this.kids = kids;
	}

	public LocalDateTime getTime() {
		// TODO Auto-generated method stub
		return story_time;
	}
	public int getId() {
		return story_id;
	}
	public void setId(int id) {
		this.story_id = id;
	}
	public String getTitle() {
		return story_title;
	}
	public void setTitle(String title) {
		this.story_title = title;
	}
	public String getUrl() {
		return story_url;
	}
	public void setUrl(String url) {
		this.story_url = url;
	}
	public int getScore() {
		return story_score;
	}
	public void setScore(int score) {
		this.story_score = score;
	}
	public String getBy() {
		return story_by;
	}
	public void setBy(String by) {
		this.story_by = by;
	}
	public void setTime(LocalDateTime time) {
		this.story_time = time;
	}

    // Add getters and setters as needed
}
